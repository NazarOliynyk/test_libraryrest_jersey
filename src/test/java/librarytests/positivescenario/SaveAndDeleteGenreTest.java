package librarytests.positivescenario;

import librarytests.testutils.BaseTest;
import model.genre.Genre;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.List;

import static client.CustomClientBuilder.logger;

public class SaveAndDeleteGenreTest extends BaseTest {

    @Test(description = "Verify creating and deleting of a Genre")
    public void testSaveAndDeleteGenre() {

        List<Genre> genres = getAllGenres();
        int incrementedGenreId = genres.get(genres.size() - 1).getGenreId() + 1;
        logger.debug("Getting the List of genres with size: " + genres.size());

        Genre genre = entityGenerator.generateRandomGenre(incrementedGenreId);
        logger.info("Creating an Genre with id: " + incrementedGenreId);

        Response responseOnPost = genreService.saveGenre(genre, token);
        logger.debug(responseOnPost);
        Assert.assertEquals(responseOnPost.getStatus(), 201, "Wrong status code");
        Genre genreOnSave = responseOnPost.readEntity(Genre.class);
        Assert.assertEquals(genreOnSave, genre, "Genre on save response is not equal to expected");
        logger.info("Saving a Genre with id: " + incrementedGenreId);

        Response responseOnDelete = genreService.deleteGenre(incrementedGenreId, token);
        logger.debug(responseOnDelete);
        Assert.assertEquals(responseOnDelete.getStatus(), 204, "Wrong status code");
        logger.info("Deleting a Genre with id: " + incrementedGenreId);
    }
}
