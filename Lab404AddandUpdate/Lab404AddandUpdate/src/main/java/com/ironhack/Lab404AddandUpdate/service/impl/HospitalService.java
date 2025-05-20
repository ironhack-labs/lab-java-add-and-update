package com.ironhack.Lab404AddandUpdate.service.impl;

import com.ironhack.Lab404AddandUpdate.model.Hospital;
import com.ironhack.Lab404AddandUpdate.repository.HospitalRepository;
import com.ironhack.Lab404AddandUpdate.service.interfaces.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService implements IHospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepository.findAll();
    }
}
