package br.com.gomes.mercadolivretreino.response;

public class UsuarioResponse {
    private Long id;
    private String login;

    public UsuarioResponse(Long id, String login) {
        this.id = id;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}
