package task7

import org.hibernate.cfg.Configuration

fun main() {
    val configuration = Configuration()
    configuration.configure("hibernate.cfg.xml")
    // OneToOne
    configuration.addAnnotatedClass(User::class.java)
    configuration.addAnnotatedClass(Address::class.java)

    // OneToMany
    configuration.addAnnotatedClass(Customer::class.java)
    configuration.addAnnotatedClass(Order::class.java)

    // ManyToMany
    configuration.addAnnotatedClass(Comment::class.java)
    configuration.addAnnotatedClass(Post::class.java)
    configuration.addAnnotatedClass(PostComment::class.java)

    val sessionFactory = configuration.buildSessionFactory()
    val session = sessionFactory.openSession()


    // -------------------------- OneToOne ----------------------------------------
    val address = Address()
    address.id = 1
    address.address = "idk"

    val user = User()
    user.id = 1;
    user.name = "Broken Angel"
    user.addressId = 1

    session.beginTransaction()
    session.save(address)
    session.save(user)
    session.transaction.commit()

    // -------------------------- OneToMany ----------------------------------------
    val customer = Customer()
    customer.id = 1
    customer.name = "idk"

    val order1 = Order()
    order1.id = 1
    order1.price = 100
    order1.customerId = 1

    val order2 = Order()
    order2.id = 2
    order2.price = 200
    order2.customerId = 1

    session.beginTransaction()
    session.save(customer)
    session.save(order1)
    session.save(order2)
    session.transaction.commit()

    // -------------------------- ManyToMany ----------------------------------------
    val post1 = Post()
    post1.id = 1
    post1.text = "idk1"

    val post2 = Post()
    post1.id = 2
    post1.text = "idk2"

    val comment1 = Comment()
    comment1.id = 1
    comment1.text = "COMMENT1"

    val comment2 = Comment()
    comment1.id = 2
    comment1.text = "COMMENT2"

    val postComment1 = PostComment()
    postComment1.id = 1
    postComment1.postId = 1 // first post
    postComment1.commentId = 2 // second comment

    val postComment2 = PostComment()
    postComment2.id = 2
    postComment2.postId = 2 // second post
    postComment2.commentId = 1 // first comment

    // etc...

    session.beginTransaction()
    session.save(post1)
    session.save(post2)
    session.save(comment1)
    session.save(comment2)
    session.save(postComment1)
    session.save(postComment2)
    session.transaction.commit()
}
