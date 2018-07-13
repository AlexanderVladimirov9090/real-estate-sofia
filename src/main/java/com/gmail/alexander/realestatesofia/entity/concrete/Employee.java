package com.gmail.alexander.realestatesofia.entity.concrete;

import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.costumers.Buyer;
import com.gmail.alexander.realestatesofia.entity.costumers.Seller;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This classs correspondence to Database table of Employee.
 */
//Same as the above classes.
@Entity
public class Employee {
    //Columns of the table Employee.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency = new Agency();
    //This annotation is used to tell the framework this is not Column of the table.
    @Transient
    //This is the sellers that the employee handles.
    private List<Seller> sellers;
    @Transient
    //This are the buyers that the employee handles.
    private List<Buyer> buyers;
    @Transient
    //This is the Collection of the Property that are visited by the buyers.
    private Map<Property, List<Buyer>> visitedByBuyers;


    public Employee() {

    }

    public Employee(int id, String name, String phone, Agency agency, List<Seller> sellers, List<Buyer> buyers, Map<Property, List<Buyer>> visitedByBuyers) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sellers = sellers;
        this.buyers = buyers;
        this.visitedByBuyers = visitedByBuyers;
        this.agency = agency;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public Map<Property, List<Buyer>> getVisitedByBuyers() {
        return visitedByBuyers;
    }

    public void setVisitedByBuyers(Map<Property, List<Buyer>> visitedByBuyers) {
        this.visitedByBuyers = visitedByBuyers;
    }
}
