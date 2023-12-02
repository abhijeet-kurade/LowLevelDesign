package ARG;

public interface DependencyFactory {
    DependencyType getDependencyType(String startTime, String endTime);
}

class DbToVmDependencyType implements DependencyFactory {

    @Override
    public DependencyType getDependencyType(String startTime, String endTime) {
        IStrategy strategy = new CmsQueryStrategy("select 1 from sys.table;", startTime, endTime);
        return new DbToVmDependencyTypes(strategy);
    }
}

class DbToStorageDependencyType implements DependencyFactory {

    @Override
    public DependencyType getDependencyType(String startTime, String endTime) {
        IStrategy strategy = new FallBackStrategy("select * form resources;",
                "select * from dependencies;",
                "MonDependencies | limit 10;", startTime, endTime);
        return new DbToStorageDependencyTypes(strategy);
    }
}
