package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Missile;
import movies.spring.data.neo4j.domain.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author pp
 * @date 2019/10/22-11:33
 */

@RepositoryRestResource(collectionResourceRel = "missiles", path = "missiles")
public interface MissileRepository extends Neo4jRepository<Missile, Long> {
    Missile findByName(@Param("name") String name);
}
