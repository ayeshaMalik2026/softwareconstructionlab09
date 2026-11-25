public class CsvReportFormatter implements ReportFormatter {
    @Override
    public String format(String data) {
        return "Writing CSV: " + data;
    }
}