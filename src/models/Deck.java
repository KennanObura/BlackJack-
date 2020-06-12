package models;

import java.util.*;

public class Deck {
    private static final int MAX_CARDS = 13;
    private final Stack<Card> cards; //cards inside[not played yet] deck
    private Set<Card> playedCards; //cards outside[already played] deck

    public Deck() {
        this.cards = new Stack<>();
        this.playedCards = new HashSet<>();
        this.refill();
    }

    /**
     * resets game to its initial state
     */
    public void reset() {
        cards.clear();
        playedCards.clear();
        refill();
        reshuffle();
    }

    private void refill() {
        for (int i = 1; i <= MAX_CARDS; i++)
            for (Face face : Face.values())
                cards.add(new Card(face, i));
    }

    /**
     * @param playedCards : A list of cards [stack]
     */
    private void refill(List<Card> playedCards) {
        this.cards.addAll(playedCards);
        this.reshuffle();
    }



    public void reshuffle() {
        if (cards.isEmpty()) throw new RuntimeException("Deck is empty");
        Collections.shuffle(cards, new Random());
    }


    /*
    For debug
     */
    public void showAvailableCards() {
        System.out.println(String.format("String has %d", cards.size()));
        for (Card card : cards)
            System.out.println(card);
    }

    private boolean canTake(int requested) {
        return (cards.size() >= requested);
    }



    /**
     *
     *
     * @param requested   The number of cards to be picked by player
     * @return Set of cards, result
     *
     *
     * Steps
     *  :: Check if the deck has enough cards requested by player
     *      - if cards are less than requested, take all already @param playedCards to refill the cards on deck
     *      - reshuffle the new set of cards
     *      - empty the already @param playedCards
     *
     *  :: Take from cards, requested number of cards and remove them from the cards on deck
     *  :: Return set of cards
     *
     */

    public Set<Card> pick(int requested) {
        if(requested >= MAX_CARDS)
            throw new RuntimeException("You can not request " + requested + " of cards");

        if (!canTake(requested)) {
            List<Card> items = new ArrayList<>(playedCards);
            this.refill(items);
            this.playedCards.clear();
        }

        Set<Card> result = new HashSet<>();
        for (int i = 0; i < requested; i++) {
            result.add(cards.pop());
        }
        return result;
    }
}
