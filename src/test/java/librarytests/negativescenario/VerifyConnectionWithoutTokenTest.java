package librarytests.negativescenario;

import librarytests.testutils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import static client.CustomClientBuilder.logger;

public class VerifyConnectionWithoutTokenTest extends BaseTest {

    @Test(description = "Verify connection without token")
    public void connectWithoutToken() {

        Response responseGetAll = bookService.getAllBooksWithoutAuth();
        Assert.assertEquals(responseGetAll.getStatus(), 403, "Wrong status code");
        logger.warn("Connection without token failed");
    }
}
