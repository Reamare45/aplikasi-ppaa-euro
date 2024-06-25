package login;

import applicationview.Login;
import javax.swing.JFrame;

public class GuestLoginFactory implements LoginFactory {

    @Override
    public JFrame createLogin() {
        return new Login();
    }
}
