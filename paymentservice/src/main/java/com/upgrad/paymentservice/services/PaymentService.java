package com.upgrad.paymentservice.services;

import com.upgrad.paymentservice.entity.TransactionDetailsEntity;

public interface PaymentService {
    public int acceptPayment(TransactionDetailsEntity transaction);
    public TransactionDetailsEntity getTransactionDetails(int id);
}
