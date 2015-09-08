package es.jesus.learningwords.service;

import es.jesus.learningwords.shared.vo.WordVO;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by jesus on 27/08/15.
 */
public class RestService {


    private ClientConfig clientConfig;

    private RestService() {
        clientConfig = new ClientConfig()
                .register(JacksonFeature.class);


    }

    private static RestService INSTANCE;

    public static RestService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RestService();
        }
        return INSTANCE;
    }

    public boolean login(String username, String password) {
        Client client = ClientBuilder.newClient(clientConfig);
        client.register(HttpAuthenticationFeature.basic(username, password));


        String result = null;
        try {
            result = client.target("http://localhost:8080")
                    .path("login")
                    .request(MediaType.WILDCARD_TYPE)
                    .get(String.class);
        } catch (NotAuthorizedException nae) {
            client = null;
            return false;
        }
        return "ok".equals(result);
    }

    public boolean save(String username, String password, WordVO word) {
        Client client = ClientBuilder.newClient(clientConfig);
        client.register(HttpAuthenticationFeature.basic(username, password));

        Response result = client.target("http://localhost:8080")
                .path("save")
                .request(MediaType.WILDCARD_TYPE)
                .post(Entity.json(word));
    // TODO use result
        return true;
    }
}
