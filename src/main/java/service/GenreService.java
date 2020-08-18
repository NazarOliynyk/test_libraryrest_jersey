package service;

import client.CustomClientBuilder;
import model.genre.Genre;
import org.apache.http.client.utils.URIBuilder;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

import static logger.AllureLogger.*;
import static utils.Constants.*;

public class GenreService extends BaseService {

    public GenreService() {
        customClientBuilder = new CustomClientBuilder();
        uriBuilder = new URIBuilder();
    }

    public Response getAllGenres(String token) {
        String params =
                uriBuilder.setParameter(PARAMETER_SIZE, INITIAL_SIZE_OF_COLLECTION).toString();
        uri = URI.create(BASE_URI + GET_ALL_GENRES + params);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response = invocationBuilder.get();
        logToAllureWarn("Trigger uri : " + uri);
        customClientBuilder.quit();
        return response;
    }

    public Response saveGenre(Genre genre, String token) {
        uri = URI.create(BASE_URI + POST_GENRE);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response =
                invocationBuilder.post(Entity.entity(genre, MediaType.APPLICATION_JSON));
        logToAllureWarn("Trigger uri : " + uri);
        customClientBuilder.quit();
        return response;
    }

    public Response getGenre(int genreId, String token) {
        uri = URI.create(BASE_URI + String.format(GET_GENRE, genreId));
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response = invocationBuilder.get();
        logToAllureWarn("Trigger uri : " + uri);
        customClientBuilder.quit();
        return response;
    }

    public Response deleteGenre(int genreId, String token) {
        uri = URI.create(BASE_URI + String.format(DELETE_GENRE, genreId));
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri).header(AUTH_KEY_WORD, token);
        Response response = invocationBuilder.delete();
        logToAllureWarn("Trigger uri : " + uri);
        customClientBuilder.quit();
        return response;
    }

}
