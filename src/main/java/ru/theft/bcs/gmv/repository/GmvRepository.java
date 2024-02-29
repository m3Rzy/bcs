package ru.theft.bcs.gmv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theft.bcs.gmv.model.Gmv;

@Repository
public interface GmvRepository extends JpaRepository<Gmv, Long> {
}
