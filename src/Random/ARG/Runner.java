package Random.ARG;

import java.util.List;

public class Runner  {
    List<DependencyFactory> dependencies;
    String startTime;
    String endTime;
    public void setDependencies(){
        dependencies.add(new DbToVmDependencyType());
        dependencies.add(new DbToStorageDependencyType());
        dependencies.add(new DbToVMSubClass());
    }

    public void execute(){
        for(DependencyFactory dependency : dependencies){
            DependencyType dependencyType = dependency.getDependencyType(startTime, endTime);
            dependencyType.executeStrategy();
            int n = A.num;
            A a = new A();
            int o = a.x;
        }
    }
}

class A{
    static int num;
    int x;
}