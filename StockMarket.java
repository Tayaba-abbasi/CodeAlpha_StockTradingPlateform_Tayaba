import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class StockMarket {
    private Map<String, Stock> stocks;

    public StockMarket() {
        stocks = new HashMap<>();
        initializeStocks();
    }

    private void initializeStocks() {
        stocks.put("AAPL", new Stock("AAPL", 120.50));
        stocks.put("AMZN", new Stock("AMZN", 3200.00));
        stocks.put("GOOGL", new Stock("GOOGL", 2500.00));
    }

    public void updateStockPrices() {
        Random random = new Random();
        for (Stock stock : stocks.values()) {
            double priceChange = random.nextDouble() * 10 - 5; // Random price change between -5% and +5%
            double newPrice = stock.getPrice() * (1 + priceChange / 100);
            stock.setPrice(newPrice);
        }
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }
}
