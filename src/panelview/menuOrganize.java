/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panelview;

import applicationview.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raja
 */
public class menuOrganize extends javax.swing.JPanel {

    /**
     * Creates new form menuDashBoard
     */
    public menuOrganize() {
        initComponents();
        populateScheduleTable();
    }
 
     private void populateScheduleTable() {
        DefaultTableModel model = (DefaultTableModel) tabelJadwal.getModel();
        model.setRowCount(0);
        
        LocalDate startDate = LocalDate.of(2024, 7, 1); // Starting from July 1, 2024
        LocalDate endDate = LocalDate.of(2025, 9, 30);
        LocalDate currentDate = LocalDate.now();

        LocalDate currentMonday = startDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));

         while (!currentMonday.isAfter(endDate)) {
            if (!currentMonday.isBefore(currentDate)) { // Only add dates that are not in the past
                String[] rowData = {
                    "Sabtu",
                    currentMonday.toString(),
                    "12:30",
                    "Halte Bidara Cina"
                };
                model.addRow(rowData);
            }

            currentMonday = currentMonday.plusWeeks(1);
        }
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelJadwal = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 768));
        setLayout(new java.awt.CardLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setPreferredSize(new java.awt.Dimension(1172, 610));

        tabelJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hari", "Tanggal", "Jam Keberangkatan", "Titik Kumpul"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelJadwal);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-schedule-30.png"))); // NOI18N
        jLabel2.setText("Jadwal Pengajaran");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Home > Jadwal");

        javax.swing.GroupLayout panel_mainLayout = new javax.swing.GroupLayout(panel_main);
        panel_main.setLayout(panel_mainLayout);
        panel_mainLayout.setHorizontalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panel_mainLayout.setVerticalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_mainLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        add(panel_main, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_main;
    private javax.swing.JTable tabelJadwal;
    // End of variables declaration//GEN-END:variables
}