package SweetBox;

import java.util.Arrays;

public class ChocolateBar extends Sweet {
    String[] chocolateBarIngredients = new String[] {"Сухое молоко", "Какао бобы", "Какао масло", "Сахарная пудра"};
    public ChocolateBar(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String toString() {
        return "Название:'" + name + '\'' +
                ", Вес:" + weight +
                ", Стоимость:" + price
                + ", Основные ингредиенты:" + Arrays.toString(chocolateBarIngredients);
    }
}
