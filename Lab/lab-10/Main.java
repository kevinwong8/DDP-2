import java.util.*;

import java.io.*;

public class Main {

    private static InputReader input = new InputReader(System.in);
    private static PrintWriter output = new PrintWriter(System.out);
    private static Scanner reader = new Scanner(System.in);
    private static DaftarPesanan<Makanan> makanan = new DaftarPesanan<Makanan>();
    private static DaftarPesanan<Minuman> minuman = new DaftarPesanan<Minuman>();

    public static void main(String[] args) {

        int jumlahMakanan = input.nextInt();
        int jumlahMinuman = input.nextInt();
        for (int i = 0; i < jumlahMakanan; i++) {
            String nama = input.next();
            int harga = input.nextInt();
            int prioritas = input.nextInt();
            int tingkatKepedasan = input.nextInt();

            makanan.tambahPesanan(new Makanan(nama, harga, prioritas, tingkatKepedasan));

        }
        for (int i = 0; i < jumlahMinuman; i++) {
            String nama = input.next();
            int harga = input.nextInt();
            int prioritas = input.nextInt();
            String isPakeEs = input.next();

            if (isPakeEs.equals("YES")) {
                minuman.tambahPesanan(new Minuman(nama, harga, prioritas, true));
            } else {
                minuman.tambahPesanan(new Minuman(nama, harga, prioritas, false));
            }

        }

        boolean flag = true;
        while (flag) {
            String perintah;

            perintah = reader.nextLine();

            if (perintah.equals("SERVE MAKANAN")) {
                if (makanan.size() == 0) {
                    output.println("Semua pesanan makanan sudah disajikan! ");
                } else {
                    output.println(makanan.nextPesanan().toString() + " telah disajikan");
                }

            } else if (perintah.equals("SERVE MINUMAN")) {
                if (minuman.size() == 0) {
                    output.println("Semua pesanan minuman sudah disajikan! ");
                } else {
                    output.println(minuman.nextPesanan().toString() + "telah disajikan");
                }

            } else {
                flag = false;

            }

        }
        output.flush();

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

        public String nextLn() {
            while (tokenizer == null) {
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
