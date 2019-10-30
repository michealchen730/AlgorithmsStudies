package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Test;
import movies.spring.data.neo4j.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private final TestService testService;
    public TestController(TestService testService) {
        this.testService=testService;
    }


    @GetMapping("/test4")
    public String test4(){
        Test test=new Test();
        test.setDate("20150506");
        test.setResult(true);
        test.setMissile("dongfen2");
        test.setSite("xindelijichang");
        test.setMode("fangshiyi");
        Test temp=testService.saveTest(test);
        if (temp!=null){
            return "success1";
        }else{
            return "fail";
        }
    }
}
