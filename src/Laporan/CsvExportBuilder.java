/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laporan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author raja
 */
public class CsvExportBuilder implements ExportBuilder{
    private String dataSource;
    private String destination;

    @Override
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public void convert() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataSource)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Implementasi konversi ke CSV
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
