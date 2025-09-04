/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

/**
 *
 * @author ZAHI
 */
public class Payment {

    private Order order;
    private Customer customer;
    private boolean isordered;
    private String paymentMethod;

    public Payment(Order order, Customer customer, String paymentMethod) {
        this.order = order;
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.isordered = false;
    }

    public boolean processPayment() {
        double total = order.calculateTotal();
        if (total > 0) {
            isordered = true;
            customer.addPayment(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean isOrdered() {
        return isordered;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Order getOrder() {
        return order;
    }

    public Customer getCustomer() {
        return customer;
    }
}