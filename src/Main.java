import models.Card;
import models.Deck;
import models.Player;

import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player();
        deck.reshuffle();
        Set<Card> picked = deck.pick(2);

        for(Card card: picked)
            player.take(card);

        player.print();

//        Set<Card> items = deck.take(5);



//
        deck.showAvailableCards();

    }

    public static class Game {
        private int totalPlayers;
        Stack<Card> playedCards = new Stack<>();
        Deck deck = new Deck();
        Player[] players;
        Player currentPlayer;

        public Game(int totalPlayers) {
            this.totalPlayers = totalPlayers;
            this.players = new Player[totalPlayers];
            this.currentPlayer = players[0];
        }

        public void put(Card card) {
            playedCards.push(card);
        }

        public void begin(Card card) {
            put(card);
        }

        public Player getCurrentPlayer() {
            return currentPlayer;
        }
    }
}
