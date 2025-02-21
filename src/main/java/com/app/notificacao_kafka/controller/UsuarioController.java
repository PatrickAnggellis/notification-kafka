package com.app.notificacao_kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.notificacao_kafka.model.Usuario;
import com.app.notificacao_kafka.repository.UsuarioRepository;
import com.app.notificacao_kafka.service.NotificacaoProducer;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NotificacaoProducer notificacaoProducer;

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        notificacaoProducer.enviarNotificacao(usuarioSalvo);
        return usuarioSalvo;
    }
}