public class DataReconciliation {

    void reconciliationMonthYearReport(MonthlyReport monthlyReport, YearReport yearReport) {
        String month = "";
        int sumExpenseMonth = 0;
        int sumIncomeMonth = 0;
        int sumExpenseYear = 0;
        int sumIncomeYear = 0;


        for (String key : monthlyReport.contents.keySet()) {
            month = key;
            for (MonthRow row : monthlyReport.contents.get(month)) {
                if (row.is_expense) {
                    sumExpenseMonth += row.sum_of_one;
                } else {
                    sumIncomeMonth += row.sum_of_one;
                }
            }
        }
        for (YearRow line : yearReport.contentsRows) {
            if (line.month == 1) {
                if (line.is_expense) {
                    sumExpenseYear += line.amount;
                } else {
                    sumIncomeYear += line.amount;
                }
            }
        }

        if (sumExpenseMonth != sumExpenseYear) {
            System.out.println("Обнаружено несоответствие расходов в месяце: " + month);
        } else {
            System.out.println("Сверка данных прошла успешно.");
        }

        if (sumIncomeMonth != sumIncomeYear) {
            System.out.println("Обнаружено несоответствие доходов в месяце: " + month);
        } else {
            System.out.println("Сверка данных прошла успешно.");
        }
    }

}
