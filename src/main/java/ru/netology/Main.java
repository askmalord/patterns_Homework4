package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main( String[] args ) throws IOException {
        OnlineShop shop = new OnlineShop("eBay", new ArrayList<>());
        Buyer client = new Buyer("Mike");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Добро пожаловать!");
        while (true) {
            System.out.println("Выберите действие:" +
                "\n1. Дополнить список продуктов на прилавках (функция для сотрудников магазина)" +
                "\n2. Просмотреть список товаров" +
                "\n3. Оценить магазин" +
                "\n4. Покинуть магазин");
            int answer = Integer.parseInt(reader.readLine());
            if (answer == 4) {
                break;
            }
            switch (answer) {
                case 1:
                    shop.makeListOfProducts();
                    break;
                case 2:
                    shop.showProductsList();
                    shop.buyProducts(client);
                    break;
                case 3:
                    shop.rate();
                    shop.showRating();
                    break;
            }
        }
    }
}
