package ru.theft.bcs.gmv.service;

import ru.theft.bcs.gmv.model.Gmv;

import java.util.List;

public interface GmvService {
    List<Gmv> getAll();

    Gmv getById(Long id);

    Gmv add(Gmv gmv);

    void delete(Gmv gmv);
}
