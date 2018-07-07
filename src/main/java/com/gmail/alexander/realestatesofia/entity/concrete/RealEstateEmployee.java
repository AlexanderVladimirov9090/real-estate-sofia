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
 */
@Entity
public class RealEstateEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phone;
    @ManyToOne
    @JoinColumn(name="agency_id")
    private Agency placeOfWork;
    @Transient
    private List<Seller> sellers;
    @Transient
    private List<Buyer> buyers;
    @Transient
    private Map<Property, List<Buyer>> visitedByBuyers;


    public RealEstateEmployee(Long id, String name, String address, String phone, Agency placeOfWork, List<Seller> sellers, List<Buyer> buyers, Map<Property, List<Buyer>> visitedByBuyers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.placeOfWork = placeOfWork;
        this.sellers = sellers;
        this.buyers = buyers;
        this.visitedByBuyers = visitedByBuyers;
    }

    public RealEstateEmployee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agency getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(Agency placeOfWork) {
        this.placeOfWork = placeOfWork;
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
