package com.example.sharesdemotask;

import com.example.sharesdemotask.models.Quote;
import com.example.sharesdemotask.services.QuoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SharesDemoTaskApplication implements CommandLineRunner {

    private final QuoteService quoteService;

    public SharesDemoTaskApplication(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SharesDemoTaskApplication.class, args);
    }

    @Override
    public void run(String... args) {

        // sample of data population
        System.out.println("Application is Running");
        final Double min1 = 100.0;
        final Double max1 = 101.0;
        final Double min2 = 101.1;
        final Double max2 = 102.0;

        Random random = new Random();
        Supplier<Double> bidSupplier = () -> min1 + (max1 - min1) * random.nextDouble();
        Supplier<Double> askSupplier = () -> min2 + (max2 - min2) * random.nextDouble();
        Supplier<Quote> quoteSupplier = () -> new Quote("RU000A0JX0J2", bidSupplier.get(), askSupplier.get());

        // creating list of 20 quotes
        List<Quote> quotes = Stream.generate(quoteSupplier).limit(20).collect(Collectors.toList());

        for (Quote quote: quotes) {
            quoteService.create(quote);
        }
    }


}
