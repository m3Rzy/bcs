package ru.theft.bcs.gmv.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.theft.bcs.gmv.model.Gmv;
import ru.theft.bcs.gmv.service.GmvService;
import ru.theft.bcs.core.DataService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/gmv")
public class GmvController {
    @Autowired
    private DataService dataService;
    private GmvService gmvService;

    @GetMapping
    public List<Gmv> readAllGmv() {
        return gmvService.getAll();
    }

    @GetMapping("/load")
    public void load() {
        dataService.loadGmvDataInDb();
    }

    @GetMapping("/{id}")
    public Gmv readGmv(@PathVariable Long id) {
        return gmvService.getById(id);
    }

    @PostMapping
    public Gmv addGmv(@RequestBody Gmv gmv) {
        return gmvService.add(gmv);
    }

    @DeleteMapping
    public void deleteGmv(@RequestBody Gmv gmv) {
        gmvService.delete(gmv);
    }
}
