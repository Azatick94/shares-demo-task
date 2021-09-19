package com.example.sharesdemotask.controllers;

import com.example.sharesdemotask.models.Elvl;
import com.example.sharesdemotask.services.ElvlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elvl")
public class ElvlController {

    private final ElvlService elvlService;

    public ElvlController(ElvlService elvlService) {
        this.elvlService = elvlService;
    }

    @GetMapping
    public List<Elvl> getAll() {
        return elvlService.getAll();
    }

    @GetMapping("{isin}")
    public Elvl getByIsin(@PathVariable String isin) {
        return elvlService.getByIsin(isin);
    }

}
