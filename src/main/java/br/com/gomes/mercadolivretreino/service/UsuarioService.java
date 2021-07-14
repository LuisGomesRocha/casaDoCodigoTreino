package br.com.gomes.mercadolivretreino.service;

import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void salvarUsuario(Usuario usuario) {
        usuario.setSenha(hashSenha(usuario.getSenha()));
        usuarioRepository.save(usuario);
    }

    public String hashSenha(String senhaAberta) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String senhaCriptografada;

        senhaCriptografada = bCrypt.encode(senhaAberta);

        return senhaCriptografada;
    }

}
