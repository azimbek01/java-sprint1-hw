public class ReportManager {
    MonthlyReport reportJanuary = new MonthlyReport();
    MonthlyReport reportFebruary = new MonthlyReport();
    MonthlyReport reportMarch = new MonthlyReport();
    YearReport reportYear = new YearReport();

    void readMonthReport() {
        String path_one = "./resources/m.202101.csv";
        String path_two = "./resources/m.202102.csv";
        String path_three = "./resources/m.202103.csv";
        ReportLoader loader = new ReportLoader();
        ReportBuilderMonth builder = new ReportBuilderMonth();
        String[] fileData = loader.readFile(path_one);
        if(fileData == null) {
            System.out.println("Невозможно обработать файл месячной отчетности за январь. "
                                + "Возможно, не удалось прочитать файл с месячным отчётом");
        } else {
            reportJanuary = builder.buildReport(fileData, "Январь");
            System.out.println("Данные отчета за январь считаны.");
        }
        String[] fileData_two = loader.readFile(path_two);
        if (fileData_two == null) {
            System.out.println("Невозможно обработать файл месячной отчетности за февраль. "
                    + "Возможно, не удалось прочитать файл с месячным отчётом");
        } else {
            reportFebruary = builder.buildReport(fileData_two, "Февраль");
            System.out.println("Данные отчета за февраль считаны.");
        }
        String[] fileData_three = loader.readFile(path_three);
        if (fileData_three == null) {
            System.out.println("Невозможно обработать файл месячной отчетности за март. "
                    + "Возможно, не удалось прочитать файл с месячным отчётом");
        } else {
            reportMarch = builder.buildReport(fileData_three, "Март");
            System.out.println("Данные отчета за март считаны.");
        }
    }

    void readYearReport() {
        ReportLoader loader = new ReportLoader();
        ReportBuilderYear reportBuilder = new ReportBuilderYear();
        String path = "./resources/y.2021.csv";
        String[] fileData = loader.readFile(path);
        if (fileData == null) {
            System.out.println("Невозможно обработать файл годовой отчетности. "
                    + "Возможно, не удалось прочитать файл с годовым отчётом");
        } else {
            reportYear = reportBuilder.buildReport(fileData);
            System.out.println("Данные годового отчета считаны");
        }
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
