package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Missile {
    @Id
    @GeneratedValue
    private Long id;
    private String name_ch; //中文名
    private String name_eng; //英文名
    private int length; //导弹长度(米)
    private int weight; //导弹重量(吨)
    private int range; //射程(公里)
    private float warheads; //弹头当量(万吨)
    private String country_dev; //研制国家
    private String organization_dev; //研制组织
    private String date_dev; //研制时间
    private String date_test; //试射时间
    private String date_prod; //生产时间
    private String mode_lan; //发射方式
    private int number_war; //弹头数量
    private String troops_ser; //服役军队



}
