package librarytests.positivescenario;

import librarytests.testutils.BaseTest;
import model.author.Author;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.List;

import static client.CustomClientBuilder.logger;

public class UpdateAuthorTest extends BaseTest {

    @Test(description = "Verify updating of an Author")
    public void testUpdateAuthor() {

        List<Author> authors = getAllAuthors();
        int incrementedAuthorId = authors.get(authors.size() - 1).getAuthorId() + 1;
        logger.debug("Getting the List of authors with size: " + authors.size());

        Author author = entityGenerator.generateRandomAuthor(incrementedAuthorId);
        logger.info("Creating an Author with id: " + incrementedAuthorId);

        Response responseOnPost = authorService.saveAuthor(author, token);
        logger.debug(responseOnPost);
        Assert.assertEquals(responseOnPost.getStatus(), 201, "Wrong status code");
        Author authorToBeUpdated = responseOnPost.readEntity(Author.class);
        Assert.assertEquals(authorToBeUpdated, author, "Author on save response is not equal to expected");
        logger.info("Saving an Author with id: " + incrementedAuthorId);

        authorToBeUpdated = entityGenerator.updateAuthor(authorToBeUpdated);
        logger.info("Updating certain fields of Author");

        Response responseOnUpdate = authorService.updateAuthor(authorToBeUpdated, token);
        logger.debug(responseOnUpdate);
        Assert.assertEquals(responseOnUpdate.getStatus(), 200, "Wrong status code");
        logger.info("Saving updated Author with id: "+ incrementedAuthorId);

        Response responseOnDelete = authorService.deleteAuthor(incrementedAuthorId, token);
        logger.debug(responseOnDelete);
        Assert.assertEquals(responseOnDelete.getStatus(), 204, "Wrong status code");
        logger.info("Deleting an Author with id: " + incrementedAuthorId);
    }
}
