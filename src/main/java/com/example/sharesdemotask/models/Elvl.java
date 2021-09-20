package com.example.sharesdemotask.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "elvl")
// Energy Level
public class Elvl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // International Securities Identification Number (ISIN)  12-digit alphanumeric code
    @Column(name = "isin")
    private String isin;

    @Column(name = "price")
    private Double bestPrice;

//    @OneToMany(mappedBy = "isin")
//    @JsonIgnore
//    private List<Quote> quotes;

    public Elvl() {
    }

    public Elvl(String isin) {
        this.isin = isin;
    }

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    public Integer getId() {
        return id;
    }

    public String getIsin() {
        return isin;
    }

    public Double getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(Double bestPrice) {
        this.bestPrice = bestPrice;
    }
}
