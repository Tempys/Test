package ua.org.dubovskyi.web.mapper;

import org.springframework.stereotype.Service;
import ua.org.dubovskyi.domain.CoordinatesEntity;
import ua.org.dubovskyi.web.dto.CoordinatesDto;


@Service
public class CoordinatesMapper {



    public CoordinatesDto toDTO(CoordinatesEntity entity) {

        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setY(entity.getY());
        coordinatesDto.setX(entity.getX());

        return coordinatesDto;
    }

    public CoordinatesEntity fromDTO(CoordinatesDto entityDTO) {

        CoordinatesEntity coordinatesEntity = new CoordinatesEntity();
        coordinatesEntity.setX(entityDTO.getX());
        coordinatesEntity.setY(entityDTO.getY());

        return coordinatesEntity;
    }


}
