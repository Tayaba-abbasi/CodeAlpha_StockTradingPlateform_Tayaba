import java.util.Scanner;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Portfolio portfolio = new Portfolio();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Stock Trading Platform");
            System.out.println("1. Buy Stocks");
            System.out.println("2. Sell Stocks");
            System.out.println("3. View Portfolio");
            System.out.println("4. Update Stock Prices");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter stock symbol: ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter number of shares: ");
                    int shares = scanner.nextInt();
                    Stock stockToBuy = stockMarket.getStock(symbol);
                    if (stockToBuy != null) {
                        portfolio.buyStock(stockToBuy, shares);
                        System.out.println("Bought " + shares + " shares of " + symbol);
                    } else {
                        System.out.println("Invalid stock symbol");
                    }
                    break;
                case 2:
                    System.out.print("Enter stock symbol: ");
                    symbol = scanner.nextLine();
                    System.out.print("Enter number of shares: ");
                    shares = scanner.nextInt();
                    Stock stockToSell = stockMarket.getStock(symbol);
                    if (stockToSell != null) {
                        portfolio.sellStock(stockToSell, shares);
                        System.out.println("Sold " + shares + " shares of " + symbol);
                    } else {
                        System.out.println("Invalid stock symbol");
                    }
                    break;
                case 3:
                    System.out.println("Portfolio:");
                    System.out.println("Cash: $" + portfolio.getCash());
                    for (Map.Entry<String, Integer> holding : portfolio.getHoldings().entrySet()) {
                        Stock stock = stockMarket.getStock(holding.getKey());
                        System.out.println(holding.getValue() + " shares of " + stock.getSymbol() + " at $" + stock.getPrice() + " per share");
                    }
                    break;
                case 4:
                    stockMarket.updateStockPrices();
                    System.out.println("Stock prices updated");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}