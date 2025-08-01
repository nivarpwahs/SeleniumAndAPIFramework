package api.flow;

import api.base.BaseService;
import api.models.PostRequest;
import io.restassured.response.Response;

public class PostUserDetails extends BaseService {

    public PostUserDetails(){

    }

    public Response postUser(PostRequest payload, String endpoint){
        return postRequest(payload,endpoint);
    }
}
