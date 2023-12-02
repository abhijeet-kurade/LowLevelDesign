package ARG;

public abstract class DependencyType {
    private IStrategy strategy;
    String source;
    String target;

    public DependencyType(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(){
        strategy.execute();
    }

}

class DbToVmDependencyTypes extends DependencyType{
    public DbToVmDependencyTypes(IStrategy strategy) {
        super(strategy);
    }

}


class DbToStorageDependencyTypes extends DependencyType{
    public DbToStorageDependencyTypes(IStrategy strategy) {
        super(strategy);
    }

}