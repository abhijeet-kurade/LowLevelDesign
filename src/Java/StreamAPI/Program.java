package Java.StreamAPI;

import Utils.Emp;
import Utils.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Execute e = new Execute();
        e.execute();
    }
}



class Execute {
    public void execute(){
        List<Employee> list = Arrays.asList(
                new Employee(1, 1, "abk", 100),
                new Employee(2, 2, "gad", 20),
                new Employee(3, 1, "sbf", 110),
                new Employee(4, 3, "xyz", 10),
                new Employee(5, 1, "tpq", 220),
                new Employee(6, 3, "sde", 10),
                new Employee(7, 2, "gab", 20)
        );

        List<Emp> emps = list.stream().map((employee) -> new Emp(employee.getId(), employee.getName())).collect(Collectors.toList());

        List<Employee> listss = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), (List<Employee> s) -> {
            return s.stream().sorted((o1, o2)-> o2.getSalary() - o1.getSalary()).limit(3).collect(Collectors.toList());
        } ));

        Map<Integer, List<Employee>> depSal = list.stream().collect(Collectors.groupingBy(Employee::getDeptId,
                Collectors.collectingAndThen(Collectors.toList(),
                        (List<Employee> ls )->{
                            return ls.stream().sorted((o1, o2)-> o2.getSalary() - o1.getSalary()).limit(2).collect(Collectors.toList());
                        })));
        System.out.println(depSal);



    }
}


