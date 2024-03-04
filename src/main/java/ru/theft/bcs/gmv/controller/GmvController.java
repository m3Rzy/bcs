package ru.theft.bcs.gmv.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.theft.bcs.gmv.model.Gmv;
import ru.theft.bcs.gmv.service.GmvService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/gmv")
public class GmvController {

    public static final String header = "X-Sharer-User-Id";
    private GmvService gmvService;

    @GetMapping
    public List<Gmv> readAllGmv() {
        return gmvService.getAll();
    }

    @GetMapping("/{id}")
    public Gmv readGmv(@PathVariable Long id) {
        return gmvService.getById(id);
    }

    @PostMapping
    public Gmv addGmv(@RequestHeader(header) Long userId, @RequestBody Gmv gmv) {
        return gmvService.add(userId, gmv);
    }

    @DeleteMapping
    public void deleteGmv(@RequestBody Gmv gmv) {
        gmvService.delete(gmv);
    }
}
