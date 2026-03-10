package org.museum.comp.service;

import org.museum.comp.model.Employee;
import org.museum.comp.model.Benchmark;

import java.util.*;
import java.util.stream.Collectors;

/*
 BenchmarkService

 Compares museum salaries to generic market benchmark surveys.

 Provides variance calculations and classification
 (Below Market / Within Market / Above Market).
*/

public class BenchmarkService {

    private List<Employee> employees;
    private List<Benchmark> benchmarks;

    public BenchmarkService(List<Employee> employees, List<Benchmark> benchmarks) {
        this.employees = employees;
        this.benchmarks = benchmarks;
    }

    public Map<String, Double> salaryVarianceByRole() {

        Map<String, Double> results = new HashMap<>();

        Map<String, List<Employee>> grouped =
                employees.stream().collect(Collectors.groupingBy(Employee::getRoleTitle));

        for (Benchmark benchmark : benchmarks) {

            String role = benchmark.getRoleTitle();

            if (grouped.containsKey(role)) {

                List<Employee> roleEmployees = grouped.get(role);

                double avgSalary = roleEmployees.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .orElse(0);

                double variance = benchmark.calculateVariance(avgSalary);

                results.put(role, variance);
            }
        }

        return results;
    }

    public String classifyMarketPosition(double variance) {

        if (variance < -10) {
            return "Below Market";
        }

        if (variance > 10) {
            return "Above Market";
        }

        return "Within Market Range";
    }

    public Map<String, String> marketPositionByRole() {

        Map<String, String> result = new HashMap<>();

        Map<String, Double> varianceMap = salaryVarianceByRole();

        for (String role : varianceMap.keySet()) {

            double variance = varianceMap.get(role);

            result.put(role, classifyMarketPosition(variance));
        }

        return result;
    }
}
