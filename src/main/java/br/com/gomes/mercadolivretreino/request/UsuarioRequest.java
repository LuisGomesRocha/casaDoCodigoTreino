package br.com.gomes.mercadolivretreino.request;

import br.com.gomes.mercadolivretreino.model.Usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank(message = "Login não deve ser branco!")
    @Size(min = 3, max = 30, message = "Login deve conter de 3 a 30 caracteres!")
    private String login;
    @Size(min = 6, message = "Senha precisa ter no mínimo 6 caracteres!")
    @NotBlank(message = "Senha em branco!")
    private String senha;

    public Usuario toModel(){
        return new Usuario(this.login, this.senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
