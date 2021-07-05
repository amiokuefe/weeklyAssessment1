fun main(args: Array<String>) {
    val text = "Hello World!"

    println( "Original text: " + text )

    println( "Remove vowels: %s".format( removeVowels(text) ) )
}

fun removeVowels( text: String ): String {
    val ignoreCase = true
    return text.filter {
            c -> "aeiou".indexOf(c, 0, ignoreCase) == -1
    }
}