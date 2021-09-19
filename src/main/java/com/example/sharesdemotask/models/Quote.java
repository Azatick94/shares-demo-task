package com.example.sharesdemotask.models;

import com.example.sharesdemotask.utls.SharesCustomValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@SharesCustomValidator
@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // International Securities Identification Number (ISIN)  12-digit alphanumeric code
    // isin 12 символов
    @Size(min=12, max=12)
    @Column(name = "isin")
    private String isin;

    // offer made by an individual or corporation to purchase an asset
    // validation - должен быть меньше ask
    @Column(name = "bid")
    private Double bid;

    // The ask is the price a seller is willing to accept for a security, which is often referred to as the offer price
    @Column(name = "ask")
    private Double ask;

    public Quote() {
    }

    public Quote(String isin, Double bid, Double ask) {
        this.isin = isin;
        this.bid = bid;
        this.ask = ask;
    }

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    public String getIsin() {
        return isin;
    }

    public Double getBid() {
        return bid;
    }

    public Double getAsk() {
        return ask;
    }

    public Integer getId() {
        return id;
    }
}
