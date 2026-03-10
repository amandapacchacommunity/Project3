package org.museum.comp;

import org.museum.comp.model.Employee;
import org.museum.comp.model.Benchmark;
import org.museum.comp.service.DataLoader;
import org.museum.comp.analytics.DashboardMetrics;

import java.util.List;

/*
 Application Entry Point

 Loads datasets, runs analytics engine,
 and prints summary metrics used by the dashboard.
*/

public class Application {

    public static void main(String[] args) {

        String employeeFile = "data/employees.csv";
        String benchmarkFile = "data/benchmarks.csv";

        DataLoader loader = new DataLoader();

        // Load datasets
        List<Employee> employees = loader.loadEmployees(employeeFile);
        List<Benchmark> benchmarks = loader.loadBenchmarks(benchmarkFile);

        // Run analytics
        DashboardMetrics metrics = new DashboardMetrics(employees, benchmarks);

        // Output summary (console)
        System.out.println("==== Museum Compensation Dashboard ====");

        System.out.println("\nRetention Rate:");
        System.out.println(metrics.getRetentionRate());

        System.out.println("\nMedian Salary by Department:");
        metrics.getMedianSalaryByDepartment()
                .forEach((k, v) -> System.out.println(k + " : $" + v));

        System.out.println("\nMedian Salary by Role Level:");
        metrics.getMedianSalaryByLevel()
                .forEach((k, v) -> System.out.println(k + " : $" + v));

        System.out.println("\nFrontline vs Non-Frontline Pay:");
        metrics.getFrontlineComparison()
                .forEach((k, v) -> System.out.println(k + " : $" + v));

        System.out.println("\nPercent Below Living Wage:");
        System.out.println(metrics.getPercentBelowLivingWage());

        System.out.println("\nCost to Reach Living Wage:");
        System.out.println("$" + metrics.getLivingWageAdjustmentCost());

        System.out.println("\nMarket Benchmark Variance:");
        metrics.getBenchmarkVariance()
                .forEach((k, v) -> System.out.println(k + " : " + v + "%"));

        System.out.println("\nMarket Position Classification:");
        metrics.getBenchmarkPosition()
                .forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("\n==== End Dashboard ====");
    }
}
