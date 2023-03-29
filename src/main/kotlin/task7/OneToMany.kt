package task7

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

//create table customer(
//  id int,
//  name varchar(255),
//  PRIMARY KEY(id)
//);

//create table order(
//  id int,
//  price int,
//  customer_id int,
//  PRIMARY KEY(id),
//  FOREIGN KEY (customer_id) REFERENCES customer(id)
//);


@Entity
@Table(name = "customer")
class Customer {

    @Id
    @Column(name = "id")
    var id = 0

    @Column(name = "name")
    var name: String = ""
}

@Entity
@Table(name = "order")
class Order {
    @Id
    @Column(name = "id")
    var id = 0

    @Column(name = "price")
    var price: Int = 0

    @Column(name = "customer_id")
    var customerId: Int = 0
}