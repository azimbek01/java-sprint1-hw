import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport reportJanuary = new MonthlyReport();
        MonthlyReport reportFebruary = new MonthlyReport();
        MonthlyReport reportMarch = new MonthlyReport();
        YearReport reportYear = new YearReport();


        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {

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
            } else if (command == 2) {
                ReportLoader loader = new ReportLoader();
                ReportBuilderYear reportBuilder = new ReportBuilderYear();
                String path = "E:\\dev\\java-sprint1-hw\\resources\\y.2021.csv";
                String[] fileData = loader.readFile(path);
                reportYear = reportBuilder.buildReport(fileData);
                System.out.println("Данные годового отчета считаны");
            } else if (command == 3) {
                System.out.println("Сверка данных");
                System.out.println("- - - - - - - - - - - - - - - - - - -");
                DataReconciliation dataRecon = new DataReconciliation();
                dataRecon.reconciliationMonthYearReport(reportJanuary, reportYear);
                dataRecon.reconciliationMonthYearReport(reportFebruary, reportYear);
                dataRecon.reconciliationMonthYearReport(reportMarch, reportYear);
            } else if (command == 4) {
                System.out.println("Информация о всех месячных отчётах");
                System.out.println("- - - - - - - - - - - - - - - - - - -");
                reportJanuary.getMaxIncome();
                reportJanuary.getMaxExpense();
                reportFebruary.getMaxIncome();
                reportFebruary.getMaxExpense();
                reportMarch.getMaxIncome();
                reportMarch.getMaxExpense();
            } else if (command == 5) {
                System.out.println("2021 год.");
                reportYear.getProfit();
                reportYear.getAverageExpense();
                reportYear.getAverageIncome();
            } else if (command == 0) {
                System.out.println("Выход из программы");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }

    }

    public static void printMenu() {
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println("Какое действие необходимо выполнить?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}

