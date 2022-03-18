package com.acme.mytrader;

import com.acme.mytrader.execution.TradeExecutionService;
import com.acme.mytrader.model.SecurityDTO;
import com.acme.mytrader.price.PriceSourceImpl;
import com.acme.mytrader.strategy.TradingStrategy;

import static java.util.Arrays.asList;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        PriceSourceImpl priceSource = new PriceSourceImpl();
        TradingStrategy tradingStrategy = new TradingStrategy(new TradeExecutionService(),
                priceSource);
        final SecurityDTO ibm = SecurityDTO.builder().security("IBM").priceThreshold(100.00).volume(12)
                .build();
        final SecurityDTO google = SecurityDTO.builder().security("GOOGL").priceThreshold(100.00)
                .volume(24)
                .build();
        tradingStrategy.autoBuy(asList(ibm, google));

        Thread thread = new Thread(priceSource);
        thread.start();
        thread.join();
    }
}
