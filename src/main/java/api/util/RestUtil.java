package api.util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;

import java.util.Map;

import static api.constant.BaseEndPoints.BASE_URL;
import static io.restassured.RestAssured.given;

@UtilityClass
public class RestUtil {
    private static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();
    }

    public static Response postWithParams(String uri, Map<String, String> params) {
        RequestSpecification requestSpecification = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParams(params);
        return requestSpecification.post(uri);
    }

    public static Response postWithFormParams(String uri, Map<String, String> params) {
        RequestSpecification requestSpecification = given(getRequestSpecification())
                .contentType(ContentType.URLENC)
                .accept(ContentType.URLENC)
                .formParams(params);
        return requestSpecification.post(uri);
    }
}