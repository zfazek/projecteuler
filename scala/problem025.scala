object a extends Application {
    override def main(args: Array[String]) {
        var a = BigInt(1)
        var b = BigInt(1)
        var n = a + b
        var i = 2
        while (n.toString.length < 1000) {
            i += 1
            n = a + b
            a = b
            b = n
        }
        println(i, n)
    }
}
