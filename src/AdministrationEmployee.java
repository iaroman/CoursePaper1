public class AdministrationEmployee {
    public void increaseSalary (Employee [] arr, int increasePer) {
        double increaseSalary;
        for (int i = 0; i < arr.length; i++) {
            increaseSalary = (arr[i].getSalary()/100) * increasePer;
            arr[i].setSalary((int)(arr[i].getSalary() + increaseSalary));
        }
    }
    public void minSalaryInDepartment (Employee [] arr, Employee.Department department) {
        int index = 0;
        while (arr[index].getDepartment() != department) {
            index++;
            if (index == arr.length) {
                System.out.println("Результат поиска сотрудника с минимальной зарплатой: В отделе " + department + " никто пока не работает");
                return;
            }
        }
        for (int i = index + 1; i < arr.length; i++) {
            if ( arr[i].getDepartment() == department) {
                if (arr[index].getSalary() > arr[i].getSalary())
                    index = i;
            }
        }
        System.out.println("Минимальная зарплата в отделе " + department + " у сотрудника:");
        System.out.println(arr[index]);
    }
    public void maxSalaryInDepartment (Employee [] arr, Employee.Department department) {
        int index = 0;
        while (arr[index].getDepartment() != department) {
            index++;
            if (index == arr.length) {
                System.out.println("Результат поиска сотрудника с максимальной зарплатой: В отделе " + department + " никто пока не работает");
                return;
            }
        }
        for (int i = index + 1; i < arr.length; i++) {
            if ( arr[i].getDepartment() == department) {
                if (arr[index].getSalary() < arr[i].getSalary())
                    index = i;
            }
        }
        System.out.println("Максимальная зарплата в отделе " + department + " у сотрудника:");
        System.out.println(arr[index]);
    }
    public int sumSalaryInDepartment (Employee [] arr, Employee.Department department) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if ( arr[i].getDepartment() == department) {
                sum += arr[i].getSalary();
            }
        }
        return sum;
    }
    public int averageSalaryInDepartment (Employee [] arr, Employee.Department department) {
        int employees = 0;
        for (int i = 0; i < arr.length; i++) {
            if ( arr[i].getDepartment() == department) {
                employees++;
            }
        }
        if (employees == 0) {
            System.out.println("Результат вычисления средней зарплаты: В отделе " + department + " никто пока не работает");
            return 0;
        }
        return sumSalaryInDepartment(arr, department) / employees;
    }
    public void increaseSalaryInDepartment (Employee [] arr, Employee.Department department, int increasePer) {
        double increaseSalary;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == department) {
                increaseSalary = (arr[i].getSalary() / 100) * increasePer;
                arr[i].setSalary((int) (arr[i].getSalary() + increaseSalary));
            }
        }
    }
    public void showListEmployeesInDepartment (Employee [] arr, Employee.Department department) {
        System.out.println("Список сотрудников отдела " + department + " :");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == department)
                System.out.println(arr[i].getEmployee());
        }
    }
    public void simpleSortEmployees (Employee [] arr, int number) {
        System.out.println("Сотрудники с зарплатой меньше, чем " + number);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() < number)
                System.out.println(arr[i]);
        }
        System.out.println("Сотрудники с зарплатой больше, чем " + number);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() >= number)
                System.out.println(arr[i]);
        }
    }
}
