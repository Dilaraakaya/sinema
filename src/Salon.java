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
