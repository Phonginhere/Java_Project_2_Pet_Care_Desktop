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
public class Pet {
    String name_pet, category_pet, ID, age_pet, id_khachhang;

    public Pet(String name_pet, String category_pet, String age_pet) {
       this.name_pet = name_pet;
        this.category_pet = category_pet;
        this.age_pet = age_pet;
    }
    
    public Pet(String name_pet, String category_pet, String age_pet, String id_khachhang) {
        this.name_pet = name_pet;
        this.category_pet = category_pet;
        this.age_pet = age_pet;
        this.id_khachhang = id_khachhang;
    }
    
   

    
    
 public String ID() {
        return ID;
    }

    public void ID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return name_pet;
    }

    public void setName(String name) {
        this.name_pet = name;
    }

    public String getCategory() {
        return category_pet;
    }

    public String getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(String id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public void setCategory(String category) {
        this.category_pet = category;
    }

    public String getAge() {
        return age_pet;
    }

    public void setAge(String age) {
        this.age_pet = age;
    }
    
}
