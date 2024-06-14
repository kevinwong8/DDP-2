
public class Saham extends Aset {
	// TODO lengkapi visibility modifier atribut dan methods berikut
	private double dividen;
	private double pertumbuhan;

	public Saham(String nama, int jumlah, double harga, double pertumbuhan, double dividen) {
		super(nama, jumlah, harga);
		this.pertumbuhan = pertumbuhan;
		this.dividen = dividen;
	}

	@Override
	public void nextYear() {
		super.nextYear();
		grow();

		this.setHarga(this.getHarga() * (1 + this.getPertumbuhan()));
		Pacilnomo.addToEarnings(this.getHarga() * this.getDividen() * this.getJumlah());
		// TODO modifikasi harga sesuai dengan pertumbuhan sekarang dan tambahkan
		// dividen ke earnings
	}

	// Linear congruential generator for subsequent growth
	private void grow() {
		int a = 0x4b;
		int c = 0x4a;
		int m = 2;
		pertumbuhan = ((a * pertumbuhan + c) % m) - 1;
		pertumbuhan = pertumbuhan < 0 ? pertumbuhan % -m : pertumbuhan;
	}

	// TODO lengkapi method toString ini
	@Override
	public String toString() {
		return this.getNama() + "\n" + "Tipe : Saham\n" + "Harga: " + String.format("%.2f", this.getHarga()) + "\n" +
				"Jumlah: " + this.getJumlah() + "\n" + "Dividen: " + this.getDividen() + "\n" + "Pertumbuhan: "
				+ this.getPertumbuhan() + "\n";
	}

	// TODO buat getter dan setter untuk fields pada class ini

	public double getDividen() {
		return this.dividen;
	}

	public double getPertumbuhan() {
		return this.pertumbuhan;
	}
}
