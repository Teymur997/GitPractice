package SweetBox;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вводим величину, ограничивающую вес корзины (кг):");
        Box sweetBox = new Box();

        System.out.println("Добавляем сладости в коробку \nВводим количество добавляемых в коробку плиток шоколада, печенек и мармеладов:");
        sweetBox.addSweet();


        System.out.println("\nПолучаем информацию о сладостях в коробке:");
        sweetBox.getAllSweetsInformation();


        System.out.println("\nУбираем из коробки последнюю добавленную сладость:");
        sweetBox.deleteTheLastOne();
        System.out.println("\nПолучаем информацию о предметах в коробке:");
        sweetBox.getAllSweetsInformation();



        System.out.println("\nУбираем по индексу сладость из коробки:");
        sweetBox.deleteByIndex(3);
        System.out.println("\nПолучаем информацию о предметах в коробке:");
        sweetBox.getAllSweetsInformation();



        System.out.println("\nПолучаем общий вес коробки:");
        System.out.println(sweetBox.getBoxWeight());
        System.out.println("\nПолучаем общую стоимость коробки:");
        System.out.println(sweetBox.getBoxPrice());



        System.out.println("\nОчищаем коробку:");
        sweetBox.clearBox();
        sweetBox.getAllSweetsInformation();
        System.out.println("\nПолучаем общий вес и стоимость вес коробки:");
        System.out.println(sweetBox.getBoxWeight());
        System.out.println(sweetBox.getBoxPrice());


        System.out.println("\nУбираем из коробки сладости с минимальной стоимостью:");
        sweetBox.deleteMinPriceSweet();
        System.out.println("\nПолучаем информацию о сладостях в коробке:");
        sweetBox.getAllSweetsInformation();
        System.out.println("\nПолучаем общий вес и стоимость вес коробки:");
        System.out.println(sweetBox.getBoxWeight());
        System.out.println(sweetBox.getBoxPrice());


        System.out.println("\nУбираем из коробки сладости с минимальным весом:");
        sweetBox.deleteMinWeightSweet();
        System.out.println("\nПолучаем информацию о сладостях в коробке:");
        sweetBox.getAllSweetsInformation();
        System.out.println("\nПолучаем общий вес и стоимость вес коробки:");
        System.out.println(sweetBox.getBoxWeight());
        System.out.println(sweetBox.getBoxPrice());
    }

}
