package com.acme.mytrader.strategy;

import static java.util.Arrays.asList;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.execution.TradeExecutionService;
import com.acme.mytrader.price.BuyPriceListener;
import com.acme.mytrader.price.PriceSourceImpl;
import com.acme.mytrader.price.PriceSourceRunnable;

import com.acme.mytrader.model.SecurityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
@AllArgsConstructor
@Getter
public class TradingStrategy {

  private final ExecutionService tradeExecutionService;
  private final PriceSourceRunnable priceSource;

  public void autoBuy(List<SecurityDTO> request) throws InterruptedException {
    request.stream().map(
        r -> new BuyPriceListener(r.getSecurity(), r.getPriceThreshold(), r.getVolume(),
            tradeExecutionService, false)).forEach(priceSource::addPriceListener);
  }
}