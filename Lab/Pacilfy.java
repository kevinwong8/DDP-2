import java.util.Scanner;

public class Pacilfy {
    static Scanner input = new Scanner(System.in);
    static String[][] list_musik = new String[0][3];

    public static void main(String[] args) {
        list_musik = opening(list_musik);
        showStatus(list_musik, 0);
        System.out.println("Terima kasih sudah menggunakan Pacilfy!");

    }

    public static void showStatus(String[][] array_musik, int index) {
        String output =  array_musik[index][1] + " - " + array_musik[index][0];
        System.out.println("Currently Playing");
        System.out.println("==================================================================");
        System.out.println("= " + output + " =");

        System.out.println("==================================================================");
        System.out.println("");
        System.out.println("|[1] prev |[2] add music |[3] details |[4] delete music |[5] next|");
        System.out.print("Command (0 untuk exit) : ");
        int menu = Integer.parseInt(input.nextLine());
        System.out.println();
        switch (menu) {
            case 0:
                break;
            case 1:
                previous(array_musik, index);
                break;
            case 2:
                array_musik = addMusic(array_musik);
                showStatus(array_musik, index);
                break;
            case 3:
                details(array_musik, index);
                break;
            case 4:
                delete(array_musik, index);
                break;
            case 5:
                next(array_musik, index);
                break;
            default:
                break;
        }
    }

    public static void delete(String[][] array_musik, int index) {
        if (array_musik.length <= 1) {
            System.out.println("Minimal ada satu musik dalam sistem\n");
            showStatus(array_musik, index);
        } else {
            String[][] new_array = new String[array_musik.length - 1][3];
            int k = 0;
            for (int i = 0; i < array_musik.length; i++) {
                if (index != i) {
                    new_array[k] = array_musik[i];
                    k++;
                }
            }
            index++;
            if (index >= new_array.length) {
                index = 0;
            }
            showStatus(new_array, index);
        }

    }

    public static void details(String[][] array_musik, int index) {
        System.out.print("Judul yang ingin dicari: ");
        String judul = input.nextLine();
        Boolean flag = false;
        for (int i = 0; i < array_musik.length; i++) {
            if (array_musik[i][0].equalsIgnoreCase(judul)) {
                flag = true;
                System.out.println("Judul: " + array_musik[i][0]);
                System.out.println("Artist : " + array_musik[i][1]);
                System.out.println("Album : " + array_musik[i][2]);
                System.out.println("Tahun : " + array_musik[i][3]);
            }
        }
        if (flag == false) {
            System.out.println("Lagu tidak ditemukan\n");
        }

        showStatus(array_musik, index);
    }

    public static void previous(String[][] array_musik, int index) {
        index--;
        if (index == -1) {
            index = array_musik.length - 1;
        }
        showStatus(array_musik, index);
    }

    public static void next(String[][] array_musik, int index) {
        index++;
        if (index > array_musik.length - 1) {
            index = 0;
        }
        showStatus(array_musik, index);
    }

    public static void showList(String[][] array_musik) {
        for (int row = 0; row < array_musik.length; row++) {
            for (int column = 0; column < array_musik[row].length; column++) {
                System.out.print(array_musik[row][column] + ",");
            }
            System.out.println();
        }
    }

    public static String[][] addMusic(String[][] array_musik) {

        System.out.print("Judul: ");
        String judul = input.nextLine();
        System.out.print("Artist : ");
        String artist = input.nextLine();
        System.out.print("Album : ");
        String album = input.nextLine();
        System.out.print("Tahun : ");
        String tahun = input.nextLine();
        System.out.println();
        String[] new_item = { judul, artist, album, tahun };
        String[][] new_array = new String[array_musik.length + 1][3];

        System.arraycopy(array_musik, 0, new_array, 0, array_musik.length);

        new_array[new_array.length - 1] = new_item;
        // showList(new_array);

        return new_array;
    }

    public static String[][] opening(String[][] array_musik) {
        System.out.println("Selamat Datang di Pacilfy\n");
        int perintah = 1;

        while (perintah == 1) {

            System.out.print("Silahkan masukkan lagu anda\n");
            array_musik = addMusic(array_musik);

            System.out.println("Lanjut menambahkan lagu?");
            System.out.println("[1] Lanjut");
            System.out.println("[0] Berhenti");

            System.out.print("Perintah : ");

            perintah = Integer.parseInt(input.nextLine());
        }

        System.out.println("Pacilfy siap dimulai");
        System.out.println("\nSELAMAT DATANG DI\n");
        System.out.println(" /$$$$$$$                     /$$ /$$  /$$$$$$\r\n" + //
                "| $$__  $$                   |__/| $$ /$$__  $$\r\n" + //
                "| $$  \\ $$ /$$$$$$   /$$$$$$$ /$$| $$| $$  \\__//$$   /$$\r\n" + //
                "| $$$$$$$/|____  $$ /$$_____/| $$| $$| $$$$   | $$  | $$\r\n" + //
                "| $$____/  /$$$$$$$| $$      | $$| $$| $$_/   | $$  | $$\r\n" + //
                "| $$      /$$__  $$| $$      | $$| $$| $$     | $$  | $$\r\n" + //
                "| $$     |  $$$$$$$|  $$$$$$$| $$| $$| $$     |  $$$$$$$\r\n" + //
                "|__/      \\_______/ \\_______/|__/|__/|__/      \\____  $$\r\n" + //
                "                                               /$$  | $$\r\n" + //
                "                                              |  $$$$$$/\r\n" + //
                "                                               \\______/\r\n" + //
                "");

        return array_musik;
    }

}
