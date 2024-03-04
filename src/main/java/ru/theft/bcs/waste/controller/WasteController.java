package ru.theft.bcs.waste.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.theft.bcs.gmv.service.GmvService;
import ru.theft.bcs.waste.model.Waste;
import ru.theft.bcs.waste.service.WasteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/waste")
@AllArgsConstructor
public class WasteController {

    public static final String header = "X-Sharer-Gmv-Id";
    private WasteService wasteService;
    private GmvService gmvService;

    @GetMapping
    public List<Waste> readAllWastes() {
        return wasteService.getAll();
    }

    @GetMapping("/{id}")
    public Waste readWaste(@PathVariable Long id) {
        return wasteService.getById(id);
    }

    @PostMapping
    public Waste addWaste(@RequestHeader(header) Long gmvId, @RequestBody Waste waste) {
        return wasteService.add(gmvId, waste);
    }

    @DeleteMapping
    public void deleteWaste(@RequestBody Waste waste) {
        wasteService.delete(waste);
    }

    @GetMapping("/gmv")
    public List<Waste> readWastesByGmvId(@RequestHeader(header) Long gmvId) {
        return wasteService.getAll()
                .stream()
                .filter(gmv -> gmvService.getById(gmvId).getId() == gmvId)
                .collect(Collectors.toList());
    }
}
