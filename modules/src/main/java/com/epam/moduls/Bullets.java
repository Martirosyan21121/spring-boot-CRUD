package com.epam.moduls;

import javax.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "bullets")
public class Bullets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @JoinColumn(name = "country_of_origin")
    private String countryOfOrigin;
    private double caliber;
    @JoinColumn(name = "for_weapons")
    private String forWeapons;
    private int cost;

    public Bullets() {
    }

    public Bullets(int id, String name, String countryOfOrigin, double caliber, String forWeapons, int cost) {
        this.id = id;
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.caliber = caliber;
        this.forWeapons = forWeapons;
        this.cost = cost;
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

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public double getCaliber() {
        return caliber;
    }

    public void setCaliber(double caliber) {
        this.caliber = caliber;
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
        Bullets bullets = (Bullets) o;
        return id == bullets.id && name == bullets.name && Double.compare(bullets.caliber, caliber) == 0 && cost == bullets.cost && Objects.equals(countryOfOrigin, bullets.countryOfOrigin) && Objects.equals(forWeapons, bullets.forWeapons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryOfOrigin, caliber, forWeapons, cost);
    }

    @Override
    public String toString() {
        return "Bullets{" +
                "id=" + id +
                ", name=" + name +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", caliber=" + caliber +
                ", forWeapons='" + forWeapons + '\'' +
                ", cost=" + cost +
                '}';
    }
}
