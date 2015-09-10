package es.jesus.learningwords.service;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by jesus on 27/08/15.
 */
public class RestClientFactory {


    private static ClientConfig clientConfig;

    static {
        clientConfig = new ClientConfig()
                .register(JacksonFeature.class);
    }

    public static class RestClient {
        private WebTarget webTarget;

        public RestClient(WebTarget webTarget) {
            this.webTarget = webTarget;
        }

        public Response put(RestRequest request) {
            return webTarget.path(request.path)
                    .request(request.mediaType)
                    .post(Entity.json(request.parameter));
        }

//        public <T> T get(RestRequest request) {
//            return (T) webTarget.path(request.path)
//                    .request(request.mediaType)
//                    .get(request.responseType);
//        }

    }

    public static class RestRequest<T> {
        public String path;
        public T parameter;
        public MediaType mediaType;
        //public Class<T> responseType;
    }

    public static RestClient create() {
        return new RestClient(
                ClientBuilder.newClient(clientConfig).target("http://localhost:8080")
        );
    }

    public static boolean authenticate(String username, String password) {
        Client client = ClientBuilder.newClient(clientConfig);
        client.register(HttpAuthenticationFeature.basic(username, password));

        try {
            String result = client.target("http://localhost:8080")
                    .path("login")
                    .request(MediaType.WILDCARD_TYPE)
                    .get(String.class);
            if ("ok".equals(result)) {
                clientConfig.register(HttpAuthenticationFeature.basic(username, password));
                return Boolean.TRUE;
            }
        } catch (NotAuthorizedException nae) {
            return Boolean.FALSE;
        }
        return false;
    }
}
