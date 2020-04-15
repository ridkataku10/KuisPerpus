/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

/**
 *
 * @author sistem
 */
public class MVCp {
    Mperpus mperpus = new Mperpus();
    VPeminjaman vPeminjaman = new VPeminjaman();
    CP cp = new CP(mperpus, vPeminjaman);
}
