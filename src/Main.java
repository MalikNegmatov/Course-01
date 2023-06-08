public class Main {
    public static Employee[] eList = new Employee[10];

    public static double allSalarySum(Employee[] e) {
        double sum = 0.0;
        for (Employee o : e) {
            if ( o != null) {
                sum += o.getSalary();
            }
        }
        return sum;
    }
    public static int searchLooser(Employee[] e) {
        double min = e[0];
        int index = -1;
        for (int i = 0; i < e.length; i++){
            if ( (e[i] != null) && (min > e[i].getSalary()) ) {
                index = i;
                min = e[i].getSalary();
            }
        }
        return index;
    }

    public static int searchWinner(Employee[] e) {
        double max = 0;
        int index = -1;
        for (int i = 0; i < e.length; i++){
            if ( (e[i] != null) && (max < e[i].getSalary()) ) {
                index = i;
                max = e[i].getSalary();
            }
        }
        return index;
    }

    public static int sumID(Employee[] e) {
        int sum = 0;
        for ( Employee o : e ) {
            if ( o != null ) sum++;
        }
        return sum;
    }
    public static double averageSalary(Employee[] e) {
        if (sumID(e) != 0) {
            return  allSalarySum(e) / sumID(e);
        } else return 0.0;
    }
    public static void printList(Employee[] e) {
        for (Employee o : e ) {
            if ( o != null ) System.out.println(o);
        }
    }
    public static void indexSalary(Employee[] e, double percent) {
        for (Employee o : e) {
            if (o != null) o.setSalary(o.getSalary()*(1 + percent / 100));
        }
    }
    public static Employee[] departmentList (Employee[] e, int d) {
        Employee[] r = new Employee[10];
        int index = 0;
        for (Employee o : e) {
            if (o != null) {
                if (o.getDepartment() == d) {
                    r[index] = o;
                    index++;
                }
            }
        }
        return r;
    }
    public static void searchDepartmentLooser(int d) {
        Employee[] o = departmentList(eList, d);
        if (sumID(o) > 0) {
                System.out.println("Сотрудник с минимальной зарплатой отдела " + d + " : " + o[searchLooser(o)]);
            }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    public static void searchDepartmentWinner(int d) {
        Employee[] o = departmentList(eList, d);
        if ( sumID(o) > 0 ) {
            System.out.println("Сотрудник с максимальной зарплатой : " + o[searchWinner(o)]);
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    public static void allDepartmentSalary(int d) {
        Employee[] o = departmentList(eList, d);
        if ( sumID(o) > 0 ) {
            System.out.println("Сумма затрана на зарплату по отделу " + d + " = " + allSalarySum(o));
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    public static void averageDepartmentSalary(int d) {
        Employee[] o = departmentList(eList, d);
        if ( sumID(o) > 0 ) {
            System.out.println("Средняя зарплата по отделу " + d + " = " + averageSalary(o));
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    public static void indexDepartmentSalary(int d, double p) {
        Employee[] o = departmentList(eList, d);
        if ( sumID(o) > 0 ) {
            indexSalary(o, p);
            printList(o);
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    public static void printDepartment(int d) {
        Employee[] o = departmentList(eList, d);
        if ( sumID(o) > 0 ) {
            for (Employee m : o ) {
               if ( m != null ) System.out.printf("%-3s%-12s%-12s%-12s%-10s\n", m.getEmployeeID(), m.getLastName(), m.getFirstName(), m.getMiddleName(), m.getSalary());
            }
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    public static void whoIsLooser( double w ) {
        for (Employee o : eList) {
            if ( o != null ) {
                if (o.getSalary() < w) System.out.printf("%-3s%-12s%-12s%-12s%-10s\n", o.getEmployeeID(), o.getLastName(), o.getFirstName(), o.getMiddleName(), o.getSalary());
            }
        }
    }
    public static void whoIsWinner( double w ) {
        for (Employee o : eList) {
            if ( o != null ) {
                if (o.getSalary() > w) System.out.printf("%-3s%-12s%-12s%-12s%-10s\n", o.getEmployeeID(), o.getLastName(), o.getFirstName(), o.getMiddleName(), o.getSalary());
            }
        }
    }

    public static void main(String[] args) {
        eList[0] = new Employee("Арсений", "Петрович", "присказка", 2, 203912);
        eList[1] = new Employee("Виталий", "Петрович", "подсказка", 3, 123123);
        eList[2] = new Employee("Корней", "Петрович", "сказка", 4, 142124);
        eList[3] = new Employee("Лариса", "Петровна", "расказова", 5, 242124);
        printList(eList);
        System.out.println("Сумма затрат на зарплаты в месяц = " + allSalarySum(eList));
        System.out.println("Сотрудник с минимальной зарплатой : " + eList[searchLooser(eList)]);
        eList[0].setSalary(57000);
        eList[0].setDepartment(1);
        System.out.println("Сотрудник с минимальной зарплатой : " + eList[searchLooser(eList)]);
        System.out.println("Сотрудник с максимальной зарплатой : " + eList[searchWinner(eList)]);
        System.out.println("Средняя зарплата = " + averageSalary(eList));
        indexSalary(eList, 5.6);
        printList(eList);
        System.out.println();
        indexSalary(eList, -12.2);
        printList(eList);
        System.out.println();
        searchDepartmentLooser(3);
        System.out.println();
        searchDepartmentWinner(2);
        System.out.println();
        allDepartmentSalary(2);
        System.out.println();
        eList[4] = new Employee("АлексанДР", "Петрович", "Недосказка", 4, 122124);
        eList[5] = new Employee("Алексей", "Петрович", "Сказка-на-Ночь", 4, 432211);
        allDepartmentSalary(4);
        System.out.println();
        averageDepartmentSalary(2);
        System.out.println();
        averageDepartmentSalary(4);
        indexDepartmentSalary(4, 12.85);
        averageDepartmentSalary(4);
        printDepartment(4);
        System.out.println();
        printList(eList);
        System.out.println();
        whoIsLooser(120000.0);
        System.out.println();
        whoIsWinner(140000.0);
    }
}