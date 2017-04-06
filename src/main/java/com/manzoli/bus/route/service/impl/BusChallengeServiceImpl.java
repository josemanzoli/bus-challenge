package com.manzoli.bus.route.service.impl;

import static com.manzoli.bus.route.service.to.BaseOutputTO.ERROR;
import static com.manzoli.bus.route.service.to.BaseOutputTO.MSG_ERROR;
import static com.manzoli.bus.route.service.to.BaseOutputTO.MSG_SUCCESS;
import static com.manzoli.bus.route.service.to.BaseOutputTO.SUCCESS;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manzoli.bus.route.domain.DirectRoute;
import com.manzoli.bus.route.domain.Route;
import com.manzoli.bus.route.domain.Station;
import com.manzoli.bus.route.representation.DirectRouteResult;
import com.manzoli.bus.route.service.BusChallengeService;
import com.manzoli.bus.route.service.DirectRouteService;
import com.manzoli.bus.route.service.StationService;
import com.manzoli.bus.route.service.to.BaseOutputTO;

@Service
@Transactional
public class BusChallengeServiceImpl implements BusChallengeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BusChallengeServiceImpl.class);

	@Autowired
	private DirectRouteService directRouteService;

	@Autowired
	private StationService stationService;

	@Transactional
	public BaseOutputTO saveRoute(DirectRoute directRoute) {
		LOGGER.debug(" Saving Direct Route {} ", directRoute);

		BaseOutputTO baseOutputTO;

		try {

			baseOutputTO = new BaseOutputTO(SUCCESS, MSG_SUCCESS);
		} catch (Exception e) {
			baseOutputTO = new BaseOutputTO(ERROR, MSG_ERROR + e.getMessage());
		}

		return baseOutputTO;
	}

	@Override
	public DirectRouteResult findDirectRoutesBetweenStations(Integer departureStationId, Integer arrivalStationId) {
		LOGGER.info("Searching direct routes between departure station = {} and arrival station ={}",
				departureStationId, arrivalStationId);

		Station departureStation = stationService.findById(departureStationId.longValue());

		Station arrivalStation = stationService.findById(arrivalStationId.longValue());

		// TODO: throws IdNotFoundException
		if (departureStation == null || arrivalStation == null) {
			return null;
		}

		Stream<DirectRoute> directRoutesDeparture = directRouteService.findAllByTo(departureStation);

		Stream<DirectRoute> directRoutesArrival = directRouteService.findAllByTo(arrivalStation);

		List<Route> routesDeparture = directRoutesDeparture.map(p -> p.getFrom()).collect(Collectors.toList());

		List<Route> routesArrival = directRoutesArrival.map(p -> p.getFrom()).collect(Collectors.toList());

		if (!Collections.disjoint(routesDeparture, routesArrival)) {
			return new DirectRouteResult(departureStationId, arrivalStationId, Boolean.TRUE);
		} else {
			return new DirectRouteResult(departureStationId, arrivalStationId, Boolean.FALSE);
		}
	}
}
