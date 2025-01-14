
public class Film {
    private String ad;
    private int sure;
    private String tur;
    private boolean isYabanci;

    public Film(String ad, int sure, String tur, boolean isYabanci) {
        this.ad = ad;
        this.sure = sure;
        this.tur = tur;
        this.isYabanci = isYabanci;
    }

    public String getAd() {
        return ad;
    }

    public int getSure() {
        return sure;
    }

    public String getTur() {
        return tur;
    }

    public boolean isYabanci() {
        return isYabanci;
    }

    public void bilgiGoster() {
        System.out.println("Film: " + ad + ", Süre: " + sure + " dk, Tür: " + tur + (isYabanci ? " (Yabancı)" : " (Türk)"));
    }

    public String toJsonString() {
        return "{ \"ad\": \"" + ad + "\", \"sure\": " + sure + ", \"tur\": \"" + tur + "\", \"isYabanci\": " + isYabanci + " }";
    }
}
