package com.piscina.atrium.controllers;


import com.piscina.atrium.dao.PlanningDao;
import com.piscina.atrium.dao.services.ActivitiesService;
import com.piscina.atrium.dao.services.PlanningService;
import com.piscina.atrium.dao.services.StreetService;
import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.models.Planning;
import com.piscina.atrium.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public String insertPlanning(@PathVariable Long iduser, Model model) {

            model.addAttribute("iduser", iduser);
            model.addAttribute("planning", service.listPlanning());


        return "/Planifications/planning";
    }

    @GetMapping("/list")
    public String insertPlanning(Model model ) {

        model.addAttribute("planning",service.listPlanning());

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

        if(planning.getOcupacion() >0) {
            planning.setOcupacion(planning.getOcupacion() - 1);
        }
        service.insertPlanning(planning);

        return "redirect:/planning/list";
    }


   



}
