public class PdfReportFormatter implements ReportFormatter {
    @Override
    public String format(String data) {
        return "Writing PDF: " + data;
    }
}