package com.epam.moduls;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "bullet_box")
public class BulletBox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int size;
    @JoinColumn(name = "country_of_origin")
    private String countryOfOrigin;
    @JoinColumn(name = "for_weapons")
    private String forWeapons;
    private int cost;

    public BulletBox() {
    }

    public BulletBox(int id, int size, String countryOfOrigin, String forWeapons, int cost) {
        this.id = id;
        this.size = size;
        this.countryOfOrigin = countryOfOrigin;
        this.forWeapons = forWeapons;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getForWeapons() {
        return forWeapons;
    }

    public void setForWeapons(String forWeapons) {
        this.forWeapons = forWeapons;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BulletBox bulletBox = (BulletBox) o;
        return id == bulletBox.id && size == bulletBox.size && cost == bulletBox.cost && Objects.equals(countryOfOrigin, bulletBox.countryOfOrigin) && Objects.equals(forWeapons, bulletBox.forWeapons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, countryOfOrigin, forWeapons, cost);
    }

    @Override
    public String toString() {
        return "BulletBox{" +
                "id=" + id +
                ", size=" + size +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", forWeapons='" + forWeapons + '\'' +
                ", cost=" + cost +
                '}';
    }
}
