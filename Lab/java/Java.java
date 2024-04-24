import java.util.Scanner;

public class Java{
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Nama Mahasiswa: ");
        String nama = input.nextLine();
        System.out.println("Masukkan Nilai Asli: ");
        Double nilai_asli = input.nextDouble();
        System.out.println("Masukkan Durasi ");
        Double durasi = input.nextDouble();

        Double nilai_akhir;
        if (durasi < 60){
            nilai_akhir = 1.2 * nilai_asli;
        }
        else if (durasi >= 60 && durasi <=70){
            nilai_akhir = nilai_asli;
        }
        else if (durasi > 70 && durasi <90){
            nilai_akhir = 0.75 * nilai_asli;
        }
        else if (durasi >= 90 && durasi <=100){
            nilai_akhir = 0.2 * nilai_asli;
        }

        System.out.printf("%s mendapatkan nilai akhir %f",nama, nilai_akhir);
    }
}