package pl.blaszak.kata.medicinedosekata.service;

import pl.blaszak.kata.medicinedosekata.model.Medicine;

public interface MedicinePumpService {
    boolean dose(Medicine medicine);
}
