package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "employee")
public class Employee {
    @Column(name = "first_name")
    private String first_name;
    @Column(name ="last_name" )
    private String last_name;
    @Column(name="gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @Column(name= "city_id")
    private int city;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public Employee(){

    }

    public Employee(String first_name, String last_name, String gender, int age, int city, int id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.id = id;
    }

    public Employee(String first_name, String last_name, String gender, int age,  int city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }


    public int getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return age == employee.age && city == employee.city && id == employee.id && Objects.equals(first_name, employee.first_name) && Objects.equals(last_name, employee.last_name) && Objects.equals(gender, employee.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, gender, age, city, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", id=" + id +
                '}';
    }
}
