package ARG;

import java.util.List;

public class Runner {
    List<DependencyFactory> dependencies;
    String startTime;
    String endTime;
    public void setDependencies(){
        dependencies.add(new DbToVmDependencyType());
        dependencies.add(new DbToStorageDependencyType());
    }

    public void execute(){
        for(DependencyFactory dependency : dependencies){
            DependencyType dependencyType = dependency.getDependencyType(startTime, endTime);
            dependencyType.executeStrategy();
        }
    }
}
