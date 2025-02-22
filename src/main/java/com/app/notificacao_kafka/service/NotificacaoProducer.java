package com.app.notificacao_kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.app.notificacao_kafka.model.Usuario;

@Service
public class NotificacaoProducer {

    private static final Logger logger = LoggerFactory.getLogger(NotificacaoProducer.class);
    private static final String TOPIC = "notificacoes";

    @Autowired
    private KafkaTemplate<String, Usuario> kafkaTemplate;

    public void enviarNotificacao(Usuario usuario) {
        logger.info("Enviando notificação para o tópico {}: {}", TOPIC, usuario);
        kafkaTemplate.send(TOPIC, usuario.getNome(), usuario);
    }
}