import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoardGameAnalytics analytics = new BoardGameAnalytics();

        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split(" ");
            String name = t[0];
            int minP = Integer.parseInt(t[1]);
            int maxP = Integer.parseInt(t[2]);
            int time = Integer.parseInt(t[3]);
            String cat = t[4];
            int stock = Integer.parseInt(t[5]);
            analytics.addGame(new BoardGame(name, minP, maxP, time, cat), stock);
        }

        int r = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < r; i++) {
            String[] t = sc.nextLine().trim().split(" ");
            analytics.addRating(t[0], t[1], Integer.parseInt(t[2]));
        }

        int threshold = Integer.parseInt(sc.nextLine().trim());
        String[] rec = sc.nextLine().trim().split(" ");
        int playerCount = Integer.parseInt(rec[0]);
        double minRating = Double.parseDouble(rec[1]);

        List<String> lowStock = analytics.getLowStockGames(threshold);
        System.out.println("LOW_STOCK " + (lowStock.isEmpty() ? "-" : String.join(" ", lowStock)));

        List<String> recommended = analytics.getRecommendedGames(playerCount, minRating);
        System.out.println("RECOMMENDED " + (recommended.isEmpty() ? "-" : String.join(" ", recommended)));

        sc.close();
    }
}
