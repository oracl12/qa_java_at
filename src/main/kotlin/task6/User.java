package task6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//create table user(
//        id int,
//        name varchar(255),
//        birthDate DATE,
//        addressId int,
//        PRIMARY KEY(id),
//        FOREIGN KEY (addressId) REFERENCES address(id)
//        );

@Entity
@Table(name = "user")
public class User {

    @Id @Column(name = "id") int id;
    @Column(name = "name") String name;
    @Column(name = "birthDate") Date birthDate;
    @Column(name = "addressId") int addressId;

}