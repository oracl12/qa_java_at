package task7

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

//create table post(
//  id int,
//  text varchar(255),
//  PRIMARY KEY(id)
//);

//create table comment(
//  id int,
//  text varchar(255),
//  PRIMARY KEY(id)
//);

//create table post_comment(
//  id int,
//  post_id int,
//  comment_id int,
//  PRIMARY KEY(id)
//  FOREIGN KEY (post_id) REFERENCES post(id),
//  FOREIGN KEY (comment_id) REFERENCES comment(id)
//);

@Entity
@Table(name = "post")
class Post {

    @Id
    @Column(name = "id")
    var id = 0

    @Column(name = "text")
    var text: String = ""
}

@Entity
@Table(name = "comment")
class Comment {
    @Id
    @Column(name = "id")
    var id = 0

    @Column(name = "text")
    var text: String = ""
}

@Entity
@Table(name = "post_comment")
class PostComment {
    @Id
    @Column(name = "id")
    var id = 0

    @Column(name = "post_id")
    var postId = 0

    @Column(name = "comment_id")
    var commentId = 0
}