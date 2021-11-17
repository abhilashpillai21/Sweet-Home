package com.upgrad.paymentservice.controller;

import com.upgrad.paymentservice.dto.PaymentServiceDTO;
import com.upgrad.paymentservice.entity.TransactionDetailsEntity;
import com.upgrad.paymentservice.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentServiceController {

    private final PaymentService paymentService;
    private final ModelMapper modelMapper;

    @Autowired
    public PaymentServiceController(PaymentService paymentService, ModelMapper modelMapper) {
        this.paymentService = paymentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value="/transaction", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> sendPaymentDetails(@RequestBody PaymentServiceDTO paymentServiceDTO){
        TransactionDetailsEntity transaction = modelMapper.map(paymentServiceDTO, TransactionDetailsEntity.class);
        int transactionID = paymentService.acceptPayment(transaction);
        return new ResponseEntity(transactionID, HttpStatus.CREATED);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<PaymentServiceDTO> getTranactionDetails(@PathVariable(name="id")int id){
        TransactionDetailsEntity transaction = paymentService.getTransactionDetails(id);
        PaymentServiceDTO paymentServiceDTO = modelMapper.map(transaction, PaymentServiceDTO.class);
        return ResponseEntity.ok(paymentServiceDTO);
    }

}
