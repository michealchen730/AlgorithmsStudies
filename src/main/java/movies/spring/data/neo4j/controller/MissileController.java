package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Missile;
import movies.spring.data.neo4j.domain.Test;
import movies.spring.data.neo4j.services.MissileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pp
 * @date 2019/10/22-12:47
 */

@RestController
@RequestMapping("/")
public class MissileController {

    @Autowired
    private final MissileService missileService;

    public MissileController(MissileService missileService) {
        this.missileService=missileService;
    }

    @PostMapping("/search")
    public Missile searchMissile(String missileName){
        System.out.println(missileName);
        return missileService.findByName(missileName);
    }





    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/test2")
    public String test2(){
        Missile df = missileService.findByName("dongfen");
        if (df!=null){
            System.out.println(df.getLength());
            return "success";

        }else{
            return "fail";
        }
    }

    @GetMapping("/test233")
    public Missile test233(){
        Missile df = missileService.findByName("dongfen");
        return df;
    }


    @GetMapping("/test3")
    public String test3(){
        Missile df = new Missile();
        df.setName("pp");
        df.setLength(30);
        df.setWeight(30);
        df.setRange(30);
        Missile ms = missileService.saveMissile(df);
        if (ms!=null){
            return "success1";
        }else{
            return "fail";
        }
    }

    @GetMapping("/test5")
    public String test5(){
        Missile df = missileService.findByName("RNG");
        df.setLength(30);
        df.setWeight(30);
        df.setRange(30);
        Missile ms = missileService.saveMissile(df);
        if (ms!=null){
            return "success1";
        }else{
            return "fail";
        }
    }

    @GetMapping("/test6")
    public String test6(){
        Missile ms = missileService.updateMissile("RNG","range","10000");
        if (ms!=null){
            return "success1";
        }else{
            return "fail";
        }
    }


}
