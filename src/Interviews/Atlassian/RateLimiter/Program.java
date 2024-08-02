package Interviews.Atlassian.RateLimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Program {

    public static void main(String[] args) {
        RateLimitManager manager = new RateLimitManager(5, 2000);

        Runnable task = () ->{
            while (true){
                if(manager.rateLimit(1)){
                    //System.out.println("Allowed.");
                }
                else {
                    //System.out.println("Not allowed");
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        //t2.start();
    }

}

class RateLimitManager{
    Map<Integer, RateLimiter> customers;

    long capacity;
    long windowSize;

    public RateLimitManager(long capacity, long windowSize) {
        this.capacity = capacity;
        this.windowSize = windowSize;
        this.customers = new HashMap<>();
    }

    public boolean rateLimit(int customerId){
        if(!this.customers.containsKey(customerId)){
            enrollCustomer(customerId);
        }
        return customers.get(customerId).tryConsume();
    }

    private void enrollCustomer(int customerId){
        customers.put(customerId, new FixedWindowRateLimiter(this.capacity, this.windowSize));
        //customers.put(customerId, new TokenBucketRateLimiter(this.capacity, this.windowSize, 100));
    }

}

abstract class RateLimiter{
    public abstract boolean tryConsume();
}
class FixedWindowRateLimiter extends RateLimiter {
    long capacity;
    long windowSize;
    AtomicLong startWindow;
    AtomicLong requestCount;


    public FixedWindowRateLimiter(long capacity, long windowSize) {
        this.capacity = capacity;
        this.windowSize = windowSize;
        this.startWindow = new AtomicLong(System.currentTimeMillis());
        this.requestCount = new AtomicLong(0);
    }

    public boolean tryConsume(){
        long curr = System.currentTimeMillis();
        long lastStart = this.startWindow.get();

        if(curr - lastStart >= windowSize){
            startWindow.set(curr);
            requestCount.set(0);
        }


        if(requestCount.get() < this.capacity){
            requestCount.incrementAndGet();
            System.out.println(curr + " Allowed");
            return true;
        }

        System.out.println(curr  + " Not Allowed");
        return false;
    }
}

class TokenBucketRateLimiter extends RateLimiter {

    long capacity;
    long refillWindow;
    long refillToken;

    AtomicLong currTokens;
    AtomicLong lastRefillTime;

    public TokenBucketRateLimiter(long capacity, long refillWindow, long refillToken) {
        this.capacity = capacity;
        this.refillWindow = refillWindow;
        this.refillToken = refillToken;
        this.currTokens = new AtomicLong(refillToken);
        this.lastRefillTime = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public boolean tryConsume() {

        if( ( System.currentTimeMillis() - lastRefillTime.get() ) / refillWindow  > 0){
            refillToken();
        }

        long curr = currTokens.get();
        if(curr > 0){
            currTokens.decrementAndGet();
            return true;
        }

        return false;
    }

    private void refillToken() {
        long now = System.currentTimeMillis();
        long lastRefill = lastRefillTime.get();
        long currTkn = currTokens.get();
        long windows = (now - lastRefill) / refillWindow;
        currTokens.compareAndSet(currTkn, Math.min(this.capacity, windows * this.refillToken));
        lastRefillTime.compareAndSet(lastRefill, now);
    }


}
