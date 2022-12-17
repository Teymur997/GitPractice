package SweetBox;

public abstract class Sweet {
    String name;
    double weight;
    double price;
    public Sweet(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Название:'" + name + '\'' +
                ", Вес:" + weight +
                ", Стоимость:" + price;
    }
}
