// BaseEntity.java
public abstract class BaseEntity {
    protected int id;
    protected String isim;

    public BaseEntity(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    public abstract void BilgiGoster();
}

// Musteri.java
public class Musteri extends BaseEntity {
    public Musteri(int id, String isim) {
        super(id, isim);
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Müşteri ID: " + id + ", İsim: " + isim);
    }
}

// Film.java
public class Film {
    private String ad;
    private int sure; // dakika cinsinden
    private String tur;

    public Film(String ad, int sure, String tur) {
        this.ad = ad;
        this.sure = sure;
        this.tur = tur;
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

    public void BilgiGoster() {
        System.out.println("Film Adı: " + ad + ", Süre: " + sure + " dakika, Tür: " + tur);
    }
}

// Salon.java
import java.util.ArrayList;
import java.util.List;

public class Salon extends BaseEntity {
    private List<Film> filmler;
    private List<Musteri> musteriler;

    public Salon(int id, String isim) {
        super(id, isim);
        this.filmler = new ArrayList<>();
        this.musteriler = new ArrayList<>();
    }

    public void filmEkle(Film film) {
        filmler.add(film);
    }

    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }

    public List<Film> getFilmler() {
        return filmler;
    }

    public List<Musteri> getMusteriler() {
        return musteriler;
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Salon ID: " + id + ", İsim: " + isim);
        System.out.println("Gösterilen Filmler:");
        for (Film film : filmler) {
            film.BilgiGoster();
        }
        System.out.println("Kayıtlı Müşteriler:");
        for (Musteri musteri : musteriler) {
            musteri.BilgiGoster();
        }
    }
}

// IKayit.java
public interface IKayit {
    void kayitEkle(BaseEntity entity);
    void kayitlariListele();
}

// SinemaSistemi.java
import java.util.ArrayList;
import java.util.List;

public class SinemaSistemi implements IKayit {
    private List<BaseEntity> kayitlar;

    public SinemaSistemi() {
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

    public static void main(String[] args) {
        SinemaSistemi sistem = new SinemaSistemi();

        // Örnek Müşteri, Film ve Salon oluşturma
        Musteri musteri1 = new Musteri(1, "Ahmet Yılmaz");
        Musteri musteri2 = new Musteri(2, "Ayşe Demir");

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
