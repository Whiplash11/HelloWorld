package models;

import org.hibernate.criterion.Order;
import play.db.jpa.Model;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "JPA_CUSTOMER")
@Entity
public class Customer extends Model {
    @Id
    @Column(name = "jpa_id",nullable = false,unique = true,length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "jpa_last_name",length = 50,nullable = false)
    private String lastName;
    @Column(name = "jpa_age",length = 10,nullable = false)
    private Integer age;
    @Column(name = "jpa_email",length = 50,nullable = false)
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "jpa_createTime")
    private Date createTime;
    @Temporal(TemporalType.DATE)
    @Column(name = "jpa_birth")
    private Date birth;


    @OneToMany(fetch=FetchType.EAGER,cascade = {CascadeType.REMOVE},mappedBy = "customer",targetEntity = models.Order.class)
    private Set<Order> orders = new HashSet<Order>();

    public Set<Order> getOrder(){
        return orders;
    }


    @Transient
    public String getInfo(){
        return "lastName:" + lastName + ",email:" + email;
    }
    public Customer(Integer id,String lastName,String email,Integer age){
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
    @Override
    public String toString(){
        return "Customer [id = " + id + ",lastName = " + lastName + ",email = " + email + ",age = " + age + "]";
    }

}
