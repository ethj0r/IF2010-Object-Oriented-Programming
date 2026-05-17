import java.util.*;
import java.util.stream.*;

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

    public void addGame(BoardGame game, int initialStock) {
        if (!stockByGame.containsKey(game.getName())) {
            games.add(game);
        }
        stockByGame.merge(game.getName(), initialStock, Integer::sum);
    }

    public void addRating(String gameName, String playerName, int rating) {
        players.add(playerName);
        ratings.computeIfAbsent(gameName, k -> new ArrayList<>()).add(rating);
    }

    private double getAverageRating(String gameName) {
        List<Integer> r = ratings.get(gameName);
        if (r == null || r.isEmpty()) return 0.0;
        return r.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public List<String> getLowStockGames(int threshold) {
        return stockByGame.entrySet().stream()
                .filter(e -> e.getValue() < threshold)
                .sorted(Comparator.comparingInt(Map.Entry<String, Integer>::getValue)
                        .thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getRecommendedGames(int playerCount, double minRating) {
        return games.stream()
                .filter(g -> g.getMinPlayers() <= playerCount && playerCount <= g.getMaxPlayers())
                .filter(g -> getAverageRating(g.getName()) >= minRating)
                .map(BoardGame::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
