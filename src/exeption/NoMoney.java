package exeption;

public class NoMoney extends Exception{
    private String acc;

    public String getAcc() {
        return acc;
    }

    public NoMoney(String acc) {
        this.acc = acc;
    }
}
