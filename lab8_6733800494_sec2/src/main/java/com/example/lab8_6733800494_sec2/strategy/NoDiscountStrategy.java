package com.example.lab8_6733800494_sec2.strategy;
import org.springframework.stereotype.Component;

@Component("NONE")
public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) { return price; }
}