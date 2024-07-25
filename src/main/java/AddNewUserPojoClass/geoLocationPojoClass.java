package AddNewUserPojoClass;

import com.fasterxml.jackson.annotation.JsonProperty;

public class geoLocationPojoClass {
    private String lat;

    @JsonProperty("long")
    private String longitude; // Internally named 'longitude'

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
