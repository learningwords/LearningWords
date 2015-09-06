package es.jesus.learningwords.service;


import es.jesus.learningwords.vo.Word;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by jesus on 23/07/15.
 */
public class WordsService {

    public static void call() {

        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("jesus", "jesus");
        Client client = ClientBuilder.newClient(new ClientConfig()).
                register(feature)
                .register(JacksonFeature.class);

        GenericType<List<Word>> genericType = new GenericType<List<Word>>(){};
        List<Word> entities = client.target("http://localhost:8080")
                .path("greeting")
                .request(MediaType.APPLICATION_JSON)
                .get(genericType);


        entities.forEach(t -> System.out.println(t.getEnglish() + " " + t.getSpanish()));

    }

}
