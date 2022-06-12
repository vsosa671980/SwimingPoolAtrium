package com.piscina.atrium.controllers;


import com.piscina.atrium.dao.services.*;
import com.piscina.atrium.models.Bonos;
import com.piscina.atrium.models.Payments;
import com.piscina.atrium.models.Subscription;
import com.piscina.atrium.models.Users;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        payment.setStatePay("correct");
        //Save the payment
        service.createPayment(payment);

        //Extract data for create Subscription
        LocalDate dateInit =payment.getDatePay();
        long id =payment.getIdu().getIdusers();
        String nameSub =payment.getBonos().getBonoName();
        Long timeSubs =  (long) payment.getBonos().getDuration();

        //For calculate the end of subscription
        LocalDate dayFinish =(dateInit.plusDays(timeSubs));
        System.out.println("Duracion" + payment.getBonos().getDuration());


          sub.setInitDay(dateInit);
          sub.setFinishday(dayFinish);
          sub.setUser(user.foundUserByid(id));
          sub.setState(sub.CheckStatusBonos());
         System.out.println(sub.getState());
         serviceSub.saveSubscription(sub);

    return "/Congratulations/payCorrect";

    }

    @GetMapping("/list/{iduser}")
    public String listPayments(Model model, @PathVariable Long iduser, Pageable pageable){

        System.out.println(iduser);
        model.addAttribute("payments",service.listPaymentsByUser(iduser));

        return "/Payments/paymentFragment :: list";

    }


}
