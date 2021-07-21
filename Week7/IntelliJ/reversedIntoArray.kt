
fun main(args: Array<String>) {

    convertInt2Array(983892)
    convertInt2Array(4355)


}


fun convertInt2Array(userNumber: Int): Unit {
    var temp: Int = userNumber
    //Store the UserNumber inputs
    val array = ArrayList<Int>()
    // We initialize an empty Integer Array
    do {
        array.add(temp % 10)
        temp /= 10
         } while (temp > 0)
         // We get the modulus of each input digit as we add them into the array variable
         // we divide the temp value by 10
         // and this process will continue as long the temp value is greater than zero
    println(array)
    // we print the Array
}
