public class Lingkaran extends BangunDatar {
    private int r;

    public Lingkaran(int r) {
        this.r = r;
    }

    public float luas() {
        return (float) (3.14 * this.r * this.r);
    }

    public float keliling() {
        return (float) (2 * 3.14 * this.r);
    }
}
