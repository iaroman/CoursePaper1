public class Employee {
    private String soname, name, patronymic;
    private int salary;
    public enum Department {ONE, TWO, THREE, FOUR, FIVE};
    private Department department;
    static private int counter;
    private int id;
    public Employee(String soname, String name, String patronymic, int salary, Department department) {
        this.soname = soname;
        this.name = name;
        this.patronymic = patronymic;
        this.salary = salary;
        this.department = department;
        id = ++counter;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Сотрудник: " + soname + " " + name + " " + patronymic + ", зарплата: " + salary + ", отдел: " + department + ", id: " + id;
    }
    public String getEmployee() {
        return "Сотрудник: " + soname + " " + name + " " + patronymic + ", зарплата: " + salary + ", id: " + id;
    }
}
