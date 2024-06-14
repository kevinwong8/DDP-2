
public class Obligasi extends Aset {
	// TODO lengkapi visibility modifier atribut dan methods berikut
	private double bunga;
	private int maturitas;
	private boolean jatuhTempo = false;

	Obligasi(String nama, int jumlah, double harga, double bunga, int maturitas) {
		// TODO lengkapi constructor ini
		super(nama, jumlah, harga);
		this.bunga = bunga;
		this.maturitas = maturitas;

	}

	public double getBunga() {
		return this.bunga;
	}

	public int getMaturitas() {
		return this.maturitas;
	}

	public boolean getJatuhTempo() {
		return jatuhTempo;
	}

	public void setmaturitas(int maturitas) {
		this.maturitas = maturitas;
	}

	public void setBunga(double bunga) {
		this.bunga = bunga;
	}

	@Override
	void nextYear() {
		// TODO validasi jatuh tempo
		if (jatuhTempo())
			return;
		super.nextYear();
		Pacilnomo.addToEarnings(this.getJumlah() * this.getHarga() * this.getBunga());
		// TODO tambahkan bunga ke total pendapatan Pacilnomo
	}

	// TODO lengkapi method toString ini
	@Override
	public String toString() {
		return this.getNama() + "\n" + "Tipe: Obligasi\n" + "Harga: " + String.format("%.2f", this.getHarga()) + "\n" +
				"Jumlah: " + this.getJumlah() + "\n" + "Bunga: " + this.getBunga() + "\n" + "Jatuh tempo: "
				+ this.getJatuhTempo() + "\n";
	}

	boolean jatuhTempo() {
		if (tahun > this.maturitas)
			return false;
		return true;
	}

	double bungaObligasi() {
		return this.getJumlah() * this.getHarga() * this.getBunga();
	}
	// TODO buat getter dan setter untuk fields pada class ini
}
