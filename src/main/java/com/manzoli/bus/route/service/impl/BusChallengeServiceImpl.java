package com.manzoli.bus.route.service.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manzoli.bus.route.domain.DirectRoute;
import com.manzoli.bus.route.domain.Route;
import com.manzoli.bus.route.domain.Station;
import com.manzoli.bus.route.repository.DirectRouteRepository;
import com.manzoli.bus.route.repository.StationRepository;
import com.manzoli.bus.route.representation.DirectRouteResult;
import com.manzoli.bus.route.service.BusChallengeService;

@Service
public class BusChallengeServiceImpl implements BusChallengeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BusChallengeServiceImpl.class);

	@Autowired
	private DirectRouteRepository directRouteRepository;

	@Autowired
	private StationRepository stationRepository;

	@Override
	public DirectRouteResult findDirectRoutesBetweenStations(Integer departureStationId, Integer arrivalStationId) {
		LOGGER.info("Searching direct routes between departure station = {} and arrival station ={}",
				departureStationId, arrivalStationId);

		Station departureStation = stationRepository.findById(departureStationId.longValue());

		Station arrivalStation = stationRepository.findById(arrivalStationId.longValue());

		// TODO: throws IdNotFoundException
		if (departureStation == null || arrivalStation == null) {
			return null;
		}

		Set<DirectRoute> directRoutesDeparture = new HashSet<>();
		directRoutesDeparture = directRouteRepository.findAllByTo(departureStation);

		Set<DirectRoute> directRoutesArrival = new HashSet<>();
		directRoutesArrival = directRouteRepository.findAllByTo(arrivalStation);

		List<Route> routesDeparture = directRoutesDeparture.stream().map(p -> p.getFrom()).collect(Collectors.toList());

		List<Route> routesArrival = directRoutesArrival.stream().map(p -> p.getFrom()).collect(Collectors.toList());

		if (!Collections.disjoint(routesDeparture, routesArrival)) {
			return new DirectRouteResult(departureStationId, arrivalStationId, Boolean.TRUE);
		} else {
			return new DirectRouteResult(departureStationId, arrivalStationId, Boolean.FALSE);
		}
	}
}
