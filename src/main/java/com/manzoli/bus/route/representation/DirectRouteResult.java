package com.manzoli.bus.route.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dep_sid", "arr_sid", "direct_bus_route" })
public class DirectRouteResult {

	@JsonProperty("dep_sid")
	private Integer depSid;

	@JsonProperty("arr_sid")
	private Integer arrSid;

	@JsonProperty("direct_bus_route")
	private Boolean directBusRoute;
	
	public DirectRouteResult() {
	
	}
	
	public DirectRouteResult(Integer depSid, Integer arrSid, Boolean directBusRoute){
		this.depSid = depSid;
		this .arrSid = arrSid;
		this.directBusRoute = directBusRoute;
	}

	@JsonProperty("dep_sid")
	public Integer getDepSid() {
		return depSid;
	}

	@JsonProperty("dep_sid")
	public void setDepSid(Integer depSid) {
		this.depSid = depSid;
	}

	@JsonProperty("arr_sid")
	public Integer getArrSid() {
		return arrSid;
	}

	@JsonProperty("arr_sid")
	public void setArrSid(Integer arrSid) {
		this.arrSid = arrSid;
	}

	@JsonProperty("direct_bus_route")
	public Boolean getDirectBusRoute() {
		return directBusRoute;
	}

	@JsonProperty("direct_bus_route")
	public void setDirectBusRoute(Boolean directBusRoute) {
		this.directBusRoute = directBusRoute;
	}

}