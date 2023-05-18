public class Employee {
    private String firstName;   // Имя
    private String middleName;  // Отчество
    private String lastName;    // Фамилия
    private int department;     // отдел (1..5)
    private int salary;         // зарплата
    public static int id = 1;   //  статическая переменная-счетчик, отвечает за id
    private int employeeID;     // id сотрудника

    public Employee() {
        this.employeeID = id;
        id++;
    }
}
