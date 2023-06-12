package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

public class UpdateBookingTests extends BaseTest{

    @Test
    public void updateBookingTest(){
        //bir token oluşturmak
        //cookie olarak header da gönderilmeli

        String token=createToken();

        //rezeryasyon oluştur
        Response createBookingObject=createBooking();
        int bookingId=createBookingObject.jsonPath().getJsonObject("bookingId");
        //request yap
        Response response=given()
                .contentType(ContentType.JSON)
                .header("Cookie","token"+token)
                .body(bookingObject())
                .put("https://restful-booker.herokuapp.com/booking/"+bookingId);

        response.prettyPrint();

        //Assertion test yaz



    }

    public String createToken(){
        JSONObject body=new JSONObject();
        body.put("username","admin");
        body.put("password","password123");

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(body.toString())
                .log().all()
                .post("https://restful-booker.herokuapp.com/auth");

        response.prettyPrint();
        return response.jsonPath().getJsonObject("token");

    }
}
