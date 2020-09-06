package signature

fun main() {

    print("Enter your name: ")
    val name = readLine()!!

    print("Enter your title: ")
    val title = readLine()!!
    
    val tag = NameTag(name, title)
    tag.print()

}
