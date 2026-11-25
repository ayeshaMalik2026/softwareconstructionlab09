public class PaymentProcessor {

    public void charge(String txId, double amount) {
        String traceId = txId;
        try {
            System.out.println("[TraceID: " + traceId + "] Processing payment...");
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than zero");
            }
            System.out.println("[TraceID: " + traceId + "] Charged $" + amount + " successfully.");
        } catch (IllegalArgumentException ex) {
            System.out.println("[TraceID: " + traceId + "] Payment failed: " + ex.getMessage());
        } finally {
            traceId = null;
            System.out.println("[TraceID: cleared] Context Cleared");
        }
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.charge("TX-1001", 250.00);
        processor.charge("TX-1002", -10.00);
    }
}