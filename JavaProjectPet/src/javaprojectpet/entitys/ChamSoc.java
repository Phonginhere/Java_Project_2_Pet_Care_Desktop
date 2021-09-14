/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectpet.entitys;

/**
 *
 * @author Phong
 */
public class ChamSoc {
    String id_chamsoc, thoigiankethuc_chamsoc, price_cham_soc, cachchua_chamsoc, id_nhanvienchamsoc, id_datlich;

    public ChamSoc(String price_cham_soc, String cachchua_chamsoc, String id_nhanvienchamsoc, String id_datlich) {
        this.price_cham_soc = price_cham_soc;
        this.cachchua_chamsoc = cachchua_chamsoc;
        this.id_nhanvienchamsoc = id_nhanvienchamsoc;
        this.id_datlich = id_datlich;
    }

    
    public String getId_chamsoc() {
        return id_chamsoc;
    }

    public void setId_chamsoc(String id_chamsoc) {
        this.id_chamsoc = id_chamsoc;
    }

    public String getPrice_cham_soc() {
        return price_cham_soc;
    }

    public void setPrice_cham_soc(String price_cham_soc) {
        this.price_cham_soc = price_cham_soc;
    }

    public String getCachchua_chamsoc() {
        return cachchua_chamsoc;
    }

    public void setCachchua_chamsoc(String cachchua_chamsoc) {
        this.cachchua_chamsoc = cachchua_chamsoc;
    }

    public String getId_nhanvienchamsoc() {
        return id_nhanvienchamsoc;
    }

    public void setId_nhanvienchamsoc(String id_nhanvienchamsoc) {
        this.id_nhanvienchamsoc = id_nhanvienchamsoc;
    }

    public String getThoigiankethuc_chamsoc() {
        return thoigiankethuc_chamsoc;
    }

    public void setThoigiankethuc_chamsoc(String thoigiankethuc_chamsoc) {
        this.thoigiankethuc_chamsoc = thoigiankethuc_chamsoc;
    }

    public String getId_datlich() {
        return id_datlich;
    }

    public void setId_datlich(String id_datlich) {
        this.id_datlich = id_datlich;
    }

    
    
}
