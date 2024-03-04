package ru.theft.bcs.core;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.theft.bcs.gmv.model.Gmv;
import ru.theft.bcs.gmv.repository.GmvRepository;
import ru.theft.bcs.waste.repository.WasteRepository;

import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Component
public class DataService {
    private final GmvRepository gmvRepository;
    private final WasteRepository wasteRepository;
    private Faker faker;

    public void loadGmvDataInDb() {
        List<Gmv> gmvs;
        gmvRepository.saveAll(gmvs = IntStream.rangeClosed(0, 5)
                .mapToObj(i -> Gmv.builder()
                        .id(i)
                        .title(faker.company().name())
                        .amount(faker.number().randomDouble(2, 100, 10000))
                        .build())
                .toList());
    }

//    public void loadWastesDataInDb() {
//        List<Waste> wastes;
//        wasteRepository.saveAll(wastes = IntStream.rangeClosed(0, 5)
//                .mapToObj(i -> Waste.builder()
//                        .id(i)
//                        .title(faker.beer().name())
//                        .symbol('%')
//                        .amount(faker.number().randomDouble(2, 10, 1000))
//                        .build())
//                .toList());
//    }
}
