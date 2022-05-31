package com.piscina.atrium.dao.services;

import com.piscina.atrium.dao.PaymentsDao;
import com.piscina.atrium.models.Payments;

import java.util.ArrayList;

public interface IPayments  {


    public void createPayment(Payments payment);

    public void deletePayment(Long id);

    public ArrayList<Payments> listPaymentsByUser(Long id);


}
