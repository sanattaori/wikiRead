package sanattaori.speedev.com.wikiread.providers

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Handler
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import sanattaori.speedev.com.wikiread.models.Urls
import sanattaori.speedev.com.wikiread.models.WikiResult
import java.io.Reader

class ArticleDataProvider {

    init {
        FuelManager.instance.baseHeaders = mapOf("User-Agent" to "Test User")
    }

    fun search(term: String, skip: Int, take: Int,responseHandler: (result: WikiResult) -> Unit?){
        Urls.getSearchUrl(term,skip,take).httpGet()
                .responseObject(WikiReadDataDeserializer()){
                    _, _, result->

                    val(data, _) = result
                    responseHandler.invoke(data as WikiResult)
                }
    }

    fun getRandom(take: Int, responseHandler: (result: WikiResult) -> Unit?) {
        Urls.getRandomUrl(take).httpGet()
                .responseObject(WikiReadDataDeserializer()){
                    _, res, result->

                    if (res.httpStatusCode != 200) {
                        throw Exception("Unable to get articles")
                    }

                    val(data, _) = result
                    responseHandler.invoke(data as WikiResult)

                }
    }

    class WikiReadDataDeserializer : ResponseDeserializable<WikiResult> {
        override fun deserialize(reader: Reader): WikiResult? {
            return Gson().fromJson(reader, WikiResult::class.java);
        }
    }
}