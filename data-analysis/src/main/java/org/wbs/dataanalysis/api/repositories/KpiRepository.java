package org.wbs.dataanalysis.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wbs.dataanalysis.api.models.Kpi;


@Repository
public interface KpiRepository extends JpaRepository<Kpi,Integer> {

}
