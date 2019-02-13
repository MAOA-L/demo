package top.cyanzoy.security.bean;

import javax.persistence.*;

/**
 * top.cyanzoy.demo.bean
 * Create By 10993 on 2019/1/17 22:49
 */
@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    private String res_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }
}
