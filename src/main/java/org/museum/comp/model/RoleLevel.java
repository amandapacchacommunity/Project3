package org.museum.comp.model;

/*
 Generic Global Role Architecture Framework (GRAF)

 This structure mirrors common job architecture used in
 compensation consulting but is coded generically.

 Levels represent increasing scope, leadership responsibility,
 and compensation band ranges.
*/

public enum RoleLevel {

    IC1(40000, 55000),
    IC2(50000, 70000),
    IC3(65000, 90000),

    MANAGER(85000, 120000),
    SENIOR_MANAGER(110000, 150000),

    DIRECTOR(140000, 220000),

    EXECUTIVE(200000, 500000);

    private final double minSalary;
    private final double maxSalary;

    RoleLevel(double minSalary, double maxSalary) {
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public boolean isWithinBand(double salary) {
        return salary >= minSalary && salary <= maxSalary;
    }

}
