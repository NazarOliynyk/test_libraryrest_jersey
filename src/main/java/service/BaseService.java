package service;

import client.CustomClientBuilder;
import org.apache.http.client.utils.URIBuilder;

import javax.ws.rs.client.Invocation;
import java.net.URI;

abstract class BaseService {

    CustomClientBuilder customClientBuilder;
    URI uri;
    Invocation.Builder invocationBuilder;
    URIBuilder uriBuilder;

}
