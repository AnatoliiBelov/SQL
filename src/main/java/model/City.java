package model;



import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")

    private int cityId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    List<Employee> employeeList;
    @Column(name = "city_name")
    private String cityName;

    public City() {
    }

    public City( String cityName) {

        this.cityName = cityName;
    }


    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return cityId == city.cityId && Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName);
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + cityId +
                ", city_name='" + cityName + '\'' +
                '}';
    }
}
