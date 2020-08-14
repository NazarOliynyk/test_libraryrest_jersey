package librarytests.testutils;

import org.testng.annotations.*;
import service.AuthenticationService;
import service.AuthorService;
import service.BookService;
import service.GenreService;
import utils.AuthException;
import utils.EntityGenerator;

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
}
