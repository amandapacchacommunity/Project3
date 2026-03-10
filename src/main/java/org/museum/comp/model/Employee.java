package org.museum.comp.model;

public class Employee {

    private String employeeId;
    private String name;
    private String department;
    private String roleTitle;

    // Generic job ladder architecture (similar to consulting frameworks)
    private RoleLevel roleLevel;

    private int fiscalYear;

    private double salary;
    private double bonus;

    private boolean frontline;
    private boolean endowedPosition;

    private int yearsExperience;

    private boolean retainedNextYear;

    public Employee() {}

    public Employee(
            String employeeId,
            String name,
            String department,
            String roleTitle,
            RoleLevel roleLevel,
            int fiscalYear,
            double salary,
            double bonus,
            boolean frontline,
            boolean endowedPosition,
            int yearsExperience,
            boolean retainedNextYear
    ) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.roleTitle = roleTitle;
        this.roleLevel = roleLevel;
        this.fiscalYear = fiscalYear;
        this.salary = salary;
        this.bonus = bonus;
        this.frontline = frontline;
        this.endowedPosition = endowedPosition;
        this.yearsExperience = yearsExperience;
        this.retainedNextYear = retainedNextYear;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public RoleLevel getRoleLevel() {
        return roleLevel;
    }

    public int getFiscalYear() {
        return fiscalYear;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public boolean isFrontline() {
        return frontline;
    }

    public boolean isEndowedPosition() {
        return endowedPosition;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public boolean isRetainedNextYear() {
        return retainedNextYear;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}
