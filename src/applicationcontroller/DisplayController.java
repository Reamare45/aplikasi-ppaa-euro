package applicationcontroller;

import applicationmodel.ProgressModel;
import DAOMahasiswa.java.DAOProgress;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import panelview.menuKakakAsuh;
import DAOMahasiswa.java.IDAOProgress;

/**
 *
 * @author raja
 */
public class DisplayController {
    menuKakakAsuh view;
    IDAOProgress iMahasiswa;
    
    public DisplayController(menuKakakAsuh view) {
        this.view = view;
        this.iMahasiswa = new DAOProgress();
    }

    public void insert() {
        try {
            String name = view.getTxtName().getText();
            int noAbsen = Integer.parseInt(view.getTxtNoAbsen().getText());

            // Fetch data from the database
            ProgressModel progress = iMahasiswa.getByNameAndNoAbsen(name, noAbsen);

            if (progress != null) {
                view.getTxtKeterampilan().setText(String.valueOf(progress.getKeterampilan()));
                view.getTxtKeaktifan().setText(String.valueOf(progress.getKeaktifan()));
                view.getTxtQuiz().setText(String.valueOf(progress.getNilaiQuiz()));
                view.getTxtPeer().setText(String.valueOf(progress.getPerr()));
                view.getTxtSelf().setText(String.valueOf(progress.getSelf()));
                view.getTxtHolistik().setText(String.valueOf(progress.getHolistik()));
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input tidak valid. Pastikan semua input angka telah diisi dengan benar.");
            e.printStackTrace(); // Handle or log the exception as needed
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }
    
    public void calculateResult() {
        try {
            int keterampilan = Integer.parseInt(view.getTxtKeterampilan().getText());
            int keaktifan = Integer.parseInt(view.getTxtKeaktifan().getText());
            int nilaiQuiz = Integer.parseInt(view.getTxtQuiz().getText());
            int peer = Integer.parseInt(view.getTxtPeer().getText());
            int self = Integer.parseInt(view.getTxtSelf().getText());
            int holistik = Integer.parseInt(view.getTxtHolistik().getText());

            // Get previous progress
            int hasilProgresSebelumnya = Integer.parseInt(view.getTxtHasilProgresSebelumnya().getText());
        
            // Calculate total progress
            int totalProgress = (keterampilan + keaktifan + nilaiQuiz + peer + self + holistik) / 6;

            // Determine letter grade and predicate
            String letterGrade;
            String predicate;

            if (totalProgress >= 90) {
                letterGrade = "A";
                predicate = "Excellent";
            } else if (totalProgress >= 80) {
                letterGrade = "B";
                predicate = "Good";
            } else if (totalProgress >= 70) {
                letterGrade = "C";
                predicate = "Average";
            } else if (totalProgress >= 60) {
                letterGrade = "D";
                predicate = "Below Average";
            } else {
                letterGrade = "E";
                predicate = "Poor";
            }

            // Update the view with the calculated results
            view.getTxtHasilProgressAngka().setText(String.valueOf(totalProgress));
            view.getTxtHasilProgressHuruf().setText(letterGrade);
            view.getTxtPredikat().setText(predicate);
            
            // Determine status
            if (totalProgress > hasilProgresSebelumnya) {
                view.getTxtStatus().setText("Meningkat dari Minggu Kemarin");
            } else {
                view.getTxtStatus().setText("Menurun dari Minggu Kemarin");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error dalam perhitungan. Pastikan semua nilai telah diisi dengan benar.");
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }
    
    
    public void cetakData() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timeStamp = dateFormat.format(new Date());
            String fileName = "data_progress_" + timeStamp + ".txt";
           
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Mengumpulkan data dari view
            String nama = view.getTxtName().getText();
            String noAbsen = view.getTxtNoAbsen().getText();
            String keterampilan = view.getTxtKeterampilan().getText();
            String keaktifan = view.getTxtKeaktifan().getText();
            String quiz = view.getTxtQuiz().getText();
            String peer = view.getTxtPeer().getText();
            String self = view.getTxtSelf().getText();
            String holistik = view.getTxtHolistik().getText();
            String hasilProgresAngka = view.getTxtHasilProgressAngka().getText();
            String hasilProgresHuruf = view.getTxtHasilProgressHuruf().getText();
            String predikat = view.getTxtPredikat().getText();
            String hasilProgresSebelumnya = view.getTxtHasilProgresSebelumnya().getText();
            String status = view.getTxtStatus().getText();

            // Menyimpan data ke file
            printWriter.println("Nama: " + nama);
            printWriter.println("No Absen: " + noAbsen);
            printWriter.println("Keterampilan: " + keterampilan);
            printWriter.println("Keaktifan: " + keaktifan);
            printWriter.println("Quiz: " + quiz);
            printWriter.println("Peer: " + peer);
            printWriter.println("Self: " + self);
            printWriter.println("Holistik: " + holistik);
            printWriter.println("Hasil Progres Angka: " + hasilProgresAngka);
            printWriter.println("Hasil Progres Huruf: " + hasilProgresHuruf);
            printWriter.println("Predikat: " + predikat);
            printWriter.println("Hasil Progres Sebelumnya: " + hasilProgresSebelumnya);
            printWriter.println("Status: " + status);

            printWriter.close();
            bufferedWriter.close();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan di " + fileName);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data ke file.");
            e.printStackTrace();
        }
    }


}
