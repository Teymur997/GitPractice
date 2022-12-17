package SweetBox;

import java.util.Arrays;

public class Cookie extends Sweet {
    String[] cookieIngredients = new String[] {"Мука", "Масло", "Сахар"};
    public Cookie(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String toString() {
        return "Название:'" + name + '\'' +
                ", Вес:" + weight +
                ", Стоимость:" + price
                + ", Основные ингредиенты:" + Arrays.toString(cookieIngredients);
    }
}
