package com.piscina.atrium.dao.services;

import com.piscina.atrium.dao.PaymentsDao;
import com.piscina.atrium.models.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class PaymentsService implements IPayments {

    @Autowired
    private PaymentsDao dao;
    @Override
    public void createPayment(Payments payment) {

        dao.save(payment);
    }

    @Override
    public void deletePayment(Long id) {

        dao.findById(id);
    }

    @Override
    public ArrayList<Payments> listPaymentsByUser(Long id) {
        return dao.listPaymentsByUser(id);
    }
}
