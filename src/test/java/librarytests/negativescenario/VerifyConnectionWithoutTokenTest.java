package librarytests.negativescenario;

import librarytests.testutils.BaseTest;
import model.fault.Fault;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import static client.CustomClientBuilder.logger;

public class VerifyConnectionWithoutTokenTest extends BaseTest {

    @Test(description = "Verify connection without token")
    public void connectWithoutToken() {

        Response responseGetAll = bookService.getAllBooksWithoutAuth();
        logger.debug(responseGetAll);
        Assert.assertEquals(responseGetAll.getStatus(), 403, "Wrong status code");
        Assert.assertEquals(responseGetAll.getStatusInfo().getReasonPhrase(),
                "Forbidden", "Wrong reason! ");
        logger.warn("Connection without token failed");
    }
}
