package com.kiskacsa.kiskacsashoping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {
    @Autowired
    Basket basket;

    Scanner sc = new Scanner(System.in);


    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        while (true) {
            printMenu();
            choseMenu();
        }
    }

    private void choseMenu() {

        String chose = sc.nextLine();
        try {


        switch (chose) {
            case "1" -> {
                Product product = new Product();
                System.out.println("add meg a termék nevét");
                product.setName(sc.nextLine());
                System.out.println("add meg a termék árát");
                product.setPrice(Integer.parseInt(sc.nextLine()));
                basket.saveProduct(product);
            }
            case "2" -> {
                System.out.println("add meg a termék nevét");
                basket.deleteProductFromName(sc.nextLine());
            }
            case "3" -> {
                Product product = new Product();
                System.out.println("add meg a termék nevét");
                product.setName(sc.nextLine());
                System.out.println("add meg a termék új árát");
                product.setPrice(Integer.parseInt(sc.nextLine()));
                basket.modificationProduct(product);
            }
            case "4" -> {
                basket.printAllProduct();
            }
            default -> {
                System.out.println("válasz inkább a menupontok közül gyökér....");
            }
        }
        }catch (NumberFormatException e){
            System.out.println("Hülye");
        }
        //sc.close();
    }


    private void printMenu() {
        System.out.println("Új termék felvétele (1)");
        System.out.println("Termék törlése (2)");
        System.out.println("Termék módosítása (3)");
        System.out.println("Termék listázása (4)");
        System.out.println("Kilépés (q)");
    }
}
