package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "employee")
public class Employee {
    @Column(name = "first_name")
    private String firstName;
    @Column(name ="last_name" )
    private String lastName;
    @Column(name="gender")
    private String gender;
    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String gender, int age, City city, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.id = id;
    }

    public Employee(String firstName, String lastName, String gender, int age,  City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public String getFirst_name() {
        return firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }


    public City getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return age == employee.age && city == employee.city && id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(gender, employee.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, age, city, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", id=" + id +
                '}';
    }
}
