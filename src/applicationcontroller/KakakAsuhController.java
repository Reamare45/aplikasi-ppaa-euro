package applicationcontroller;

import applicationmodel.TabelModelKaksuh;
import panelview.MenuAdikAsuh;
import aplikasi.adsuh.server.DAOAdikAsuh;
import aplikasi.adsuh.server.IDAOAdikAsuh;
import applicationmodel.AdikAsuhModel;
import applicationmodel.TabelModelAdsuh;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import kakakAsuh.DAOKakakAsuh;
import kakakAsuh.IDAOKakakAsuh;
import applicationmodel.KakakAsuhModel;
import panelview.menuKakakAsuh;

public class KakakAsuhController {
    private menuKakakAsuh menuKaksuh;
    private IDAOKakakAsuh daoKakakAsuh;

    public KakakAsuhController(menuKakakAsuh menuKaksuh) {
        this.menuKaksuh = menuKaksuh;
        this.daoKakakAsuh = new DAOKakakAsuh();
        isiTable();
    }

    public void isiTable() {
        List<KakakAsuhModel> lstMhs = daoKakakAsuh.getAll();
        TabelModelKaksuh tabelKaksuh = new TabelModelKaksuh(lstMhs);
        menuKaksuh.getTableKaksuh().setModel(tabelKaksuh);
    }

    public void tambah() {
        try {
            KakakAsuhModel b = new KakakAsuhModel();
            b.setNoAbsen(Integer.parseInt(menuKaksuh.getTxtNoAbsen().getText()));
            b.setNama(menuKaksuh.getTxtName().getText());
            b.setHasilAngka(Integer.parseInt(menuKaksuh.getTxtHasilProgressAngka().getText()));
            b.setHasilHuruf(menuKaksuh.getHasilHuruf().getText());
            b.setPredikat(menuKaksuh.getTxtPredikat().getText());
            b.setStatus(menuKaksuh.getTxtStatus().getText());

            boolean res = daoKakakAsuh.insert(b);
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
    int selectedRow = menuKaksuh.getTableKaksuh().getSelectedRow();
    
    // Pastikan baris yang dipilih valid
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus dari tabel.");
        return;
    }
    
    // Ambil nomor absen dari kolom pertama (indeks 0) di baris yang dipilih
    int noAbsen = (int) menuKaksuh.getTableKaksuh().getValueAt(selectedRow, 0);
    
    // Hapus data berdasarkan nomor absen
    daoKakakAsuh.delete(noAbsen);
    
    // Tampilkan pesan berhasil dan update tabel
    JOptionPane.showMessageDialog(null, "Hapus Berhasil");
    isiTable();
}


public void cari() {
    String keyword = menuKaksuh.getTxtCariKaksuh().getText().toLowerCase(); // Ambil teks pencarian dan ubah ke lowercase
    List<KakakAsuhModel> lstMhs = daoKakakAsuh.getAll(); // Ambil semua data AdikAsuh dari DAO
    List<KakakAsuhModel> filteredList = new ArrayList<>();
    
    for (KakakAsuhModel mhs : lstMhs) {
        if (mhs.getNama().toLowerCase().contains(keyword)) {
            filteredList.add(mhs);
        }
    }
    
    // Update tabel dengan hasil pencarian
    TabelModelKaksuh tabelMhs = new TabelModelKaksuh(filteredList);
    menuKaksuh.getTableKaksuh().setModel(tabelMhs);
}


    private void reset() {
        menuKaksuh.getTxtNoAbsen().setText("");
        menuKaksuh.getTxtName().setText("");
        menuKaksuh.getTxtHasilProgressAngka().setText("");
        menuKaksuh.getTxtHasilProgressHuruf().setText("");
        menuKaksuh.getTxtPredikat().setText("");
        menuKaksuh.getTxtStatus().setText("");


    }

   
}
