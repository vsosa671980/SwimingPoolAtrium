package com.piscina.atrium.controllers;


import com.piscina.atrium.dao.services.*;
import com.piscina.atrium.models.Bonos;
import com.piscina.atrium.models.Payments;
import com.piscina.atrium.models.Subscription;
import com.piscina.atrium.models.Users;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payments")
public class PaymentsController {


    @Autowired
    private PaymentsService service;
    
    @Autowired 
    private UserService user;

    @Autowired
    private SubscriptionService serviceSub;

    //This method create a new Bonus associate to User and registry new payment of user
    @PostMapping("/save")
    public String payDo(@ModelAttribute("paymentForm") Payments payment, Subscription sub){

        service.createPayment(payment);
        
        LocalDate dateInit =payment.getDatePay();
        long id =payment.getIdu().getIdusers();
        String nameSub =payment.getBonos().getBonoName();
        Long timeSubs =  (long) payment.getBonos().getDuration();
        
        LocalDate dayFinish =(dateInit.plusDays(timeSubs));
        System.out.println("Duracion" + payment.getBonos().getDuration());


          sub.setInitDay(dateInit);
          sub.setFinishday(dayFinish);
          sub.setUser(user.foundUserByid(id));
          sub.CheckStatusBonos();

        serviceSub.saveSubscription(sub);

    return "/Congratulations/payCorrect";

    }
}
