package org.museum.comp.service;

import org.museum.comp.model.Employee;
import org.museum.comp.model.RoleLevel;
import org.museum.comp.model.Benchmark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
 DataLoader

 Responsible for loading CSV datasets into memory.

 Datasets:
 employees.csv
 benchmarks.csv
*/

public class DataLoader {

    public List<Employee> loadEmployees(String filePath) {

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                Employee emp = new Employee(
                        parts[0], // employeeId
                        parts[1], // name
                        parts[2], // department
                        parts[3], // roleTitle
                        RoleLevel.valueOf(parts[4]),
                        Integer.parseInt(parts[5]),
                        Double.parseDouble(parts[6]),
                        Double.parseDouble(parts[7]),
                        Boolean.parseBoolean(parts[8]),
                        Boolean.parseBoolean(parts[9]),
                        Integer.parseInt(parts[10]),
                        Boolean.parseBoolean(parts[11])
                );

                employees.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }

    public List<Benchmark> loadBenchmarks(String filePath) {

        List<Benchmark> benchmarks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                Benchmark benchmark = new Benchmark(
                        parts[0],
                        Double.parseDouble(parts[1]),
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3])
                );

                benchmarks.add(benchmark);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return benchmarks;
    }
}
