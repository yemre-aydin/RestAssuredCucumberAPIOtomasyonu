package com.otelrezervasyonu;

import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingByIdTests extends BaseTest{

    //https://restful-booker.herokuapp.com/booking/1
    @Test
    public void getBookingById(){

        Response newBooking=createBooking();
        int reservationId=newBooking.jsonPath().getJsonObject("bookingid");


        Response response=given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/203"+reservationId);//buraya kadar olan kısım response kısmı

        response.then()
                .statusCode(200);
        response.prettyPrint();//response çağrısnın detaylarını console yazdırabiliriz

        String firstname=response.jsonPath().getJsonObject("firstname");//jsonpath ile objeye ulaşmak
        String lastname=response.jsonPath().getJsonObject("lastname");


       Assertions.assertEquals("John",firstname);
       Assertions.assertEquals("Smith",lastname);
    }
}
