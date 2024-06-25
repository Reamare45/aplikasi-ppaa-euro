package applicationmodel;

/**
 *
 * @author raja
 */
public class Pencatatan {
    private int noabsen;
    private String namaPengajar;
    private String namaAdsuh;
    private String kelasAdsuh;
    private int minggu;
    private String kendala;
    private String hasilProgres;

    public Pencatatan(int noabsen, String namaPengajar, String namaAdsuh, String kelasAdsuh, int minggu, String kendala, String hasilProgres) {
        this.noabsen = noabsen;
        this.namaPengajar = namaPengajar;
        this.namaAdsuh = namaAdsuh;
        this.kelasAdsuh = kelasAdsuh;
        this.minggu = minggu;
        this.kendala = kendala;
        this.hasilProgres = hasilProgres;
    }

    public int getNoabsen() {
        return noabsen;
    }

    public String getNamaPengajar() {
        return namaPengajar;
    }

    public String getNamaAdsuh() {
        return namaAdsuh;
    }

    public String getKelasAdsuh() {
        return kelasAdsuh;
    }

    public int getMinggu() {
        return minggu;
    }

    public String getKendala() {
        return kendala;
    }

    public String getHasilProgres() {
        return hasilProgres;
    }
}
