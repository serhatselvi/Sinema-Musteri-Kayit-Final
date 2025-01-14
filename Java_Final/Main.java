
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Yabancı filmler
        Film cesuryurek = new Film("Cesur Yurek", 160, "Aksiyon", true);
        Film avengers = new Film("Avengers", 150, "Fantastik", true);
        Film catchmeifyoucan = new Film("Catch Me If You Can", 140, "Drama", true);

        // Türk filmleri
        Film recepIvedik = new Film("Recep İvedik 4", 117, "Komedi", false);

        // Müşteriler
        Musteri ahmet = new Musteri(1, "Ahmet");
        Musteri mehmet = new Musteri(2, "Mehmet");
        Musteri erkan = new Musteri(3, "Erkan");

        // Salonlar
        Salon imax1 = new Salon(1, "IMAX 1", true, 20);
        Salon imax2 = new Salon(2, "IMAX 2", true, 20);
        Salon normal = new Salon(3, "Normal Salon", false, 10);

        // Film ve müşteri atama
        imax1.setOynatilanFilm(cesuryurek);
        imax2.setOynatilanFilm(avengers);
        normalSalon.setOynatilanFilm(recepIvedik4);

        imax1.musteriEkle(ahmet);
        imax2.musteriEkle(mehmet);
        normalSalon.musteriEkle(erkan);

        // JSON dosyaları oluşturma
        try (FileWriter writer = new FileWriter("Film.json")) {
            writer.write(cesuryurek.toJsonString());
        }
        try (FileWriter writer = new FileWriter("Salon.json")) {
            writer.write(imax1.toJsonString());
        }
        try (FileWriter writer = new FileWriter("Musteri.json")) {
            writer.write(ahmet.toJsonString());
        }

        // Menüyü görüntüleme
        while (true) {
            System.out.println("\n1- Filmleri Listele");
            System.out.println("2- Salonları Listele");
            System.out.println("3- Bir Salondaki Müşterileri Listele");
            System.out.println("4- Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    cesuryurek.bilgiGoster();
                    avengers.bilgiGoster();
                    catchmeifyoucan.bilgiGoster();
                    recepIvedik4.bilgiGoster();
                    break;
                case 2:
                    imax1.bilgiGoster();
                    imax2.bilgiGoster();
                    normal.bilgiGoster();
                    break;
                case 3:
                    System.out.print("Salon ID girin: ");
                    int salonId = scanner.nextInt();
                    if (salonId == 1) {
                        imax1.musterileriListele();
                    } else if (salonId == 2) {
                        imax2.musterileriListele();
                    } else if (salonId == 3) {
                        normal.musterileriListele();
                    } else {
                        System.out.println("Geçersiz salon ID!");
                    }
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}
