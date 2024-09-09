package br.com.alelo.consumer.consumerpat.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import br.com.alelo.consumer.consumerpat.app.dto.ConsumerDTO;
import br.com.alelo.consumer.consumerpat.domain.service.ConsumerService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @ResponseBody
    @GetMapping("/consumerList")
    public ResponseEntity<List<ConsumerDTO>> listAllConsumers() {
        return ResponseEntity.ok(consumerService.getAllConsumers());
    }

    @PostMapping("/createConsumer")
    public ResponseEntity<Void> createConsumer(@RequestBody ConsumerDTO consumerDTO ) {
        consumerService.createConsumer(consumerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/updateConsumer")
    public ResponseEntity<Void> updateConsumer(@RequestBody ConsumerDTO consumerDTO) {
        consumerService.updateConsumer(consumerDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/setcardbalance")
    public ResponseEntity<Void> setBalance(@RequestParam int cardNumber, @RequestParam double value) {
        consumerService.setCardBalance(cardNumber, value);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ResponseBody
    @GetMapping("/buy")
    public ResponseEntity<Void> buy(
            @RequestParam int establishmentType,
            @RequestParam String establishmentName,
            @RequestParam int cardNumber,
            @RequestParam String productDescription,
            @RequestParam double value
    ) {
        consumerService.buy(establishmentType, establishmentName, cardNumber, productDescription, value);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
