package task17

import io.restassured.RestAssured
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class TrelloApiTests {

    private val apiKey = "api token"
    private val apiToken = "api token"
    private val boardId = "6447c860a8ed12e4e278c983"
    private val cardName = "Test Card"
    private var cardId: String? = null
    private var commentId: String? = null
    private var baseInfo: BaseInfo = BaseInfo(apiKey, apiToken)

    @BeforeClass
    fun setUp() {
        RestAssured.baseURI = "https://api.trello.com/1"
    }

    @Test(priority = 1)
    fun createNewCard() {
        val response = CreateCard(boardId, cardName, baseInfo).sendRequest()

        ComperatorClass(response, listOf("name"), listOf(cardName)).validate()
        cardId = response!!.jsonPath().get("id")
    }

    @Test(priority = 2)
    fun addCommentToCard() {
        val commentText = "Test Comment"
        val response = cardId?.let { AddComment(it, commentText, baseInfo).sendRequest() }

        ComperatorClass(response, listOf("data.text"), listOf(commentText)).validate()
        commentId = response!!.jsonPath().get("id")
    }

    @Test(priority = 3)
    fun updateCommentText() {
        val updatedCommentText = "Updated Test Comment"
        val response = commentId?.let { UpdateComment(it, updatedCommentText, baseInfo).sendRequest() }

        ComperatorClass(response, listOf("data.text"), listOf(updatedCommentText)).validate()
    }

    @Test(priority = 4)
    fun deleteComment() {
        val response = commentId?.let { DeleteComment(it, baseInfo).sendRequest() }

        ComperatorClass(response, listOf("_value"), listOf(null)).validate()
    }
}