package Mapping_Relationship.ManyToMany;

import jakarta.persistence.*;

import java.util.List;

//@Embeddable  //Marks a class as embeddable.
@Entity
public class Laptop {

    @Id
    private int lid;
    private String brand;
    private String model;
    private int ram;

    @ManyToMany(mappedBy = "laptops") // points to the field in A that owns the relation.

    private List<A> a;

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

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public List<A> getA() {
        return a;
    }

    public void setA(List<A> a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
