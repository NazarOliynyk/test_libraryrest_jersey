package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;

import static logger.AllureLogger.*;

public class CustomClientBuilder {

    private Invocation.Builder invocationBuilder = null;

    public CustomClientBuilder() {
    }

    public synchronized Invocation.Builder getInvocationBuilder(URI uri) {

        if (invocationBuilder == null) {
            logToAllureInfo("Starting ClientBuilder");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(uri);
            invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        }
        return invocationBuilder;
    }

    public void quit() {
        logToAllureInfo("Quitting builder");
        invocationBuilder = null;
    }

}
