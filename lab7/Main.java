
import java.util.*;

import java.io.*;

public class Main {
    private static InputReader input = new InputReader(System.in);
    private static PrintWriter output = new PrintWriter(System.out);

    static Mobil[] daftarMobil;

    public static void main(String[] args) {
        int P = input.nextInt();
        daftarMobil = new Mobil[P];
        for (int i = 0; i < P; i++) {
            String nama = input.next();
            String jenis = input.next();
            String behaviour = input.next();
            String bahanBakar = input.next();

            EngineBehaviour engineBehaviour = null;
            if (behaviour.equals("BBM")) {
                engineBehaviour = new BBM();
            } else {
                engineBehaviour = new Listrik();
            }

            if (jenis.equals("Air")) {
                daftarMobil[i] = new MobilAir(nama, engineBehaviour, bahanBakar);
            } else if (jenis.equals("Terbang")) {
                daftarMobil[i] = new MobilTerbang(nama, engineBehaviour, bahanBakar);
            } else {
                daftarMobil[i] = new MobilTruk(nama, engineBehaviour, bahanBakar);
            }

        }
        int Q = input.nextInt();
        for (int i = 0; i < Q; i++) {
            String nama = input.next();
            String perintah = input.next();

            Mobil mobilNow = null;
            for (Mobil x : daftarMobil) {
                if (nama.equals(x.getNama())) {
                    mobilNow = x;
                    break;
                }
            }

            if (perintah.equals("GAS")) {
                output.println(mobilNow.gas());
            } else if (perintah.equals("START")) {
                output.println(mobilNow.start());
            } else if (perintah.equals("STOP")) {
                output.println(mobilNow.stop());
            } else if (perintah.equals("ISI")) {
                String hasil = mobilNow.isiBahanBakar();
                output.println(hasil);
            } else {
                String[] hasil = mobilNow.simulasi();
                for (String line : hasil) {
                    output.println(line);
                }
            }

        }
        output.close();
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