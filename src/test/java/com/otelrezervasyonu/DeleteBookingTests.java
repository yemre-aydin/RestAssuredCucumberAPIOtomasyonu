package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteBookingTests extends BaseTest{

    public void deleteBookingTest(){
        //token oluşturma
        //rezervasyon oluşturma
        //delete çağrısı yapma
        //assertion test yazma

        Response response=given()
                .contentType(ContentType.JSON)
                .header("Cookie","token="+createToken())
                .when()
                .delete("https://restful-booker.herokuapp.com/booking/"+createBookingId());

        response.prettyPrint();

        response
                .then()
                .statusCode(201);//sonuç:201 olmalı
    }
}
