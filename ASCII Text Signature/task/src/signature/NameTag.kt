package signature

class NameTag(name: String = "Jane Doe", title: String = "Placeholder") {
    private var nameFont = TypeFace("G:/roman.txt")
    private var titleFont = TypeFace("G:/medium.txt")

    private val nameField: List<String> = nameFont.getRaster(name)
    private val titleField = titleFont.getRaster(title)
    private val maxWidth = nameField[0].length.coerceAtLeast(titleField[0].length)

    private var verticalBorderWidth = 2
    private var border = "8"

    private val minPadding = 2
    private val padding = " "

    private val paddedNameField = getPaddedField(nameField)
    private val paddedTitleField = getPaddedField(titleField)
    private val horizontalBorder = getHorizontalBorder()
    private val tagField = getTagField()

    private fun getTagField(): List<String> {
        val composedTag = ArrayList<String>()
        composedTag.add(horizontalBorder)
        for (line in paddedNameField) {
            composedTag.add(line)
        }
        for (line in paddedTitleField) {
            composedTag.add(line)
        }
        composedTag.add(horizontalBorder)
        return composedTag
    }

    private fun getHorizontalBorder(): String {
        return border.repeat(verticalBorderWidth * 2 + minPadding * 2 + maxWidth)
    }

    private fun getPaddedField(list: List<String>): List<String> {
        val paddedList = ArrayList<String>()
        for (line in list) {
            paddedList.add(getPaddedLine(line))
        }
        return paddedList
    }

    private fun getPaddedLine(string: String): String {
        val extraPaddingLeft = getExtraPaddingLeft(string)
        val extraPaddingRight = getExtraPaddingRight(string)

        return border.repeat(verticalBorderWidth) + padding.repeat(minPadding) +
                padding.repeat(extraPaddingLeft) + string + padding.repeat(extraPaddingRight) +
                padding.repeat(minPadding) + border.repeat(verticalBorderWidth)
    }

    private fun getExtraPaddingLeft(string: String): Int {
        return if (string.length < maxWidth) {
            if (maxWidth % 2 == 0 && string.length % 2 != 0) {
                maxWidth / 2 - string.length / 2 - 1
            } else {
                maxWidth / 2 - string.length / 2
            }
        } else {
            0
        }
    }

    private fun getExtraPaddingRight(string: String): Int {
        return if (string.length < maxWidth) {
            if (maxWidth % 2 != 0 && string.length % 2 == 0) {
                maxWidth / 2 - string.length / 2 + 1
            } else {
                maxWidth / 2 - string.length / 2
            }
        } else {
            0
        }
    }

    fun print() {
        for (line in tagField) {
            println(line)
        }
    }
}