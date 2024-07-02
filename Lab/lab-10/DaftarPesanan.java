import java.util.ArrayList;

public class DaftarPesanan<T extends Pesanan> {

    private ArrayList<T> pesanans;

    public DaftarPesanan() {
        this.pesanans = new ArrayList<>();
    }

    public void tambahPesanan(T pesanan) {
        pesanans.add(pesanan);
    }

    public T nextPesanan() {
        T duluan = pesanans.get(0);
        for (int i = 1; i < pesanans.size(); i++) {
            if ((duluan.compareTo((pesanans.get(i))) == 1)) {
                duluan = pesanans.get(i);
            }
        }
        pesanans.remove(duluan);
        return duluan;
    }

    public int size() {
        return pesanans.size();
    }
}