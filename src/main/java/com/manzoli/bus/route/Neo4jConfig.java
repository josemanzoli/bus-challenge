package com.manzoli.bus.route;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT
 * Configuration to initialize and start the embedded graph database.
 *
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.manzoli.bus.route.repository")
public class Neo4jConfig extends Neo4jConfiguration{


	public Neo4jConfig() {
        setBasePackage("com.manzoli.bus.route.domain");
    }

    @Bean
    GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("tmpNeo4j.db");
    }
	
}
