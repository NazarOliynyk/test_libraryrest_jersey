package librarytests.positivescenario;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import librarytests.testutils.BaseTest;
import model.genre.Genre;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.List;

import static logger.AllureLogger.*;

public class SaveAndDeleteGenreTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify creating and deleting of a Genre")
    @Step("Verify creating and deleting of a Genre")
    public void testSaveAndDeleteGenre() {

        List<Genre> genres = getAllGenres();
        int incrementedGenreId = genres.get(genres.size() - 1).getGenreId() + 1;
        logToAllureDebug("Getting the List of genres with size: " + genres.size());

        Genre genre = entityGenerator.generateRandomGenre(incrementedGenreId);
        logToAllureInfo("Creating an Genre with id: " + incrementedGenreId);

        Response responseOnPost = genreService.saveGenre(genre, token);
        logToAllureDebug(responseOnPost.toString());
        Assert.assertEquals(responseOnPost.getStatus(), 201, "Wrong status code");
        Genre genreOnSave = responseOnPost.readEntity(Genre.class);
        Assert.assertEquals(genreOnSave, genre, "Genre on save response is not equal to expected");
        logToAllureInfo("Saving a Genre with id: " + incrementedGenreId);

        Response responseOnDelete = genreService.deleteGenre(incrementedGenreId, token);
        logToAllureDebug(responseOnDelete.toString());
        Assert.assertEquals(responseOnDelete.getStatus(), 204, "Wrong status code");
        logToAllureInfo("Deleting a Genre with id: " + incrementedGenreId);
    }
}
