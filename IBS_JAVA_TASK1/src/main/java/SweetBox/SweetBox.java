package SweetBox;

public interface SweetBox {
    public void addSweet();
    public void deleteTheLastOne();
    public void deleteByIndex(int index);
    public double getBoxWeight();
    public double getBoxPrice();
    public void getAllSweetsInformation();
    public void clearBox();
    public void deleteMinPriceSweet();
    public void deleteMinWeightSweet();
}
