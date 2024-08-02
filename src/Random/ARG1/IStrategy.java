package Random.ARG1;

public interface IStrategy {
    void execute();
}

class CmsQueryStrategy implements IStrategy{

    String cmsQuery;
    String startTime;
    String endTime;

    public CmsQueryStrategy(String cmsQuery, String startTime, String endTime) {
        this.cmsQuery = cmsQuery;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    @Override
    public void execute() {
        // some logic to execute the CMS query.
        // ..
        // ..
    }
}


class FallBackStrategy implements IStrategy{

    String cmsResourceQuery;
    String cmsDependenciesQuery;
    String kustoDependenciesQuery;
    String startTime;
    String endTime;

    public FallBackStrategy(String cmsResourceQuery, String cmsDependenciesQuery, String kustoDependenciesQuery, String startTime, String endTime) {
        this.cmsResourceQuery = cmsResourceQuery;
        this.cmsDependenciesQuery = cmsDependenciesQuery;
        this.kustoDependenciesQuery = kustoDependenciesQuery;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public void execute() {
        // some logic to execute the fall back strategy.
        // ..
        // ..
    }
}

