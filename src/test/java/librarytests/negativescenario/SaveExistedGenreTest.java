package librarytests.negativescenario;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import librarytests.testutils.BaseTest;
import model.fault.Fault;
import model.genre.Genre;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.List;

import static logger.AllureLogger.*;

public class SaveExistedGenreTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify saving a Genre with existed genreId")
    @Step("Verify saving a Genre with existed genreId")
    public void testSaveGenreWithExistedId() {

        List<Genre> genres = getAllGenres();
        int realGenreId = genres.get(genres.size() - 1).getGenreId();
        logToAllureDebug("Getting the List of genres with size: " + genres.size());

        Genre genre = entityGenerator.generateRandomGenre(realGenreId);
        logToAllureInfo("Creating an Genre with existed genreId: " + realGenreId);

        Response responseOnPost = genreService.saveGenre(genre, token);
        logToAllureDebug(responseOnPost.toString());
        Fault fault = responseOnPost.readEntity(Fault.class);
        Assert.assertEquals(fault.getStatusCode(), 409, "Wrong status code");
        Assert.assertEquals(fault.getErrorMessage(), "Genre with such 'genreId' already exists!");
        logToAllureWarn("Falling to save a Genre with id: " + realGenreId);
    }
}
