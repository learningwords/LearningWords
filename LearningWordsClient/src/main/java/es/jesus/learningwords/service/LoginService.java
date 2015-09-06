package es.jesus.learningwords.service;

/**
 * Created by jesus on 27/08/15.
 */
public class LoginService {

    private LoginService() {

    }


    private static LoginService INSTANCE;

    public static LoginService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginService();
        }
        return INSTANCE;
    }


    public boolean login(String username, String password) {
        if (RestService.getInstance().login(username, password)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}
