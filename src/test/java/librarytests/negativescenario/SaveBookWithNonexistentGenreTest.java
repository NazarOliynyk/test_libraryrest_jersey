package librarytests.negativescenario;

import librarytests.testutils.BaseTest;
import model.author.Author;
import model.book.Book;
import model.genre.Genre;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.List;

import static client.CustomClientBuilder.logger;

public class SaveBookWithNonexistentGenreTest extends BaseTest {

    @Test(description = "Verify creating of a Book")
    public void testSaveBookNonexistentGenre() {

        List<Book> books = getAllBooks();
        int incrementedBookId = books.get(books.size() - 1).getBookId() + 1;
        logger.debug("Getting the List of books with size: " + books.size());

        List<Author> authors = getAllAuthors();
        int realAuthorId = authors.get(authors.size() - 1).getAuthorId();
        logger.debug("Getting the List of authors with size: " + authors.size());

        List<Genre> genres = getAllGenres();
        int nonexistentGenreId = genres.get(genres.size() - 1).getGenreId() +1 ;
        logger.debug("Getting the List of genres with size: " + genres.size());

        Book book = entityGenerator.generateRandomBook(incrementedBookId);
        logger.info("Creating an Book with id: " + incrementedBookId);

        Response responseOnPost = bookService.saveBook(book, realAuthorId, nonexistentGenreId, token);
        Assert.assertEquals(responseOnPost.getStatus(), 404, "Wrong status code");
        logger.warn("Saving a Book with id: " +
                incrementedBookId + " failed because of nonexistent Genre with id: "+ nonexistentGenreId);
    }
}
