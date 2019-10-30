package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Test;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tests", path = "tests")
public interface TestRepository extends Neo4jRepository<Test,Long> {
}
