package Random.ARG1;

import java.util.List;

public class Runner {
    List<DependencyType> dependencies;
    String startTime;
    String endTime;
    public void setDependencies(){
        dependencies.add(new DbToVmDependencyType());
        dependencies.add(new DbToStorageDependencyType());
    }

    public void execute(){
        for(DependencyType dependency : dependencies){
            Dependency dependencyType = dependency.getDependencyType(startTime, endTime);
            dependencyType.executeStrategy();
        }
    }
}
