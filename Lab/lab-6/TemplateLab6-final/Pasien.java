public class Pasien extends Warga {
	// TODO: Ubah modifier atribut pada class Pasien agar code menjadi lebih aman
	private int happiness;
	private String penyakit;
	private boolean pasienSembuh;

	// TODO: Lengkapi constructor
	Pasien() {

	}

	Pasien(String nama, String penyakit) {
		super(nama);
		this.penyakit = penyakit;
		this.happiness = 0;
	}

	public void cekHappiness(int happinessPlus20) {
		if (happinessPlus20 < 0)
			happiness = 0;
		else if (happinessPlus20 > 100)
			happiness = 100;

	}

	public boolean cekSembuh(Dokter isha) {
		if (this.getPenyakit().equals(isha.getPenyakitKeahlian())) {
			this.pasienSembuh = true;
			return true;
		}
		return false;
	}

	// TODO: Lengkapi method berinteraksi untuk pasien
	@Override
	public void berinteraksi(Warga X) {
		if (X instanceof Dokter) {
			Dokter isha = (Dokter) X;
			if (cekSembuh(isha)) {
				this.setHappiness(this.getHappiness() + 20);
				cekHappiness(happiness);
			}
			if (isha.getDokterRamah()) {
				this.setHappiness(this.getHappiness() + 10);
				cekHappiness(happiness);
			} else {
				this.setHappiness(this.getHappiness() - 5);
				cekHappiness(happiness);
			}
		} else {
			this.setHappiness(this.getHappiness() + 5);
			cekHappiness(happiness);
		}
		this.addLogInteraksi(X);

	}

	// TODO: Lengkapi toString dengan memanggil method toString milik superclass
	@Override
	public String toString() {
		return super.toString();
	}

	public int getHappiness() {
		return this.happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public boolean getStatusSembuh() {
		return this.pasienSembuh;
	}

	public String getPenyakit() {
		return this.penyakit;
	}

}
