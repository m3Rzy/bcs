package ru.theft.bcs.util;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.theft.bcs.gmv.model.Gmv;
import ru.theft.bcs.gmv.repository.GmvRepository;

import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
@Component
public class DataService {
    private GmvRepository gmvRepository;

    public void loadTestDataInDb() {
        Faker faker = new Faker();
        List<Gmv> gmvs;
        gmvRepository.saveAll(gmvs = IntStream.rangeClosed(0, 5)
                .mapToObj(i -> Gmv.builder()
                        .id(i)
                        .title(faker.company().name())
                        .amount(faker.number().randomDouble(2, 100, 10000))
                        .build())
                .toList());
    }
}
