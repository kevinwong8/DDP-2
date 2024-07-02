
public class Minuman extends Pesanan {
    boolean isPakeEs;

    public Minuman() {

    }

    public Minuman(String iName, int iHarga, int iPrioritas, boolean iIsPakeEs) {
        super(iName, iHarga, iPrioritas);
        isPakeEs = iIsPakeEs;
    }

    public String toString() {
        if (this.isPakeEs)
            return this.getNama() + " dingin";
        return this.getNama() + " hangat";
    }

}
