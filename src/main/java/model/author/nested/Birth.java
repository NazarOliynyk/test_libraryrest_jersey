package model.author.nested;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import serializer.CustomDateDeserializer;
import serializer.CustomDateSerializer;

import java.time.LocalDate;
import java.util.Objects;

public class Birth {

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDate date;
    @JsonProperty
    private String country;
    @JsonProperty
    private String city;

    public Birth() {
    }

    public Birth(LocalDate date, String country, String city) {
        this.date = date;
        this.country = country;
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birth birth = (Birth) o;
        return Objects.equals(date, birth.date) &&
                Objects.equals(country, birth.country) &&
                Objects.equals(city, birth.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, country, city);
    }

    @Override
    public String toString() {
        return "Birth{" +
                "date=" + date +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
