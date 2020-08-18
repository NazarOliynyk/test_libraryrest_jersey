package librarytests.testutils;

import io.qameta.allure.Step;
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

import static logger.AllureLogger.*;

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
            logToAllureError(e.getMessage());
            System.exit(0);
        }
        authorService = new AuthorService();
        bookService = new BookService();
        genreService = new GenreService();
        entityGenerator = new EntityGenerator();
        logToAllureInfo("BeforeMethod: Initialize Services");
    }

    @AfterClass
    public void cleanUp() {
        authorService = null;
        bookService = null;
        genreService = null;
        logToAllureInfo("AfterMethod: Nullify services");
    }

    @Step("Get List of authors from the Server")
    protected List<Author> getAllAuthors() {
        Response responseGetAllAuthors = authorService.getAllAuthors(token);
        logToAllureDebug(responseGetAllAuthors.toString());
        Assert.assertEquals(responseGetAllAuthors.getStatus(), 200, "Wrong status code");
        return responseGetAllAuthors.readEntity(new GenericType<List<Author>>() {
        });
    }

    @Step("Get List of books from the Server")
    protected List<Book> getAllBooks(){
        Response responseGetAllBooks = bookService.getAllBooks(token);
        logToAllureDebug(responseGetAllBooks.toString());
        Assert.assertEquals(responseGetAllBooks.getStatus(), 200, "Wrong status code");
        return responseGetAllBooks.readEntity(new GenericType<List<Book>>() {
        });
    }

    @Step("Get List of genres from the Server")
    protected List<Genre> getAllGenres(){
        Response responseGetAllGenres = genreService.getAllGenres(token);
        logToAllureDebug(responseGetAllGenres.toString());
        Assert.assertEquals(responseGetAllGenres.getStatus(), 200, "Wrong status code");
        return responseGetAllGenres.readEntity(new GenericType<List<Genre>>() {
        });
    }
}
