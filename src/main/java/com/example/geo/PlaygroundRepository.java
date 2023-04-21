package com.example.geo;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaygroundRepository extends ListCrudRepository<Playground,Long> {

    @Query("""
        select p from Playground p where within(p.coordinates, :geoArea) = true
            """)
    List<Playground> filterOnCircle(@Param("geoArea") Geometry<G2D> geoArea);

}
