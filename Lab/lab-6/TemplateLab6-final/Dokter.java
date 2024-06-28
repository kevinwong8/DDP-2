public class Dokter extends Warga {
	// TODO: Ubah modifier atribut pada class Dokter agar code menjadi lebih aman
	private int jumlahPasienDitemui;
	private String penyakitKeahlian;
	private boolean dokterRamah;

	// TODO: Lengkapi constructor
	Dokter() {

	}

	Dokter(String nama, String penyakitKeahlian, boolean dokterRamah) {
		super(nama);

		this.penyakitKeahlian = penyakitKeahlian;
		this.dokterRamah = dokterRamah;
	}

	// TODO: Lengkapi method berinteraksi untuk dokter
	@Override
	public void berinteraksi(Warga X) {
		if (X instanceof Pasien) {
			this.jumlahPasienDitemui++;
		}

		this.addLogInteraksi(X);

	}

	// TODO: Lengkapi toString dengan memanggil method toString milik superclass
	@Override
	public String toString() {
		return super.toString();
	}

	public int getJumlahPasienDitemui() {
		return this.jumlahPasienDitemui;
	}

	public String getPenyakitKeahlian() {
		return this.penyakitKeahlian;
	}

	public boolean getDokterRamah() {
		return this.dokterRamah;
	}

}
