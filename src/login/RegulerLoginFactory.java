package login;

import applicationview.LoginReguler;
import javax.swing.JFrame;

public class RegulerLoginFactory implements LoginFactory {

    @Override
    public JFrame createLogin() {
        return new LoginReguler();
    }
}
