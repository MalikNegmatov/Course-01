public class Main {
    public static Employee[] eList = new Employee[10];
    public static void main(String[] args) {
        Employee e = new Employee("василий", "петрович", "сидоров", 6, -119);
        System.out.println(e.getDepartment());
        e.setDepartment(4);
        System.out.println(e.getDepartment());
        System.out.println(e.getSalary());
        e.setSalary(323);

        eList[0] = new Employee("Арсений", "Петрович", "сказка", 2, 203912);
        System.out.println(eList[0]);
        System.out.println(eList[1]);
    }

}