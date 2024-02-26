package  org.wbs.dataanalysis.api.models;


import jakarta.persistence.*;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.sql.Date;


@Entity
public class Measurement {
	@Id
	private int id;
	private int metric_id;

	private int team_id;

	private BigDecimal value;


	private Date measurement_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMetric_id() {
		return metric_id;
	}

	public void setMetric_id(int metric_id) {
		this.metric_id = metric_id;
	}



	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}




	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Date getMeasurement_date() {
		return measurement_date;
	}

	public void setMeasurement_date(Date measurement_date) {
		this.measurement_date = measurement_date;
	}
	@Transient
	private String metric_name;
	@Transient
	private String team_name;
	public String getMetric_name() {
		return metric_name;
	}

	public void setMetric_name(String metric_name) {
		this.metric_name = metric_name;
	}
	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	@Override
	public String toString() {
		  return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)        		
				   .append("id : ", id)
				   //.append("metric_name : ", metric_name)
		          // .append("team_name : " ,team_name)
				   .append("date : ", measurement_date)
				  .append("value : ", value )
		           .toString();
	}
}
