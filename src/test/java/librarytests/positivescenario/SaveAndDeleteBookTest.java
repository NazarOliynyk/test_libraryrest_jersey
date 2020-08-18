package librarytests.positivescenario;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import librarytests.testutils.BaseTest;
import model.author.Author;
import model.book.Book;
import model.genre.Genre;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import java.util.List;

import static logger.AllureLogger.*;

public class SaveAndDeleteBookTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify creating and deleting of a Book")
    @Step("Verify creating and deleting of a Book")
    public void testSaveAndDeleteBook() {

        List<Book> books = getAllBooks();
        int incrementedBookId = books.get(books.size() - 1).getBookId() + 1;
        logToAllureDebug("Getting the List of books with size: " + books.size());

        List<Author> authors = getAllAuthors();
        int realAuthorId = authors.get(authors.size() - 1).getAuthorId();
        logToAllureDebug("Getting the List of authors with size: " + authors.size());

        List<Genre> genres = getAllGenres();
        int realGenreId = genres.get(genres.size() - 1).getGenreId();
        logToAllureDebug("Getting the List of genres with size: " + genres.size());

        Book book = entityGenerator.generateRandomBook(incrementedBookId);
        logToAllureInfo("Creating an Book with id: " + incrementedBookId);

        Response responseOnPost = bookService.saveBook(book, realAuthorId, realGenreId, token);
        logToAllureDebug(responseOnPost.toString());
        Assert.assertEquals(responseOnPost.getStatus(), 201, "Wrong status code");
        Book bookOnSave = responseOnPost.readEntity(Book.class);
        Assert.assertEquals(bookOnSave, book, "Book on save response is not equal to expected");
        logToAllureInfo("Saving a Book with id: " + incrementedBookId);

        Response responseOnDelete = bookService.deleteBook(incrementedBookId, token);
        Assert.assertEquals(responseOnDelete.getStatus(), 204, "Wrong status code");
        logToAllureInfo("Deleting a Book with id: " + incrementedBookId);
    }

}
