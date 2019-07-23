package models;


import play.db.jpa.Model;

import javax.persistence.*;

@Table(name = "jpa_order")
@Entity
public class Order extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String orderName;
    @JoinColumn(name = "customer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;


    public Order(Integer id,String orderName,Customer customer){
        super();
        this.id = id;
        this.orderName = orderName;
        this.customer = customer;
    }
    public Order(){
        super();
    }
    @Override
    public String toString(){
        return "Order [id = " + id + ",orderName = " + orderName + "]";
    }
}
