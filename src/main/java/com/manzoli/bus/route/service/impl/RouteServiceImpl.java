package com.manzoli.bus.route.service.impl;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manzoli.bus.route.domain.DirectRoute;
import com.manzoli.bus.route.domain.Route;
import com.manzoli.bus.route.repository.RouteRepository;
import com.manzoli.bus.route.service.RouteService;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

	
	@Autowired
	private RouteRepository routeRepository;
	
	@Transactional
	public Route saveRoute(Long id, Set<DirectRoute> stations){
		Route route = routeRepository.findById(id);
		if (route != null){
			return route;
		}
		return routeRepository.save(new Route(id, stations));
	}
	
	@Transactional
	public Route saveRoute(Route route){
		return routeRepository.save(route);
	}
	
	public Route findById(Long id){
		return routeRepository.findById(id);
	}
	
	public Iterable<Route> findAll(){
		return routeRepository.findAll();
	}
}
