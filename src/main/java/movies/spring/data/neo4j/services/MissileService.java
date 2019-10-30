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

import java.util.List;

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

    /**
     * 导弹节点的保存操作
     * @param missile
     * @return
     */
    public Missile saveMissile(Missile missile){
        return missileRepository.save(missile);
    }

    /**
     * 导弹节点的保存操作（只给导弹名称）
     * @param missileName
     * @return
     */
    public Missile saveMissileByName(String missileName){
        Missile missile=new Missile();
        missile.setName(missileName);
        return missileRepository.save(missile);
    }

    /**
     * 导弹节点的批量保存操作（只给导弹名称的列表）
     * @param nameList
     */
    public void saveAllMissileByNameList(List<String> nameList){
        for (String missileName:nameList) {
            saveMissileByName(missileName);
        }
    }

    /**
     * 更新节点的属性
     * @param missileName
     * @param relationship
     * @param updateValue
     * @return
     */
    public Missile updateMissile(String missileName,String relationship,String updateValue){
        Missile missile=missileRepository.findByName(missileName);
        switch (relationship){
            case "length":
                missile.setLength(Integer.parseInt(updateValue));
                break;
            case "range":
                missile.setRange(Integer.parseInt(updateValue));
                break;
            case "weight":
                missile.setWeight(Integer.parseInt(updateValue));
                break;
            default:
        }
        return missileRepository.save(missile);
    }

}
