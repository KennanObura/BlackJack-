package models;

public class Card {
    final private Face face;
    final private int value;

    Card(Face face, int value){
        this.face = face;
        this.value = value;
    }

    Face getFace(){
        return this.face;
    }

    int getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return String.format("[ %d , %s ]", this.value, this.face.toString());
    }
}
