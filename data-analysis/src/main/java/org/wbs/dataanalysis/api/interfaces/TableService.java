package org.wbs.dataanalysis.api.interfaces;

import java.util.List;

import org.wbs.dataanalysis.api.models.Measurement;

public interface TableService {
	public List<Measurement> getAllMeasurements();
}