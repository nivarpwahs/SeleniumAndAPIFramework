package api.base;

import common.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    private RequestSpecification requestSpecification;

    protected BaseService(){
        this.requestSpecification = RestAssured.given()
                .baseUri(ConfigReader.get("api.base.url"))
                        .contentType(ContentType.JSON);
    }

    public Response postRequest(Object payload, String endpoint){
        return requestSpecification.basePath(endpoint).body(payload).post();
    }

    public Response getRequest(String endpoint){
        return requestSpecification.basePath(endpoint).get();
    }
}
