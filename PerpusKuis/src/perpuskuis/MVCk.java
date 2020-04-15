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
public class MVCk {
    Mperpus mperpus = new Mperpus();
    VKaryawan vKaryawan = new VKaryawan();
    CK ck = new CK(mperpus, vKaryawan);
    
}
