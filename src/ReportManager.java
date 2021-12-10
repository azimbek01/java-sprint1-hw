public class ReportManager {
    MonthlyReport reportJanuary = new MonthlyReport();
    MonthlyReport reportFebruary = new MonthlyReport();
    MonthlyReport reportMarch = new MonthlyReport();
    YearReport reportYear = new YearReport();

    void readMonthReport() {
        String path_one = "E:\\dev\\java-sprint1-hw\\resources\\m.202101.csv";
        String path_two = "E:\\dev\\java-sprint1-hw\\resources\\m.202102.csv";
        String path_three = "E:\\dev\\java-sprint1-hw\\resources\\m.202103.csv";
        ReportLoader loader = new ReportLoader();
        ReportBuilderMonth builder = new ReportBuilderMonth();

        String[] fileData = loader.readFile(path_one);
        reportJanuary = builder.buildReport(fileData, "Январь");
        String[] fileData_two = loader.readFile(path_two);
        reportFebruary = builder.buildReport(fileData_two, "Февраль");
        String[] fileData_three = loader.readFile(path_three);
        reportMarch = builder.buildReport(fileData_three, "Март");
        System.out.println("Данные месячных отчетов считаны");
    }

    void readYearReport() {
        ReportLoader loader = new ReportLoader();
        ReportBuilderYear reportBuilder = new ReportBuilderYear();
        String path = "E:\\dev\\java-sprint1-hw\\resources\\y.2021.csv";
        String[] fileData = loader.readFile(path);
        reportYear = reportBuilder.buildReport(fileData);
        System.out.println("Данные годового отчета считаны");
    }

    void dataReconciliation() {
        System.out.println("Сверка данных");
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        DataReconciliation dataRecon = new DataReconciliation();
        if (reportJanuary.contents.isEmpty() || reportFebruary.contents.isEmpty() ||
                reportMarch.contents.isEmpty() || reportYear.contentsRows.isEmpty()) {
            System.out.println("Сверка невозможна. Данные месячных или годового отчета" +
                                " не считаны.");
        } else {
            dataRecon.reconciliationMonthYearReport(reportJanuary, reportYear);
            dataRecon.reconciliationMonthYearReport(reportFebruary, reportYear);
            dataRecon.reconciliationMonthYearReport(reportMarch, reportYear);
        }
    }

    void printMonthReport() {
        System.out.println("Информация о всех месячных отчётах");
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        if (reportJanuary.contents.isEmpty() || reportFebruary.contents.isEmpty() ||
                reportMarch.contents.isEmpty()) {
            System.out.println("Вывод отчетов невозможен. Данные месячных отчетов не считаны.");
            return;
        } else {
            reportJanuary.getMaxIncome();
            reportJanuary.getMaxExpense();
            reportFebruary.getMaxIncome();
            reportFebruary.getMaxExpense();
            reportMarch.getMaxIncome();
            reportMarch.getMaxExpense();
        }
    }

    void printYearReport() {
        if (reportYear.contentsRows.isEmpty()) {
            System.out.println("Вывод отчетов невозможен. Данные годового отчета не считаны.");
            return;
        }
        System.out.println("2021 год.");
        reportYear.getProfit();
        reportYear.getAverageExpense();
        reportYear.getAverageIncome();
    }
}
