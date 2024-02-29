package ru.theft.bcs.waste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theft.bcs.waste.model.Waste;

@Repository
public interface WasteRepository extends JpaRepository<Waste, Long> {
}
