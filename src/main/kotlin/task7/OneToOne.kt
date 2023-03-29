package task7

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

//create table address(
//  id int,
//  address varchar(255),
//  PRIMARY KEY(id)
//);

//create table user(
//  id int,
//  name varchar(255),
//  address_id int,
//  PRIMARY KEY(id),
//  FOREIGN KEY (address_id) REFERENCES address(id)
//);


@Entity
@Table(name = "user")
class User {

    @Id
    @Column(name = "id")
    var id = 0

    @Column(name = "name")
    var name: String? = null

    @Column(name = "address_id")
    var addressId = 0
}

@Entity
@Table(name = "address")
class Address {
    @Id
    @Column(name = "id")
    var id = 0

    @Column(name = "address")
    var address: String? = null
}