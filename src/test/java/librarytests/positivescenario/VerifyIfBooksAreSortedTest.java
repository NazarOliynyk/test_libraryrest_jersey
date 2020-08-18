package librarytests.positivescenario;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import librarytests.testutils.BaseTest;
import model.book.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.Comparator;
import java.util.List;

import static logger.AllureLogger.*;

public class VerifyIfBooksAreSortedTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify if books are sorted by by the bookName")
    @Step("Verify if books are sorted by by the bookName")
    public void verifySortingOfBooks() {

        Response responseGetAll = bookService.getAllBooksSortedDescending(token);
        logToAllureDebug(responseGetAll.toString());
        Assert.assertEquals(responseGetAll.getStatus(), 200, "Wrong status code");
        List<Book> books = responseGetAll.readEntity(new GenericType<List<Book>>() {
        });
        logToAllureDebug("Getting the List of books with size: " + books.size());

        Comparator<Book> bookComparator = Comparator.comparing(Book::getBookName).reversed();
        Assert.assertTrue(bookService.isSorted(books, bookComparator), "List of books is not sorted properly");
        logToAllureInfo("Verified if list is sorted");
    }

}
