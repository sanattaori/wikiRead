package sanattaori.speedev.com.wikiread.models

object Urls {
    val BaseUrl = "https://en.wikipedia.org/w/api.php"

    fun getSearchUrl(term: String, skip: Int, take: Int): String{
        return BaseUrl + "?action=query" +
                "action=query" +
                "&generator=prefixsearch" +
                "&gpssearch=$term" +
                "&gpslimit=$take" +
                "&gpsoffset=$skip" +
                "&prop=pageimages|info" +
                "piprop=thumbnail|url" +
                "&pithumbsize=200" +
                "&pilimit=$take" +
                "&wbpatterms=description" +
                "&inprop=url" +
                "&format=json" +
                "&formatversion=2"
    }

    fun getRandomUrl(take: Int) :String {
        return BaseUrl + "?format=json" +
                "&action=query" +
                "&generator=random" +
                "&grnnamespace=0" +
                "&prop=pageimages|info" +
                "formatversion=2" +
                "&inprop=url" +
                "&grnlimit=$take" +
                "&pithumbsize=200"
    }

}