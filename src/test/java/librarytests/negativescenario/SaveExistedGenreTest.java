package librarytests.negativescenario;

import librarytests.testutils.BaseTest;
import model.genre.Genre;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.List;

import static client.CustomClientBuilder.logger;

public class SaveExistedGenreTest extends BaseTest {

    @Test(description = "Verify saving a Genre with existed genreId")
    public void testSaveGenreWithExistedId() {

        List<Genre> genres = getAllGenres();
        int realGenreId = genres.get(genres.size() - 1).getGenreId();
        logger.debug("Getting the List of genres with size: " + genres.size());

        Genre genre = entityGenerator.generateRandomGenre(realGenreId);
        logger.info("Creating an Genre with existed genreId: " + realGenreId);

        Response responseOnPost = genreService.saveGenre(genre, token);
        logger.debug(responseOnPost);
        Assert.assertEquals(responseOnPost.getStatus(), 409, "Wrong status code");
        logger.warn("Falling to save a Genre with id: " + realGenreId);
    }
}
