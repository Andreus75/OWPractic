package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class LocationUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;
    private String country;
    private String region;
    private String city;
    private String userPostAddress;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {/*CascadeType.MERGE, CascadeType.DETACH,CascadeType.PERSIST,*/ CascadeType.REFRESH},
            mappedBy = "location")
    private List<User> user;

    public LocationUser() {
    }

    public LocationUser(String country, String region, String city, String userPostAddress) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.userPostAddress = userPostAddress;
    }

    public LocationUser(String region, String city) {
        this.region = region;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUserPostAddress() {
        return userPostAddress;
    }

    public void setUserPostAddress(String userPostAddress) {
        this.userPostAddress = userPostAddress;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationUser location = (LocationUser) o;
        return locationId == location.locationId &&
                Objects.equals(country, location.country) &&
                Objects.equals(region, location.region) &&
                Objects.equals(city, location.city) &&
                Objects.equals(userPostAddress, location.userPostAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(locationId, country, region, city, userPostAddress);
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", userPostAddress='" + userPostAddress + '\'' +
                '}';
    }
}
