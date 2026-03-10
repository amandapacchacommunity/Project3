package org.museum.comp.service;

import org.museum.comp.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/*
 LivingWageService

 Compares employee salaries against a living wage benchmark.

 Used to identify workforce segments that fall below
 sustainable compensation levels.
*/

public class LivingWageService {

    // Annual living wage estimate for NYC single adult household
    private static final double LIVING_WAGE = 60000;

    private List<Employee> employees;

    public LivingWageService(List<Employee> employees) {
        this.employees = employees;
    }

    // Percentage of employees below living wage
    public double percentBelowLivingWage() {

        long count = employees.stream()
                .filter(e -> e.getSalary() < LIVING_WAGE)
                .count();

        return (double) count / employees.size();
    }

    // Department-level living wage gaps
    public Map<String, Double> departmentLivingWageGap() {

        Map<String, Double> gaps = new HashMap<>();

        for (Employee e : employees) {

            if (e.getSalary() < LIVING_WAGE) {

                double gap = LIVING_WAGE - e.getSalary();

                gaps.merge(
                        e.getDepartment(),
                        gap,
                        Double::sum
                );
            }
        }

        return gaps;
    }

    // Cost to raise all employees to living wage
    public double costToReachLivingWage() {

        double totalCost = 0;

        for (Employee e : employees) {

            if (e.getSalary() < LIVING_WAGE) {

                totalCost += (LIVING_WAGE - e.getSalary());
            }
        }

        return totalCost;
    }
}
