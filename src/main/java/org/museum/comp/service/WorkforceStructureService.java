package org.museum.comp.service;

import org.museum.comp.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 WorkforceStructureService

 Calculates workforce composition used for
 organizational pyramid visualizations.
*/

public class WorkforceStructureService {

    private List<Employee> employees;

    public WorkforceStructureService(List<Employee> employees) {
        this.employees = employees;
    }

    public Map<String, Integer> workforceByLevel() {

        Map<String, Integer> counts = new HashMap<>();

        for (Employee e : employees) {

            String level = e.getRoleLevel().name();

            counts.put(level, counts.getOrDefault(level, 0) + 1);
        }

        return counts;
    }

    public int frontlineCount() {

        int count = 0;

        for (Employee e : employees) {
            if (e.isFrontline()) {
                count++;
            }
        }

        return count;
    }

    public int leadershipCount() {

        int count = 0;

        for (Employee e : employees) {

            String level = e.getRoleLevel().name();

            if (level.equals("DIRECTOR") || level.equals("EXECUTIVE")) {
                count++;
            }
        }

        return count;
    }

}
