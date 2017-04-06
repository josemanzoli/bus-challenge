package com.manzoli.bus.route.service;

import com.manzoli.bus.route.domain.Station;

public interface StationService {

	Station findById(Long id);

	Station saveStation(Long id);

	Station saveStation(Station station);

}
