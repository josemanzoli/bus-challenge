package com.manzoli.bus.route.service;

import com.manzoli.bus.route.representation.DirectRouteResult;

public interface BusChallengeService {

	DirectRouteResult findDirectRoutesBetweenStations(Integer departureStationId, Integer arrivalStationId);

}
