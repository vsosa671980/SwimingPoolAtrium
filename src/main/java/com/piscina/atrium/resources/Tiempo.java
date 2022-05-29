package com.piscina.atrium.resources;

import com.piscina.atrium.dao.services.SubscriptionService;
import com.piscina.atrium.models.Subscription;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Tiempo {

      Timer timer = new Timer();

      public void exectask(){
            Task task = new Task();
            timer.schedule(task,10000,14400000 );

      }

}
