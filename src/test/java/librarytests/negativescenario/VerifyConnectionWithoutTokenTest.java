package librarytests.negativescenario;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import librarytests.testutils.BaseTest;
import model.fault.Fault;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import static logger.AllureLogger.*;

public class VerifyConnectionWithoutTokenTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify connection without token")
    @Step("Verify connection without token")
    public void connectWithoutToken() {

        Response responseGetAll = bookService.getAllBooksWithoutAuth();
        logToAllureDebug(responseGetAll.toString());
        Assert.assertEquals(responseGetAll.getStatus(), 403, "Wrong status code");
        Assert.assertEquals(responseGetAll.getStatusInfo().getReasonPhrase(),
                "Forbidden", "Wrong reason! ");
        logToAllureDebug("Connection without token failed");
    }
}
