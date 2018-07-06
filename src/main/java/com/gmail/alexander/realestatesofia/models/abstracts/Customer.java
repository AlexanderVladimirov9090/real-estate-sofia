package com.gmail.alexander.realestatesofia.models.abstracts;

import javax.persistence.*;

/**
 * Created on 05.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This is the abstract class of Customer that is extendet by Buyer and Seller conreate classes.
 */
@Entity
@Table(name="customers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String type;

   public Customer(Long id, String name, String phone, Class type) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.type = type.getSimpleName();
    }

    public String getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type.getSimpleName();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
