package com.manzoli.bus.route.service.impl;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manzoli.bus.route.domain.DirectRoute;
import com.manzoli.bus.route.domain.Route;
import com.manzoli.bus.route.domain.Station;
import com.manzoli.bus.route.repository.DirectRouteRepository;
import com.manzoli.bus.route.service.DirectRouteService;

@Service
@Transactional
public class DirectRouteServiceImpl implements DirectRouteService {

	@Autowired
	private DirectRouteRepository directRouteRepository;

	@Override
	@Transactional
	public Stream<DirectRoute> findAllByFrom(Route from) {
		return directRouteRepository.findAllByFrom(from);
	}

	@Override
	@Transactional
	public Stream<DirectRoute> findAllByTo(Station to) {
		return directRouteRepository.findAllByTo(to);
	}

}
