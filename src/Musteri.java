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
