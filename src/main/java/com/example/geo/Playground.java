package com.example.geo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.util.Objects;

@Entity
public class Playground {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Point<G2D> coordinates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point<G2D> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point<G2D> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playground that = (Playground) o;
        return Objects.equals(id, that.id) && Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Playground.class.hashCode();
    }
}
