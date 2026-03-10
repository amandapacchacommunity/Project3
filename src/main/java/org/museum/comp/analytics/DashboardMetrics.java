package org.museum.comp.analytics;

import org.museum.comp.model.Employee;
import org.museum.comp.model.Benchmark;
import org.museum.comp.service.LivingWageService;
import org.museum.comp.service.BenchmarkService;

import java.util.List;
import java.util.Map;

/*
 DashboardMetrics

 Aggregates all analytics outputs into a single object
 used by the dashboard layer.
*/

public class DashboardMetrics {

    private Map<String, Double> medianSalaryByDepartment;
    private Map<String, Double> medianSalaryByLevel;
    private Map<String, Double> frontlineComparison;

    private double retentionRate;

    private double percentBelowLivingWage;
    private double livingWageAdjustmentCost;

    private Map<String, Double> benchmarkVariance;
    private Map<String, String> benchmarkPosition;

    public DashboardMetrics(
            List<Employee> employees,
            List<Benchmark> benchmarks
    ) {

        CompensationAnalyzer analyzer = new CompensationAnalyzer(employees);

        LivingWageService livingWageService =
                new LivingWageService(employees);

        BenchmarkService benchmarkService =
                new BenchmarkService(employees, benchmarks);

        this.medianSalaryByDepartment =
                analyzer.medianSalaryByDepartment();

        this.medianSalaryByLevel =
                analyzer.medianSalaryByLevel();

        this.frontlineComparison =
                analyzer.frontlineComparison();

        this.retentionRate =
                analyzer.retentionRate();

        this.percentBelowLivingWage =
                livingWageService.percentBelowLivingWage();

        this.livingWageAdjustmentCost =
                livingWageService.costToReachLivingWage();

        this.benchmarkVariance =
                benchmarkService.salaryVarianceByRole();

        this.benchmarkPosition =
                benchmarkService.marketPositionByRole();
    }

    public Map<String, Double> getMedianSalaryByDepartment() {
        return medianSalaryByDepartment;
    }

    public Map<String, Double> getMedianSalaryByLevel() {
        return medianSalaryByLevel;
    }

    public Map<String, Double> getFrontlineComparison() {
        return frontlineComparison;
    }

    public double getRetentionRate() {
        return retentionRate;
    }

    public double getPercentBelowLivingWage() {
        return percentBelowLivingWage;
    }

    public double getLivingWageAdjustmentCost() {
        return livingWageAdjustmentCost;
    }

    public Map<String, Double> getBenchmarkVariance() {
        return benchmarkVariance;
    }

    public Map<String, String> getBenchmarkPosition() {
        return benchmarkPosition;
    }
}
