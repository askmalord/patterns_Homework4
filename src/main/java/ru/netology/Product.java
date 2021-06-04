package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Single Responsibility Principle - все методы предназначены исключительно для продукта
public class Product implements Ratingable {
    // Magics - константы вынесены отдельно
    private static final double PLUS_KOEF = 1.03;
    private static final double MINUS_KOEF = 0.97;
    private String name;
    private int price;
    private String producerName;
    private Double rating;
    private final Double MAX_RATING = 5.00;

    public Product(String name, int price, String producerName) {
        this.name = name;
        this.price = price;
        this.producerName = producerName;
        this.rating = 3.00;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void rate() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вам понравился данный товар? Поставьте '+' или '-'");
        try {
            String answer = reader.readLine();
            double newRating;
            if (answer.equals("+")) {
                newRating = rating * PLUS_KOEF;
                if (newRating > MAX_RATING) {
                    this.setRating(MAX_RATING);
                } else {
                    this.setRating(newRating);
                }
            } else {
                newRating = rating * MINUS_KOEF;
                this.setRating(newRating);
            }
        } catch (IOException e) {

        }
    }
}
