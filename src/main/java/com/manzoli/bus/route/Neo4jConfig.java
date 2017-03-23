package com.manzoli.bus.route;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT
 * Configuration to initialize and start the embedded graph database.
 *
 */
@org.springframework.context.annotation.Configuration
@EnableNeo4jRepositories(basePackages = "com.manzoli.bus.route.repository")
@EnableTransactionManagement
public class Neo4jConfig {

	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
	   Configuration config = new Configuration();
	   config
	       .driverConfiguration()
	       .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
	       .setURI("http://neo4j:neo4j@neo4j-database:7474");
	   return config;
	}

	@Bean
	public SessionFactory sessionFactory() {
	    return new SessionFactory(configuration(), "com.manzoli.bus.route.domain");
	}

}
