package com.acme.mytrader.execution;

public class TradeExecutionService implements ExecutionService {

  @Override
  public void buy(String security, double price, int volume) {
    System.out.printf("\n BUY Trade executed for %s @ £ %.2f for %d number of securities", security,
        price, volume);
  }

  @Override
  public void sell(String security, double price, int volume) {
    System.out.printf("\n SELL Trade executed for %s @ £ %.2f for %d number of securities", security,
            price, volume);
  }
}
