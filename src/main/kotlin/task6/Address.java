package task6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//create table address(
//        id int,
//        street varchar(255),
//        city varchar(255),
//        state varchar(255),
//        PRIMARY KEY(id)
//        );

@Entity
@Table(name = "address")
public class Address {
    @Id @Column(name = "id") int id;
    @Column(name = "street") String street;
    @Column(name = "city") String city;
    @Column(name = "state") String state;
}