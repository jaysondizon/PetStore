package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import files.payLoad;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
public class stepDefinition {
	
	
	Properties prop= new Properties();
	@Given("^I have succesfully logged in my account$")
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Training4.9\\Eclipse4.9_workspace\\PetStore\\src\\test\\java\\files\\env.properties");
		prop.load(fis);	
	}
	public void i_have_succesfully_logged_in_my_account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI=prop.getProperty("HOST");
		given().
		queryParam("key",prop.getProperty("KEY")).
		queryParam("username",prop.getProperty("user")).
		queryParam("password",prop.getProperty("pass")).
		when().
		get(resources.userlogin()).
		then().assertThat().statusCode(200);	
	   
	}
	
	@When("^User view his pet inventory$")
	public void user_view_his_pet_inventory() throws Throwable {
		i_have_succesfully_logged_in_my_account();
		given().get(resources.inventory());
		
	    
	}	
	
	@Then("^Inventory of pets by status successfully shown$")
	public void inventory_of_pets_by_status_successfully_shown() throws Throwable {
		user_view_his_pet_inventory();
		given().then().statusCode(200);
		
	}

	@Given("^The details of the order$")
	public void the_details_of_the_order() throws Throwable {
		RestAssured.baseURI=prop.getProperty("HOST");
		given().
		param("key",prop.getProperty("KEY")).
		body(payLoad.placeorder());
		
	}

	@When("^The order has been placed$")
	public void the_order_has_been_placed() throws Throwable {
		the_details_of_the_order();
		given().post(resources.placeorder());

	}

	@Then("^Order succesfully created with the provided details$")
	public void order_succesfully_created_with_the_provided_details() throws Throwable {
		the_order_has_been_placed();
		given().then().statusCode(200);
	}

	@Given("^The invalid details of the order$")
	public void the_invalid_details_of_the_order() throws Throwable {
		RestAssured.baseURI=prop.getProperty("HOST");
		given().
		param("key",prop.getProperty("KEY")).
		body(payLoad.placeorder());
	}

	@When("^Submit the order details$")
	public void submit_the_order_details() throws Throwable {
		the_invalid_details_of_the_order();
		given().post(resources.placeorder());
	}

	@Then("^Order is not created$")
	public void order_is_not_created() throws Throwable {
		submit_the_order_details();
		given().then().statusCode(400);
	}

	@Given("^The reference number of an existing order$")
	public void the_reference_number_of_an_existing_order() throws Throwable {
		RestAssured.baseURI=prop.getProperty("HOST");
		given().
		param("key",prop.getProperty("KEY")).
		param("orderId",prop.getProperty("orderid"));
	}

	@When("^User search for the order$")
	public void user_search_for_the_order() throws Throwable {
		the_reference_number_of_an_existing_order();
		given().get(resources.queryorder());
	}

	@Then("^Details of the order shown successfully$")
	public void details_of_the_order_shown_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		user_search_for_the_order();
		given().then().statusCode(200);
	}

	@Given("^The reference number of existing order$")
	public void the_reference_number_of_existing_order() throws Throwable {
		RestAssured.baseURI=prop.getProperty("HOST");
		given().
		param("key",prop.getProperty("KEY")).
		param("orderId",prop.getProperty("orderid"));
	}

	@When("^User deletes the order$")
	public void user_deletes_the_order() throws Throwable {
		the_reference_number_of_existing_order();
		given().delete(resources.deleteorder());
	}

	@Then("^Order successfully deleted$")
	public void order_successfully_deleted() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		user_deletes_the_order();
		given().then().statusCode(400);
	}

	
	
	
}
