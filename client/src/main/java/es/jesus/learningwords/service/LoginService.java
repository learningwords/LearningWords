package es.jesus.learningwords.service;

/**
 * Created by jesus on 27/08/15.
 */
public class LoginService {

    private static LoginService INSTANCE;

    private LoginService() {
    }


    public static LoginService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginService();
        }
        return INSTANCE;
    }


    public boolean login(String username, String password) {
        return RestClientFactory.authenticate(username, password);
    }


}
