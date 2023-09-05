package java01.ecommerce.delivery;

public class Delivery {

    public String deliveryAddress;
    public String deliveryStatus;

    // 배송지 입력
    public void setDeliveryAddress(String deliveryAddress){
        this.deliveryAddress = deliveryAddress;
    }

    // 배송상태
    public void setDeliveryStatus(String deliveryStatus){
        this.deliveryStatus = deliveryStatus;
    }

    // 배송상태 조회
    public String getDeliveryStatus(){
        return this.deliveryStatus;
    }

    // 배송 접수
    public void information(){
        this.deliveryStatus = "배송 접수";
        System.out.println(this.deliveryStatus);
    }

    // 배송 중
    public void transit(){
        this.deliveryStatus = "배송 중";
        System.out.println(this.deliveryStatus);
    }

    // 배송 완료
    public void delivered(){
        this.deliveryStatus = "배송 완료";
        System.out.println(this.deliveryStatus);
    }


}
