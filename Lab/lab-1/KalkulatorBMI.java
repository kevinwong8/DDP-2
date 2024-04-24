import java.util.Scanner;
//--------------------------- PROGRAM PENGHITUNG BMI ----------------------
// OLEH: KEVIN 2106705436, 17/02/22

// Constructor di Java
public class KalkulatorBMI {
    public static void main(String[] args) {

        // Menampilkan kata pembuka
        System.out.println("Selamat datang di program kalkulator BMI!");
        System.out.println("--------------------------------------------------------");
        
        // Meminta input jumlah mahasiswa
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa yang akan dihitung datanya: ");
        int jumlahMahasiswa = input.nextInt();
        
        // Deklarasi variabel untuk penghitungan kumulutatif
        int bawahNormal = 0;
        int normal = 0;
        int atasNormal = 0;
        int obesitas = 0;
        double BMI;

        // Iterasi untuk setiap mahasiswa
        for(int i = 1; i<= jumlahMahasiswa; i++){

            // Meminta input user dan menampilkan kata sambutan
            System.out.printf("--------------------DATA MAHASISWA %d--------------------",i);
            System.out.println();
            System.out.print("Standar pengukuran apakah yang digunakan? ");

            String standarPengukuran = input.next();
            
            // Jika imperial maka akan dihitung secara imperial
            if( standarPengukuran.equals("IMPERIAL") ){
                System.out.print("Masukkan massa tubuh mahasiswa (pon): ");
                double massaTubuh = input.nextDouble();

                System.out.print("Masukkan tinggi tubuh mahasiswa (inci): ");
                double tinggiTubuh = input.nextDouble();
                
                // Menghitung BMI
                BMI = 703 * (massaTubuh/(Math.pow(tinggiTubuh,2)));
            }

            // Jika bukan imperial (dalam kasus ini dipastikan Metrik), maka BMI dihitung secara metrik
            else{
                System.out.print("Masukkan massa tubuh mahasiswa (kilogram): ");
                double massaTubuh = input.nextDouble();

                System.out.print("Masukkan tinggi tubuh mahasiswa (sentimeter): ");
                double tinggiTubuh = input.nextDouble();

                // Menghitung BMI
                BMI = massaTubuh/(Math.pow(tinggiTubuh,2) ) * Math.pow(10,4);
            }

            // Pengklasifikasian BMI lalu menambahkan jumlahnya sesuai kategori            
            if (BMI < 18.5){
                ++bawahNormal;
            }
            else if (BMI<25){
                ++normal;
            }
            else if (BMI<30){
                ++atasNormal;
            }
            else{
                ++obesitas;
            }
            


        }

        // Menampilkan hasil dari perhitungan dan pengklasifikasian
        System.out.printf("Berikut merupakan ringkasan hasil pengukuran BMI dari %d mahasiswa. %n", jumlahMahasiswa);
        System.out.printf("Jumlah mahasiswa dengan berat badan di bawah normal: %d %n", bawahNormal);
        System.out.printf("Jumlah mahasiswa dengan berat badan normal: %d %n", normal);
        System.out.printf("Jumlah mahasiswa dengan berat badan di atas normal: %d %n", atasNormal);
        System.out.printf("Jumlah mahasiswa obesitas: %d %n", obesitas);

        // Menampilkan kata penutup
        System.out.println("--------------------------------------------------------");
        System.out.println("Terima kasih telah menggunakan program kalkulator BMI!");
    }
}
