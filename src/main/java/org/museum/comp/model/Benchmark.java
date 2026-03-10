package org.museum.comp.model;

/*
 Generic Benchmark Model

 Represents salary medians derived from multiple
 compensation survey datasets.

 Survey providers are referenced generically
 to avoid using real company names.
*/

public class Benchmark {

    private String roleTitle;

    // Generic survey identifiers
    private double surveyA;
    private double surveyB;
    private double surveyC;

    private double marketMedian;

    public Benchmark() {}

    public Benchmark(String roleTitle, double surveyA, double surveyB, double surveyC) {
        this.roleTitle = roleTitle;
        this.surveyA = surveyA;
        this.surveyB = surveyB;
        this.surveyC = surveyC;

        this.marketMedian = (surveyA + surveyB + surveyC) / 3;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public double getSurveyA() {
        return surveyA;
    }

    public double getSurveyB() {
        return surveyB;
    }

    public double getSurveyC() {
        return surveyC;
    }

    public double getMarketMedian() {
        return marketMedian;
    }

    public double calculateVariance(double museumSalary) {
        return ((museumSalary - marketMedian) / marketMedian) * 100;
    }

}
