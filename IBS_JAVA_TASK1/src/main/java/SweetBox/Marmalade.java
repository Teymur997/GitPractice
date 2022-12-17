package SweetBox;

import java.util.Arrays;

public class Marmalade extends Sweet {
    String[] marmaladeIngredients = new String[] {"Фруктовый сок", "Сахар", "Желатин"};
    public Marmalade(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String toString() {
        return "Название:'" + name + '\'' +
                ", Вес:" + weight +
                ", Стоимость:" + price
                + ", Основные ингредиенты:" + Arrays.toString(marmaladeIngredients);
    }
}
