/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Laporan;

import java.io.IOException;

/**
 *
 * @author raja
 */
public interface ExportBuilder {
    void setDataSource(String dataSource);
    void setDestination(String destination);
    void convert() throws IOException;
}
