// BaseEntity.java
public abstract class BaseEntity {
    protected int id;
    protected String isim;

    public BaseEntity() {
        // Parametresiz kurucu
    }

    public BaseEntity(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    public abstract void BilgiGoster();
}
