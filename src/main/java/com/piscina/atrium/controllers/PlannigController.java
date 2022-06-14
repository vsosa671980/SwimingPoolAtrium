package com.piscina.atrium.controllers;


import com.piscina.atrium.dao.services.ActivitiesService;
import com.piscina.atrium.dao.services.PlanningService;
import com.piscina.atrium.dao.services.StreetService;
import com.piscina.atrium.models.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;

@Controller
@RequestMapping("/planning")
public class PlannigController {

    @Autowired
    private PlanningService service;

    @Autowired
    private StreetService serviceStreet;

    @Autowired
    private ActivitiesService serviceActivity;



    @GetMapping("/list/{iduser}")
    public String insertPlanning(@PathVariable Long iduser , Model model) {

            model.addAttribute("iduser", iduser);
            model.addAttribute("planning", service.listPlanning());


        return "/Planifications/planning";
    }

    @GetMapping("/list")
    public String insertPlanning(Model model, Pageable pageable,@RequestParam(name ="dateInit",required = false) String dateInit,@RequestParam(name="dateFinish",required = false) String dateFinish) {


        if (dateInit != null && dateFinish != null) {

            model.addAttribute("planning", service.listBydate(dateInit, dateFinish));

        }else{

            LocalDate datenow = LocalDate.now();
            LocalDate lastdayOfWeek = datenow.plusDays(7);

            String daten = new String(String.valueOf(datenow));
            String lastday = new String(String.valueOf(lastdayOfWeek));


            model.addAttribute("planning",service.listBydate(daten,lastday));
        }

        return "/Planifications/planning";
    }

    @GetMapping("/insert")
    public String FormtPlanning( Model model,Planning planning){


        model.addAttribute("planningForm",planning);
        model.addAttribute("streets",serviceStreet.listStreets());
        model.addAttribute("activities",serviceActivity.listActivities());
        return "fragmentPlanning :: modalPlanning";

    }


    @PostMapping("/save")
    public String savePlanning(@ModelAttribute("planningForm")Planning planning){


        service.insertPlanning(planning);

        return "redirect:/planning/list";
    }

    @GetMapping("/update/{idplanning}")
    public String updatePlanning(@PathVariable Long idplanning, Model model){


        model.addAttribute("planningForm",service.foundPlannning(idplanning));
        model.addAttribute("streets",serviceStreet.listStreets());
        model.addAttribute("activities",serviceActivity.listActivities());

        return "fragmentPlanning :: modalPlanning";
    }

    @GetMapping("/delete/{idPlanning}")
    public String DeletePlanning(@PathVariable Long idPlanning){


        service.deletePlanning(idPlanning);

        return "redirect:/planning/list";

    }



   



}
