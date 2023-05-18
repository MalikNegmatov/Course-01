public class Main {

    public static void main(String[] args) {
        String[] names = new String[3];
        EmployeeBook book = new EmployeeBook();
        for (int i = 0; i < 7; i++) {
            java.util.Random random = new java.util.Random();
            names = generateName();
            book.addVictim(names[0],names[1],names[2], random.nextInt(5) + 1, random.nextInt(200000) + 40000);
        }
        System.out.println("Полный список сотрудников: ");
        book.printList();
        System.out.println();
        book.printDepartments();
        System.out.println();
        System.out.println("Сотрудники у которых зарплата меньше 120000");
        book.whoIsLooser(120000.0);
        System.out.println();
        System.out.println("Сотрудники у которых зарплата выше 140000");
        book.whoIsWinner(140000.0);
        System.out.println();
        book.modifyVictimD(names[0], names[1], names[2], 3 );
        book.modifyVictimS(names[0], names[1], names[2], 132931.0 );
        System.out.println("Сотрудники у которых зарплата меньше 120000");
        book.whoIsLooser(120000);
        System.out.println();
        System.out.println("Сотрудник отдела 3 с наименьшей зарплатой в отделе");
        book.searchDepartmentLooser(3);
        System.out.println();
        System.out.println("Сотрудник отдела 4 с наибольшей зарплатой в отделе");
        book.searchDepartmentWinner(4);
        System.out.println();
        book.allDepartmentSalary(2);
        System.out.println();
        book.averageDepartmentSalary(5);
        System.out.println();
        System.out.println("Индексация запрлаты сотрудников отдела 5");
        book.indexDepartmentSalary(5, 7.06);
        System.out.println();
        book.averageDepartmentSalary(5);
        System.out.println();
        book.deleteVictim(4);
        book.deleteVictim("Кирилл", "Петрович", "Сергеев");
    }
    private static String[] generateName() {
        java.util.Random random = new java.util.Random();
        String[] names = new String[3];
        names[0] = firstNames[random.nextInt(21)];
        names[1] = middleNames[random.nextInt(21)];
        names[2] = lastNames[random.nextInt(21)];
        return names;
    }

    public static String[] firstNames = new String[] {"Иван", "Сергей", "Борис", "Павел", "Геннадий", "Алексей", "Александр",
            "Виталий", "Олег", "Василий", "Петр", "Руслан", "Марат", "Владимир", "Дмитрий", "Радион", "Федор",
            "Семен", "Кирилл", "Андрей", "Феликс"};
    public static String[] middleNames = new String[] {"Иванович", "Сергеевич", "Борисович", "Павлович", "Геннадьевич",
            "Алексеевич", "Александрович", "Витальевич", "Олегович", "Васильевич", "Петрович", "Русланович",
            "Маратович", "Владимирович", "Дмитриевич", "Радионович", "Федорович", "Семенович", "Кириллович",
            "Андреевич", "Константинович"};
    public static String[] lastNames = new String[] {"Хорошилов", "Сергеев", "Борисов", "Павлов", "Семашко",
            "Васильев", "Родионов", "Прохоров", "Райкунов", "Малышев", "Точилин", "Сгибнев", "Фоминов",
            "Макаров", "Захаренко", "Шевченко", "Маслов", "Курбатов", "Шеин", "Рязанов", "Егоров"};
}