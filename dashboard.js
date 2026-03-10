// Simulated dashboard data
// In a full system this would come from the Java backend

const dashboardData = {

    retentionRate: 0.82,

    livingWagePercent: 0.38,

    livingWageCost: 2850000,

    medianSalaryByDepartment: {
        "Curatorial": 135000,
        "Visitor Services": 48000,
        "Security": 52000,
        "Retail": 46000,
        "Education": 62000,
        "Development": 102000
    },

    medianSalaryByLevel: {
        "IC1": 47000,
        "IC2": 63000,
        "IC3": 84000,
        "MANAGER": 105000,
        "DIRECTOR": 178000,
        "EXECUTIVE": 315000
    },

    frontlineComparison: {
        "Frontline": 49000,
        "Non-Frontline": 121000
    },

    benchmarkVariance: {
        "Curator": -5,
        "Visitor Associate": 2,
        "Retail Manager": -8,
        "Development Director": 12
    }

};


// Populate KPI cards

document.getElementById("retentionRate").innerText =
    (dashboardData.retentionRate * 100).toFixed(1) + "%";

document.getElementById("livingWagePercent").innerText =
    (dashboardData.livingWagePercent * 100).toFixed(1) + "%";

document.getElementById("livingWageCost").innerText =
    "$" + dashboardData.livingWageCost.toLocaleString();


// Salary by Department Chart

new Chart(document.getElementById("deptChart"), {

    type: "bar",

    data: {

        labels: Object.keys(dashboardData.medianSalaryByDepartment),

        datasets: [{
            label: "Median Salary",

            data: Object.values(dashboardData.medianSalaryByDepartment)
        }]
    }

});


// Salary by Role Level Chart

new Chart(document.getElementById("levelChart"), {

    type: "bar",

    data: {

        labels: Object.keys(dashboardData.medianSalaryByLevel),

        datasets: [{
            label: "Median Salary",

            data: Object.values(dashboardData.medianSalaryByLevel)
        }]
    }

});


// Frontline vs Staff Chart

new Chart(document.getElementById("frontlineChart"), {

    type: "pie",

    data: {

        labels: Object.keys(dashboardData.frontlineComparison),

        datasets: [{
            data: Object.values(dashboardData.frontlineComparison)
        }]
    }

});


// Benchmark Variance Chart

new Chart(document.getElementById("benchmarkChart"), {

    type: "bar",

    data: {

        labels: Object.keys(dashboardData.benchmarkVariance),

        datasets: [{
            label: "Market Variance %",
            data: Object.values(dashboardData.benchmarkVariance)
        }]
    }

});
