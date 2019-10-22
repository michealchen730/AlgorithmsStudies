package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Missile;
import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.repositories.MissileRepository;
import movies.spring.data.neo4j.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pp
 * @date 2019/10/22-12:33
 */
@Service
public class MissileService {

    private final static Logger LOG = LoggerFactory.getLogger(MissileService.class);

    @Autowired
    private final MissileRepository missileRepository;
    public MissileService(MissileRepository missileRepository) {
        this.missileRepository = missileRepository;
    }
    @Transactional(readOnly = true)
    public Missile findByName(String name) {
        Missile result = missileRepository.findByName(name);
        return result;
    }

    public Missile saveMissile(Missile missile){
        return missileRepository.save(missile);
    }
}
