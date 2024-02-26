public class GameInfo {
    String name;
    int releaseyear;
    String publisher;
    int price;

    public GameInfo(String name, int releaseyear, String publisher, int price) {
        this.name = name;
        this.releaseyear = releaseyear;
        this.publisher = publisher;
        this.price = price;
    }

    public void changeName(String newName) {
        name = newName;
    }

    public void changePrice(int discount) {
        price -= discount;
    }
}
