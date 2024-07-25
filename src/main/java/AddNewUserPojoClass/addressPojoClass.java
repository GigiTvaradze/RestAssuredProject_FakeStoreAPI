package AddNewUserPojoClass;

public class addressPojoClass {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public geoLocationPojoClass getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(geoLocationPojoClass geoLocation) {
        this.geoLocation = geoLocation;
    }

    private String street;
    private String number;
    private String zipcode;
    private geoLocationPojoClass geoLocation;
}
