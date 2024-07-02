
public class Makanan extends Pesanan {

    private int tingkatKepedasan;

    public Makanan() {

    }

    public Makanan(String nama, int harga, int prioritas, int tingkatKepedasan) {
        super(nama, harga, prioritas);
        this.tingkatKepedasan = tingkatKepedasan;
    }

    public String toString() {
        return this.getNama() + " level " + this.tingkatKepedasan;
    }

    public static void main(String[] args) {
        System.out.println("test");
        Pesanan ayam = new Pesanan();
        System.out.println(ayam.getNama());
    }
}
