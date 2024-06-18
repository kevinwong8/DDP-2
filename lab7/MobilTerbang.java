
import java.util.ArrayList;

public class MobilTerbang extends Mobil {
    public MobilTerbang(String nama, EngineBehaviour engineBehaviour, String bahanbakar) {
        super(nama, bahanbakar, engineBehaviour, "Terbang");
    }

    public String isiBahanBakar() {
        if (this.getIsOn()) {
            return "Mobil masih menyala, matikan terlebih dahulu agar tidak jatuh.";
        }
        this.setPersenFuel(100);
        return String.format("%s sekarang sudah penuh, mobil dapat diterbangkan kembali!", this.getBahanBakar());
    }

    public String[] simulasi() {
        ArrayList<String> out = new ArrayList<String>();
        out.add(start());
        for (int i = 0; i < 2; i++) {
            out.add(gas());
        }
        out.add(stop());
        out.add(isiBahanBakar());

        return out.toArray(new String[out.size()]);
    }
}
