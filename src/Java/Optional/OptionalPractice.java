package Java.Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalPractice {

    class Employee{
        int id;
        String name;
        int dept;
        int salary;

        public Employee(int id, String name, int dept, int salary) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public Optional<Employee> getEmployee(List<Employee> emps, int id){

        Optional<Employee> emp =emps.stream().filter(item -> item.id == id).findFirst();
        return emp;
    }
    public static void main(String[] args) {
        OptionalPractice op = new OptionalPractice();
        op.run();
    }

    public void run(){
        List<Employee> list = Arrays.asList(new Employee(10, "qwr"),
                new Employee(13, "fghu"),
                new Employee(16, "adfs"),
                new Employee(13, "saef"));
        Optional<Employee> oneEmp = getEmployee(list, 1);
        if(oneEmp.isEmpty()) return;
        System.out.println(oneEmp.get().name);
    }
}
