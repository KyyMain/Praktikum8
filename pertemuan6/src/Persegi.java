public class Persegi extends BangunDatar {
    private int sisi;

    public Persegi(int sisi) {
        this.sisi = sisi;
    }

    public float luas() {
        return (float) (sisi * sisi);
    }

    public float keliling() {
        return (float) (2 * sisi);
    }
}
