package ru.netology;

import java.io.IOException;

// Interface Segregation Principle - интерфейс предназначен исключительно для оценки чего-либо
public interface Ratingable {
    public void rate () throws IOException;
}
