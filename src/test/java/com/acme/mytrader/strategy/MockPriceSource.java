package com.acme.mytrader.strategy;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSourceImpl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MockPriceSource extends PriceSourceImpl {

    String security;
    double price;

    MockPriceSource(String security, double price) {
        this.security = security;
        this.price = price;
    }

    private final List<PriceListener> priceListeners = new CopyOnWriteArrayList<>();

    @Override
    public void addPriceListener(PriceListener listener) {
        priceListeners.add(listener);
    }

    @Override
    public void removePriceListener(PriceListener listener) {
        priceListeners.remove(listener);
    }

    @Override
    public void run() {
        priceListeners.forEach(priceListener -> priceListener.priceUpdate(security, price));
    }
}
