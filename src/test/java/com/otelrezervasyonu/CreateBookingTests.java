package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTests extends BaseTest{

    @Test
    public void createBookingTest(){
        //Body oluşturma
/*
        JSONObject body=new JSONObject();//body içinde istenilen alanlar tanımlanabilir
        body.put("firstname","Yunus Emre");
        body.put("lastname","Aydın");
        body.put("totalprice",200);
        body.put("depositpaid",true);

        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2023-02-01");
        bookingDates.put("checkout","2023-02-04");
        body.put("bookingdates",bookingDates);
        body.put("additionalneeds","Sigara içilen oda");
*/
        //çağrı gerçekleştirilir
      /*  Response response=given()
                .when()
                .contentType(ContentType.JSON)
                .body(bookingObject())//json tipini string e çevirmek
                .post("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();

        response
                .then()
                .statusCode(200);
*/
        Response response=createBooking();//createbooking i çağırarak yapabiliriz

        Assertions.assertEquals("Yunus Emre",response.jsonPath().getJsonObject("booking.firstname"));
        Assertions.assertEquals("Aydın",response.jsonPath().getJsonObject("booking.lastname"));
        Assertions.assertEquals(200,(Integer) response.jsonPath().getJsonObject("booking.totalprice"));
        Assertions.assertEquals(true,response.jsonPath().getJsonObject("booking.depositpaid"));




    }
}
