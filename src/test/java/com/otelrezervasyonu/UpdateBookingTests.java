package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

public class UpdateBookingTests extends BaseTest{

    @Test
    public void updateBookingTest(){
        //bir token oluşturmak
        //cookie olarak header da gönderilmeli

        //rezeryasyon oluştur

        //request yap
        Response response=given()
                .contentType(ContentType.JSON)
                .header("Cookie","token"+createToken())
                .body(bookingObject("Ayşe","Test",500,false))
                .put("https://restful-booker.herokuapp.com/booking/"+createBookingId());//testin booikng id si basetest deki methoddan geliyor

        response.prettyPrint();

        //Assertion test yaz

        String firstName=response.jsonPath().getJsonObject("firstname");
        String lastName=response.jsonPath().getJsonObject("lastname");
        int totalPrice=response.jsonPath().getJsonObject("totalprice");
        boolean depositPaid=response.jsonPath().getJsonObject("depositpaid");

        Assertions.assertEquals("Ayşe",firstName);
        Assertions.assertEquals("Test",lastName);
        Assertions.assertEquals(500,totalPrice);
        Assertions.assertEquals(false,depositPaid);




    }


}
