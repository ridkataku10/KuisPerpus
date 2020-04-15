/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author sistem
 */
public class CK {

    Mperpus mperpus;
    VKaryawan vKaryawan;
    String dataTerpilih;
    

    public CK(Mperpus mperpus, VKaryawan vKaryawan) {
        this.mperpus = mperpus;
        this.vKaryawan = vKaryawan;

        if (mperpus.getBykK() != 0) {
            String dataK[][] = mperpus.ReadK();
            vKaryawan.table.setModel((new JTable(dataK, vKaryawan.kolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vKaryawan.simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vKaryawan.getNIK().equals("")) {
                    JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong");
                } else {
                    String nik = vKaryawan.getNIK();
                    String namak = vKaryawan.getNama();
                    String jk = vKaryawan.getJk();
                    String golongan = vKaryawan.getGol();
                    String jabatan = vKaryawan.getJab();
                    String tunjangan = vKaryawan.getTun();
                    String gaji = vKaryawan.getGaji();

                    mperpus.InsertK(nik, namak, jk, golongan, jabatan, tunjangan, gaji);

                    String dataK[][] = mperpus.ReadK();
                    vKaryawan.table.setModel(new JTable(dataK, vKaryawan.kolom).getModel());
                }
            }
        });

        vKaryawan.keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Beranda();
                vKaryawan.dispose();
            }

        });

        vKaryawan.refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vKaryawan.tnik.setText("");
                vKaryawan.tnama.setText("");
                vKaryawan.tgol.setText("");
                vKaryawan.tjab.setText("");
                vKaryawan.ttunjang.setText("");
                vKaryawan.tgaji.setText("");

                String dataK[][] = mperpus.ReadK();
                vKaryawan.table.setModel(new JTable(dataK, vKaryawan.kolom).getModel());

            }
        });

        vKaryawan.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = vKaryawan.table.getSelectedRow();
                int kolom = vKaryawan.table.getSelectedColumn();
                dataTerpilih = vKaryawan.table.getValueAt(baris, 0).toString();

            }
        });
        
        vKaryawan.hapus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nik = dataTerpilih;
                        mperpus.DeleteK(nik);

                        String dataK[][] = mperpus.ReadK();
                        vKaryawan.table.setModel(new JTable(dataK, vKaryawan.kolom).getModel());
                    }
                }
                );

        vKaryawan.cari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jd = vKaryawan.tnama.getText();

                mperpus.SearchK(jd);

                String dataK[][] = mperpus.SearchK(jd);
                vKaryawan.table.setModel(new JTable(dataK, vKaryawan.kolom).getModel());
            }
        });

        vKaryawan.tgol.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String jb = null;
                    int tj = 0;
                    int gj = 0;
                    if ("1".equals(vKaryawan.getGol())) {
                        jb = "Manager";
                        tj = 8000000;
                        gj = 10000000;
//                        vKaryawan.tjab.setText("Manager");
//                        vKaryawan.ttunjang.setText("8000000");
//                        vKaryawan.tgaji.setText("10000000");
                    } else if ("3".equals(vKaryawan.getGol())) {
                        jb = "Staff TU";
                        tj = 2500000;
                        gj = 5300000;
//                        vKaryawan.tjab.setText("Staff TU");
//                        vKaryawan.ttunjang.setText("2500000");
//                        vKaryawan.tgaji.setText("5300000");
                    } else if ("2".equals(vKaryawan.getGol())) {
                        jb = "Pustakawan Penyelia";
                        tj = 4000000;
                        gj = 6700000;
//                        vKaryawan.tjab.setText("Pustakawan Penyelia");
//                        vKaryawan.ttunjang.setText("4000000");
//                        vKaryawan.tgaji.setText("6700000");
                    } else if ("4".equals(vKaryawan.getGol())) {
                        jb = "Tenaga Kependidikan";
                        tj = 1000000;
                        gj = 3500000;
//                        vKaryawan.tjab.setText("Tenaga Kependidikan");
//                        vKaryawan.ttunjang.setText("1000000");
//                        vKaryawan.tgaji.setText("3500000");
                    } else if ("5".equals(vKaryawan.getGol())) {
                        jb = "OB";
                        tj = 500000;
                        gj = 1800000;
//                        vKaryawan.tjab.setText("O B");
//                        vKaryawan.ttunjang.setText("500000");
//                        vKaryawan.tgaji.setText("1800000");
                    }
                    int totalgj = tj+gj;
                    vKaryawan.tjab.setText(jb);
                    vKaryawan.ttunjang.setText(Integer.toString(tj));
                    vKaryawan.tgaji.setText(Integer.toString(totalgj));
                }
            }
        });

    }

}
