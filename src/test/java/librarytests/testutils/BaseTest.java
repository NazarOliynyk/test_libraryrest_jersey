package librarytests.testutils;

import model.author.Author;
import model.book.Book;
import model.genre.Genre;
import org.testng.Assert;
import org.testng.annotations.*;
import service.AuthenticationService;
import service.AuthorService;
import service.BookService;
import service.GenreService;
import utils.AuthException;
import utils.EntityGenerator;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static client.CustomClientBuilder.logger;

@Listeners({TestListener.class})
public abstract class BaseTest {

    protected AuthorService authorService;
    protected BookService bookService;
    protected GenreService genreService;
    protected EntityGenerator entityGenerator;
    protected String token;

    @BeforeClass
    public void reinitialize() {
        try {
            token = new AuthenticationService().authenticate();
        } catch (AuthException e) {
            logger.error(e.getMessage());
            System.exit(0);
        }
        authorService = new AuthorService();
        bookService = new BookService();
        genreService = new GenreService();
        entityGenerator = new EntityGenerator();
        logger.info("BeforeMethod: Initialize Services");
    }

    @AfterClass
    public void cleanUp() {
        authorService = null;
        bookService = null;
        genreService = null;
        logger.info("AfterMethod: Nullify services");
    }

    protected List<Author> getAllAuthors() {
        Response responseGetAllAuthors = authorService.getAllAuthors(token);
        logger.debug(responseGetAllAuthors);
        Assert.assertEquals(responseGetAllAuthors.getStatus(), 200, "Wrong status code");
        return responseGetAllAuthors.readEntity(new GenericType<List<Author>>() {
        });
    }

    protected List<Book> getAllBooks(){
        Response responseGetAllBooks = bookService.getAllBooks(token);
        logger.debug(responseGetAllBooks);
        Assert.assertEquals(responseGetAllBooks.getStatus(), 200, "Wrong status code");
        return responseGetAllBooks.readEntity(new GenericType<List<Book>>() {
        });
    }

    protected List<Genre> getAllGenres(){
        Response responseGetAllGenres = genreService.getAllGenres(token);
        logger.debug(responseGetAllGenres);
        Assert.assertEquals(responseGetAllGenres.getStatus(), 200, "Wrong status code");
        return responseGetAllGenres.readEntity(new GenericType<List<Genre>>() {
        });
    }
}
