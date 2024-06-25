package applicationmodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raja
 */
public class TabelModelMahasiswa extends AbstractTableModel{
    
    public TabelModelMahasiswa(List<ProgressModel> lstMhs)
    {
        this.lstMhs = lstMhs;
    }
    @Override
    public int getRowCount() {
        return this.lstMhs.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "No Absen";
            case 1:
                return "Nama Adik Asuh";
            case 2:
                return "Minggu";
            case 3:
                return "Keterampilan";
            case 4:
                return "Keaktifan";
            case 5:
                return "Nilai Quiz";
            case 6:
                return "Peer";
            case 7:
                return "Self";
            case 8:
                return "Holistik";
            case 9:
                return "Catatan";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lstMhs.get(rowIndex).getNoAbsen();
            case 1:
                return lstMhs.get(rowIndex).getNamaAdikAsuh();
            case 2:
                return lstMhs.get(rowIndex).getMinggu();
            case 3:
                return lstMhs.get(rowIndex).getKeterampilan();
            case 4:
                return lstMhs.get(rowIndex).getKeaktifan();
            case 5:
                return lstMhs.get(rowIndex).getNilaiQuiz();
            case 6:
                return lstMhs.get(rowIndex).getPerr();
            case 7:
                return lstMhs.get(rowIndex).getSelf();
            case 8:
                return lstMhs.get(rowIndex).getHolistik();
            case 9:
                return lstMhs.get(rowIndex).getCatatan();
            default:
                return null;
        }
    }
   List<ProgressModel> lstMhs;
}
