public class Employee {
    private final String firstName;   // Имя
    private final String middleName;  // Отчество
    private final String lastName;    // Фамилия
    private int department;     // отдел (1..5)
    private int salary;         // зарплата
    public static int id = 1;   //  статическая переменная-счетчик, отвечает за id
    private final int employeeID;     // id сотрудника


     /* Конструктор класса
     */
    public Employee(String firstName, String middleName, String lastName, int department, int salary) {
        this.firstName = formatField(firstName);
        this.middleName = formatField(middleName);
        this.lastName = formatField(lastName);
        this.employeeID = id;
        id++;
        if ( salary > 0 ) {
            this.salary = salary;
        }
        else {
            System.out.println("Зарплата сотрудника не может быть отрицательной.");
            System.out.println("Установите зарплату сотрудника через сеттер");
            this.salary = -1;
        }
        if ( checkDepartment(department) ) {
            this.department = department;
        }
        else {
            System.out.println("Номер отдела должен быть задан в диапазоне от 1 до 5");
            System.out.println("Сотруднику присвоен номер отдела 5. Установите правильный номер отдела через сеттер");
            this.department = 5;
        }
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
        return employeeID;
    }
    public void setDepartment(int department) {
        if ( checkDepartment(department) ) {
            this.department = department;
        }
        else System.out.println("Номер отдела должен быть задан в диапазоне от 1 до 5");
    }
    public void setSalary(int salary) {
        if ( salary > 0 )
            this.salary = salary;
        else System.out.println("Зарплата не может быть отрицательной");
    }
    @Override
    public String toString() {
        return String.format("%-3s%-12s%-12s%-12s%-3s%-10s", this.getEmployeeID(), this.getLastName(), this.getFirstName(), this.getMiddleName(), this.getDepartment(), this.getSalary());
    }
    // Проверки на ошибки
    /**
     * Метод проверки вводимых значений в поле department
     * @param department - поле должно принимать значения от 1 до 5
     * @return возвращает true, если значение поля в диапазоне от 1 до 5
     */
    private boolean checkDepartment(int department) {
        return ( department > 0 && department < 6 );
    }

    /**
     * Метод форматирования вводимых значеий в поля ФИО
     * @param field - строка переданная в конструктор
     * @return возвращает в форматем первая заглавная, остальные строчные
     */
    public String formatField(String field) {
        return field.substring(0, 1).toUpperCase() + field.substring(1).toLowerCase();
    }
}
