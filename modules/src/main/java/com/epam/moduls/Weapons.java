package com.epam.moduls;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "weapons")
public class Weapons {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double caliber;
    @JoinColumn(name = "country_of_origin")
    private String countryOfOrigin;
    @JoinColumn(name = "bullet_box")
    private String bulletBox;
    private int cost;
    @JoinColumn(name = "year_of_production")
    private int yearOfProduction;
    @Enumerated(value = EnumType.STRING)
    private Type type;

    public Weapons() {
    }

    public Weapons(int id, String name, double caliber, String countryOfOrigin, String bulletBox, int cost, int yearOfProduction, Type type) {
        this.id = id;
        this.name = name;
        this.caliber = caliber;
        this.countryOfOrigin = countryOfOrigin;
        this.bulletBox = bulletBox;
        this.cost = cost;
        this.yearOfProduction = yearOfProduction;
        this.type = type;
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

    public double getCaliber() {
        return caliber;
    }

    public void setCaliber(double caliber) {
        this.caliber = caliber;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getBulletBox() {
        return bulletBox;
    }

    public void setBulletBox(String bulletBox) {
        this.bulletBox = bulletBox;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapons guns = (Weapons) o;
        return id == guns.id && name == guns.name && Double.compare(guns.caliber, caliber) == 0 && cost == guns.cost && Objects.equals(countryOfOrigin, guns.countryOfOrigin) && Objects.equals(bulletBox, guns.bulletBox) && Objects.equals(yearOfProduction, guns.yearOfProduction) && type == guns.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, caliber, countryOfOrigin, bulletBox, cost, yearOfProduction, type);
    }

    @Override
    public String toString() {
        return "Guns{" +
                "id=" + id +
                ", name=" + name +
                ", caliber=" + caliber +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", bulletBox='" + bulletBox + '\'' +
                ", cost=" + cost +
                ", yearOfProduction='" + yearOfProduction + '\'' +
                ", type=" + type +
                '}';
    }
}
