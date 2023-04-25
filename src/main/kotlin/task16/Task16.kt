package task16

import io.restassured.RestAssured
import io.restassured.RestAssured.*
import io.restassured.http.ContentType
import org.testng.AssertJUnit.assertEquals
import org.testng.AssertJUnit.assertNull
import org.testng.annotations.*

class TrelloApiTests {

    private val apiKey = "api key"
    private val apiToken = "apikoken"
    private val boardId = "6447c860a8ed12e4e278c983"
    private val cardName = "Test Card"
    private var cardId: String? = null
    private var commentId: String? = null

    @BeforeClass
    fun setUp() {
        RestAssured.baseURI = "https://api.trello.com/1"
    }

    @Test(priority = 1)
    fun createNewCard() {
        val response = given()
            .queryParam("key", apiKey)
            .queryParam("token", apiToken)
            .queryParam("idList", boardId)
            .`when`()
            .body("{\n" +
                    "    \"name\": \"$cardName\",\n" +
                    "    \"description\": \"none\",\n" +
                    "    \"pos\": \"top\"\n" +
                    "}")
            .contentType(ContentType.JSON)
            .post("/cards")
            .then()
            .extract().response()

        assertEquals(response.statusCode, 200)
        cardId = response.jsonPath().get("id")
        assertEquals(response.jsonPath().get("name"), cardName)
    }

    @Test(priority = 2)
    fun addCommentToCard() {
        val commentText = "Test Comment"
        val response = given()
            .queryParam("key", apiKey)
            .queryParam("token", apiToken)
            .queryParam("text", commentText)
            .contentType(ContentType.JSON)
            .`when`()
            .post("/cards/$cardId/actions/comments")
            .then()
            .extract().response()

        assertEquals(response.statusCode, 200)
        commentId = response.jsonPath().get("id")
        assertEquals(response.jsonPath().get("data.text"), commentText)
    }

    @Test(priority = 3)
    fun updateCommentText() {
        val updatedCommentText = "Updated Test Comment"
        val response = given()
            .queryParam("key", apiKey)
            .queryParam("token", apiToken)
            .queryParam("text", updatedCommentText)
            .contentType(ContentType.JSON)
            .`when`()
            .put("/actions/$commentId")
            .then()
            .extract().response()

        assertEquals(response.statusCode, 200)
        assertEquals(response.jsonPath().get("data.text"), updatedCommentText)
    }

    @Test(priority = 4)
    fun deleteComment() {
        val response = given()
            .queryParam("key", apiKey)
            .queryParam("token", apiToken)
            .contentType(ContentType.JSON)
            .`when`()
            .delete("/actions/$commentId")
            .then()
            .extract().response()

        assertEquals(response.statusCode, 200)
        assertNull(response.jsonPath().get("_value"))
    }
}