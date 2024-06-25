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
public class TabelModelAdsuh extends AbstractTableModel{
    
    public TabelModelAdsuh(List<AdikAsuhModel> lstMhs)
    {
        this.lstMhs = lstMhs;
    }
    @Override
    public int getRowCount() {
        return this.lstMhs.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "No Absen";
            case 1:
                return "Nama Adik Asuh";
            case 2:
                return "Umur";
            case 3:
                return "Kelas";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         AdikAsuhModel model = lstMhs.get(rowIndex);
        switch (columnIndex){
            case 0:
                return lstMhs.get(rowIndex).getNoAbsen();
            case 1:
                return lstMhs.get(rowIndex).getNama();
            case 2:
                return lstMhs.get(rowIndex).getUmur();
            case 3:
                return lstMhs.get(rowIndex).getKelas();
            default:
                return null;
        }
    }
   List<AdikAsuhModel> lstMhs;
}
