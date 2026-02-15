package com.example.task02;

public class DiscountBill extends Bill{
    private double discount;

    public DiscountBill(double discount) {
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        return super.getPrice() * (100 - (long)discount) / 100;

    }

    public String getDiscount() {
        return this.discount + "%";
    }

    public long getBenefit() {
        return super.getPrice() - this.getPrice();
    }
}
