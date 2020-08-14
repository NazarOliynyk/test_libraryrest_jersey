package librarytests.positivescenario;

import librarytests.testutils.BaseTest;
import model.book.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.Comparator;
import java.util.List;

import static client.CustomClientBuilder.logger;

public class VerifyIfBooksAreSortedTest extends BaseTest {

    @Test(description = "Verify if books are sorted by by the bookName")
    public void verifySortingOfBooks() {

        Response responseGetAll = bookService.getAllBooksSortedDescending(token);
        Assert.assertEquals(responseGetAll.getStatus(), 200, "Wrong status code");
        List<Book> books = responseGetAll.readEntity(new GenericType<List<Book>>() {
        });
        logger.debug("Getting the List of books with size: " + books.size());

        Comparator<Book> bookComparator = Comparator.comparing(Book::getBookName).reversed();
        boolean isSorted = bookService.isSorted(books, bookComparator);
        Assert.assertTrue(isSorted, "List of books is not sorted");
        logger.info("Verified if list is sorted");
    }

}
