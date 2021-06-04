package ru.netology;

import java.util.HashMap;
import java.util.Map;

// Single Responsibility Principle - все методы предназначены исключительно для покупателя
public class Buyer {
    private String name;
    // Dependency Inversion Principle - выполняется для мапы, своего интерфейса придумать не успел
    private Map<Product, Integer> shoppingBasket;

    public Buyer(String name) {
        this.name = name;
        this.shoppingBasket = new HashMap<>();
    }

    public void addProductToBasket(Product someProduct, Integer count) {
        System.out.println("Товар " + someProduct + " добавлен в корзину в количестве " + count);
        shoppingBasket.put(someProduct, count);
    }

    public void deleteProductFromBasket(Product someProduct, Integer count) {
        if (shoppingBasket.get(someProduct) >= count) {
            shoppingBasket.put(someProduct, shoppingBasket.get(someProduct) - count);
            System.out.println("Количество товара уменьшено. Оставшееся количество: "
                + shoppingBasket.get(someProduct));
        }
        else {
            shoppingBasket.remove(someProduct);
            System.out.println("Товар полностью удален из корзины");
        }
    }

    public void showShoppingBasket() {
        System.out.println("Список покупок:");
        for (Map.Entry<Product, Integer> productWithCount : shoppingBasket.entrySet()) {
            System.out.println(productWithCount.getKey() + ": " + productWithCount.getValue());
        }
    }

    public String getName() {
        return name;
    }

    public Map<Product, Integer> getShoppingBasket() {
        return shoppingBasket;
    }

}
