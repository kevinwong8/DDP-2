
import java.util.HashMap;
import java.util.Scanner;

public class IdGenerator {
    static HashMap<Character, Integer> charToValue = new HashMap<>(36);
    static char[] valueToChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static String[] listProgramStudi = { "SIK", "SSI", "MIK", "MTI", "DIK" };

    /*
     * Code pada method main tidak boleh diganti sama sekali!
     */
    public static void main(String[] args) {
        buildMapCharToValue();
        Scanner input = new Scanner(System.in);
        System.out.println("Selamat Datang di Perpustakaan!");

        boolean shouldTerminateProgram = false;

        while (!shouldTerminateProgram) {
            printMenu();
            System.out.print("Menu yang anda pilih: ");
            int menu = input.nextInt();
            input.nextLine();

            if (menu == 1) {
                System.out.print("Program Studi: ");
                String programStudi = input.nextLine();
                System.out.print("Angkatan: ");
                String angkatan = input.nextLine();
                System.out.print("Tanggal Lahir: ");
                String tanggalLahir = input.nextLine();

                System.out.println(generateId(programStudi, angkatan, tanggalLahir));
            } else if (menu == 2) {
                System.out.print("ID Anggota: ");
                String idAnggota = input.nextLine();

                System.out.print("Validitas: ");
                System.out.println(checkValidity(idAnggota));
            } else {
                shouldTerminateProgram = true;
                System.out.println("Sampai jumpa!");
            }
        }

        input.close();
    }

    /*
     * Method buildMapCodeToNumber adalah method untuk membuat mapping reference
     * numbers Code 93
     */
    public static void buildMapCharToValue() {
        for (int count = 0; count < valueToChar.length; count++) {
            charToValue.put(valueToChar[count], count);
        }
    }

    /*
     * Method getCharFromValue adalah method yang akan mengembalikan Code 93 dari
     * value yang diberikan
     */
    private static char getCharFromValue(int value) {
        return valueToChar[value];
    }

    /*
     * Method getValueFromChar adalah method yang akan mengembalikan value dari Code
     * 93 yang diberikan
     */
    private static int getValueFromChar(char character) {
        return charToValue.get(character);
    }

    private static void printMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("Menu yang tersedia:");
        System.out.println("1. Generate ID anggota untuk anggota baru");
        System.out.println("2. Check validitas ID anggota");
        System.out.println("3. Keluar");
        System.out.println("--------------------------------------------");
    }

    /*
     * Method generateId adalah method untuk membuat ID keanggotaan perpustakaan
     * Parameter dan return type dari method ini tidak boleh diganti
     */

    public static boolean cekProgramStudi(String programStudi) {
        for (String lsp : listProgramStudi) {
            if (lsp.equals(programStudi))
                return true;
        }
        return false;
    }

    public static boolean cekAngkatan(String angkatan) {
        int integerAngkata = Integer.parseInt(angkatan);
        if(2000<= integerAngkata && integerAngkata <= 2021)return true;
        
        return false;
    }

    public static String generateId(String programStudi, String angkatan, String tanggalLahir) {
        // TODO: Tuliskan implementasi untuk membuat ID keanggotaan perpustakaan
        String[] tgl = tanggalLahir.split("/");
        tanggalLahir = String.valueOf(tgl[0] + tgl[1] + tgl[2]);
        String id = programStudi + angkatan.substring(2, 4) +
                tanggalLahir.substring(0, 4) + tanggalLahir.substring(6, 8);
        System.out.println(id);
        id = addNewChar(id);
        id = addNewChar(id);

        return id;
    }

    public static String addNewChar(String idSementara) {
        char[] charID = idSementara.toCharArray();

        int sum = 0;
        for (int i = 0; i < charID.length; i++) {
            System.out.println("Nilai i sekarang " + (charID.length - i));
            System.out.println("Nilai char sekarang " + getValueFromChar(charID[i]));
            sum += ((charID.length - i) * getValueFromChar(charID[i]));
            System.out.println("Nilai sum sekarang " + sum);
        }
        sum = sum % 36;
        return idSementara + getCharFromValue(sum);

    }

    /*
     * Method checkValidity adalah method untuk mengecek validitas ID keanggotaan
     * perpustakaan
     * Parameter dan return type dari method ini tidak boleh diganti
     */

    public static boolean checkNamaFakultas(String idAnggota) {
        if (idAnggota.substring(0, 3).equals("SIK") ||
                idAnggota.substring(0, 3).equals("SSI") ||
                idAnggota.substring(0, 3).equals("MIK") ||
                idAnggota.substring(0, 3).equals("MTI") ||
                idAnggota.substring(0, 3).equals("DIK")) {
            return true;
        }
        return false;
    }

    public static boolean checkValidity(String idAnggota) {
        // TODO: Tuliskan implementasi untuk mengecek validitas ID keanggotaan
        // perpustakaan

        // cek nama fakultas
        /***
         * if(!checkNamaFakultas(idAnggota)){
         * return false;
         * 
         * }
         ***/
        return false;

    }
}
