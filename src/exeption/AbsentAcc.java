package exeption;

public class AbsentAcc extends Exception{
    String acc;
    public AbsentAcc(String acc) {
        this.acc = acc;
    }

    public String getAcc() {
        return acc;
    }
}
