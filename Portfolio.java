import java.util.HashMap;
import java.util.Map;
public class Portfolio {
    private Map<String, Integer> holdings;
    private double cash;

    public Portfolio() {
        holdings = new HashMap<>();
        cash = 10000.0; // Initial cash balance
    }

    public void buyStock(Stock stock, int shares) {
        double cost = stock.getPrice() * shares;
        if (cash >= cost) {
            holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0) + shares);
            cash -= cost;
        } else {
            System.out.println("Insufficient cash to buy " + shares + " shares of " + stock.getSymbol());
        }
    }

    public void sellStock(Stock stock, int shares) {
        if (holdings.getOrDefault(stock.getSymbol(), 0) >= shares) {
            holdings.put(stock.getSymbol(), holdings.get(stock.getSymbol()) - shares);
            cash += stock.getPrice() * shares;
        } else {
            System.out.println("Insufficient shares of " + stock.getSymbol() + " to sell");
        }
    }

    public double getCash() { return cash; }
    public Map<String, Integer> getHoldings() { return holdings; }
}
