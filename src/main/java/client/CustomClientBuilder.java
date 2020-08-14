package client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;

public class CustomClientBuilder {

    private Invocation.Builder invocationBuilder = null;
    public static final Logger logger = LogManager.getLogger(CustomClientBuilder.class);

    public CustomClientBuilder() {
    }

    public synchronized Invocation.Builder getInvocationBuilder(URI uri) {

        if (invocationBuilder == null) {
            logger.info("Starting ClientBuilder");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(uri);
            invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        }
        return invocationBuilder;
    }

    public void quit() {
        logger.info("Quitting builder");
        invocationBuilder = null;
    }

}
