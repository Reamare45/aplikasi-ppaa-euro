package applicationcontroller;

import DAOMahasiswa.java.DAOProgress;
import applicationmodel.ProgressModel;
import applicationmodel.TabelModelMahasiswa;
import applicationview.FormProgress;
import java.util.List;
import javax.swing.JOptionPane;
import DAOMahasiswa.java.IDAOProgress;

/**
 *
 * @author raja
 */
public class ControllerProgress {
    FormProgress frmProgress;
    IDAOProgress iMahasiswa;
    List<ProgressModel> lstMhs;

    public ControllerProgress(FormProgress frmProgress) {
        this.frmProgress = frmProgress;
        iMahasiswa = new DAOProgress();
    }

    public void isiTable() {
        lstMhs = iMahasiswa.getAll();
        TabelModelMahasiswa tabelMhs = new TabelModelMahasiswa(lstMhs);
        frmProgress.getTabelData().setModel(tabelMhs);
    }

    public void insert() {
    try {
        ProgressModel b = new ProgressModel();
        b.setNoAbsen(Integer.parseInt(frmProgress.getNoAbsenField().getText()));
        b.setNamaAdikAsuh(frmProgress.getNamaAdikAsuhField().getText());
        b.setMinggu(Integer.parseInt(frmProgress.getMingguField().getText()));
        b.setKeterampilan(Integer.parseInt(frmProgress.getKeterampilanField().getText()));
        b.setKeaktifan(Integer.parseInt(frmProgress.getKeaktifanField().getText()));
        b.setNilaiQuiz(Integer.parseInt(frmProgress.getNilaiQuizField().getText()));

        // Peer Field
        String peerFieldText = frmProgress.getPeerField().getText().trim();
        if (!peerFieldText.isEmpty()) {
            b.setPerr(Integer.parseInt(peerFieldText));
        } else {
            // Handle case where peerFieldText is empty or not a valid integer
            b.setPerr(0); // Default value or handle as needed
        }

        // Self Field
        String selfFieldText = frmProgress.getSelfField().getText().trim();
        if (!selfFieldText.isEmpty()) {
            b.setSelf(Integer.parseInt(selfFieldText));
        } else {
            // Handle case where selfFieldText is empty or not a valid integer
            b.setSelf(0); // Default value or handle as needed
        }

        // Holistik Field
        String holistikFieldText = frmProgress.getHolistikField().getText().trim();
        if (!holistikFieldText.isEmpty()) {
            b.setHolistik(Integer.parseInt(holistikFieldText));
        } else {
            // Handle case where holistikFieldText is empty or not a valid integer
            b.setHolistik(0); // Default value or handle as needed
        }

        b.setCatatan(frmProgress.getCatatanField().getText());

        boolean res = iMahasiswa.insert(b);
        if (res) {
            JOptionPane.showMessageDialog(null, "Input berhasil");
            // Reset fields after successful insertion
            reset();
        } else {
            JOptionPane.showMessageDialog(null, "Gagal/Data Duplikat");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Input tidak valid. Pastikan semua input angka telah diisi dengan benar.");
        e.printStackTrace(); 
    }
}


    public void reset() {
        if(!frmProgress.getNoAbsenField().isEnabled())
            frmProgress.getNoAbsenField().setEnabled(true);
        frmProgress.getNoAbsenField().setText("");
        frmProgress.getNamaAdikAsuhField().setText("");
        frmProgress.getMingguField().setText("");
        frmProgress.getKeterampilanField().setText("");
        frmProgress.getKeaktifanField().setText("");
        frmProgress.getNilaiQuizField().setText("");
        frmProgress.getPeerField().setText("");
        frmProgress.getSelfField().setText("");
        frmProgress.getHolistikField().setText("");
        frmProgress.getCatatanField().setText("");
    }

    public void isiField(int row) {
        frmProgress.getNoAbsenField().setEnabled(false);
        frmProgress.getNoAbsenField().setText(String.valueOf(lstMhs.get(row).getNoAbsen()));
        frmProgress.getNamaAdikAsuhField().setText(lstMhs.get(row).getNamaAdikAsuh());
        frmProgress.getMingguField().setText(String.valueOf(lstMhs.get(row).getMinggu()));
        frmProgress.getKeterampilanField().setText(String.valueOf(lstMhs.get(row).getKeterampilan()));
        frmProgress.getKeaktifanField().setText(String.valueOf(lstMhs.get(row).getKeaktifan()));
        frmProgress.getNilaiQuizField().setText(String.valueOf(lstMhs.get(row).getNilaiQuiz()));
        frmProgress.getPeerField().setText(String.valueOf(lstMhs.get(row).getPerr()));
        frmProgress.getSelfField().setText(String.valueOf(lstMhs.get(row).getSelf()));
        frmProgress.getHolistikField().setText(String.valueOf(lstMhs.get(row).getHolistik()));
        frmProgress.getCatatanField().setText(lstMhs.get(row).getCatatan());
    }

    public void update() {
        ProgressModel b = new ProgressModel();
        b.setNoAbsen(Integer.parseInt(frmProgress.getNoAbsenField().getText())); 
        b.setNamaAdikAsuh(frmProgress.getNamaAdikAsuhField().getText());
        b.setMinggu(Integer.parseInt(frmProgress.getMingguField().getText()));
        b.setKeterampilan(Integer.parseInt(frmProgress.getKeterampilanField().getText()));
        b.setKeaktifan(Integer.parseInt(frmProgress.getKeaktifanField().getText()));
        b.setNilaiQuiz(Integer.parseInt(frmProgress.getNilaiQuizField().getText()));
        b.setPerr(Integer.parseInt(frmProgress.getPeerField().getText()));
        b.setSelf(Integer.parseInt(frmProgress.getSelfField().getText()));
        b.setHolistik(Integer.parseInt(frmProgress.getHolistikField().getText()));
        b.setCatatan(frmProgress.getCatatanField().getText());

        iMahasiswa.update(b);
        JOptionPane.showMessageDialog(null, "Update berhasil");
    }

    public void delete() {
        iMahasiswa.delete(Integer.parseInt(frmProgress.getNoAbsenField().getText()));
        JOptionPane.showMessageDialog(null, "Delete berhasil");
    }

    public void cari() {
        lstMhs = iMahasiswa.getAllByName(frmProgress.gettxtCariNama().getText());
        TabelModelMahasiswa tabelMhs = new TabelModelMahasiswa(lstMhs);
        frmProgress.getTabelData().setModel(tabelMhs);
    }
}
