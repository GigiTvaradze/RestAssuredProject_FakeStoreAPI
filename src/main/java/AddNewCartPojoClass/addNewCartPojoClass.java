package AddNewCartPojoClass;

import java.util.List;

public class addNewCartPojoClass {

    private String userId;
    private String date;
    private List<productsPojoClass> products;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<productsPojoClass> getProducts() {
        return products;
    }

    public void setProducts(List<productsPojoClass> products) {
        this.products = products;
    }
}
