package SweetBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Box implements SweetBox {
    private static Scanner input = new Scanner(System.in);
    private static  double BOX_MAX_SIZE = Double.parseDouble(input.next());
    private static List<Sweet> box = new ArrayList<Sweet>();

    public static List<Sweet> getBox() {
        return box;
    }
    private static double boxWeight = 0;
    private static double boxPrice = 0;




    @Override
    public void addSweet() {
        double ChocolateBarCount = Double.parseDouble(input.next());
        double CookieCount = Double.parseDouble(input.next());
        double MarmaladeCount = Double.parseDouble(input.next());

        RandomSweet randomSweet = new RandomSweet();
        for (int i = 0; i < ChocolateBarCount; i++) {
            getBox().add(randomSweet.getRandomChocolateBar());
        }
        for (int i = 0; i < CookieCount; i++) {
            getBox().add(randomSweet.getRandomCookie());
        }
        for (int i = 0; i < MarmaladeCount; i++) {
            getBox().add(randomSweet.getRandomMarmalade());
        }

    }

    @Override
    public void deleteTheLastOne() {
        getBox().remove(getBox().size()-1);
    }

    @Override
    public void deleteByIndex(int index) {
        getBox().remove(index);
    }

    @Override
    public double getBoxWeight() {
        boxWeight = getBox().
                stream().
                mapToDouble(sweet -> sweet.weight).
                sum();
        return boxWeight;
    }

    @Override
    public double getBoxPrice() {
        boxPrice = getBox().
                stream().
                mapToDouble(sweet -> sweet.price).
                sum();
        return boxPrice;
    }

    @Override
    public void getAllSweetsInformation() {
        getBox().
                stream().
                map(sweet -> sweet.toString()).
                forEach(System.out::println);
        if (getBoxWeight() > BOX_MAX_SIZE) {
            System.out.println("Коробка переполнена! Необходимо вытащить лишнее.");
        }
    }

    @Override
    public void clearBox() {
        getBox().clear();
        boxPrice = 0;
        boxWeight = 0;
        System.out.println("Коробка пуста");
    }

    @Override
    public void deleteMinPriceSweet() {
        int index = 0;
        double min;
        if (getBox().size() != 0 || getBoxWeight() > BOX_MAX_SIZE) {
            do {
                min = getBox().get(0).price;
                for (int i = 0; i < getBox().size(); i++) {
                    if (getBox().get(i).price < min) {
                        min = getBox().get(i).price;
                    }
                }
                for (int j = 0; j < getBox().size(); j++) {
                    if (getBox().get(j).price == min) {
                        index = j;
                    }
                }
                getBox().remove(index);
            } while (getBoxWeight() >= BOX_MAX_SIZE);
        }
    }

    @Override
    public void deleteMinWeightSweet() {
        int index = 0;
        double min;
        if (getBox().size() != 0 || getBoxWeight() > BOX_MAX_SIZE) {
            do {
                min = getBox().get(0).weight;
                for (int i = 0; i < getBox().size(); i++) {
                    if (getBox().get(i).weight < min) {
                        min = getBox().get(i).weight;
                    }
                }
                for (int j = 0; j < getBox().size(); j++) {
                    if (getBox().get(j).weight == min) {
                        index = j;
                    }
                }
                getBox().remove(index);
            } while (getBoxWeight() >= BOX_MAX_SIZE);
        }
    }
}