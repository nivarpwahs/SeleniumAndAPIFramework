package api.tests;

import api.Constants;
import api.apilisteners.APiTestListener;
import api.flow.GetUserDetails;
import api.models.GetResponse;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(APiTestListener.class)
public class GetUserAPITest {

    private static final Logger logger = LogManager.getLogger(GetUserAPITest.class);

    @Test(testName = "Get User Details Test" ,groups = {"API"})
    public void getUserDetails(){
        logger.info("Running Get User Details Test");
        GetUserDetails getUserDetails = new GetUserDetails();
        Response response = getUserDetails.getUserDetails(Constants.SINGLE_POST_PATH);
        logger.info(response.prettyPrint());
        GetResponse getResponse = response.as(GetResponse.class);

        assertEquals(response.getStatusCode(), 200);
        assertEquals(getResponse.getId(), 1); // post ID = 1
        assertEquals(getResponse.getUserId(), 1); // user ID = 1
    }
}
