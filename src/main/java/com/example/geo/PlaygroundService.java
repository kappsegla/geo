package com.example.geo;

import org.geolatte.geom.*;
import org.geolatte.geom.codec.Wkt;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.geolatte.geom.builder.DSL.*;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;


@Service
public class PlaygroundService {

    PlaygroundRepository playgroundRepository;

    public PlaygroundService(PlaygroundRepository playgroundRepository) {
        this.playgroundRepository = playgroundRepository;
    }

    List<Playground> getAll() {
        return playgroundRepository.findAll();
    }

    public Playground createNew(Location location) {
        var playground = new Playground();

        String text = "POINT (" + location.lat() + " " + location.lon() + ")";
        var geo = Wkt.fromWkt(text, WGS84);
        playground.setCoordinates((Point<G2D>) geo);

//        var geo = Geometries.mkPoint(new G2D(location.lat(), location.lon()), CoordinateReferenceSystems.WGS84);
//        playground.setCoordinates(geo);

        return playgroundRepository.save(playground);
    }

    public List<Playground> getInside() {
        var area = polygon(WGS84, ring(
                g(-10.0, -10.0),
                g(10.0, -10.0),
                g(10.0, 10.0),
                g(-10.0, 10.0),
                g(-10.0, -10.0)
        ));
        return playgroundRepository.filterOnCircle(area);
    }
}
