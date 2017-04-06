package com.manzoli.bus.route.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manzoli.bus.route.domain.Station;
import com.manzoli.bus.route.repository.StationRepository;
import com.manzoli.bus.route.service.StationService;

@Service
@Transactional
public class StationServiceImpl implements StationService {

	@Autowired
	private StationRepository stationRepository;
	
	@Override
	@Transactional
	public Station saveStation(Long id){
		Station station = stationRepository.findById(id);
		if (station != null){
			return station;
		}
		return stationRepository.save(new Station(id));
	}
	
	@Override
	@Transactional
	public Station saveStation(Station station){
		return stationRepository.save(station);
	}
	
	@Override
	public Station findById(Long id){
		return stationRepository.findById(id);
	}
}
