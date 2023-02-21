package com.kiskacsa.kiskacsashoping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Basket {
    private List<Product> products = new ArrayList<>();

    public void saveProduct(Product product) {
        products.add(product);
    }

    public void deleteProductFromName(String nextLine) {
        for (Product p : products){
            if(p.getName().equals(nextLine)){
                products.remove(p);
                return;
            }
        }
        System.out.println("nem is volt benne ilyen.... -.-");
    }

    public void modificationProduct(Product product) {
        for (Product p : products){
            if(p.getName().equals(product.getName())){
                products.remove(p);
                products.add(p);
                return;
            }
        }
    }

    public void printAllProduct() {
        for (Product p : products){
            System.out.println(p);
        }
    }
}
