public class Checkout <T extends PaymentStrategy>{
    T paymentStrategy;
    // void setPaymentStrategy(T a){
    //     paymentStrategy = a;
    // }
    // void processPayment(int amount){
    //     // T.pay(amount)
    //     if (paymentStrategy == null) {
    //         System.out.println("No payment method selected.");
    //     } else {
    //         paymentStrategy.pay(amount);
    //     }

    // }
    public void setPaymentStrategy(T a) {
        this.paymentStrategy = a;
    }

    public void processPayment(int amount) {
        if (this.paymentStrategy == null) {
            System.out.println("No payment method selected");
        } else {
            this.paymentStrategy.pay(amount);
        }
    }


}
