import java.util.*;

class Company extends Node {

    private String industry;
    private Map<Person, String> employees; // maps employees to their job position

    public Company(String name, String industry) {
        super(name, null);
        this.industry = industry;
        this.employees = new HashMap<Person, String>();
    }

    public String getIndustry() {
        return industry;
    }

    public void addEmployee(Person employee, String jobPosition) {
        employees.put(employee, jobPosition);
        employee.addRelationship(this, "works for"); // create a person-to-company relationship
    }

    public Map<Person, String> getEmployees() {
        return employees;
    }
}