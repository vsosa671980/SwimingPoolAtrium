package com.piscina.atrium.controllers;


import com.piscina.atrium.dao.PlanningDao;
import com.piscina.atrium.dao.services.ActivitiesService;
import com.piscina.atrium.dao.services.PlanningService;
import com.piscina.atrium.dao.services.StreetService;
import com.piscina.atrium.models.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/planning")
public class PlannigController {

    @Autowired
    private PlanningService service;

    @Autowired
    private StreetService serviceStreet;

    @Autowired
    private ActivitiesService serviceActivity;

    @GetMapping("/list")
    private String insertPlanning(Model model) {

        model.addAttribute("planning",service.listPlanning());

        return "/Planifications/planning";
    }

    @GetMapping("/insert")
    private String FormtPlanning(Model model,Planning planning){

        model.addAttribute("planningForm",planning);
        model.addAttribute("streets",serviceStreet.listStreets());
        model.addAttribute("activities",serviceActivity.listActivities());
        return "fragmentPlanning :: modalPlanning";

    }

    @PostMapping("/save")
    private String savePlanning(@ModelAttribute("planningForm")Planning planning){



        service.insertPlanning(planning);

        return "redirect:/planning/list";
    }


}
