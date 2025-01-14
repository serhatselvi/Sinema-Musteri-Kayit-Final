
import java.util.ArrayList;
import java.util.List;

public class Salon extends BaseEntity implements IKayit {
    private List<Musteri> musteriler;
    private Film oynatilanFilm;
    private boolean isImax;
    private double fiyat;

    public Salon(int id, String name, boolean isImax, double fiyat) {
        super(id, name);
        this.musteriler = new ArrayList<>();
        this.isImax = isImax;
        this.fiyat = fiyat;
    }

    public void setOynatilanFilm(Film film) {
        this.oynatilanFilm = film;
    }

    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Salon ID: " + id + ", Adı: " + name + ", Tür: " + (isImax ? "IMAX" : "Normal") + ", Fiyat: " + fiyat + " TL");
        if (oynatilanFilm != null) {
            System.out.println("Gösterilen Film: ");
            oynatilanFilm.bilgiGoster();
        }
    }

    public void musterileriListele() {
        System.out.println("Salon: " + name + " için müşteri listesi:");
        for (Musteri musteri : musteriler) {
            musteri.bilgiGoster();
        }
    }

    @Override
    public void kaydet() {
        System.out.println("Salon kaydedildi: " + name);
    }

    public String toJsonString() {
        StringBuilder jsonBuilder = new StringBuilder("{ \"id\": " + id + ", \"name\": \"" + name + "\", \"isImax\": " + isImax + ", \"fiyat\": " + fiyat + ", \"oynatilanFilm\": ");
        jsonBuilder.append(oynatilanFilm != null ? oynatilanFilm.toJsonString() : "null");
        jsonBuilder.append(", \"musteriler\": [");
        for (int i = 0; i < musteriler.size(); i++) {
            jsonBuilder.append(musteriler.get(i).toJsonString());
            if (i < musteriler.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("] }");
        return jsonBuilder.toString();
    }
}
