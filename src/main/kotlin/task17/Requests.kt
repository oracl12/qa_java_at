package task17

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.Response

data class BaseInfo(var key: String, var token: String)

open class CreateCard(private var listId: String, private var cardName: String, private var baseInfo: BaseInfo) {
    fun sendRequest(): Response? {
        return RestAssured.given()
            .queryParam("key", baseInfo.key)
            .queryParam("token", baseInfo.token)
            .queryParam("idList", listId)
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
    }
}

open class AddComment(private var cardId: String, private var commentText: String, private var baseInfo: BaseInfo) {
    fun sendRequest(): Response? {
        return RestAssured.given()
            .queryParam("key", baseInfo.key)
            .queryParam("token", baseInfo.token)
            .queryParam("text", commentText)
            .contentType(ContentType.JSON)
            .`when`()
            .post("/cards/$cardId/actions/comments")
            .then()
            .extract().response()
    }
}

open class UpdateComment(private var commentId: String, private var updatedCommentText: String, private var baseInfo: BaseInfo) {
    fun sendRequest(): Response? {
        return RestAssured.given()
            .queryParam("key", baseInfo.key)
            .queryParam("token", baseInfo.token)
            .queryParam("text", updatedCommentText)
            .contentType(ContentType.JSON)
            .`when`()
            .put("/actions/$commentId")
            .then()
            .extract().response()
    }
}

open class DeleteComment(private var commentId: String, private var baseInfo: BaseInfo) {
    fun sendRequest(): Response? {
        return RestAssured.given()
            .queryParam("key", baseInfo.key)
            .queryParam("token", baseInfo.token)
            .contentType(ContentType.JSON)
            .`when`()
            .delete("/actions/$commentId")
            .then()
            .extract().response()
    }
}