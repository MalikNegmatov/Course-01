public class Employee {
    private String firstName;   // Имя
    private String middleName;  // Отчество
    private String lastName;    // Фамилия
    private int department;     // отдел (1..5)
    private int salary;         // зарплата
    public static int id = 1;   //  статическая переменная-счетчик, отвечает за id
    private final int employeeID = id;     // id сотрудника

    public Employee() {

        id++;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getDepartment() {
        return department;
    }
    public int getSalary() {
        return salary;
    }
    public int getEmployeeID() {
        return salary;
    }
}
