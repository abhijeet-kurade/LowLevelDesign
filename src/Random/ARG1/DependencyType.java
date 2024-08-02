package Random.ARG1;

public interface DependencyType {
    Dependency getDependencyType(String startTime, String endTime);
}

class DbToVmDependencyType implements DependencyType {

    @Override
    public Dependency getDependencyType(String startTime, String endTime) {
        IStrategy strategy = new CmsQueryStrategy("select 1 from sys.table;", startTime, endTime);
        return new Dependency(strategy);
    }
}

class DbToStorageDependencyType implements DependencyType {

    @Override
    public Dependency getDependencyType(String startTime, String endTime) {
        IStrategy strategy = new FallBackStrategy("select * form resources;",
                "select * from dependencies;",
                "MonDependencies | limit 10;", startTime, endTime);
        return new Dependency(strategy);
    }
}
