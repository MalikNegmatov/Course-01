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
    public void setDepartment(int department) {
        if ( checkDepartment(department) ) {
            this.department = department;
        }
        else System.out.println("Значение отдела должно быть от 1 до 5");
    }
    public void setSalary(int salary) {
        if ( salary > 0 )
            this.salary = salary;
        else System.out.println("Зарплата не может быть отрицательной");
    }

    // Проверки на ошибки
    private boolean checkDepartment(int department) {
        return ( department > 0 && department < 6 );
    }
}
