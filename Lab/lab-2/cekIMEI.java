import java.util.Scanner;

public class cekIMEI {

    public static int Nilai(String imei) {
        if (imei.length() == 0) {
            return 0;

        }
        int jumlah = Integer.parseInt(String.valueOf(imei.charAt(0)));
        if (imei.length() % 2 == 1) {

            jumlah = jumlah * 2;

            if (jumlah > 9) {
                jumlah = jumlah / 10 + jumlah % 10;
            }

        }

        return jumlah + Nilai(imei.substring(1));
    }

    public static boolean Validity(String imei) {
        int nilai = Nilai(imei);
        if (nilai % 10 == 0) {
            return true;
        }
        return false;
    }

    public static boolean CekDigit(Long imei) {
        String s = String.valueOf(imei);

        if (s.length() != 11) {
            return false;
        }

        long divider = 10000000000L;
        long first_digit = imei / divider;

        long second_digit = (imei / 1000000000) % 10;

        if (first_digit == 2) {
            return true;
        } else if (first_digit == 1) {
            if (second_digit == 8) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan jumlah imei: ");
        int n = input.nextInt();
        Long[] list_imei = new Long[n];
        for (int i = 0; i < n; i++) {
            list_imei[i] = input.nextLong();
        }

        System.out.println();
        for (long i : list_imei) {
            if (CekDigit(i)) {
                if (Validity(String.valueOf(i))) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
        input.close();

    }
}