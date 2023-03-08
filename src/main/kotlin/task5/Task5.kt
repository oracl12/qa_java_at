package task5

import java.io.File
import java.io.Serializable
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.util.Date


//{
//  "name": "Katie",
//  "birthdate": "1990-05-12",
//  "address":
//  {
//      "street": "123 Main St",
//      "city": "Denver",
//      "state": "CO"
//  }
//}

data class User(var name: String, var birthdate: Date, var address: Address) : Serializable
data class Address(var street: String, var city: String, var state: String) : Serializable

fun sortAddresses(address: MutableList<Address>): MutableList<Address> {
    val comparator = Comparator { o1: Address, o2: Address ->
        return@Comparator o1.state.length - o2.state.length
    }
    val copy = arrayListOf<Address>().apply { addAll(address) }
    copy.sortWith(comparator)
    return copy
}

fun main(){
    // First task
    val text = File("src\\main\\kotlin\\task5\\input.json").readText()
    val user = jacksonObjectMapper().readerFor(User::class.java).readValue<User>(text)
    user.address.street = "Some another street"
    user.name = "Some another name"
    val userJson = jacksonObjectMapper().writeValueAsString(user)
    File("src\\main\\kotlin\\task5\\output.json").writeText(userJson)

    // Second task
    val addresses = mutableListOf<Address>()
    for (i in 5..15) {
        addresses.add(Address("text$i", "city$i", "state$i"))
    }
    println(addresses.sortedBy { it.street })
    println(sortAddresses(addresses))
}