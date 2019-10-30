package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * 试射记录
 */

@NodeEntity(label = "Test")
public class Test {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "missile")
    private String missile; //试射导弹
    @Property(name = "date")
    private String date; //试射时间
    @Property(name = "mode")
    private String mode; //试射方式
    @Property(name = "site")
    private String site; //试射场地
    @Property(name = "result")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMissile() {
        return missile;
    }

    public void setMissile(String missile) {
        this.missile = missile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
