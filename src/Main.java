public class Main {

    public static void main(String[] args) {
        Employee [] employees = new Employee[10];
        employees[0] = new Employee("Якушин", "Роман", "Анатольевич", 10_000, Employee.Department.FOUR);
        employees[1] = new Employee("Чуликова", "Анна", "Сергеевна", 100_000, Employee.Department.FOUR);
        employees[2] = new Employee("Морозов", "Даниил", "Сергеевич", 100_000, Employee.Department.TWO);
        employees[3] = new Employee("Смирнов", "Андрей", "Андреевич", 1000, Employee.Department.TWO);
        employees[4] = new Employee("Смирнова", "Анна", "Сергевна", 200_000, Employee.Department.THREE);
        employees[5] = new Employee("Смашная", "Ирина", "Михайловна", 20_000, Employee.Department.THREE);
        employees[6] = new Employee("Иванов", "Иван", "Иванович", 30_000, Employee.Department.FIVE);
        employees[7] = new Employee("Шмид", "Герман", "Дийевич", 40_000, Employee.Department.FIVE);
        employees[8] = new Employee("Лось", "Андрей", "Михайлович", 50_000, Employee.Department.FIVE);
        employees[9] = new Employee("Петров", "Петр", "Эдуардович", 60_000, Employee.Department.FIVE);

        showListEmployees(employees);
        System.out.println("Сумма расходов по зарплате: " + sumSalary(employees));
        System.out.println("Минимальная зарплата:");
        minSalary(employees);
        System.out.println("Максимальная зарплата:");
        maxSalary(employees);
        System.out.println("Средняя зарплата сотрудников: " + averageSalary(employees));

        AdministrationEmployee administrationEmployee = new AdministrationEmployee();
        administrationEmployee.increaseSalary(employees, 10);
        showListEmployees(employees);
        administrationEmployee.minSalaryInDepartment(employees, Employee.Department.FIVE);
        administrationEmployee.maxSalaryInDepartment(employees, Employee.Department.TWO);
        System.out.println("Сумма расходов по зарплате в отделе: " +
                administrationEmployee.sumSalaryInDepartment(employees, Employee.Department.THREE));
        System.out.println("Средняя зарплата сотрудников в отделе: " +
                administrationEmployee.averageSalaryInDepartment(employees, Employee.Department.THREE));
        administrationEmployee.increaseSalaryInDepartment(employees, Employee.Department.FIVE, 20);
        administrationEmployee.showListEmployeesInDepartment(employees, Employee.Department.FIVE);
        administrationEmployee.simpleSortEmployees(employees, 60_000);
    }
    public static void showListEmployees (Employee [] arr) {
        System.out.println("Список всех сотрудников компании: ");
        for (Employee emp : arr) {
            System.out.println(emp);
        }
    }
    public static int sumSalary (Employee [] arr) {
        int sum = 0;
        for (Employee emp : arr) {
            sum += emp.getSalary();
        }
        return sum;
    }
    public static void minSalary (Employee [] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[index].getSalary() > arr[i].getSalary())
                index = i;
        }
        System.out.println(arr[index]);
    }
    public static void maxSalary (Employee [] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[index].getSalary() < arr[i].getSalary())
                index = i;
        }
        System.out.println(arr[index]);
    }
    public static double averageSalary (Employee [] arr) {
        return (double) (sumSalary(arr) / arr.length);
    }

}