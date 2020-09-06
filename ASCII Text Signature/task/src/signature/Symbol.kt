package signature

class Symbol(private val width: Int = 0, private val raster: Array<String> = arrayOf("")) {

    fun getWidth() = width

    fun getRasterLine(line: Int): String = raster[line]

}