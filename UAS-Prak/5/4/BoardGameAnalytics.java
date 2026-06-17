import java.util.*;
import java.util.stream.Collectors;

public class BoardGameAnalytics {

    private List<BoardGame> games;
    private Set<String> players;
    private Map<String, Integer> stockByGame;
    private Map<String, List<Integer>> ratings;

    public BoardGameAnalytics() {
        games = new ArrayList<>();
        players = new HashSet<>();
        stockByGame = new HashMap<>();
        ratings = new HashMap<>();
    }

    /**
     * Menambahkan game baru beserta stok awal.
     * Jika game dengan nama sama sudah ada, stoknya ditambah.
     *
     * @param game board game yang ditambahkan
     * @param initialStock stok awal yang ditambahkan
     */
    public void addGame(BoardGame game, int initialStock) {

        /**
         * hash -> .containsKey buat cari key game name
         * kalau game name ada di games, then stockByGame.put(key=gameName, gameName Stock +initialstock)
         * kalau belum ada name game di games, then
         *      games.add(game)
         *      stockByGame.put(game.getName(), initialStock) <- ini buat naruh key (string) dan val (int) baru
         * 
         */
        if (!stockByGame.containsKey(game.getName())) {
            games.add(game);
            stockByGame.put(game.getName(), initialStock);
        } else {
            int currentStock = stockByGame.get(game.getName());
            stockByGame.put(game.getName, currentStock+initialStock);
        }
    }

    /**
     * Menambahkan rating dari seorang pemain untuk sebuah game.
     * Pemain disimpan sebagai pemain unik.
     *
     * @param gameName nama game
     * @param playerName nama pemain
     * @param rating nilai rating
     */
    public void addRating(String gameName, String playerName, int rating) {
        players.add(playerName);
        if (!ratings.containsKey(gameName)) {
            ratings.put(gameName, new ArrayList<>());
        }
        ratings.get(gameName).add(rating);
    }

    /**
     * Menghitung rata-rata rating sebuah game.
     * Jika belum ada rating, hasilnya 0.0.
     *
     * @param gameName nama game
     * @return rata-rata rating
     */
    private double getAverageRating(String gameName) {
        List<Integer> gameRatings = ratings.get(gameName);

        if (gameRatings == null || gameRatings.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (int rating : gameRatings) sum += rating;
        return sum / gameRatings.size();
    }

    /**
     * Mengembalikan daftar nama game yang stoknya kurang dari threshold.
     * Hasil diurutkan berdasarkan stok menaik.
     * Jika stok sama, urutkan berdasarkan nama game secara alfabetis.
     *
     * Method ini diharapkan menggunakan Map dan Stream API.
     *
     * @param threshold batas stok
     * @return daftar nama game dengan stok di bawah threshold
     */
    public List<String> getLowStockGames(int threshold) {
        // // TODO: Implementasikan getLowStockGames
        // return Collections.emptyList();
        return stockByGame.entrySet()
            .stream()
            .filter(entry -> entry.getValue() < threshold)
            .sorted(
                Comparator
                    .comparing(Map.Entry<String, Integer>::getValue)
                    .thenComparing(Map.Entry::getKey)
            )
            .map(Map.Entry::getKey)
            .toList();
    }

    /**
     * Mengembalikan daftar nama game yang:
     * - cocok untuk jumlah pemain tertentu
     * - memiliki rata-rata rating minimal tertentu
     * Hasil diurutkan alfabetis.
     *
     * @param playerCount jumlah pemain
     * @param minRating rating minimum
     * @return daftar nama game yang direkomendasikan
     */
    public List<String> getRecommendedGames(int playerCount, double minRating) {
        // TODO: Implementasikan getRecommendedGames
        return Collections.emptyList();
    }

    /**
     * Main untuk mengetes implementasi secara lokal.
     *
     * Format input:
     * N
     * name minPlayers maxPlayers playTime category stock   (sebanyak N baris)
     * R
     * gameName playerName rating                           (sebanyak R baris)
     * threshold
     * playerCount minRating
     *
     * Output:
     * Baris 1:
     * LOW_STOCK <name1> <name2> ...
     * atau
     * LOW_STOCK -
     *
     * Baris 2:
     * RECOMMENDED <name1> <name2> ...
     * atau
     * RECOMMENDED -
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoardGameAnalytics analytics = new BoardGameAnalytics();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int minPlayers = sc.nextInt();
            int maxPlayers = sc.nextInt();
            int playTime = sc.nextInt();
            String category = sc.next();
            int stock = sc.nextInt();

            analytics.addGame(
                    new BoardGame(name, minPlayers, maxPlayers, playTime, category),
                    stock
            );
        }

        int r = sc.nextInt();
        for (int i = 0; i < r; i++) {
            String gameName = sc.next();
            String playerName = sc.next();
            int rating = sc.nextInt();
            analytics.addRating(gameName, playerName, rating);
        }

        int threshold = sc.nextInt();
        int playerCount = sc.nextInt();
        double minRating = sc.nextDouble();

        List<String> lowStock = analytics.getLowStockGames(threshold);
        List<String> recommended = analytics.getRecommendedGames(playerCount, minRating);

        if (lowStock.isEmpty()) {
            System.out.println("LOW_STOCK -");
        } else {
            System.out.println("LOW_STOCK " + String.join(" ", lowStock));
        }

        if (recommended.isEmpty()) {
            System.out.println("RECOMMENDED -");
        } else {
            System.out.println("RECOMMENDED " + String.join(" ", recommended));
        }

        sc.close();
    }
}