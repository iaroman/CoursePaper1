import java.util.Objects;

public class EmployeeBook {
    private Employee [] employees = new Employee[10];

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Якушин", "Роман", "Анатольевич", 100_000, Employee.Department.ONE);
        employeeBook.addEmployee("Романов", "Кирилл", "Анатольевич", 25_000, Employee.Department.ONE);
        employeeBook.addEmployee("Морозов", "Даниил", "Анатольевич", 30_000, Employee.Department.FIVE);
        employeeBook.addEmployee("Краснов", "Павел", "Анатольевич", 40_000, Employee.Department.FIVE);
        employeeBook.addEmployee("Воронов", "Иван", "Анатольевич", 50_000, Employee.Department.FIVE);
        employeeBook.addEmployee("Гаврилов", "Герман", "Анатольевич", 80_000, Employee.Department.ONE);

        employeeBook.showListEmployees();
        System.out.println("Sum salary: " + employeeBook.sumSalary());
        System.out.println("Sum salary department FIFE: " + employeeBook.sumSalary(Employee.Department.FIVE));
        System.out.println("Sum salary department ONE: " + employeeBook.sumSalary(Employee.Department.ONE));
        System.out.println("Min salary ");
        employeeBook.printEmployee(employeeBook.minSalaryIndex());
        System.out.println("Min salary department FIFE");
        employeeBook.printEmployee(employeeBook.minSalaryIndex(Employee.Department.FIVE));
        System.out.println("Max salary");
        employeeBook.printEmployee(employeeBook.maxSalaryIndex());
        System.out.println("Max salary department FiFE");
        employeeBook.printEmployee(employeeBook.maxSalaryIndex(Employee.Department.FIVE));
        System.out.println("Average salary: " + employeeBook.averageSalary());
        System.out.println("Average salary ONE: " + employeeBook.averageSalary(Employee.Department.ONE));

        employeeBook.changeEmployee(1, 500_000);
        employeeBook.changeEmployee(2, Employee.Department.FOUR);
        employeeBook.changeEmployee(3, "Теплов","Герман","Васильевич");
        employeeBook.showListEmployees();
        employeeBook.changeEmployee("Якушин","Роман","Анатольевич",1000);
        employeeBook.changeEmployee("Теплов","Герман","Васильевич", Employee.Department.TWO);
        employeeBook.changeEmployee("Теплов","Герман","Васильевич","Жарков","Ибн","Оглы");
        employeeBook.showListEmployees();

        employeeBook.deleteEmployee(1);
        employeeBook.showListEmployees();

        employeeBook.showListEmployeesDepartments();
    }
    private int searchNullIndex() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null)
                return i;
        }
        return -1;
    }
    private int searchFirstEmployeeDepartment(Employee.Department department) {
        for (int i = 0; i < searchNullIndex(); i++) {
            if (employees[i].getDepartment() == department)
                return i;
        }
        return -1;
    }
    private int searchEmployee (int id) {
        for (int i = 0; i < searchNullIndex(); i++) {
            if (employees[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
    private int searchEmployee (String somane, String name, String patronymic) {
        for (int i = 0; i < searchNullIndex(); i++) {
            if (Objects.equals(employees[i].getSoname(), somane) && Objects.equals(employees[i].getName(), name) && Objects.equals(employees[i].getPatronymic(), patronymic)) {
                return i;
            }
        }
        return -1;
    }
    private void deleteEmployeeByIndex(int index) {
        int endList = searchNullIndex() - 1;
        if (index >= 0 && index <= endList)
            if (index == endList)
                employees[index] = null;
            else {
                for (int i = index; i < endList; i++)
                    employees[i] = employees[i + 1];
                employees[endList] = null;
            }
    }
    public void addEmployee (String soname, String name, String patronymic, int salary, Employee.Department department) {
        employees[searchNullIndex()] = new Employee(soname, name, patronymic, salary, department);
    }
    public void deleteEmployee(int id) {
        int index = searchEmployee(id);
        if (index != -1)
            deleteEmployeeByIndex(index);
    }
    public void deleteEmployee(String soname, String name, String patronymic) {
        int index = searchEmployee(soname, name, patronymic);
        if (index != -1)
            deleteEmployeeByIndex(index);
    }
    public void changeEmployee (int id, String newSomane, String newName, String newPatronymic) {
        int index = searchEmployee(id);
        if (index != -1) {
            employees[index].setSoname(newSomane);
            employees[index].setName(newName);
            employees[index].setPatronymic(newPatronymic);
        }
    }
    public void changeEmployee (String soname, String name, String patronymic, String newSomane, String newName, String newPatronymic) {
        int index = searchEmployee(soname, name, patronymic);
        if (index != -1) {
            employees[index].setSoname(newSomane);
            employees[index].setName(newName);
            employees[index].setPatronymic(newPatronymic);
        }
    }
    public void changeEmployee (int id, int newSalary) {
        int index = searchEmployee(id);
        if (index != -1) {
            employees[index].setSalary(newSalary);
        }
    }
    public void changeEmployee (String soname, String name, String patronymic, int newSalary) {
        int index = searchEmployee(soname, name, patronymic);
        if (index != -1) {
            employees[index].setSalary(newSalary);
        }
    }
    public void changeEmployee (int id, Employee.Department newDepartment) {
        int index = searchEmployee(id);
        if (index != -1) {
            employees[index].setDepartment(newDepartment);
        }
    }
    public void changeEmployee (String soname, String name, String patronymic, Employee.Department newDepartment) {
        int index = searchEmployee(soname, name, patronymic);
        if (index != -1) {
            employees[index].setDepartment(newDepartment);
        }
    }
    public void showListEmployees() {
        System.out.println("Список всех сотрудников компании: ");
        for (int i = 0; i < searchNullIndex(); i++) {
            System.out.println(employees[i]);
        }
    }
    public void showListEmployees(Employee.Department department) {
        System.out.println("Список сотрудников отдела " + department + " :");
        for (int i = 0; i < searchNullIndex(); i++) {
            if (employees[i].getDepartment() == department)
                System.out.println(employees[i].getEmployee());
        }
    }
    public void showListEmployeesDepartments() {
        System.out.println("Список сотрудников компании по отделам");
        if (searchFirstEmployeeDepartment(Employee.Department.ONE) != -1) {
            System.out.println("Список сотрудников отдела ONE:");
            for (int i = 0; i < searchNullIndex(); i++) {
                if (employees[i].getDepartment() == Employee.Department.ONE)
                    System.out.println(employees[i].getEmployee());
            }
        }
        if (searchFirstEmployeeDepartment(Employee.Department.TWO) != -1) {
            System.out.println("Список сотрудников отдела TWO:");
            for (int i = 0; i < searchNullIndex(); i++) {
                if (employees[i].getDepartment() == Employee.Department.TWO)
                    System.out.println(employees[i].getEmployee());
            }
        }
        if (searchFirstEmployeeDepartment(Employee.Department.THREE) != -1) {
            System.out.println("Список сотрудников отдела THREE:");
            for (int i = 0; i < searchNullIndex(); i++) {
                if (employees[i].getDepartment() == Employee.Department.THREE)
                    System.out.println(employees[i].getEmployee());
            }
        }
        if (searchFirstEmployeeDepartment(Employee.Department.FOUR) != -1) {
            System.out.println("Список сотрудников отдела FOUR:");
            for (int i = 0; i < searchNullIndex(); i++) {
                if (employees[i].getDepartment() == Employee.Department.FOUR)
                    System.out.println(employees[i].getEmployee());
            }
        }
        if (searchFirstEmployeeDepartment(Employee.Department.FIVE) != -1) {
            System.out.println("Список сотрудников отдела FIVE:");
            for (int i = 0; i < searchNullIndex(); i++) {
                if (employees[i].getDepartment() == Employee.Department.FIVE)
                    System.out.println(employees[i].getEmployee());
            }
        }
    }
    public void printEmployee (int index) {
        if (index >= 0 && index < employees.length)
            System.out.println(employees[index]);
    }
    public int sumSalary () {
        int sum = 0;
        for (int i = 0; i < searchNullIndex(); i++)
                sum += employees[i].getSalary();
        return sum;
    }
    public int sumSalary (Employee.Department department) {
        int sum = 0;
        for (int i = 0; i < searchNullIndex(); i++) {
                if (employees[i].getDepartment() == department)
                    sum += employees[i].getSalary();
        }
        return sum;
    }
    public int minSalaryIndex () {
        int index = 0;
        for (int i = 1; i < searchNullIndex(); i++) {
                if (employees[i].getSalary() < employees[index].getSalary())
                    index = i;
        }
        return index;
    }
    public int minSalaryIndex (Employee.Department department) {
        if (searchFirstEmployeeDepartment(department) == -1)
            return -1;
        int index = searchFirstEmployeeDepartment(department);
        for (int i = index + 1; i < searchNullIndex(); i++) {
            if ( employees[i].getDepartment() == department) {
                if (employees[i].getSalary() < employees[index].getSalary())
                    index = i;
            }
        }
        return index;
    }
    public int maxSalaryIndex () {
        int index = 0;
        for (int i = 1; i < searchNullIndex(); i++) {
            if (employees[i].getSalary() > employees[index].getSalary())
                index = i;
        }
        return index;
    }
    public int maxSalaryIndex (Employee.Department department) {
        if (searchFirstEmployeeDepartment(department) == -1)
            return -1;
        int index = searchFirstEmployeeDepartment(department);
        for (int i = index + 1; i < searchNullIndex(); i++) {
            if ( employees[i].getDepartment() == department) {
                if (employees[i].getSalary() > employees[index].getSalary())
                    index = i;
            }
        }
        return index;
    }
    public void increaseSalary (int increasePer) {
        double increaseSalary;
        for (int i = 0; i < searchNullIndex(); i++) {
            increaseSalary = (employees[i].getSalary()/100) * increasePer;
            employees[i].setSalary((int)(employees[i].getSalary() + increaseSalary));
        }
    }
    public void increaseSalary (Employee.Department department, int increasePer) {
        double increaseSalary;
        for (int i = 0; i < searchNullIndex(); i++) {
            if (employees[i].getDepartment() == department) {
                increaseSalary = (employees[i].getSalary() / 100) * increasePer;
                employees[i].setSalary((int) (employees[i].getSalary() + increaseSalary));
            }
        }
    }
    public void simpleSortEmployees (int number) {
        System.out.println("Сотрудники с зарплатой меньше, чем " + number);
        for (int i = 0; i < searchNullIndex(); i++) {
            if (employees[i].getSalary() < number)
                System.out.println(employees[i]);
        }
        System.out.println("Сотрудники с зарплатой больше, чем " + number);
        for (int i = 0; i < searchNullIndex(); i++) {
            if (employees[i].getSalary() >= number)
                System.out.println(employees[i]);
        }
    }
    public double averageSalary() {
        return (double) (sumSalary() / searchNullIndex());
    }
    public double averageSalary(Employee.Department department) {
        int worker = 0;
        for (int i = 0; i < searchNullIndex(); i++) {
            if ( employees[i].getDepartment() == department) {
                worker++;
            }
        }
        if (worker == 0) {
            System.out.println("Результат вычисления средней зарплаты: В отделе " + department + " никто пока не работает");
            return 0;
        }
        return sumSalary(department) / worker;
    }
}
