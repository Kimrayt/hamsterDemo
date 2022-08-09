package com.example.eventdriven.kafka.consumer;

import com.example.eventdriven.models.Hamster;
import com.example.eventdriven.mongodbRepository.IHamsterRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerService {

    private final IHamsterRepository hamsterRepository;

    public ConsumerService(IHamsterRepository hamsterRepository) {
        this.hamsterRepository = hamsterRepository;
    }

    @KafkaListener(topics = "rest-spring-boot-integration", containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        Hamster review = new Hamster();
        review.setName(message);

        hamsterRepository.insert(review);
    }
}