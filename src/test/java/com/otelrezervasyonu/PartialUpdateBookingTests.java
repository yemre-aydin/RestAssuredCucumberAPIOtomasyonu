package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PartialUpdateBookingTests extends BaseTest{

    @Test
    public void partialUpdateBookingTest(){

        //çağrıyı oluşturma

        JSONObject body=new JSONObject();
        body.put("firstname","Ahmet");
        Response response=given()
                .contentType(ContentType.JSON)
                .header("Cookie","token="+createToken())//basetest de oluşturulan tokendan bilgi geliyor
                .body(body.toString())
                .when()
                .patch("https://restful-booker.herokuapp.com/booking/"+createBookingId());

        response.prettyPrint();
        //Assertion testleri yazma

        Assertions.assertEquals("Ahmet",response.jsonPath().getJsonObject("firstname"));

    }
}
