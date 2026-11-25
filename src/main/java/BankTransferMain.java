import java.math.BigDecimal;

public class BankTransferMain {
    public static void main(String[] args) {
        try {
            new BankTransfer("ACC-101", "ACC-202", new BigDecimal("-25.00"));
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        try {
            new BankTransfer(null, "ACC-202", new BigDecimal("50.00"));
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}