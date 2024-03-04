package ru.theft.bcs.gmv.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.theft.bcs.gmv.model.Gmv;
import ru.theft.bcs.gmv.repository.GmvRepository;
import ru.theft.bcs.user.service.UserService;
import ru.theft.bcs.util.exception.NotFoundException;
import ru.theft.bcs.waste.model.Waste;
import ru.theft.bcs.waste.service.WasteService;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GmvServiceImpl implements GmvService {

    private GmvRepository gmvRepository;
    private WasteService wasteService;
    private UserService userService;

    @Override
    public List<Gmv> getAll() {
        log.info("Quantity gmv: {}", gmvRepository.findAll().size());
        return gmvRepository.findAll();
    }

    @Override
    public Gmv getById(Long id) {
        return gmvRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gmv doesn't exist " + id + " id."));
    }

    @Override
    public Gmv add(Long userId, Gmv gmv) {
        gmv.setUser(userService.getById(userId));
        log.info("{} has been created.", gmv);
        return gmvRepository.save(gmv);
    }

    @Override
    public void delete(Gmv gmv) {
        gmvRepository.delete(getById(gmv.getId()));
        log.info("{} has been deleted.", gmv);
    }

    @Override
    public Gmv incomeMinusExpenses(Long id) {
        Gmv gmv = getById(id);
        for (Waste waste : wasteService.getAll()) {
             gmv.setAmount(gmv.getAmount() - waste.getAmount());
        }
        return gmv;
    }
}
