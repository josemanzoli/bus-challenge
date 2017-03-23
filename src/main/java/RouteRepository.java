

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.manzoli.bus.route.domain.Route;

/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT 
 * Basic repository for the Route entity
 *
 */
@Repository
public interface RouteRepository extends GraphRepository<Route> {

}
