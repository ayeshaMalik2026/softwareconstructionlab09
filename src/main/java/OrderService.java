public class OrderService {
    public interface DiscountPolicy {
        double applyDiscount(double subtotal);
    }

    private final DiscountPolicy discountPolicy;

    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public double calculateTotal(double subtotal) {
        return discountPolicy.applyDiscount(subtotal);
    }
}