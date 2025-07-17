package Mapping_Relationship.OneToOne;

import jakarta.persistence.*;

@Entity
public class A {

    @Id
    private int aid;
    private String aname;
    private String tech;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "A{" +
                "laptop=" + laptop +
                ", tech='" + tech + '\'' +
                ", aname='" + aname + '\'' +
                ", aid=" + aid +
                '}';
    }
}

