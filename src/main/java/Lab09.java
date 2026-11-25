import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lab09 {
    public static void main(String[] args) {
        Map<String, ReportFormatter> formatters = new HashMap<>();
        formatters.put("PDF", new PdfReportFormatter());
        formatters.put("CSV", new CsvReportFormatter());

        ReportManager reportManager = new ReportManager(formatters, new ConsoleNotifier());
        List<String> rows = List.of("Row1", "Row2", "Row3");

        reportManager.generate("PDF", rows, true);
        reportManager.generate("CSV", rows, false);
        reportManager.generate(null, rows, false);
    }
}