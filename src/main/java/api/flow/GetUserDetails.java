package api.flow;

import api.base.BaseService;
import io.restassured.response.Response;

public class GetUserDetails extends BaseService {

    public GetUserDetails(){

    }

    public Response getUserDetails(String endpoint){

        return getRequest(endpoint);
    }
}
