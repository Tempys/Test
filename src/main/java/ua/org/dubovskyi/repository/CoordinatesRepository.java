package ua.org.dubovskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.dubovskyi.domain.CoordinatesEntity;


@Repository
public interface CoordinatesRepository extends JpaRepository<CoordinatesEntity, Integer> {


}
