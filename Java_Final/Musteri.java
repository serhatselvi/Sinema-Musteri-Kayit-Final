
public class Musteri extends BaseEntity implements IKayit {

    public Musteri(int id, String name) {
        super(id, name);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Müşteri ID: " + id + ", Adı: " + name);
    }

    @Override
    public void kaydet() {
        System.out.println("Müşteri kaydedildi: " + name);
    }

    public String toJsonString() {
        return "{ \"id\": " + id + ", \"name\": \"" + name + "\" }";
    }
}
