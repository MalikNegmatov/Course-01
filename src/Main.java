public class Main {
    public static void main(String[] args) {
        Employee e = new Employee("василий", "петрович", "сидоров", 6, 119);
        System.out.println(e.getDepartment());
        e.setDepartment(4);
        System.out.println(e.getDepartment());
    }
}