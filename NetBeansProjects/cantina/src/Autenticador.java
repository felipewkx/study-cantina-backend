
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author FELIPEGUSTAVOWALKER
 */
public class Autenticador {

    private final List<Usuario> usuarios = new ArrayList();

    //private final Usuario administrador = new Usuario("Administrador", "admin", "1234");
    public Autenticador() {
        usuarios.add(new Usuario("Administrador", "admin", "1234"));
        usuarios.add(new Usuario("Caixa", "caixa", "1234"));
    }

    public Usuario autenticar(Usuario tentativa) {

        for (Usuario usuario : usuarios) {
            boolean loginOk = usuario.getLogin().equals(tentativa.getLogin());
            boolean senhaOk = usuario.getSenha().equals(tentativa.getSenha());

            if (loginOk && senhaOk) {
                return usuario;
            }
        }
        return null;
    }
}
