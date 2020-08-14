package librarytests.negativescenario;

import librarytests.testutils.BaseTest;
import model.author.Author;
import model.book.Book;
import model.genre.Genre;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static client.CustomClientBuilder.logger;

public class SaveBookWithNonexistentGenreTest extends BaseTest {

    @Test(description = "Verify creating of a Book")
    public void testSaveBookNonexistentGenre() {

        Response responseGetAll = bookService.getAllBooks(token);
        Assert.assertEquals(responseGetAll.getStatus(), 200, "Wrong status code");
        List<Book> books = responseGetAll.readEntity(new GenericType<List<Book>>() {
        });
        int incrementedBookId = books.get(books.size() - 1).getBookId() + 1;
        logger.debug("Getting the List of books with size: " + books.size());

        Response responseGetAllAuthors = authorService.getAllAuthors(token);
        Assert.assertEquals(responseGetAllAuthors.getStatus(), 200, "Wrong status code");
        List<Author> authors = responseGetAllAuthors.readEntity(new GenericType<List<Author>>() {
        });
        int realAuthorId = authors.get(authors.size() - 1).getAuthorId();
        logger.debug("Getting the List of authors with size: " + authors.size());

        Response responseGetAllGenres = genreService.getAllGenres(token);
        Assert.assertEquals(responseGetAllGenres.getStatus(), 200, "Wrong status code");
        List<Genre> genres = responseGetAllGenres.readEntity(new GenericType<List<Genre>>() {
        });
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
