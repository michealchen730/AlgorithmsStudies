package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Test;
import movies.spring.data.neo4j.repositories.TestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final static Logger LOG = LoggerFactory.getLogger(TestService.class);


    @Autowired
    private final TestRepository testRepository;
    public TestService(TestRepository testRepository){this.testRepository=testRepository;}


    public Test saveTest(Test test){ return testRepository.save(test); }


}
