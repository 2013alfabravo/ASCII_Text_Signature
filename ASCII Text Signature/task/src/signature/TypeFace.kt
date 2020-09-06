package signature

import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class TypeFace(filename: String) {
    private val charMap = HashMap<Char, Symbol>()
    private val height: Int

    init {
        val scanner = Scanner(File(filename))

        height = scanner.nextInt()
        val totalCount = scanner.nextLine().trim().toInt()

        repeat(totalCount) {
            val id = scanner.next().first()
            val width = scanner.nextLine().trim().toInt()
            val array = Array(height) { "" }

            for (i in 0 until height) {
                array[i] = scanner.nextLine()
            }

            charMap[id] = Symbol(width, array)
        }

        // adding the blank space character which has the same width as 'a'
        val spaceWidth = charMap['a']?.getWidth() ?: 0
        charMap[' '] = Symbol(spaceWidth, Array(height) { " ".repeat(spaceWidth) } )

        scanner.close()
    }

    fun getRaster(string: String): List<String> {
        val rasterArray = ArrayList<String>()
        for (i in 0 until height) {
            var rasterLine = ""
            for (letter in string) {
                rasterLine += charMap[letter]?.getRasterLine(i) ?: ""
            }
            rasterArray.add(rasterLine)
        }
        return rasterArray
    }
}