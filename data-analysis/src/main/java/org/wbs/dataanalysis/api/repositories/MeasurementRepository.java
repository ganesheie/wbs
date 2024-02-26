package org.wbs.dataanalysis.api.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.wbs.dataanalysis.api.models.Measurement;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {

}
