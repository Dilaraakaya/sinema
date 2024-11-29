//SinemaSistemi.java
import java.util.ArrayList;
import java.util.List;

public class SinemaSistemi extends BaseEntity implements IKayit {
    private List<BaseEntity> kayitlar;

    public SinemaSistemi() {
        super(); // Parametresiz kurucu çağrısı
        this.kayitlar = new ArrayList<>();
    }

    public SinemaSistemi(int id, String isim) {
        super(id, isim); // Parametreli kurucu çağrısı
        this.kayitlar = new ArrayList<>();
    }

    @Override
    public void kayitEkle(BaseEntity entity) {
        kayitlar.add(entity);
    }

    @Override
    public void kayitlariListele() {
        for (BaseEntity entity : kayitlar) {
            entity.BilgiGoster();
        }
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Sistem ID: " + id + ", İsim: " + isim);
    }

    public static void main(String[] args) {
        SinemaSistemi sistem = new SinemaSistemi(1, "Ana Sinema Sistemi");

        // Örnek Müşteri, Film ve Salon oluşturma
        Musteri Musteri1 = new Musteri(1, "Ahmet Yılmaz");
        Musteri Musteri2 = new Musteri(2, "Ayşe Demir");

        Film film1 = new Film("Inception", 148, "Bilim Kurgu");
        Film film2 = new Film("Titanic", 195, "Romantik");

        Salon salon1 = new Salon(1, "Salon 1");
        salon1.filmEkle(film1);
        salon1.filmEkle(film2);
        salon1.musteriEkle(musteri1);
        salon1.musteriEkle(musteri2);

        sistem.kayitEkle(musteri1);
        sistem.kayitEkle(musteri2);
        sistem.kayitEkle(salon1);

        // Kayıtları listeleme
        sistem.kayitlariListele();
    }
}
