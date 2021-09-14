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
public class DatLich {
    String id, thoi_gian_dat_lich, id_khachhang, id_thucung, trieuchung, type;

    public DatLich(String id_khachhang, String id_thucung, String trieuchung) {
        this.id_khachhang = id_khachhang;
        this.id_thucung = id_thucung;
        this.trieuchung = trieuchung;
    }

    public String getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(String id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public String getId_thucung() {
        return id_thucung;
    }

    public void setId_thucung(String id_thucung) {
        this.id_thucung = id_thucung;
    }

    public String getTrieuchung() {
        return trieuchung;
    }

    public void setTrieuchung(String trieuchung) {
        this.trieuchung = trieuchung;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   

    public String getThoi_gian_dat_lich() {
        return thoi_gian_dat_lich;
    }

    public void setThoi_gian_dat_lich(String thoi_gian_dat_lich) {
        this.thoi_gian_dat_lich = thoi_gian_dat_lich;
    }

   

    
    
}
