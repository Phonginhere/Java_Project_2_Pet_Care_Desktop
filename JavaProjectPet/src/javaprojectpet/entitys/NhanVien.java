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
public class NhanVien {
    String fullname_nhanvien, sodienthoai_nhanvien, email_nhanvien, pass_nhanvien, username_nhanvien;

    public NhanVien(String fullname_nhanvien, String sodienthoai_nhanvien, String email_nhanvien, String pass_nhanvien, String username_nhanvien) {
        this.fullname_nhanvien = fullname_nhanvien;
        this.sodienthoai_nhanvien = sodienthoai_nhanvien;
        
        this.email_nhanvien = email_nhanvien;
        this.pass_nhanvien = pass_nhanvien;
        
        this.username_nhanvien = username_nhanvien;
    }
     public NhanVien(String fullname_nhanvien, String sodienthoai_nhanvien, String email_nhanvien, String pass_nhanvien) {
        this.fullname_nhanvien = fullname_nhanvien;
        this.sodienthoai_nhanvien = sodienthoai_nhanvien;
        
        this.email_nhanvien = email_nhanvien;
        this.pass_nhanvien = pass_nhanvien;
        
    }

    public NhanVien(String pass_nhanvien, String username_nhanvien) {
        this.pass_nhanvien = pass_nhanvien;
        this.username_nhanvien = username_nhanvien;
    }
     

    public String getFullname_nhanvien() {
        return fullname_nhanvien;
    }

    public void setFullname_nhanvien(String fullname_nhanvien) {
        this.fullname_nhanvien = fullname_nhanvien;
    }

    public String getSodienthoai_nhanvien() {
        return sodienthoai_nhanvien;
    }

    public void setSodienthoai_nhanvien(String sodienthoai_nhanvien) {
        this.sodienthoai_nhanvien = sodienthoai_nhanvien;
    }

    public String getEmail_nhanvien() {
        return email_nhanvien;
    }

    public void setEmail_nhanvien(String email_nhanvien) {
        this.email_nhanvien = email_nhanvien;
    }

    public String getPass_nhanvien() {
        return pass_nhanvien;
    }

    public void setPass_nhanvien(String pass_nhanvien) {
        this.pass_nhanvien = pass_nhanvien;
    }

    

    public String getUsername_nhanvien() {
        return username_nhanvien;
    }

    public void setUsername_nhanvien(String username_nhanvien) {
        this.username_nhanvien = username_nhanvien;
    }
    
    
}
