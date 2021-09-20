package com.example.sharesdemotask.services;

import com.example.sharesdemotask.models.Elvl;
import com.example.sharesdemotask.repositories.ElvlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElvlService {

    private final ElvlRepository elvlRepository;

    public ElvlService(ElvlRepository elvlRepository) {
        this.elvlRepository = elvlRepository;
    }

    public List<Elvl> getAll() {
        return elvlRepository.findAll();
    }

    public Elvl getByIsin(String isin) {
        return elvlRepository.findByIsin(isin);
    }
}
