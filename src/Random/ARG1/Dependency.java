package Random.ARG1;

public class Dependency {
    private IStrategy strategy;
    String source;
    String target;

    public Dependency(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(){
        strategy.execute();
    }

}
