import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Task1312 {
    private final static Logger logger = Logger.getLogger("LOG");

    public static void main(String[] args) throws ParseException {
        Database database = new Database();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");
        database.addEmployee(new Employee("Bob", "bob", "ddd", dateFormat.parse("11.01.2016")));
        database.addEmployee(new Employee("Tom", "bob", "bip", dateFormat.parse("11.01.2015")));
        database.addEmployee(new Employee("Bob", "Ilya", "bob", dateFormat.parse("11.05.2013")));
        database.addEmployee(new Employee("Bob", "bob", "bob", dateFormat.parse("11.01.2014")));
        database.addEmployee(new Employee("Bob", "bob", dateFormat.parse("11.01.2016")));
        database.addEmployee(new Employee("Vitaliy", "bob", "bob", dateFormat.parse("11.01.2016")));
        database.addEmployee(new Employee("Bob", "bob", "bob", dateFormat.parse("11.04.2011")));
        database.addEmployee(new Employee("Jon", "bob", "bob", dateFormat.parse("11.02.2010")));
        database.addEmployee(new Employee("James", "t", dateFormat.parse("11.11.2018")));
        database.getEmployeesWithWorkYears(3).forEach(employee -> logger.info(employee.getEmployeeInfo()));
        database.findEmployeesBySubstring("vit").forEach(employee -> logger.info(employee.getEmployeeInfo()));

    }
}

class Employee {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date employDate;

    public Employee(String firstName, String lastName, Date employDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = "";
        this.employDate = employDate;
    }

    public Employee(String firstName, String lastName, String middleName, Date employDate) {
        this(firstName, lastName, employDate);
        this.middleName = middleName;
    }

    public int getWorkYears(Date today) {
        Calendar employCal = Calendar.getInstance();
        employCal.setTime(employDate);
        Calendar todayCal = Calendar.getInstance();
        todayCal.setTime(today);
        int yearDiff = todayCal.get(Calendar.YEAR) - employCal.get(Calendar.YEAR);
        if (todayCal.get(Calendar.MONTH) < employCal.get(Calendar.MONTH)) {
            yearDiff--;
        }
        return yearDiff;
    }

    public String getEmployeeInfo() {
        return firstName + " " + lastName + " " + middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
}

class Database {
    private List<Employee> employees;

    public Database() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployeesWithWorkYears(int years) {
        List<Employee> result = new ArrayList<>();
        Date now = new Date();
        employees.forEach(employee -> {
            if (years == employee.getWorkYears(now)) {
                result.add(employee);
            }
        });
        //employees.stream().filter(employee -> years == employee.getWorkYears(now)).map(employee -> result.add(employee)).collect(Collectors.toList());
        return result;
    }

    public List<Employee> findEmployeesBySubstring(String substring) {
        String upperCaseSubstring = substring.toUpperCase();
        return employees.stream()
                .filter(employee ->
                        employee.getLastName().toUpperCase().contains(upperCaseSubstring) ||
                                employee.getFirstName().toUpperCase().contains(upperCaseSubstring) ||
                                employee.getMiddleName().toUpperCase().contains(upperCaseSubstring)).collect(Collectors.toList());

    }
}