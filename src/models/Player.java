package models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Player {
    Set<Card> cardsAtHand = new HashSet<>();

    public void take(Card... n) {
        this.cardsAtHand.addAll(Arrays.asList(n));
    }

    public void print(){
        for(Card card: this.cardsAtHand)
            System.out.println(card);
    }

    public void giveup() {
        this.cardsAtHand.clear();
    }

    /***
     *
     * Returns bool type
     *
     * is true if
     *      :: Has card at hand, and Face or Value matches the card to consider
     *
     */
    boolean canPlay(Card cardOnDeck) {
        if (cardsAtHand.isEmpty()) return false;

        for (Card card : cardsAtHand)
            if (card.getFace() == cardOnDeck.getFace() || card.getValue() == cardOnDeck.getValue())
                return true;
        return false;
    }

    void play(Card cardOnDeck){

    }

}
