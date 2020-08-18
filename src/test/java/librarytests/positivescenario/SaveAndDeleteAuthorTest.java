package librarytests.positivescenario;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import librarytests.testutils.BaseTest;
import model.author.Author;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.List;

import static logger.AllureLogger.*;

public class SaveAndDeleteAuthorTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify creating and deleting of an Author")
    @Step("Verify creating and deleting of an Author")
    public void testSaveAndDeleteAuthor() {

        List<Author> authors = getAllAuthors();
        int incrementedAuthorId = authors.get(authors.size() - 1).getAuthorId() + 1;
        logToAllureDebug("Getting the List of authors with size: " + authors.size());

        Author author = entityGenerator.generateRandomAuthor(incrementedAuthorId);
        logToAllureInfo("Creating an Author with id: " + incrementedAuthorId);

        Response responseOnPost = authorService.saveAuthor(author, token);
        logToAllureDebug(responseOnPost.toString());
        Assert.assertEquals(responseOnPost.getStatus(), 201, "Wrong status code");
        Author authorOnSave = responseOnPost.readEntity(Author.class);
        Assert.assertEquals(authorOnSave, author, "Author on save response is not equal to expected");
        logToAllureInfo("Saving an Author with id: " + incrementedAuthorId);

        Response responseOnDelete = authorService.deleteAuthor(incrementedAuthorId, token);
        logToAllureDebug(responseOnDelete.toString());
        Assert.assertEquals(responseOnDelete.getStatus(), 204, "Wrong status code");
        logToAllureInfo("Deleting an Author with id: " + incrementedAuthorId);
    }
}
