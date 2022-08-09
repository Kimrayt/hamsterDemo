package com.example.eventdriven.controllers;

import com.example.eventdriven.kafka.producer.Producer;
import com.example.eventdriven.models.Hamster;
import com.example.eventdriven.mongodbRepository.IHamsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HamsterController {

    @Autowired
    private final IHamsterRepository HamsterRepository;
    private final Producer producer;

    public HamsterController(IHamsterRepository HamsterRepository, Producer producer) {
        this.HamsterRepository = HamsterRepository;
        this.producer = producer;
    }

    @RequestMapping(value = "/Hamsters", method = RequestMethod.GET)
    public String welcomeMatForm(Model model) {
        List<Hamster> hamsters = getHamsters();
        model.addAttribute("hamsters", hamsters);
        return "hamsters";
    }

    public List<Hamster> getHamsters() {
        return HamsterRepository.findAll();
    }

//    @RequestMapping(value = "/Hamsters", method = RequestMethod.GET)
//    public List<Hamster> getHamsters() {
//        return HamsterRepository.findAll();
//    }


    @RequestMapping(value = "/Hamster", method = RequestMethod.POST)
    public void insertHamster(@RequestBody String Hamster) {
        producer.sendMessage(Hamster);
    }
}