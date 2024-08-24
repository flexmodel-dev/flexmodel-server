package tech.wetech.flexmodel.api;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import tech.wetech.flexmodel.MySQLTestResource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author cjbi
 */
@QuarkusTest
@QuarkusTestResource(MySQLTestResource.class)
public class RestAPIResourceTest {

  @Test
  void testGET() {
    // list
    given()
      .when()
      .get("/api/v1/system/Classes/list")
      .then()
      .statusCode(200)
      .body("size()", greaterThanOrEqualTo(1))
      .body("data.systemClassesList[0].classCode", notNullValue());
    // view
    given()
      .when()
      .get("/api/v1/system/Classes/1")
      .then()
      .statusCode(200)
      .body("data.systemClasses.classCode", notNullValue());
  }

  @Test
  void testPOST() {
    given()
      .when()
      .contentType(ContentType.JSON)
      .body("""
          {
            "id": 999,
            "classCode": "C_004",
            "className": "三年级2班"
          }
        """)
      .post("/api/v1/system/Classes")
      .then()
      .statusCode(200)
      .body("data", notNullValue());
  }

  @Test
  void testPUT() {
    given()
      .when()
      .contentType(ContentType.JSON)
      .body("""
          {
            "id": 1,
            "classCode": "C_10",
            "className": "五年级3班"
          }
        """)
      .put("/api/v1/system/Classes/1")
      .then()
      .statusCode(200)
      .body("data", notNullValue());
  }

  @Test
  void testDELETE() {
    given()
      .when()
      .delete("/api/v1/system/Classes/1")
      .then()
      .statusCode(200)
      .body("data", notNullValue());
  }

}