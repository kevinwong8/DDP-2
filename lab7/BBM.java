
public class BBM implements EngineBehaviour {
    public String start(Mobil mobil) {
        return mobil.getNama() + " menyalakan mesin, NGENG! ";
    }

    public int gas(int persenFuel) {
        return persenFuel - 25;
    }

    public String stop(Mobil mobil) {
        return mobil.getNama() + " mesin mati, mobil istirahat dulu.";
    }
}
