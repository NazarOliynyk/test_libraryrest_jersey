package service;

import client.CustomClientBuilder;
import com.google.common.collect.Ordering;
import model.book.Book;
import org.apache.http.client.utils.URIBuilder;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Comparator;
import java.util.List;

import static client.CustomClientBuilder.logger;
import static utils.Constants.*;

public class BookService extends BaseService{

    public BookService() {
        customClientBuilder = new CustomClientBuilder();
        uriBuilder= new URIBuilder();
    }

    public Response getAllBooks(String token){
        String params =
                uriBuilder.setParameter(PARAMETER_SIZE, INITIAL_SIZE_OF_COLLECTION).toString();
        uri = URI.create(BASE_URI + GET_ALL_BOOKS + params);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response = invocationBuilder.get();
        logger.warn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

    public Response getAllBooksWithoutAuth(){
        uri = URI.create(BASE_URI + GET_ALL_BOOKS);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri);
        Response response = invocationBuilder.get();
        logger.warn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

    public Response getAllBooksSortedDescending(String token){
        String params = uriBuilder.
                setParameter(PARAMETER_SIZE, INITIAL_SIZE_OF_COLLECTION).
                setParameter(PARAMETER_ORDER, DESCENDING_ORDER).
                setParameter(PARAMETER_SORT, BOOK_SORTING_PARAMETER).
                toString();
        uri = URI.create(BASE_URI + GET_ALL_BOOKS + params);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response = invocationBuilder.get();
        logger.warn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

    public Response saveBook(Book book, int authorId, int genreId, String token){
        uri = URI.create(BASE_URI + String.format(POST_BOOK, authorId, genreId));
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response =
                invocationBuilder.post(Entity.entity(book, MediaType.APPLICATION_JSON));
        logger.warn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

    public Response getBook(int bookId, String token){
        uri = URI.create(BASE_URI + String.format(GET_BOOK, bookId));
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response = invocationBuilder.get();
        logger.warn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

    public Response deleteBook(int bookId, String token){
        uri = URI.create(BASE_URI+String.format(DELETE_BOOK, bookId));
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response = invocationBuilder.delete();
        logger.warn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

    public boolean isSorted(List<Book> books, Comparator<Book> bookComparator) {
        return Ordering.from(bookComparator).isOrdered(books);
    }

}
