public class Segitiga extends BangunDatar {
    private int alas, tinggi;

    public Segitiga(int alas, int tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public float luas() {
        return (float) (0.5 * alas * tinggi);
    }

    public float keliling() {
        double sisiMiring = Math.sqrt(alas * alas + tinggi * tinggi);
        return (float) (alas + tinggi + sisiMiring);
    }
}