package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
 * 试射记录
 */
public class Test {
    @Id
    @GeneratedValue
    private Long id;
    private String missile; //试射导弹
    private String date; //试射时间
    private String mode; //试射方式
    private String site; //试射场地
    private boolean result; //试射结果

    public Test() {
    }

    public Test(Long id, String missile, String date, String mode, String site, boolean result) {
        this.id = id;
        this.missile = missile;
        this.date = date;
        this.mode = mode;
        this.site = site;
        this.result = result;
    }
}
