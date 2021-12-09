public class ReportBuilderMonth {
    MonthlyReport buildReport(String[] lines, String month) {
        MonthlyReport monthlyReport = new MonthlyReport();
        for (int i = 1; i < lines.length; i++) {
            MonthRow monthRow = new MonthRow(lines[i].split(","));
            monthlyReport.addMonthRow(monthRow, month);
        }
        return monthlyReport;
    }
}