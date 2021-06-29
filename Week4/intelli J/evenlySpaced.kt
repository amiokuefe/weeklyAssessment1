fun main(args: Array<String>) {
    println(evenlySpaced(2,5,6))
}

fun evenlySpaced(a:Int, b:Int, c:Int):Boolean{
    var diff1:Int = 0;
    var diff2:Int = 0;
    var diff3:Int = 0;

    if (a==b && a==c)
        return true;

    if (a==b || b==c || a==c)
        return false

    diff1 = Math.abs(a-b)
    diff2 = Math.abs(a-c)
    diff3 = Math.abs(b-c)

    if (diff1 == diff2)
        return true
    if (diff1 == diff3)
        return true
    if (diff2 == diff3)
        return true
    return false

}