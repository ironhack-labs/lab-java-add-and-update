package com.ironhack.Lab404AddandUpdate.service.interfaces;

import com.ironhack.Lab404AddandUpdate.model.Hospital;

import java.util.List;

public interface IHospitalService {

    Hospital saveHospital(Hospital hospital);

    List<Hospital> getAllHospital();
}
