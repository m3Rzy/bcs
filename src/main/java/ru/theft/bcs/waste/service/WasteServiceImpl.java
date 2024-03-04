package ru.theft.bcs.waste.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.theft.bcs.gmv.service.GmvService;
import ru.theft.bcs.util.exception.BadRequestException;
import ru.theft.bcs.util.exception.NotFoundException;
import ru.theft.bcs.waste.model.Waste;
import ru.theft.bcs.waste.repository.WasteRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class WasteServiceImpl implements WasteService {

    private WasteRepository wasteRepository;
    private GmvService gmvService;

    @Override
    public List<Waste> getAll() {
        log.info("Quantity wastes: {}", wasteRepository.findAll().size());
        return wasteRepository.findAll();
    }

    @Override
    public Waste getById(Long id) {
        return wasteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Waste doesn't exist " + id + " id."));
    }

    @Override
    public Waste add(Long gmvId, Waste waste) {
        waste.setGmv(gmvService.getById(gmvId));

        if (waste.getTitle().isBlank() || waste.getTitle().isEmpty()) {
            throw new BadRequestException("Waste title can't be empty or blank.");
        }

        if (waste.getAmount() <= (double) 0) {
            throw new BadRequestException("Waste amount can't equal 0 or less.");
        }

        log.info("{} has been created.", waste);
        return wasteRepository.save(waste);
    }

    @Override
    public void delete(Waste waste) {
        log.info("{} has been deleted.", waste);
        wasteRepository.delete(waste);
    }
}
