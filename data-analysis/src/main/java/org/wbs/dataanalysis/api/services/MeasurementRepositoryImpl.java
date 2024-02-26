package org.wbs.dataanalysis.api.services;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MeasurementRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> executeNativeQuery(String query) {
        return entityManager.createNativeQuery(query).getResultList();
    }
}