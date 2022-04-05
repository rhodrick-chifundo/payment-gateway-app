package com.example.payment_gateway_app;

public class customers {
    String serviceName, customerName, referenceNumber, customerBill;

    public customers() {
    }

    public customers(String serviceName, String customerName, String referenceNumber, String customerBill) {
        this.serviceName = serviceName;
        this.customerName = customerName;
        this.referenceNumber = referenceNumber;
        this.customerBill = customerBill;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getCustomerBill() {
        return customerBill;
    }

    public void setCustomerBill(String customerBill) {
        this.customerBill = customerBill;
    }
}
