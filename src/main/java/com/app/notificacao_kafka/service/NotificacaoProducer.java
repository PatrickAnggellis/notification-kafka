package com.app.notificacao_kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.app.notificacao_kafka.model.Usuario;

@Service
public class NotificacaoProducer {

    @Autowired
    private KafkaTemplate<String, Usuario> kafkaTemplate;

    public void enviarNotificacao(Usuario usuario) {
        kafkaTemplate.send("notificações", usuario.getNome(), usuario);
    }
}
