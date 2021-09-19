package com.example.sharesdemotask.controllers;

import com.example.sharesdemotask.models.Quote;
import com.example.sharesdemotask.services.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quote")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Quote> getAll() {
        return quoteService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Quote getById(@PathVariable Integer id) {
        return quoteService.getById(id);
    }

    @GetMapping("/isin/{isin}")
    @ResponseStatus(HttpStatus.OK)
    public List<Quote> getByIsin(@PathVariable String isin) {
        return quoteService.getByIsin(isin);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Quote quote) {
        quoteService.create(quote);
    }
}
