package org.wbs.dataanalysis.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wbs.dataanalysis.api.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {

}
