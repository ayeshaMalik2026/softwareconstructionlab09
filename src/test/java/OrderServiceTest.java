import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {

    @Test
    void calculateTotal_appliesVipDiscount_withoutTouchingDatabase() {
        // Arrange
        OrderService.DiscountPolicy vipDiscount = subtotal -> subtotal * 0.80;
        OrderService orderService = new OrderService(vipDiscount);

        // Act
        double total = orderService.calculateTotal(100.0);

        // Assert
        assertEquals(80.0, total, 0.001);
    }
}