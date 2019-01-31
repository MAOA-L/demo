package top.cyanzoy.demo.bean;

import javax.persistence.*;

/**
 * top.cyanzoy.demo.bean
 * Create By 10993 on 2019/1/17 22:45
 */

@Entity
@Table(name = "role_resource")
public class Role_Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer rid;

    private Integer resid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getResid() {
        return resid;
    }

    public void setResid(Integer resid) {
        this.resid = resid;
    }
}
