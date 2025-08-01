package api.tests;

import api.apilisteners.APiTestListener;
import api.flow.PostUserDetails;
import api.models.PostRequest;
import api.models.PostResponse;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static api.Constants.*;
import static org.testng.Assert.assertEquals;

@Listeners(APiTestListener.class)
public class PostUserDetailsTest {


    private static final Logger logger = LogManager.getLogger(PostUserDetailsTest.class);

    @Test(testName = "Post User Details Test" ,groups = {"API"})
    public void postUserDetails(){
        logger.info("Running Post User Details Test");
        PostRequest userRequest = new PostRequest("pravin","sdet",1);
        PostUserDetails postUserDetails = new PostUserDetails();
        Response response = postUserDetails.postUser(userRequest,POSTS_PATH);
        logger.info(response.prettyPrint());
        PostResponse postResponse = response.as(PostResponse.class);
        assertEquals(response.getStatusCode(), 201);
        assertEquals(postResponse.getTitle(), "pravin");
        assertEquals(postResponse.getBody(), "sdet");
        assertEquals(postResponse.getUserId(), 1);
    }

}
