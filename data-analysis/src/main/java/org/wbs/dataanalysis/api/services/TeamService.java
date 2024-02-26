package org.wbs.dataanalysis.api.services;


import org.springframework.stereotype.Service;
import org.wbs.dataanalysis.api.models.Team;
import org.wbs.dataanalysis.api.repositories.TeamRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class TeamService {

	private final TeamRepository teamRepository;


	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}


	public List<Team> getTeamNames() {
		return new ArrayList<>(teamRepository.findAll());
	}
}
