public class ReportBuilderYear {
    YearReport buildReport(String[] lines) {
        YearReport yearReport = new YearReport();
        for (int i = 1; i < lines.length; i++) {
            YearRow yearRow = new YearRow(lines[i].split(","));
            yearReport.addYearRow(yearRow);
        }
        return yearReport;
    }
}
