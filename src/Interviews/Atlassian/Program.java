package Interviews.Atlassian;

import java.time.Period;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        JIRA jira = new JIRA(new Date(2024,06,22), new Date(2024,9,1), "P");
        CostExplorer explorer = new CostExplorer();

        List<BillEntry> bill = explorer.monthlyCostList(jira);
        for (BillEntry b : bill){
            System.out.println(b);
        }
    }

}

abstract class SubscriptionBasedService{
    String name;
    Date startDate;

    int trialDays;
    Date billStartDate;

    public abstract double getMonthlyBill();
    public abstract double getYearlyBill();

    public abstract double fractionalBill(int days);
}

class JIRA extends SubscriptionBasedService{

    Map<String, Double> tiers;
    String tier;

    public JIRA(Date startDate, Date billStartDate, String tire) {
        this.name = "JIRA";
        tiers = new HashMap<>();
        tiers.put("B", 100.0);
        tiers.put("G", 500.0);
        tiers.put("P", 1000.0);
        this.startDate = startDate;
        this.billStartDate = billStartDate;
        this.tier = tire;
    }

    @Override
    public double getMonthlyBill() {
        return tiers.get(tier);
    }

    @Override
    public double getYearlyBill() {
        return getMonthlyBill() * 12;
    }

    @Override
    public double fractionalBill(int days) {
        return  (days / 30.0) * getMonthlyBill();
    }

}



class ServiceManger{
    Map<String, SubscriptionBasedService> services;

    public SubscriptionBasedService subscribeToService(String service){
        return null;
    }
}

class Customer{



}
class BillEntry{
    String service;
    Date Start;
    Date end;
    double amount;

    public BillEntry(String service, double amount) {
        this.service = service;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BillEntry{" +
                "service='" + service + '\'' +
                ", amount=" + amount +
                '}';
    }
}
class CostExplorer{

    public List<BillEntry> monthlyCostList(SubscriptionBasedService service){
        List<BillEntry> bill = new ArrayList<>();
        String name = service.name;

        addZeroBillEntries(bill, service);

        bill.add(getCurrentMothsBill(service));

        for(int i=0; i<11; i++){
            bill.add(new BillEntry(name, service.getMonthlyBill()));
        }

        return bill;
    }

    public void addZeroBillEntries(List<BillEntry> bill, SubscriptionBasedService service){

        Date curr = service.startDate;

        while(curr.getMonth() < service.billStartDate.getMonth()){
            bill.add(new BillEntry(service.name, 0));
            curr.setMonth(curr.getMonth()+1);
        }

    }

    public BillEntry getCurrentMothsBill(SubscriptionBasedService service){

        int daysLeft = 30 - service.billStartDate.getDate();

        double firstMonthBill = service.fractionalBill(daysLeft);
        return new BillEntry(service.name, firstMonthBill);
    }

    public BillEntry annualCost(SubscriptionBasedService service){
        double amount = 0;
        amount += getCurrentMothsBill(service).amount;
        amount += 11 * service.getMonthlyBill();
        return new BillEntry(service.name, amount);
    }
}
