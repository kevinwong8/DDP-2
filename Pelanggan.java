public class Pelanggan {

    String nama;
    int uang;
    Order[] keranjang;

    int kapasitasKeranjang = 5000;

    // TODO: Buat Constructor
    public Pelanggan(String nama, int uang, int kapasitas) {
        this.nama = nama;
        this.uang = uang;
        this.keranjang = new Order[50];

    }

    int findIndex(Barang barang) {
        int index = 0;

        if (keranjang.length != 0) {
            for (int i = 0; i < keranjang.length; i++) {
                if (keranjang[i] == null) {
                    index = i;
                    break;
                }
                if (barang.getNama().equals(keranjang[i].getBarang().getNama())) {
                    index = i;
                }
            }
        }

        return index;
    }

    boolean cekBeratBarang(Barang barang, int banyakBarang) {
        if (barang.getBeratBarang() * banyakBarang > this.kapasitasKeranjang) {
            return true;
        }
        return false;
    }

    // TODO: lengkapi method di bawah ini
    String addBarang(Barang barang, int banyakBarang) {
        if (!barang.cekStock(banyakBarang)) {
            return "Stock " + barang.getNama() + " kurang\n";
        }
        if (cekBeratBarang(barang, banyakBarang)) {
            int stockBisaAmbil = 0;
            for (int i = banyakBarang - 1; i > 0; i--) {
                if (!cekBeratBarang(barang, i)) {
                    stockBisaAmbil = i;
                    break;
                }
            }
            int index = findIndex(barang);
            if (keranjang[index] == null) {
                keranjang[index] = new Order(barang, stockBisaAmbil);
            } else {
                keranjang[index].setBanyakBarang(keranjang[index].getBanyakBarang() + stockBisaAmbil);

            }
            barang.setStock(barang.getStock() - stockBisaAmbil);
            this.kapasitasKeranjang -= barang.getBeratBarang() * stockBisaAmbil;
            System.out.println(this.getNama());
            System.out.println("uang " + +this.getUang());
            System.out.println("kapasitas " + +this.kapasitasKeranjang);
            for (int i = 0; i < keranjang.length; i++) {
                if (keranjang[i] == null) {
                    break;
                }

            }

            return "Maaf " + String.valueOf(banyakBarang) + " " + barang.getNama() +
                    " terlalu berat, tetapi " + String.valueOf(stockBisaAmbil) + " " + barang.getNama()
                    + " berhasil ditambahkan \n";

        }
        int index = findIndex(barang);
        if (keranjang[index] == null) {
            keranjang[index] = new Order(barang, banyakBarang);
        } else {
            keranjang[index].setBanyakBarang(keranjang[index].getBanyakBarang() + banyakBarang);
        }
        barang.setStock(barang.getStock() - banyakBarang);
        this.kapasitasKeranjang -= barang.getBeratBarang() * banyakBarang;

        return this.getNama() + " berhasil menambahkan " + String.valueOf(banyakBarang) + " " + barang.getNama() + "\n";

    }

    // TODO: lengkapi method di bawah ini
    int totalHargaBarang() {
        int total = 0;
        for (int i = 0; i < keranjang.length; i++) {

            if (keranjang[i] == null) {
                continue;
            } else {
                System.out.println(keranjang[i].getBarang().getNama() + " " + keranjang[i].getBarang().getHarga() + " "
                        + keranjang[i].getBarang().getBeratBarang());
                total = total + keranjang[i].getBarang().getHarga() * keranjang[i].getBanyakBarang();
            }

        }
        return total;
    }

    // TODO: lengkapi method di bawah ini
    String cekUang() {
        String pesan = "Uang " + this.getNama() + " sekarang " + String.valueOf(this.getUang() + "\n");
        return pesan;
    }

    // Setter and Getter dan lengkapi modifier
    String getNama() {
        return this.nama;
    }

    void setNama(String nama) {
        this.nama = nama;
    }

    int getUang() {
        return this.uang;
    }

    void setUang(int uang) {
        this.uang = uang;
    }

    Order[] getKeranjang() {
        return keranjang;
    }

    void resetKeranjang() {
        this.keranjang = new Order[50];
    }

}