package com.manzoli.bus.route.service;

import java.util.stream.Stream;

import com.manzoli.bus.route.domain.DirectRoute;
import com.manzoli.bus.route.domain.Route;
import com.manzoli.bus.route.domain.Station;

public interface DirectRouteService {

	Stream<DirectRoute> findAllByFrom(Route from);

	Stream<DirectRoute> findAllByTo(Station to);

}
