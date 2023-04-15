package io.github.reskimulud.testtrinity.data

import android.content.Context
import io.github.reskimulud.testtrinity.R
import io.github.reskimulud.testtrinity.model.Contact
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object ContactsData {
    private val contacts = ArrayList<Contact>()

    private fun loadJsonArray(context: Context): JSONArray? {
        val builder = StringBuilder()
        val `in` = context.resources.openRawResource(R.raw.data)
        val reader = BufferedReader(InputStreamReader(`in`))
        var line: String?
        try {
            while (reader.readLine().also { line = it } != null) {
                builder.append(line)
            }
            val json = JSONObject(builder.toString())
            return json.getJSONArray("contacts")
        } catch (exception: IOException) {
            exception.printStackTrace()
        } catch (exception: JSONException) {
            exception.printStackTrace()
        }
        return null
    }

    fun getData(context: Context): ArrayList<Contact> {
        val jsonArray = loadJsonArray(context)
        try {
            if (jsonArray != null) {
                for (i in 0 until jsonArray.length()) {
                    val item = jsonArray.getJSONObject(i)
                    contacts.add(
                        Contact(
                            item.getString("id"),
                            item.getString("firstName"),
                            item.getString("lastName"),
                        )
                    )
                }
            }
        } catch (exception: JSONException) {
            exception.printStackTrace()
        }

        return contacts
    }
}