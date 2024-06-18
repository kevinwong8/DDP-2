
abstract class Mobil {

    private String nama;
    private int persenFuel;
    private String bahanBakar;
    private EngineBehaviour engineBehaviour;
    private boolean isOn;
    private String jenis;

    protected Mobil(String nama, String bahanBakar, EngineBehaviour engineBehaviour, String jenis) {
        this.nama = nama;
        this.persenFuel = 100;
        this.bahanBakar = bahanBakar;
        this.engineBehaviour = engineBehaviour;
        this.isOn = false;
        this.jenis = jenis;
    }

    public String start() {
        this.isOn = true;
        return engineBehaviour.start(this);
    }

    public String gas() {
        if (!this.isOn) {
            return "Nyalakan mobil dulu!";
        } else if (this.persenFuel == 0) {
            return "Bensin habis!";
        } else {
            // TODO: lengkapin behaviour
            this.persenFuel = this.engineBehaviour.gas(persenFuel);
            String tempat = "laut";
            if (this.getJenis().equals("Terbang")) {
                tempat = "langit";
            } else if (this.getJenis().equals("Truk")) {
                tempat = "Jalan raya";
            }
            return String.format("%s  digas dengan cepat di %s! Bahan bakar mobil %s sekarang %d%%.", this.nama,
                    tempat, this.bahanBakar,
                    this.persenFuel);
        }
    }

    public String stop() {
        this.isOn = false;
        return engineBehaviour.stop(this);
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPersenFuel() {
        return this.persenFuel;
    }

    public void setPersenFuel(int persenFuel) {
        this.persenFuel = persenFuel;
    }

    public String getBahanBakar() {
        return this.bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    public EngineBehaviour getEngineBehaviour() {
        return this.engineBehaviour;
    }

    public void setEngineBehaviour(EngineBehaviour engineBehaviour) {
        this.engineBehaviour = engineBehaviour;
    }

    public boolean getIsOn() {
        return this.isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public String getJenis() {
        return this.jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public abstract String isiBahanBakar();

    public abstract String[] simulasi();
}
