package librarytests.positivescenario;

import librarytests.testutils.BaseTest;
import model.author.Author;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static client.CustomClientBuilder.logger;

public class SaveAndDeleteAuthorTest extends BaseTest {

    @Test(description = "Verify creating and deleting of an Author")
    public void testSaveAndDeleteAuthor() {

        Response responseGetAll = authorService.getAllAuthors(token);
        Assert.assertEquals(responseGetAll.getStatus(), 200, "Wrong status code");
        List<Author> authors = responseGetAll.readEntity(new GenericType<List<Author>>() {
        });
        int incrementedAuthorId = authors.get(authors.size() - 1).getAuthorId() + 1;
        logger.debug("Getting the List of authors with size: " + authors.size());

        Author author = entityGenerator.generateRandomAuthor(incrementedAuthorId);
        logger.info("Creating an Author with id: " + incrementedAuthorId);

        Response responseOnPost = authorService.saveAuthor(author, token);
        Assert.assertEquals(responseOnPost.getStatus(), 201, "Wrong status code");
        Author authorOnSave = responseOnPost.readEntity(Author.class);
        Assert.assertEquals(authorOnSave, author, "Author on save response is not equal to expected");
        logger.info("Saving an Author with id: " + incrementedAuthorId);

        Response responseOnDelete = authorService.deleteAuthor(incrementedAuthorId, token);
        Assert.assertEquals(responseOnDelete.getStatus(), 204, "Wrong status code");
        logger.info("Deleting an Author with id: " + incrementedAuthorId);
    }
}
