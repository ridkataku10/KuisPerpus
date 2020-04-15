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
public class MVCa {
    Mperpus mperpus = new Mperpus();
    VAnggota vAnggota = new VAnggota();
    CA ca = new CA(mperpus, vAnggota);
    
}
