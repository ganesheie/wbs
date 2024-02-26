package org.wbs.dataanalysis.api.services;


import org.springframework.stereotype.Service;
import org.wbs.dataanalysis.api.models.Kpi;
import org.wbs.dataanalysis.api.repositories.KpiRepository;


import java.util.ArrayList;
import java.util.List;


@Service
public class KpiService {

	private final KpiRepository kpiRepository;


	public KpiService(KpiRepository kpiRepository) {
		this.kpiRepository = kpiRepository;
	}


	public List<Kpi> getMetricsNames() {
		return new ArrayList<>(kpiRepository.findAll());
	}
}
