package FakeStoreAPI_End2End;

import AddNewUserPojoClass.addNewUserPojoClass;
import AddNewUserPojoClass.addressPojoClass;
import AddNewUserPojoClass.geoLocationPojoClass;
import AddNewUserPojoClass.namePojoClass;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

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


        /**
         * Step 3: Add New Product
         *
         * Adds a new product to the system.
         */


        /**
         * Step 4: Get a Single Product and Assert that Data are Correct
         *
         * Retrieves a single product and asserts that the data is correct.
         */

        /**
         * Step 5: Add a New Cart
         *
         * Adds a new cart to the system for a user.
         */


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
