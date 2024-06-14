
public class Aset {
	// TODO lengkapi visibility modifier atribut dan methods berikut
	protected String nama;
	protected int jumlah;
	protected double harga;
	protected static int tahun = 0;

	Aset(String nama, int jumlah, double harga) {
		this.nama = nama;
		this.jumlah = jumlah;
		this.harga = harga;
	}

	// Increment tahun
	void nextYear() {
		tahun++;
	}

	public String getNama() {
		return this.nama;
	}

	public int getJumlah() {
		return this.jumlah;
	}

	public double getHarga() {
		return this.harga;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public void setHarga(double harga) {
		this.harga = harga;
	}

	// TODO buat getter dan setter untuk fields pada class ini
}
