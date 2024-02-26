package org.wbs.dataanalysis.api.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.wbs.dataanalysis.api.models.Measurement;
import org.wbs.dataanalysis.api.repositories.MeasurementRepository;


@Service
public class MeasurementService{

	private final MeasurementRepository measurementRepository;


	public MeasurementService(MeasurementRepository measurementRepository) {
		this.measurementRepository = measurementRepository;
	}


	public List<Measurement> getAllMeasurements() {
		List<Measurement> allMeasurements = new ArrayList<>();
		measurementRepository.findAll().forEach(allMeasurements::add);
		return allMeasurements;
	}


	@PersistenceContext
	private EntityManager entityManager;
	public List<Measurement> executeNativeQuery(String query,String parameterName,String parameterValue) {
		List<Measurement> allMeasurement = new ArrayList<>();
		List<Object[]> results = new ArrayList<>();
		if (StringUtils.isBlank(parameterName)){
			results = entityManager.createNativeQuery(query).getResultList();
		}else {
			results = entityManager.createNativeQuery(query).setParameter(parameterName,parameterValue).getResultList();
		}

		covertQueryOutputToMeasurementObject(results,allMeasurement);
		return allMeasurement;
	}

	private void covertQueryOutputToMeasurementObject(List<Object[]> inputList , List<Measurement> outputList){
		for (Object[] row : inputList) {
			Measurement measurement = new Measurement();
			measurement.setId((Integer) row[0]);
			measurement.setMetric_id ((Integer) row[1]);
			measurement.setTeam_id( (Integer) row[2]);
			measurement.setValue((BigDecimal) row[3]);
			measurement.setMeasurement_date((Date) row[4]);
			measurement.setTeam_name((String) row[5]);
			measurement.setMetric_name((String) row[6]);
			outputList.add(measurement);
		}
	}

}
