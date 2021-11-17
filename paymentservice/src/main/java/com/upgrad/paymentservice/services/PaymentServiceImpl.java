package com.upgrad.paymentservice.services;

import com.upgrad.paymentservice.dao.PaymentServiceDao;
import com.upgrad.paymentservice.entity.TransactionDetailsEntity;
import com.upgrad.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentServiceDao paymentServiceDao;

    @Autowired
    public PaymentServiceImpl(PaymentServiceDao paymentServiceDao) {
        this.paymentServiceDao = paymentServiceDao;
    }

    @Override
    public int acceptPayment(TransactionDetailsEntity transaction) {
        TransactionDetailsEntity savedTranscation = paymentServiceDao.save(transaction);
        return savedTranscation.getTransactionID();
    }

    @Override
    public TransactionDetailsEntity getTransactionDetails(int id) {
        TransactionDetailsEntity transaction = paymentServiceDao.getById(id);
        return transaction;
    }
}
