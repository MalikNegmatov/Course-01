public class EmployeeBook {
    private Employee[] eBook = new Employee[10];

    private double getSalarySum(Employee[] e) {
        double sum = 0.0;
        for (Employee o : e) {
            if ( o != null) {
                sum += o.getSalary();
            }
        }
        return sum;
    }
    private int searchLooser(Employee[] e) {
        double min = 500000.0;
        int index = -1;
        for (int i = 0; i < e.length; i++){
            if ( (e[i] != null) && (min > e[i].getSalary()) ) {
                index = i;
                min = e[i].getSalary();
            }
        }
        return index;
    }
    private int searchWinner(Employee[] e) {
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

    private int sumID(Employee[] e) {
        int sum = 0;
        for ( Employee o : e ) {
            if ( o != null ) sum++;
        }
        return sum;
    }
    private double averageSalary(Employee[] e) {
        if (sumID(e) != 0) {
            return  getSalarySum(e) / sumID(e);
        } else return 0.0;
    }
    private void printList(Employee[] e) {
        for (Employee o : e ) {
            if ( o != null ) System.out.println(o);
        }
    }
    private void indexSalary(Employee[] e, double percent) {
        for (Employee o : e) {
            if (o != null) o.setSalary(o.getSalary()*(1 + percent / 100));
        }
    }
    private Employee[] departmentList (Employee[] e, int d) {
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
    private void searchDepartmentLooser(int d) {
        Employee[] o = departmentList(eBook, d);
        if (sumID(o) > 0) {
            System.out.println("Сотрудник с минимальной зарплатой отдела " + d + " : " + o[searchLooser(o)]);
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    private void searchDepartmentWinner(int d) {
        Employee[] o = departmentList(eBook, d);
        if ( sumID(o) > 0 ) {
            System.out.println("Сотрудник с максимальной зарплатой : " + o[searchWinner(o)]);
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    private void allDepartmentSalary(int d) {
        Employee[] o = departmentList(eBook, d);
        if ( sumID(o) > 0 ) {
            System.out.println("Сумма затрана на зарплату по отделу " + d + " = " + getSalarySum(o));
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    private void averageDepartmentSalary(int d) {
        Employee[] o = departmentList(eBook, d);
        if ( sumID(o) > 0 ) {
            System.out.println("Средняя зарплата по отделу " + d + " = " + averageSalary(o));
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    private void indexDepartmentSalary(int d, double p) {
        Employee[] o = departmentList(eBook, d);
        if ( sumID(o) > 0 ) {
            indexSalary(o, p);
            printList(o);
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    private void printDepartment(int d) {
        Employee[] o = departmentList(eBook, d);
        if ( sumID(o) > 0 ) {
            for (Employee m : o ) {
                if ( m != null ) System.out.printf("%-3s%-12s%-12s%-12s%-10s\n", m.getEmployeeID(), m.getLastName(), m.getFirstName(), m.getMiddleName(), m.getSalary());
            }
        }
        else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }
    private void whoIsLooser( double w ) {
        for (Employee o : eBook) {
            if ( o != null ) {
                if (o.getSalary() < w) System.out.printf("%-3s%-12s%-12s%-12s%-10s\n", o.getEmployeeID(), o.getLastName(), o.getFirstName(), o.getMiddleName(), o.getSalary());
            }
        }
    }
    private void whoIsWinner( double w ) {
        for (Employee o : eBook) {
            if ( o != null ) {
                if (o.getSalary() > w) System.out.printf("%-3s%-12s%-12s%-12s%-10s\n", o.getEmployeeID(), o.getLastName(), o.getFirstName(), o.getMiddleName(), o.getSalary());
            }
        }
    }
}
