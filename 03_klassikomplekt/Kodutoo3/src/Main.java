public class Main {
    public static void main(String[] args) {

        /*Info info = new Info("MacBook", 16, "Intel");
        Arvuti arvuti = new Arvuti(info, 1000, "Kristiine");
        arvuti.muudaPoodi("Mustamäe");
        arvuti.info.muudaNimetus("Mac Pro");

        Arvuti arvuti2 = new Arvuti(
                new Info("Dell", 32, "Intel"),
                1100, "Ülemiste");
        arvuti2.paneAllahindlus(200);*/

        GameInfo gameinfo1 = new GameInfo("Grand Theft Auto 5", 2013, "Rockstar Games", 60);
        Requirements requirements1 = new Requirements(gameinfo1,8,120,1080);
        requirements1.changeStorage(140);
        requirements1.gameinfo.changePrice(4);


        GameInfo gameinfo2 = new GameInfo("Minecraft", 2011, "Mojang", 20);
        Requirements requirements2 = new Requirements(gameinfo2, 16, 20, 2070);
        requirements2.changeGraphics(4090);
        requirements2.gameinfo.changeName("Red Dead Redemption 2");

    }
}