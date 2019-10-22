package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "Missile")
public class Missile {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;
    /*private String name_ch; //中文名
    private String name_eng; //英文名*/
    @Property(name = "length")
    private int length; //导弹长度(米)
    @Property(name = "weight")
    private int weight; //导弹重量(吨)
    @Property(name = "range")
    private int range; //射程(公里)

/*    private float warheads; //弹头当量(万吨)
    private String country_dev; //研制国家
    private String organization_dev; //研制组织
    private String date_dev; //研制时间
    private String date_test; //试射时间
    private String date_prod; //生产时间
    private String mode_lan; //发射方式
    private int number_war; //弹头数量
    private String troops_ser; //服役军队*/

    //导弹是主语，试验是宾语，TRIAL_RUN表示关系
    @Relationship(type = "TRIAL_RUN")
    private List<Test> tests;


    public Missile() {
    }

    public Missile(Long id, String name,  int length, int weight, int range) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.weight = weight;
        this.range = range;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void addTest(Test test) {
        if (this.tests == null) {
            this.tests = new ArrayList<>();
        }
        this.tests.add(test);
    }
}
