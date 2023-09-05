package java01.polymorphism;

public class Tv extends Product {
    boolean power;  // 전원 on/off
    int channel;    // 채널

    public Tv(){
        this.price = 100;
        this.productName = "TV";
    }
    /**
     * 전원 on/off
     */
    void power(){
        power = !power;
        System.out.println("전원 : " + power);
    }

    /**
     * 채널 업
     */
    void channelUp(){
        ++channel;
        System.out.println("채널 : " + channel);
    }

    /**
     * 채널 다운
     */
    void channelDown(){
        --channel;
        System.out.println("채널 : " + channel);
    }
}
