/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import sun.java2d.d3d.D3DRenderQueue;

/**
 *
 * @author sistem
 */
public class CA {

    Mperpus mperpus;
    VAnggota vAnggota;
    String dataTerpilih;

    public CA(Mperpus mperpus, VAnggota vAnggota) {
        this.mperpus = mperpus;
        this.vAnggota = vAnggota;

        if (mperpus.getBykA() != 0) {
            String dataA[][] = mperpus.ReadA();
            vAnggota.table.setModel((new JTable(dataA, vAnggota.kolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vAnggota.simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vAnggota.getNIS().equals("")) {
                    JOptionPane.showMessageDialog(null, "NIS tidak boleh kosong");
                } else {
                    String nis = vAnggota.getNIS();
                    String nama = vAnggota.getNama();
                    String ttl = vAnggota.getTtl();
                    String jk = vAnggota.getJk();
                    String agama = vAnggota.getAgama();
                    String kelas = vAnggota.getKelas();
                    String daftar = vAnggota.getDaftar();
                    String berlaku = vAnggota.getLaku();
                    mperpus.InsertA(nis, nama, ttl, jk, agama, kelas, daftar, berlaku);

                    String dataA[][] = mperpus.ReadA();
                    vAnggota.table.setModel(new JTable(dataA, vAnggota.kolom).getModel());
                }
            }
        });

        vAnggota.keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Beranda();
                vAnggota.dispose();

            }

        });

        vAnggota.refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vAnggota.tnis.setText("");
                vAnggota.tnama.setText("");
                vAnggota.tfttl.setText("");
                vAnggota.ma.addItem("--Pilihan--");
                vAnggota.tkelas.setText("");
                vAnggota.tdaftar.setText("");
                vAnggota.tlaku.setText("");

                String dataA[][] = mperpus.ReadA();
                vAnggota.table.setModel(new JTable(dataA, vAnggota.kolom).getModel());

            }
        });

        vAnggota.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = vAnggota.table.getSelectedRow();
                int kolom = vAnggota.table.getSelectedColumn();
                dataTerpilih = vAnggota.table.getValueAt(baris, 0).toString();

            }
        });
        
        vAnggota.hapus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nis = dataTerpilih;
                        mperpus.DeleteA(nis);

                        String dataA[][] = mperpus.ReadA();
                        vAnggota.table.setModel(new JTable(dataA, vAnggota.kolom).getModel());
                    }
                }
                );

    }

}
