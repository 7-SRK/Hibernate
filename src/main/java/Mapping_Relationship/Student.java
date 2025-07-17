package Mapping_Relationship;

import jakarta.persistence.*;

@Entity // Represents a table in a relational database
//@Table(name = "student_table")  //table name
public class Student {

    @Id //Primary key
//  @Column(name = "roll_number")  //column name
    private int rollNo;
    private String name;
    private int age;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
