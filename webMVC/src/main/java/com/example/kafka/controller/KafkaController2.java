package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.service.KafkaProducer2;

@RestController
@RequestMapping(value = "/kafka2")
public class KafkaController2 {

    private final KafkaProducer2 producer;

    @Autowired
    KafkaController2(KafkaProducer2 producer){
        this.producer = producer;
    }

    @PostMapping
    @ResponseBody
    public String sendMessage(@RequestParam String message) {
        this.producer.sendMessage(message);

        return "success message:"+message;
    }
}