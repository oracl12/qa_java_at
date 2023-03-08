package task6

import org.hibernate.cfg.Configuration
import java.time.LocalDate

fun main() {
    val configuration = Configuration()
    configuration.configure("hibernate.cfg.xml")
    configuration.addAnnotatedClass(User::class.java)
    configuration.addAnnotatedClass(Address::class.java)

    val sessionFactory = configuration.buildSessionFactory()
    val session = sessionFactory.openSession()

    // CREATE OBJECTS

    val address1 = Address()
    address1.id = 1
    address1.city = "lviv"
    address1.state = "Ukraine"
    address1.street = "idk"

    val user1 = User()

    user1.id = 1;
    user1.name = "Broken Angel";
    user1.birthDate = java.sql.Date.valueOf(LocalDate.now())
    user1.addressId = 1

    session.beginTransaction()
    session.save(address1)
    session.save(user1)
    session.transaction.commit()
    // READ OBJECT
    val gottenUser = session.get(User::class.java, 1) as User
    println("Got User object: ")
    println("id: ${gottenUser.id}")
    println("name: ${gottenUser.name}")

    // UPDATE OBJECT
    gottenUser.name = "NEW COOL NAME"
    session.save(gottenUser)
    val reGottenUser = session.get(User::class.java, 1) as User
    println("Got Updated User object: ")
    println("id: ${reGottenUser.id}")
    println("name: ${reGottenUser.name}")

    // DELETE OBJECT
    session.delete(reGottenUser)
    try {
        session.get(User::class.java, 1) as User
    }
    catch (e: NullPointerException){
        println("User do not exists")
    }
}
