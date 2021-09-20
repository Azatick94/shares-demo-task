package com.example.sharesdemotask.services;

import com.example.sharesdemotask.models.Elvl;
import com.example.sharesdemotask.models.Quote;
import com.example.sharesdemotask.repositories.ElvlRepository;
import com.example.sharesdemotask.repositories.QuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class QuoteService {

    private final QuoteRepository quoteRepo;
    private final ElvlRepository elvlRepo;

    public QuoteService(QuoteRepository quoteRepo, ElvlRepository elvlRepo) {
        this.quoteRepo = quoteRepo;
        this.elvlRepo = elvlRepo;
    }

    public List<Quote> getAll() {
        return quoteRepo.findAll();
    }

    public Quote getById(Integer id) {
        return quoteRepo.findById(id);
    }

    @Async
    @Transactional
    // saving new quote
    public CompletableFuture<Void> create(Quote quote) {

        log.info("Thread " + Thread.currentThread().getName() + " is SAVING NEW QUOTE " + quote);

        // creating or update command
        quoteRepo.save(quote);

        // NEEDS SYNCHRONIZATION
        // taking quote info
        String isin = quote.getIsin();
        Double bid = quote.getBid();
        Double ask = quote.getAsk();
        Double newBestPrice;
        // if elvl for this isin is present, then update elvl
        // check if this isin is present in db
        Elvl elvlFromDb = elvlRepo.findByIsin(isin);

        if (elvlFromDb != null) {
            Double bestPriceFromDB = elvlFromDb.getBestPrice();
            if (bid > bestPriceFromDB) {
                newBestPrice = bid;
            } else if (ask < bestPriceFromDB) {
                newBestPrice = ask;
            } else {
                newBestPrice = bestPriceFromDB;
                // bid can be absent
            }

            // updating elvl
            elvlFromDb.setBestPrice(newBestPrice);
            elvlRepo.save(elvlFromDb);

            // elvl not present in db, so create elvl for this isin
        } else {
            Elvl newElvl = new Elvl(isin);
            newElvl.setBestPrice(bid);
            elvlRepo.save(newElvl);
        }

        return CompletableFuture.completedFuture(null);
    }

    public List<Quote> getByIsin(String isin) {
        return quoteRepo.findByIsin(isin);
    }
}
