package com.mycompany.newbakovetsurgeryv2;


public class Animal {
    String animalID;
    String species;
    String animalName;
    String ownerGivName;
    String ownerSurname;
    String email;
    String phone;
    public Animal(String id, String make, String name, String ownerGivName, String ownerSurname, String email, String phone ) {
        this.animalID = id;
        this.species = make;
        this.animalName = name;
        this.ownerGivName = ownerGivName;
        this.ownerSurname = ownerSurname;
        this.email = email;
        this.phone = phone;
    }    
}
