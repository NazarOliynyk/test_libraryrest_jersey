package service;

import client.CustomClientBuilder;
import model.author.Author;
import org.apache.http.client.utils.URIBuilder;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

import static utils.Constants.*;
import static logger.AllureLogger.*;

public class AuthorService extends BaseService{

    public AuthorService() {
        customClientBuilder = new CustomClientBuilder();
        uriBuilder= new URIBuilder();
    }

    public Response getAllAuthors(String token){
        String params =
                uriBuilder.setParameter(PARAMETER_SIZE, INITIAL_SIZE_OF_COLLECTION).toString();
        uri = URI.create(BASE_URI + GET_ALL_AUTHORS + params);
        invocationBuilder = customClientBuilder.
                getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response = invocationBuilder.get();
        logToAllureWarn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

    public Response saveAuthor(Author author, String token){
        uri = URI.create(BASE_URI + POST_AUTHOR);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response =
                invocationBuilder.post(Entity.entity(author, MediaType.APPLICATION_JSON));
        logToAllureWarn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

    public Response updateAuthor(Author author, String token){
        uri = URI.create(BASE_URI + PUT_AUTHOR);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response =
                invocationBuilder.put(Entity.entity(author, MediaType.APPLICATION_JSON));
        logToAllureWarn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

    public Response getAuthor(int authorId, String token){
        uri = URI.create(BASE_URI + String.format(GET_AUTHOR, authorId));
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response = invocationBuilder.get();
        logToAllureWarn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

    public Response deleteAuthor(int authorId, String token){
        uri = URI.create(BASE_URI+String.format(DELETE_AUTHOR, authorId));
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response = invocationBuilder.delete();
        logToAllureWarn("Trigger uri : "+uri);
        customClientBuilder.quit();
        return response;
    }

}
