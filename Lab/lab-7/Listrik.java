
public class Listrik implements EngineBehaviour {
    public String start(Mobil mobil) {
        return mobil.getNama() + " menyalakan listrik, SIAP DIGAS!";
    }

    public int gas(int persenFuel) {
        return persenFuel - 20;
    }

    public String stop(Mobil mobil) {
        return mobil.getNama() + " listrik dimatikan, mobil telah berhenti.";
    }
}
