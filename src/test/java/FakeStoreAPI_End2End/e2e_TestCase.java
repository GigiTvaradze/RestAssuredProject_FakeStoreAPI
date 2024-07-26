package FakeStoreAPI_End2End;

import AddNewCartPojoClass.addNewCartPojoClass;
import AddNewCartPojoClass.productsPojoClass;
import AddNewProductPojoClass.addNewProductPojoClass;
import AddNewUserPojoClass.addNewUserPojoClass;
import AddNewUserPojoClass.addressPojoClass;
import AddNewUserPojoClass.geoLocationPojoClass;
import AddNewUserPojoClass.namePojoClass;
import io.cucumber.java.an.E;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class e2e_TestCase {
    @Test
    public void userCartProductWorkflow() {
        /**
         * Step 1: Add a New User
         *
         * Adds a new user to the system.
         */

        //Serialization
        addNewUserPojoClass addNewUser = new addNewUserPojoClass();

        addNewUser.setEmail("test@gmail.com");
        addNewUser.setUsername("test");
        addNewUser.setPassword("testPassword");

        namePojoClass name = new namePojoClass();
        name.setFirstname("Test");
        name.setLastname("TesTest");
        addNewUser.setName(name);

        addressPojoClass address = new addressPojoClass();
        address.setCity("Test");
        address.setStreet("Test");
        address.setNumber("3");
        addNewUser.setAddress(address);

        geoLocationPojoClass geoLocation = new geoLocationPojoClass();
        geoLocation.setLat("-41.2312");
        geoLocation.setLongitude("31.123");
        address.setGeoLocation(geoLocation);

        addNewUser.setPhone("123123123");

       String addNewUserRequest =given()
               .contentType("application/json")
               .log()
               .all()
               .body(addNewUser)
               .when()
               .post("https://fakestoreapi.com/users")
               .then()
               .log()
               .all()
               .assertThat()
               .statusCode(200).extract().asString();

        JsonPath js = ReUsableMethods.rawToJson(addNewUserRequest);
        String id = js.getString("id");
        System.out.println(id);

        /**
         * Step 2: Get User Carts and Assert That A New User Has No Cart
         *
         * Retrieves the carts for a user and asserts that a new user has no carts.
         */

        given().pathParam("userId", id)
                .log()
                .all()
                .when()
                .get("https://fakestoreapi.com/carts/user/{userId}")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .body("", hasSize(0));

        /**
         * Step 3: Add New Product
         *
         * Adds a new product to the system.
         */

        HashMap<String,Object> map = new HashMap<>();
        map.put("title", "Test Product");
        map.put("price", "13.22");
        map.put("description", "Test Product By Me");
        map.put("image", "https://i.pravatar.cc");
        map.put("category", "Cars");

        addNewProductPojoClass request = given()
                .contentType("application/json")
                .body(map)
                .when()
                .post("https://fakestoreapi.com/products")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().as(addNewProductPojoClass.class);

        String productId = request.getId();
        String title = request.getTitle();
        String price = request.getPrice();
        String description = request.getDescription();
        String image = request.getImage();
        String category = request.getCategory();

        /**
         * Step 4: Get a Single Product and Assert that Data are Correct
         *
         * Retrieves a single product and asserts that the data is correct.
         */

        Assert.assertEquals(title,"Test Product");
        Assert.assertEquals(price,"13.22");
        Assert.assertEquals(description,"Test Product By Me");
        Assert.assertEquals(image,"https://i.pravatar.cc");
        Assert.assertEquals(category,"Cars");

        /**
         * Step 5: Add a New Cart
         *
         * Adds a new cart to the system for a user.
         */

        addNewCartPojoClass cart = new addNewCartPojoClass();
        cart.setUserId(id);
        cart.setDate("2020-02-03");

        // Create a product object and set its properties
        productsPojoClass products = new productsPojoClass();
        products.setProductId(productId);
        products.setQuantity("24");

        // Create a list and add the product object to it
        List<productsPojoClass> productList = new ArrayList<>();
        productList.add(products);

        // Set the products list in the cart
        cart.setProducts(productList);

        given()
                .contentType("application/json")
                .body(cart)
                .when()
                .log()
                .all()
                .post("https://fakestoreapi.com/carts")
                .then()
                .assertThat()
                .statusCode(200);


        /**
         * Step 6: Update a Cart
         *
         * Updates the details of an existing cart.
         */


        /**
         * Step 7: Get a Single Cart and Assert that Cart is Updated
         *
         * Retrieves a single cart and asserts that the cart has been updated.
         */


        /**
         * Step 8: Delete a Cart
         *
         * Deletes a specified cart from the system.
         */


        /**
         * Step 9: Delete a Product
         *
         * Deletes a specified product from the system.
         */


        /**
         * Step 10: Delete a User
         *
         * Deletes a specified user from the system.
         */


        /**
         * Step 11: Assert that User, Product, and Cart are Deleted
         *
         * Asserts that the user, product, and cart have been successfully deleted from the system.
         */
    }
}
