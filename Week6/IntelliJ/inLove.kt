fun main(args: Array<String>) {
    println("Is this Couple in Love?: " + inLove(1,4))
    println("Is this Couple in Love?: " + inLove(6,4))
}

fun inLove(flower1Petal:Int, flower2Petal:Int): Boolean {
    return (flower1Petal + flower2Petal) % 2 === 1;
}