package data;

import entities.Login;

public class LoginData {
    private Login login = new Login();

    public Login loginUsuario(){
        login.setEmail("alicia@email.com");
        login.setSenha("senha123");

        return login;
    }

    public Login loginIncorreto(){
        login.setEmail("aliciaa@email.com");
        login.setSenha("senha123");

        return login;
    }
}
