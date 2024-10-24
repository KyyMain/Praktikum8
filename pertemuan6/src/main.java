public class main {
    public static void main(String[] args) {
        Lingkaran Lingkaran = new Lingkaran(20);
        Persegi Persegi = new Persegi(20);
        Segitiga Segitiga = new Segitiga(10, 20);

        System.out.println("Menghitung Luas dan Keliling Lingkaran:");
        System.out.println("Luas Lingkaran: " + Lingkaran.luas());
        System.out.println("Keliling Lingkaran: " + Lingkaran.keliling());

        System.out.println("\nMenghitung Luas dan Keliling Segitiga:");
        System.out.println("Luas Segitiga: " + Segitiga.luas());
        System.out.println("Keliling Segitiga: " + Segitiga.keliling());

        System.out.println("\nMenghitung Luas dan Keliling Persegi:");
        System.out.println("Luas Persegi: " + Persegi.luas());
        System.out.println("Keliling Persegi: " + Persegi.keliling());
    }
}
