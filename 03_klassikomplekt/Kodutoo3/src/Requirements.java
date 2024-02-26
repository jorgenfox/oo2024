public class Requirements {
    GameInfo gameinfo;
    int ram;
    int storage;
    int graphicsCard;

    public Requirements(GameInfo gameinfo, int ram, int storage, int graphicsCard) {
        this.gameinfo = gameinfo;
        this.ram = ram;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
    }

    public void changeStorage(int newSize) {
        this.storage = this.storage - newSize;
    }
    public void changeGraphics(int newGraphics) {
        graphicsCard = newGraphics;
    }
}
