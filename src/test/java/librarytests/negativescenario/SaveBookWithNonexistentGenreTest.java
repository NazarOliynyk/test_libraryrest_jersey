package librarytests.negativescenario;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import librarytests.testutils.BaseTest;
import model.author.Author;
import model.book.Book;
import model.fault.Fault;
import model.genre.Genre;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.List;

import static logger.AllureLogger.*;

public class SaveBookWithNonexistentGenreTest extends BaseTest {

    @Test(description = "Verify saving a Book with nonexistent Genre")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify saving a Book with nonexistent Genre")
    @Step("Verify saving a Book with nonexistent Genre")
    public void testSaveBookNonexistentGenre() {

        List<Book> books = getAllBooks();
        int incrementedBookId = books.get(books.size() - 1).getBookId() + 1;
        logToAllureDebug("Getting the List of books with size: " + books.size());

        List<Author> authors = getAllAuthors();
        int realAuthorId = authors.get(authors.size() - 1).getAuthorId();
        logToAllureDebug("Getting the List of authors with size: " + authors.size());

        List<Genre> genres = getAllGenres();
        int nonexistentGenreId = genres.get(genres.size() - 1).getGenreId() +1 ;
        logToAllureDebug("Getting the List of genres with size: " + genres.size());

        Book book = entityGenerator.generateRandomBook(incrementedBookId);
        logToAllureInfo("Creating an Book with id: " + incrementedBookId);

        Response responseOnPost = bookService.saveBook(book, realAuthorId, nonexistentGenreId, token);
        logToAllureDebug(responseOnPost.toString());
        Fault fault = responseOnPost.readEntity(Fault.class);
        Assert.assertEquals(fault.getStatusCode(), 404, "Wrong status code");
        Assert.assertEquals(fault.getErrorMessage(),
                "Genre with 'genreId' = '"+nonexistentGenreId+"' doesn't exist!", "Wrong error message");
        logToAllureWarn("Saving a Book with id: " +
                incrementedBookId + " failed because of nonexistent Genre with id: "+ nonexistentGenreId);
    }
}
