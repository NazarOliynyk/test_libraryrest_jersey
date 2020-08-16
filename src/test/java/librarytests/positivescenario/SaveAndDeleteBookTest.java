package librarytests.positivescenario;

import librarytests.testutils.BaseTest;
import model.author.Author;
import model.book.Book;
import model.genre.Genre;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import java.util.List;

import static client.CustomClientBuilder.logger;

public class SaveAndDeleteBookTest extends BaseTest {

    @Test(description = "Verify creating and deleting of a Book")
    public void testSaveAndDeleteBook() {

        List<Book> books = getAllBooks();
        int incrementedBookId = books.get(books.size() - 1).getBookId() + 1;
        logger.debug("Getting the List of books with size: " + books.size());

        List<Author> authors = getAllAuthors();
        int realAuthorId = authors.get(authors.size() - 1).getAuthorId();
        logger.debug("Getting the List of authors with size: " + authors.size());

        List<Genre> genres = getAllGenres();
        int realGenreId = genres.get(genres.size() - 1).getGenreId();
        logger.debug("Getting the List of genres with size: " + genres.size());

        Book book = entityGenerator.generateRandomBook(incrementedBookId);
        logger.info("Creating an Book with id: " + incrementedBookId);

        Response responseOnPost = bookService.saveBook(book, realAuthorId, realGenreId, token);
        Assert.assertEquals(responseOnPost.getStatus(), 201, "Wrong status code");
        Book bookOnSave = responseOnPost.readEntity(Book.class);
        Assert.assertEquals(bookOnSave, book, "Book on save response is not equal to expected");
        logger.info("Saving a Book with id: " + incrementedBookId);

        Response responseOnDelete = bookService.deleteBook(incrementedBookId, token);
        Assert.assertEquals(responseOnDelete.getStatus(), 204, "Wrong status code");
        logger.info("Deleting a Book with id: " + incrementedBookId);
    }

}
