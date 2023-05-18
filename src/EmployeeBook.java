public class EmployeeBook {
    private final Employee[] eBook = new Employee[10];

    public double getSalarySum(Employee[] e) {
        double sum = 0.0;
        for (Employee o : e) {
            if (o != null) {
                sum += o.getSalary();
            }
        }
        return sum;
    }

    public int searchLooser(Employee[] e) {
        double min = 500000.0;
        int index = -1;
        for (int i = 0; i < e.length; i++) {
            if ((e[i] != null) && (min > e[i].getSalary())) {
                index = i;
                min = e[i].getSalary();
            }
        }
        return index;
    }

    public int searchWinner(Employee[] e) {
        double max = 0;
        int index = -1;
        for (int i = 0; i < e.length; i++) {
            if ((e[i] != null) && (max < e[i].getSalary())) {
                index = i;
                max = e[i].getSalary();
            }
        }
        return index;
    }

    public int sumID(Employee[] e) {
        int sum = 0;
        for (Employee o : e) {
            if (o != null) sum++;
        }
        return sum;
    }

    public double averageSalary(Employee[] e) {
        if (sumID(e) != 0) {
            return getSalarySum(e) / sumID(e);
        } else return 0.0;
    }

    public void printList(Employee[] e) {
        for (Employee o : e) {
            if (o != null) System.out.println(o);
        }
    }
    public void printList() {
        for (Employee o : eBook) {
            if (o != null) System.out.println(o);
        }
    }

    public void indexSalary(Employee[] e, double percent) {
        for (Employee o : e) {
            if (o != null) o.setSalary(o.getSalary() * (1 + percent / 100));
        }
    }

    public Employee[] departmentList(Employee[] e, int d) {
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

    public void searchDepartmentLooser(int d) {
        Employee[] o = departmentList(eBook, d);
        if (sumID(o) > 0) {
            System.out.println("Сотрудник с минимальной зарплатой отдела " + d + " : " + o[searchLooser(o)]);
        } else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }

    public void searchDepartmentWinner(int d) {
        Employee[] o = departmentList(eBook, d);
        if (sumID(o) > 0) {
            System.out.println("Сотрудник с максимальной зарплатой : " + o[searchWinner(o)]);
        } else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }

    public void allDepartmentSalary(int d) {
        Employee[] o = departmentList(eBook, d);
        if (sumID(o) > 0) {
            System.out.println("Сумма затрат на зарплату по отделу " + d + " = " + getSalarySum(o));
        } else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }

    public void averageDepartmentSalary(int d) {
        Employee[] o = departmentList(eBook, d);
        if (sumID(o) > 0) {
            System.out.println("Средняя зарплата по отделу " + d + " = " + averageSalary(o));
        } else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }

    public void indexDepartmentSalary(int d, double p) {
        Employee[] o = departmentList(eBook, d);
        if (sumID(o) > 0) {
            indexSalary(o, p);
            printList(o);
        } else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }

    private void printDepartment(int d) {
        Employee[] o = departmentList(eBook, d);
        if (sumID(o) > 0) {
            for (Employee m : o) {
                if (m != null)
                    System.out.printf("%-3s%-12s%-12s%-12s%-10s\n", m.getEmployeeID(), m.getLastName(), m.getFirstName(), m.getMiddleName(), m.getSalary());
            }
        } else {
            System.out.println("В отделе " + d + " нет сотрудников.");
        }
    }

    public void whoIsLooser(double w) {
        for (Employee o : eBook) {
            if (o != null) {
                if (o.getSalary() < w)
                    System.out.printf("%-3s%-12s%-12s%-12s%-10s\n", o.getEmployeeID(), o.getLastName(), o.getFirstName(), o.getMiddleName(), o.getSalary());
            }
        }
    }

    public void whoIsWinner(double w) {
        for (Employee o : eBook) {
            if (o != null) {
                if (o.getSalary() > w)
                    System.out.printf("%-3s%-12s%-12s%-12s%-10s\n", o.getEmployeeID(), o.getLastName(), o.getFirstName(), o.getMiddleName(), o.getSalary());
            }
        }
    }

    public void addVictim(String firstName, String middleName, String lastName, int department, int salary) {
        for (int i = 0; i < 10; i++) {
            if (eBook[i] == null) {
                eBook[i] = new Employee(firstName, middleName, lastName, department, salary);
                return;
            }
        }
        System.out.println("Книга заполнена");
    }
    public void deleteVictim(String firstName, String middleName, String lastName) {
        for (int i = 0; i < 10; i++) {
            if ( eBook[i] != null ) {
                if (eBook[i].getLastName().equals(lastName) && eBook[i].getFirstName().equals(firstName) && eBook[i].getMiddleName().equals(middleName) ) {
                    eBook[i] = null;
                    return;
                }
            }
        }
        System.out.println("Сотрудник с такими данными в книге отсутствует");
    }
    public void deleteVictim(int id) {
        for (int i = 0; i < 10; i++)
            if (eBook[i].getEmployeeID() == id) {
                eBook[i] = null;
                return;
            }
        System.out.println("Сотрудник с таким id в книге отсутствует");
    }
    public void modifyVictimD(String firstName, String middleName, String lastName, int department) {
        for (int i = 0; i < 10; i++) {
            if (eBook[i].getLastName().equals(lastName) && eBook[i].getFirstName().equals(firstName) && eBook[i].getMiddleName().equals(middleName) ) {
                eBook[i].setDepartment(department);
                return;
            }
        }
        System.out.println("Сотрудник с такими данными ФИО в книге отсутствует");
    }
    public void modifyVictimS(String firstName, String middleName, String lastName, double salary) {
        for (int i = 0; i < 10; i++) {
            if (eBook[i].getLastName().equals(lastName) && eBook[i].getFirstName().equals(firstName) && eBook[i].getMiddleName().equals(middleName) ) {
                eBook[i].setSalary(salary);
                return;
            }
        }
        System.out.println("Сотрудник с такими данными ФИО в книге отсутствует");
    }
    public void printDepartments() {
        for ( int i = 1; i < 6; i++) {
            System.out.println("Список отдела " + i);
            printDepartment(i);
        }
    }
}
