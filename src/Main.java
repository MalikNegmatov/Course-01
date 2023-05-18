public class Main {
    public static Employee[] eList = new Employee[10];

    public static int allSalarySum(Employee[] e) {
        int sum = 0;
        for (Employee o : e) {
            if ( o != null) {
                sum += o.getSalary();
            }
        }
        return sum;
    }

    public static int searchLooser(Employee[] e) {
        int min = 500000, index=0;
        for (int i = 0; i < e.length; i++){
            if ( (e[i] != null) && (min > e[i].getSalary()) ) {
                index = i;
                min = e[i].getSalary();
            }
        }
        return index;
    }

    public static void main(String[] args) {

        eList[0] = new Employee("Арсений", "Петрович", "сказка", 2, 203912);
        eList[1] = new Employee("Виталий", "Петрович", "сказка", 3, 123123);
        eList[2] = new Employee("Корней", "Петрович", "сказка", 4, 142124);
        System.out.println(eList[0]);
        System.out.println(eList[1]);
        System.out.println(eList[2]);
        System.out.println(allSalarySum(eList));
        System.out.println(eList[searchLooser(eList)]);
    }

}