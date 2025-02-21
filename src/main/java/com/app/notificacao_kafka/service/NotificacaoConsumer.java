package com.app.notificacao_kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.app.notificacao_kafka.model.Usuario;

@Service
public class NotificacaoConsumer {

    @KafkaListener(topics = "notificacoes", groupId = "notification-group")
    public void consumirNotificacao(Usuario usuario) {
        System.out.println("Notificação recebida: " + usuario);
    }
}