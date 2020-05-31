package com.gmail.alexander.realestatestore.models.concrete;

import com.gmail.alexander.realestatestore.models.abstracts.Property;
import com.gmail.alexander.realestatestore.models.costumers.Buyer;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Entity
public class ViewedRealEstate {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="property_id")
    private Property propertyForView =  new Property();
    @ManyToOne
    @JoinColumn(name="buyer_id")
    private Buyer buyers= new Buyer();
    @Column(name="date_of_view")
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date realEstateViewingDate = new Date();

    public ViewedRealEstate(int id, Property propertyForView, Buyer buyers, Date realEstateViewingDate) {
        this.id = id;
        this.propertyForView = propertyForView;
        this.buyers = buyers;
        this.realEstateViewingDate = realEstateViewingDate;
    }

    public ViewedRealEstate() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Property getPropertyForView() {
        return propertyForView;
    }

    public void setPropertyForView(Property propertyForView) {
        this.propertyForView = propertyForView;
    }

    public Buyer getBuyer() {
        return buyers;
    }

    public void setBuyers(Buyer buyers) {
        this.buyers = buyers;
    }

    public Date getRealEstateViewingDate() {
        return realEstateViewingDate;
    }

    public void setRealEstateViewingDate(Date date) {
        realEstateViewingDate.setTime(date.getTime());
    }
}
