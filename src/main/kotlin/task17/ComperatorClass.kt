package task17

import io.restassured.response.Response
import org.testng.AssertJUnit

class ComperatorClass(private var response: Response?, private var fieldsToCheck: List<String>, private var valuesToCheck: List<*>) {
    fun validate() {
        if (response == null) throw Exception("response is null")
        if (fieldsToCheck.size != valuesToCheck.size) throw Exception("fields and values size is different")

        if (response!!.statusCode != 200 && response!!.statusCode != 201) assert(false)

        for (o in fieldsToCheck.indices) {
            AssertJUnit.assertEquals(response!!.jsonPath().get(fieldsToCheck[o]), valuesToCheck[o])
        }

        assert(true)
    }
}