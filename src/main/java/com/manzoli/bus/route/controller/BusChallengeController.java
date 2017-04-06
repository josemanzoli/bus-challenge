package com.manzoli.bus.route.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manzoli.bus.route.representation.ApplicationVersion;
import com.manzoli.bus.route.service.BusChallengeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT
 * 
 */
@Controller
@RequestMapping(path = "/api")
@Api(value = "api")
public class BusChallengeController {
	
	@Autowired
	private BusChallengeService busChallengeService;

	/**
	 * @param dep_sid
	 *            - Departure Station Id
	 * @param arr_sid
	 *            - Arrival Station Id
	 * @return 200 {@link DirectRouteResult} the result if there is a direct
	 *         Route between the departure Station and the arrival Station
	 * @return 404 - if there is a Station id not found
	 * @return 500 - if some unrecognized error occurs.
	 */
	@GetMapping(path = "/direct/{dep_sid}&{arr_sid}", produces = "application/json")
	@ResponseBody
	@ApiOperation(value = "Used to get if there is a direct route between two stations", response = ResponseEntity.class, httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "DirectRouteResult"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<String> directRouteResult(@PathVariable("dep_sid") Integer departureStationid,
			@PathVariable("arr_sid") Integer arrivalStationId) {
		String directRouteResult = null;
		// try {
		//
		// } catch (IdNotFoundException i) {
		// return
		// ResponseEntity.status(HttpStatus.NOT_FOUND).body(i.getMessage());
		// }

		return ResponseEntity.status(HttpStatus.OK).body(directRouteResult);
	}

	/**
	 * @return the build information about the project
	 */
	@GetMapping(path = "/version", produces = "application/json")
	@ResponseBody
	@ApiOperation(value = "Return the version of the project.", response = ApplicationVersion.class, httpMethod = "GET")
	public ApplicationVersion checkVersion() {
		return new ApplicationVersion();
	}
}
