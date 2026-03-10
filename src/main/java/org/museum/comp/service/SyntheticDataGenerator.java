package org.museum.comp.service;

import org.museum.comp.model.RoleLevel;

import java.io.FileWriter;
import java.util.Random;

/*
 SyntheticDataGenerator

 Generates a large realistic workforce dataset
 for a museum compensation analysis project.

 Produces ~800 employees across multiple
 departments and fiscal years.
*/

public class SyntheticDataGenerator {

    private static final String[] departments = {
            "Curatorial",
            "Visitor Services",
            "Security",
            "Facilities",
            "Retail",
            "Education",
            "Development",
            "Marketing",
            "IT",
            "HR",
            "Finance",
            "Legal"
    };

    private static final String[] roles = {
            "Curator",
            "Visitor Associate",
            "Security Officer",
            "Facilities Technician",
            "Retail Associate",
            "Education Coordinator",
            "Development Manager",
            "Marketing Specialist",
            "IT Analyst",
            "HR Generalist",
            "Finance Analyst",
            "Legal Counsel"
    };

    private Random random = new Random();

    public void generate(String filePath) {

        try {

            FileWriter writer = new FileWriter(filePath);

            writer.write("employeeId,name,department,roleTitle,roleLevel,fiscalYear,salary,bonus,frontline,endowedPosition,yearsExperience,retainedNextYear\n");

            int id = 1000;

            for (int year = 2022; year <= 2024; year++) {

                for (int i = 0; i < 850; i++) {

                    String dept = departments[random.nextInt(departments.length)];
                    String role = roles[random.nextInt(roles.length)];

                    RoleLevel level = RoleLevel.values()[random.nextInt(RoleLevel.values().length)];

                    double salary = generateSalary(level);

                    boolean frontline =
                            dept.equals("Visitor Services")
                                    || dept.equals("Retail")
                                    || dept.equals("Security");

                    boolean endowed =
                            dept.equals("Curatorial") && random.nextDouble() < 0.15;

                    boolean retained =
                            random.nextDouble() > 0.18; // ~82% retention

                    int experience = random.nextInt(20);

                    double bonus = level.ordinal() >= 3
                            ? random.nextInt(15000)
                            : 0;

                    writer.write(
                            id++ + ","
                                    + "Employee" + id + ","
                                    + dept + ","
                                    + role + ","
                                    + level.name() + ","
                                    + year + ","
                                    + salary + ","
                                    + bonus + ","
                                    + frontline + ","
                                    + endowed + ","
                                    + experience + ","
                                    + retained
                                    + "\n"
                    );
                }
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double generateSalary(RoleLevel level) {

        double min = level.getMinSalary();
        double max = level.getMaxSalary();

        return min + (max - min) * random.nextDouble();
    }
}
