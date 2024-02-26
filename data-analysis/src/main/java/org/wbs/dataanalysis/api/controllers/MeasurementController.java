package org.wbs.dataanalysis.api.controllers;

import jakarta.websocket.OnClose;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wbs.dataanalysis.api.models.Kpi;
import org.wbs.dataanalysis.api.models.Measurement;
import org.wbs.dataanalysis.api.models.Team;
import org.wbs.dataanalysis.api.services.KpiService;
import org.wbs.dataanalysis.api.services.MeasurementService;
import org.wbs.dataanalysis.api.services.TeamService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MeasurementController {
    private static String BASE_QUERY= "select m.*,t.name team_name,k.name metric_name " +
            "from measurement m, team t, kpi k " +
            "where t.id=m.team_id and k.id=m.metric_id ";
    private static String END_QUERY = " order by metric_name,team_name";
    public MeasurementService measurementService;
    public TeamService teamService;
    public KpiService kpiService;
    public MeasurementController(MeasurementService measurementService , TeamService teamService,KpiService kpiService ) {
        this.measurementService = measurementService;
        this.kpiService = kpiService;
        this.teamService = teamService;
    }

    @GetMapping({"/measurement/all","/measurement/all/"})
    public ResponseEntity<List<Measurement>> getMeasurements() {
        String query = BASE_QUERY + END_QUERY;
        List<Measurement> allMeasurements =  measurementService.executeNativeQuery(query,"","");
        return new ResponseEntity<>(allMeasurements, HttpStatus.OK);
    }

    @GetMapping(value={"/measurementforteam/{team}", "/measurementforteam/{team}/"})
    public ResponseEntity<List<Measurement>> getMeasurementForTeam(@PathVariable String team) {
        String query = BASE_QUERY + " and t.name = :team" + END_QUERY;
        List<Measurement> allMeasurements =  measurementService.executeNativeQuery(query,"team",team);
        return new ResponseEntity<>(allMeasurements, HttpStatus.OK);
    }
    @GetMapping(value={"/measurementfordate/{date}","/measurementfordate/{date}/"})
    public ResponseEntity<List<Measurement>> getMeasurementForDate(@PathVariable String date) {
        String query = BASE_QUERY + " and measurement_date = :date" + END_QUERY;
        List<Measurement> allMeasurements =  measurementService.executeNativeQuery(query,"date",date);
        return new ResponseEntity<>(allMeasurements, HttpStatus.OK);
    }
    @GetMapping(value={"/measurementforcategory/{category}" ,"/measurementforcategory/{category}/" })
    public ResponseEntity<List<Measurement>> getMeasurementForCategory(@PathVariable String category) {
        String query = BASE_QUERY + " and k.name = :category" + END_QUERY;
        List<Measurement> allMeasurements =  measurementService.executeNativeQuery(query,"category",category);
        return new ResponseEntity<>(allMeasurements, HttpStatus.OK);
    }

    @GetMapping({"/get-all-category","/get-all-category/" })
    public ResponseEntity<List<Kpi>> getAllCategory() {
        return new ResponseEntity<>(kpiService.getMetricsNames(), HttpStatus.OK);
    }
    @GetMapping({"/get-all-teams", "/get-all-teams/"})
    public ResponseEntity<List<Team>> getAllTeams() {
        return new ResponseEntity<>(teamService.getTeamNames(), HttpStatus.OK);
    }
    @GetMapping({"/get-all-dates","/get-all-dates/"})
    public ResponseEntity<List<Measurement>> getAllDate() {
        String query = "select distinct(measurement_date) from measurement";
        List<Measurement> allMeasurements =  measurementService.executeNativeQuery(query,"","");
        return new ResponseEntity<>(allMeasurements, HttpStatus.OK);
    }
}
