package ua.org.dubovskyi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dubovskyi.domain.CoordinatesEntity;
import ua.org.dubovskyi.exception.EntityNotFoundInServiceException;

import ua.org.dubovskyi.repository.CoordinatesRepository;
import ua.org.dubovskyi.web.mapper.CoordinatesMapper;

import java.util.List;



@Service
public class CoordinatesService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CoordinatesRepository repository;
    @Autowired
    private CoordinatesMapper coordinatesMapper;


    @javax.transaction.Transactional
    public List<CoordinatesEntity> findAll() {
        List<CoordinatesEntity> result = repository.findAll();

        return result;
    }


    @Transactional
    public CoordinatesEntity save(CoordinatesEntity entity) throws EntityNotFoundInServiceException {
        CoordinatesEntity coordinatesEntityNew = repository.save(entity);
        return coordinatesEntityNew;
    }


}
