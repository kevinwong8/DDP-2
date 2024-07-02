
class Pesanan {
    private String nama;
    private int harga;
    private int prioritas;

    public Pesanan() {
        this.nama = "ayam";
    }

    public Pesanan(String inama, int iharga, int iprioritas) {
        this.nama = inama;
        this.harga = iharga;
        this.prioritas = iprioritas;
    }

    public int compareTo(Pesanan x) {
        if (this.prioritas < x.prioritas)
            return -1;
        return 1;
    }

    public String getNama() {
        return this.nama;
    }

    public int getHarga() {
        return this.harga;
    }

    public int getPrioritas() {
        return this.prioritas;
    }
}
