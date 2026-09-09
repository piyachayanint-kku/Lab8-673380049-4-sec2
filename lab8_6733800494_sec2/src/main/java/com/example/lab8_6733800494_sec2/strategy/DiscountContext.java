package com.example.lab8_6733800494_sec2.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class DiscountContext {

    private final Map<String, DiscountStrategy> strategies;

    public DiscountContext(Map<String, DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    public double calculate(String discountType, double price) {
        DiscountStrategy strategy = strategies.getOrDefault(discountType, strategies.get("NONE"));
        return strategy.applyDiscount(price);
    }
}