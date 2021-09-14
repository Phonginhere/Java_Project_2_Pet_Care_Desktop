/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectpet.entitys;

import java.util.Date;

/**
 *
 * @author Phong
 */
public class KhachHang {
    String name_khachhang, phoneNumber, district, email;

    public KhachHang(String name_khachhang, String phoneNumber, String district, String email) {
        this.name_khachhang = name_khachhang;
        this.phoneNumber = phoneNumber;
        this.district = district;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName_khachhang() {
        return name_khachhang;
    }

    public void setName_khachhang(String name_khachhang) {
        this.name_khachhang = name_khachhang;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    
    
}
