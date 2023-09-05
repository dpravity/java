package java01.card;

public class Card {

    public static final int KIND_MAX = 4;   // 카드 무늬 종류(스페이드, 클로버, 하트, 다이아몬드)
    public static final int NUM_MAX = 13;   // 무늬별 카드 수
    public static final int SPADE = 4;
    public static final int DIAMOND = 4;
    public static final int HEART = 4;
    public static final int CLOVER = 4;

    int kind = 0;
    int number = 0;

    public Card(){
        this(SPADE, 1);
    }

    public Card(int kind, int number){
        this.kind = kind;
        this.number = number;
    }

    public String toString(){
        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers = "0123456789XJQK";

        return "kind : " + kinds[this.kind]
                + ", number : " + numbers.charAt(this.number);
    }


}
