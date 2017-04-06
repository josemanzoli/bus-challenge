package com.manzoli.bus.route.service.impl;

import static com.manzoli.bus.route.service.to.BaseOutputTO.ERROR;
import static com.manzoli.bus.route.service.to.BaseOutputTO.MSG_ERROR;
import static com.manzoli.bus.route.service.to.BaseOutputTO.MSG_SUCCESS;
import static com.manzoli.bus.route.service.to.BaseOutputTO.SUCCESS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manzoli.bus.route.domain.DirectRoute;
import com.manzoli.bus.route.repository.DirectRouteRepository;
import com.manzoli.bus.route.repository.RouteRepository;
import com.manzoli.bus.route.repository.StationRepository;
import com.manzoli.bus.route.service.BusChallengeService;
import com.manzoli.bus.route.service.DirectRouteService;
import com.manzoli.bus.route.service.RouteService;
import com.manzoli.bus.route.service.StationService;
import com.manzoli.bus.route.service.to.BaseOutputTO;

@Service
@Transactional
public class BusChallengeServiceImpl implements BusChallengeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BusChallengeServiceImpl.class);
	
	@Autowired
	private DirectRouteService directRouteService;
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private StationService stationService;
	

	@Transactional
	public BaseOutputTO saveRoute(DirectRoute directRoute){
		LOGGER.debug(" Saving Direct Route {} ", directRoute);
		
		BaseOutputTO baseOutputTO;
		
		try {
			
			baseOutputTO = new BaseOutputTO(SUCCESS, MSG_SUCCESS);
		} catch (Exception e) {
			baseOutputTO = new BaseOutputTO(ERROR, MSG_ERROR + e.getMessage());
		}
		
		return baseOutputTO;
	}
}
