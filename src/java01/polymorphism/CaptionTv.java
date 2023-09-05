package java01.polymorphism;

public class CaptionTv extends Tv {
    String text;    // 캡션 보여줄 문자열

    public CaptionTv(){
        this.price = 100;
        this.productName = "CaptionTv";
    }

    void caption(){
        System.out.println("캡션 : " + this.text);
    }

}
