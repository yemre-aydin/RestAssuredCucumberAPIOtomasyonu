package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.awt.geom.RectangularShape;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected Response createBooking(){
        Response response=given()
                .when()
                .contentType(ContentType.JSON)
                .body(bookingObject())//json tipini string e çevirmek
                .post("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();

        response
                .then()
                .statusCode(200);
        return response;

    }

    protected String bookingObject(){
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

        return body.toString();
    }
}
