import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookingsTests {
    //çağrıyı oluşturma
    //response kontrolleri
    //curl -i https://restful-booker.herokuapp.com/booking

    @Test
    public  void getAllBookingTest(){
        given()
                .when()//burdan sonra url ve method u belirtiyoruz
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .log().all()//response yi console yazdırma
                .statusCode(200);//cevabı kontrol ediyoruz
    }
}
