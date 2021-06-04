package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Single Responsibility Principle - все методы предназначены исключительно для магазина
class OnlineShop implements Ratingable{
    private String shopName;
    private List<Product> products;
    private Double shopRating;
    private static List<Integer> listOfGrades = new ArrayList<>();

    public OnlineShop(String shopName, List<Product> products) {
        this.shopName = shopName;
        this.products = products;
    }

    public void makeListOfProducts() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        products = new ArrayList<>();
        System.out.println("----- Заполнение списка продуктов -----" +
            "\nВведите информацию о продукте через пробел (название, цену, производителя):");
        while (true) {
            String potentialProduct = reader.readLine();
            if (potentialProduct.equals("СТОП")) {
                break;
            }
            String productInfo[] = potentialProduct.split(" ");
            String name = productInfo[0];
            int price = Integer.parseInt(productInfo[1]);
            String producerName = productInfo[2];
            products.add(
                new Product(name, price, producerName)
            );
            System.out.println("Продукт " + name
                + " добавлен (для того, чтобы закончить добавление товаров, введите СТОП)");
        }
    }

    public void showProductsList() {
        System.out.println("----- Список товаров -----");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    public Product searchProductBuyName(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (productName.equals(products.get(i).getName())) {
                return products.get(i);
            }
        }
        return null;
    }

    public void buyProducts(Buyer someBuyer) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set productsNames = new HashSet();
        for (int i = 0; i < products.size(); i++) {
            productsNames.add(products.get(i).getName());
        }
        while (true) {
            System.out.println("Введите название товара, который хотите купить: ");
            try {
                String productName = reader.readLine();
                if (productsNames.contains(productName)) {
                    System.out.println("Товар найден, введите количетсво, которое желаете приобрести:");
                    int count = Integer.parseInt(reader.readLine());
                    Product product = searchProductBuyName(productName);
                    someBuyer.addProductToBasket(product, count);
                }
                else {
                    System.out.println("Товар не найден");
                }
                System.out.println("Желаете продолжить покупки? (да/нет)");
                String answer = reader.readLine();
                if (answer.equals("нет")) {
                    someBuyer.showShoppingBasket();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getShopName() {
        return shopName;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void rate() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Оцените наш магазин по шкале от 0 до 10: ");
        try {
            int rating = Integer.parseInt(reader.readLine());
            listOfGrades.add(rating);
        } catch (IOException e) {

        }
    }

    public void showRating() {
        int sumOfGrades = 0;
        for (int i = 0; i < listOfGrades.size(); i++) {
            sumOfGrades += listOfGrades.get(i);
        }
        shopRating = 1.0 * sumOfGrades / listOfGrades.size();
        System.out.println("Текущий тейтинг магазина: " + shopRating);
    }
}
