import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReportManager {
    private final Map<String, ReportFormatter> formatters;
    private final Notifier notifier;

    public ReportManager(Map<String, ReportFormatter> formatters, Notifier notifier) {
        this.formatters = Objects.requireNonNull(formatters);
        this.notifier = Objects.requireNonNull(notifier);
    }

    public void generate(String type, List<String> data, boolean sendEmail) {
        if (type == null || data == null) {
            System.out.println("Invalid input: type or data is null.");
            return;
        }

        ReportFormatter formatter = formatters.get(type);
        if (formatter == null) {
            System.out.println("Unknown report type: " + type);
            return;
        }

        String joined = String.join(",", data);
        String result = formatter.format(joined);
        System.out.println(result);

        if (sendEmail) {
            notifier.send("admin@company.com", result);
        }
    }
}