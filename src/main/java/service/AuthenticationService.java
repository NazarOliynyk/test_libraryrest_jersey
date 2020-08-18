package service;

import client.CustomClientBuilder;
import model.authentication.CustomUserDetails;
import utils.AuthException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

import static logger.AllureLogger.*;
import static utils.Constants.*;

public class AuthenticationService extends BaseService{

    public AuthenticationService() {
        customClientBuilder = new CustomClientBuilder();
    }

    public String authenticate() throws AuthException {
        uri = URI.create(BASE_URI + AUTHENTICATION_URI);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri);
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.setUsername(AUTH_USERNAME);
        userDetails.setPassword(AUTH_PASSWORD);
        Response response =
                invocationBuilder.post(Entity.entity(userDetails, MediaType.APPLICATION_JSON));
        logToAllureWarn("Trigger uri : "+uri);
        customClientBuilder.quit();
        String token;
        if(response.getStatus() == 200){
            token = String.valueOf(response.getHeaders().getFirst(AUTH_KEY_WORD));
        }else {
            throw new AuthException("Authentication failed !!!!");
        }
        logToAllureWarn("Auth token received from the header");
        return token;
    }
}
