package java01.ecommerce.delivery;

import java.util.ArrayList;
import java.util.List;


public class Address {
    List<String> addressList;

    public Address(){
        this.addressList = new ArrayList<>();
        addressList.add("경기도 남양주시");
        addressList.add("경기도 용인시");
        addressList.add("서대문");
    }

    public void setAddressList(String address){
        this.addressList.add(address);
    }

    public List<String> getAddressList(){
        return this.addressList;
    }


}
