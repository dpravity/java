package java01.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<Product> productList;

    public Cart(){
        this.productList = new ArrayList<>();
    }

    public void setProductList(List<Product> productList){
        this.productList = productList;
    }

    public List<Product> getProductList(){
        return this.productList;
    }

}
