package ru.theft.bcs.waste.service;

import ru.theft.bcs.waste.model.Waste;

import java.util.List;

public interface WasteService {
    List<Waste> getAll();

    Waste getById(Long id);

    Waste add(Waste waste);

    void delete(Waste waste);
}
