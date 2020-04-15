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
public class MVCb {
    Mperpus mperpus = new Mperpus();
    VBuku vBuku = new VBuku();
    CB cb = new CB(mperpus, vBuku);
    
}
