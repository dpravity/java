package java01.ecommerce.cart;

import java01.ecommerce.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {

    public Map<String, Integer> productList;

    public Map<String, Integer> getCart(){
        if(Objects.isNull(this.productList)){
            this.productList = new HashMap<>();
        }
        return this.productList;
    }

    public void addCart(Product p){
        if(this.productList.containsKey(p.productName)){
            Integer i = this.productList.get(p.productName) + 1;
            this.productList.replace(p.productName, i);
        }else{
            this.productList.put(p.productName, 1);
        }
    }

    public void minusCart(Product p){
        if(this.productList.containsKey(p.productName)){
            Integer i = this.productList.get(p.productName) - 1;
            if(i > 0){
                this.productList.replace(p.productName, i);
            }else{
                this.productList.remove(p.productName);
            }
        }
    }

    public void removeCart(Product p){
        if(this.productList.containsKey(p.productName)){
            this.productList.remove(p.productName);
        }
    }

}
