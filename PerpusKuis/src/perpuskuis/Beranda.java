/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sistem
 */
public class Beranda extends JFrame {

    JLabel judul = new JLabel("DATA PERPUSTAKAAN UPN");
    JButton anggota = new JButton(" INPUT DATA ANGGOTA");
    JButton karyawan = new JButton("INPUT DATA KARYAWAN");
    JButton buku = new JButton("INPUT DATA BUKU");
    JButton pinjam = new JButton("INPUT DATA PEMINJAMAN");

    Beranda() {
        setTitle("BERANDA");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(2,1));
        
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(judul);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2,2,20,20));
        p2.add(anggota);
        p2.add(buku);
        p2.add(karyawan);
        p2.add(pinjam);
        
        c.add(p1);
        c.add(p2);
        
        anggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MVCa();
                dispose();
            }
        }); 
        
         karyawan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MVCk();
                dispose();
            }
        }); 
         
          buku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MVCb();
                dispose();
            }
        }); 
          
           pinjam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MVCp();
                dispose();
            }
        }); 
  
    }

}

class OutputBer {

    public static void main(String[] args) {
        new Beranda();
    }

}
