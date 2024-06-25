package applicationmodel;

import applicationmodel.*;
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
public class TabelModelKaksuh extends AbstractTableModel{
    
    private List<KakakAsuhModel> lstMhs;

    public TabelModelKaksuh(List<KakakAsuhModel> lstMhs)
    {
        this.lstMhs = lstMhs;
    }
    @Override
    public int getRowCount() {
        return this.lstMhs.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "No Absen";
            case 1:
                return "Nama Adik Asuh";
            case 2:
                return "Hasil Progress dalam Angka";
            case 3:
                return "Hasil Progress dalam Huruf";
            case 4:
                return "Predikat";
            case 5:
                return "Status";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KakakAsuhModel model = lstMhs.get(rowIndex);
        switch (columnIndex){
            case 0:
                return lstMhs.get(rowIndex).getNoAbsen();
            case 1:
                return lstMhs.get(rowIndex).getNama();
            case 2:
                return lstMhs.get(rowIndex).getHasilAngka();
            case 3:
                return lstMhs.get(rowIndex).getHasilHuruf();
            case 4:
                return lstMhs.get(rowIndex).getPredikat();
            case 5:
                return lstMhs.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
}
