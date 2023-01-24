package com.example.deliveryapp;

public class Order {
    private int serial_number; // will have global counter
    private String product;
    private String order_date;
    private String origin_country;
    private String delivery_sent_date;
    private String destination_country;
    private String arrival_date;
    private String client_pickup_date;
    private boolean status; // order is open => true, order is closed => false

    public Order(int serial_number, String product, String order_date,
                 String origin_country, String destination_country)
    {
        this.serial_number = serial_number;
        this.product = product;
        this.order_date = order_date;
        this.origin_country = origin_country;
        this.destination_country = destination_country;
        this.delivery_sent_date = order_date; // need to be modified
        this.arrival_date = order_date; // need to be modified
        this.client_pickup_date = order_date; // need to be modified
        this.status = true;
    }

    // getters
    public int getSerial_number(){
        return serial_number;
    }

    public String getProduct() {
        return product;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public String getDelivery_sent_date() {
        return delivery_sent_date;
    }

    public String getDestination_country() {
        return destination_country;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public String getClient_pickup_date() {
        return client_pickup_date;
    }

    public boolean getOrderStatus() {
        return status;
    }

    // setters
    public void setStatus(boolean status) {
        this.status = status;
    }
}
