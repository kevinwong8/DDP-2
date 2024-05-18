import java.io.*;
import java.util.*;

public class Kasir {
    private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);
    // Gunakan out sebagai pengganti System.out
    // out ini akan menahan output sampai dia di-(close/flush)
    // Contoh jika ingin print("merah"), maka tulis out.print("merah")

    static Barang[] barang;
    static Pelanggan[] pelanggan;
    static int N, M;

    static Pelanggan cariPelanggan(String nama) {
        for (Pelanggan p : pelanggan) {
            if (nama.equals(p.getNama())) {
                return p;
            }
        }
        return null;
    }

    static Barang cariBarang(String namaBarang) {
        for (Barang b : barang) {
            if (namaBarang.equals(b.getNama())) {
                return b;
            }
        }
        return null;
    }

    static void kasir(Pelanggan cust) {

        Order[] belanjaan = cust.getKeranjang();
        // out.printf("jumlah uang " + cust.getNama() + " adalah " + cust.getUang() +
        // "\n");
        if (cust.totalHargaBarang() == 0) {
            out.printf("Maaf tidak ada barang di keranjang " + cust.getNama() + "\n");

        } else if (cust.getUang() < cust.totalHargaBarang()) {
            out.printf("Maaf " + cust.getNama() + " tidak memiliki cukup uang\n");

        } else {
            out.printf("Pembelian " + cust.getNama() + " berhasil\n");
            cust.setUang(cust.getUang() - cust.totalHargaBarang());
            ;
            for (int i = 0; i < belanjaan.length; i++) {
                if (belanjaan[i] == null) {
                    break;
                }
                out.printf("* " + belanjaan[i].getBarang().getNama() + " "
                        + belanjaan[i].getBanyakBarang() + " = "
                        + String.valueOf(belanjaan[i].getBarang().getHarga() * belanjaan[i].getBanyakBarang()) + "\n");
            }
            out.printf("* Total Belanjaan = " + String.valueOf(cust.totalHargaBarang()) + "\n");
            out.printf("* Sisa Uang = " + String.valueOf(cust.getUang()) + "\n");
            cust.kapasitasKeranjang = 5000;
            cust.resetKeranjang();
        }

    }

    public static void main(String[] args) {
        N = in.nextInt();
        barang = new Barang[N];
        for (int i = 0; i < N; i++) {
            String namaBarang = in.next();
            int hargaBarang = in.nextInt();
            int beratBarang = in.nextInt();
            int stock = in.nextInt();

            barang[i] = new Barang(namaBarang, hargaBarang, beratBarang, stock);

        }

        M = in.nextInt();
        pelanggan = new Pelanggan[M];
        for (int j = 0; j < M; j++) {
            String namaPelanggan = in.next();
            int uang = in.nextInt();

            pelanggan[j] = new Pelanggan(namaPelanggan, uang, 500);

        }

        int P = in.nextInt();
        for (int k = 0; k < P; k++) {
            String command = in.next();

            if (command.equals("ADD")) {
                String namaPelanggan = in.next();
                String namaBarang = in.next();
                int banyakBarangDiambil = in.nextInt();

                Pelanggan plg = cariPelanggan(namaPelanggan);
                out.print(plg.addBarang(cariBarang(namaBarang), banyakBarangDiambil));
            }

            if (command.equals("TOTAL_HARGA")) {
                String namaPelanggan = in.next();
                Pelanggan plg = cariPelanggan(namaPelanggan);
                out.printf("Total harga belanjaan %s adalah %d%n", plg.getNama(), plg.totalHargaBarang());
            }

            if (command.equals("KASIR")) {
                String namaPelanggan = in.next();
                Pelanggan plg = cariPelanggan(namaPelanggan);
                kasir(plg);
            }

            if (command.equals("CEK_UANG")) {
                String namaPelanggan = in.next();
                Pelanggan plg = cariPelanggan(namaPelanggan);
                out.print(plg.cekUang());
            }
        }

        // don't forget to close/flush the output
        out.close();
    }

    // taken from https://codeforces.com/submissions/Petr
    // together with PrintWriter, these input-output (IO) is much faster than the
    // usual Scanner(System.in) and System.out
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}