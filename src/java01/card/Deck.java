package java01.card;

public class Deck {

    final int CARD_NUM = 52;
    Card cardArr[] = new Card[CARD_NUM];


    // 덱 초기화
    public Deck(){
        int i = 0;
        for(int k=Card.KIND_MAX; k > 0; k--){
            for(int n=0; n < Card.NUM_MAX; n++){
                cardArr[i++] = new Card(k, n+1);
            }
        }
    }

    // 지정된 위치 카드 선택
    public Card pick(int index){
        return cardArr[index];
    }

    // 덱에서 임의의 카드 한장 선택
    public Card pick(){
        int index = (int) (Math.random() * CARD_NUM);
        return pick(index);
    }

    // 카드 섞기
    public void shuffle(){
        for(int i=0; i < cardArr.length; i++){
            int r = (int) (Math.random() * CARD_NUM);

            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }

}
