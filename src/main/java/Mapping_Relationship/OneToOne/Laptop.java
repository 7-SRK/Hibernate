package Mapping_Relationship.OneToOne;

import jakarta.persistence.*;


@Entity
public class Laptop {

    @Id
    private int lid;
    private int ram;
    private String brand;
    private String model;

    @OneToOne(mappedBy = "laptop")
    private A a;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", ram=" + ram +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", a=" + a +
                '}';
    }
}
