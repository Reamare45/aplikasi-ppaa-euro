package applicationcontroller;

import panelview.MenuAdikAsuh;
import aplikasi.adsuh.server.DAOAdikAsuh;
import aplikasi.adsuh.server.IDAOAdikAsuh;
import applicationmodel.AdikAsuhModel;
import applicationmodel.TabelModelAdsuh;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AdikAsuhController {
    private MenuAdikAsuh menuAdsuh;
    private IDAOAdikAsuh daoAdikAsuh;

    public AdikAsuhController(MenuAdikAsuh menuAdsuh) {
        this.menuAdsuh = menuAdsuh;
        this.daoAdikAsuh = new DAOAdikAsuh();
        isiTable();
    }

    public void isiTable() {
        List<AdikAsuhModel> lstMhs = daoAdikAsuh.getAll();
        TabelModelAdsuh tabelAds = new TabelModelAdsuh(lstMhs);
        menuAdsuh.getTableAdsuh().setModel(tabelAds);
    }

    public void tambah() {
        try {
            AdikAsuhModel b = new AdikAsuhModel();
            b.setNoAbsen(Integer.parseInt(menuAdsuh.getTxtNoAbsen().getText()));
            b.setNama(menuAdsuh.getTxtNama().getText());
            b.setUmur(Integer.parseInt(menuAdsuh.getTxtUmur().getText().trim()));
            String selectedKelas = menuAdsuh.getKelasComboBox().getSelectedItem().toString();
            b.setKelas(selectedKelas);

            boolean res = daoAdikAsuh.insert(b);
            if (res) {
                JOptionPane.showMessageDialog(null, "Input berhasil");
                reset();
                isiTable();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal/Data Duplikat");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input tidak valid. Pastikan semua input angka telah diisi dengan benar.");
            e.printStackTrace();
        }
    }

    public void delete() {
    // Dapatkan nomor absen dari baris yang dipilih di tabel
    int selectedRow = menuAdsuh.getTableAdsuh().getSelectedRow();
    
    // Pastikan baris yang dipilih valid
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus dari tabel.");
        return;
    }
    
    // Ambil nomor absen dari kolom pertama (indeks 0) di baris yang dipilih
    int noAbsen = (int) menuAdsuh.getTableAdsuh().getValueAt(selectedRow, 0);
    
    // Hapus data berdasarkan nomor absen
    daoAdikAsuh.delete(noAbsen);
    
    // Tampilkan pesan berhasil dan update tabel
    JOptionPane.showMessageDialog(null, "Hapus data berhasil");
    isiTable();
}


public void cari() {
    String keyword = menuAdsuh.getTxtCariAdsuh().getText().toLowerCase(); // Ambil teks pencarian dan ubah ke lowercase
    List<AdikAsuhModel> lstMhs = daoAdikAsuh.getAll(); // Ambil semua data AdikAsuh dari DAO
    List<AdikAsuhModel> filteredList = new ArrayList<>();
    
    for (AdikAsuhModel mhs : lstMhs) {
        if (mhs.getNama().toLowerCase().contains(keyword)) {
            filteredList.add(mhs);
        }
    }
    
    // Update tabel dengan hasil pencarian
    TabelModelAdsuh tabelMhs = new TabelModelAdsuh(filteredList);
    menuAdsuh.getTableAdsuh().setModel(tabelMhs);
}


    private void reset() {
        menuAdsuh.getTxtNoAbsen().setText("");
        menuAdsuh.getTxtNama().setText("");
        menuAdsuh.getTxtUmur().setText("");
        menuAdsuh.getKelasComboBox().setSelectedIndex(0);
    }

   
}
