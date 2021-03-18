package com.demo.aircompany.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AirCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private AirCompanyType type;

    @Column(nullable = false)
    private LocalDate foundedAt;

    public AirCompany() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirCompany that = (AirCompany) o;
        return id.equals(that.id) && name.equals(that.name) && type == that.type && foundedAt.equals(that.foundedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, foundedAt);
    }

    @Override
    public String toString() {
        return "AirCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", foundedAt=" + foundedAt +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirCompanyType getType() {
        return type;
    }

    public void setType(AirCompanyType type) {
        this.type = type;
    }

    public LocalDate getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(LocalDate foundedAt) {
        this.foundedAt = foundedAt;
    }


}
