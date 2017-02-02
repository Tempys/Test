package ua.org.dubovskyi.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.org.dubovskyi.domain.CoordinatesEntity;
import ua.org.dubovskyi.exception.EntityNotFoundInServiceException;

import ua.org.dubovskyi.service.CoordinatesService;
import ua.org.dubovskyi.web.dto.CoordinatesDto;
import ua.org.dubovskyi.web.mapper.CoordinatesMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/coordinates", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CoordinatesResource {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CoordinatesService coordinatesService;
    @Autowired
    private CoordinatesMapper coordinatesMapper;


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public  List<CoordinatesDto>  getMessages()  {

        List<CoordinatesEntity> result = coordinatesService.findAll();

        List<CoordinatesDto> resultDto = result.stream().map(coordinatesMapper::toDTO).collect(Collectors.toList());

        return resultDto;
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void save(
            @RequestBody @Valid CoordinatesDto coordinatesDTO
    ) throws EntityNotFoundInServiceException {

        log.info("get coordinate: "+ coordinatesDTO);
        CoordinatesEntity coordinatesEntity = coordinatesMapper.fromDTO( coordinatesDTO);
        coordinatesService.save(coordinatesEntity);
    }




}
