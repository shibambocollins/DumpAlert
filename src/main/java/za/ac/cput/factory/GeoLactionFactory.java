package za.ac.cput.factory;

import za.ac.cput.domain.GeoLocation;

public class GeoLactionFactory {

    public static GeoLocation createGeoLocation(double latitude, double longitude) {

        return new GeoLocation.Builder()
                .setLatitude(latitude)
                .setLongitude(longitude)
                .build();
    }
}

