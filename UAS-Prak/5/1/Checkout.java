class Checkout {
    PaymentStrategy paymentStrategy;
    
    public void setPaymentStrategy(PaymentStrategy a) {
        this.paymentStrategy = a;
    }

    public void processPayment(int amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}