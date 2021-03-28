package com.jnelsonjava.inventorymanager.inventory.part;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;
    String description;
    int qty = 0;

    public Part() {
    }

    public Part(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Part(Part copyPart) {
        this.name = copyPart.name;
        this.description = copyPart.description;
    }
}
