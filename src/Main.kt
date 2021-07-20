fun main() {
    var obj1 = TestClass1()
    obj1.testMethod1()
    var obj01 = TestClass001()
    obj01.testMethod1()

    println("------------------------------")

    var obj2 = SubClass()
    obj2.subMethod1()
}

open class TestClass1 constructor(var a2:Int){

    var a1 = 100

    constructor() : this(100) {

    }

    open fun testMethod1() {
        var a1 = 200
        println("a1 : $a1")
        println("this.a1 : ${this.a1}")

        fun testMethod2() {
            println("testMethod1 내부의 testMethod2")
        }

        testMethod2()
        this.testMethod2()
    }
    private fun testMethod2() {
        println("TestClass1의 testMethod2")
    }
}

class TestClass001 : TestClass1() {

    var a001 = 300
    override fun testMethod1() {
        var a001 = 400
        println("a001 : $a001")
        println("this.a001 : ${this.a001}")
        println("super.a1 : ${super.a1}")
        super.testMethod1()
    }
}

open class SuperClass (var a2:Int) {
    open var a1 = 100

    open fun superMethod1() {
        println("SuperClass 의 superMethod1")
    }


}
class SubClass : SuperClass(100) { // 주 생성자에서 부모의 생성자를 호출한 경우

    override var a1 = 1000 //Variable 또한 Override 가 가능하다.

    fun subMethod1() {
        a1 = 10000
        println("a1 : $a1") // 10000
        println("super.a1 : ${super.a1}") //100
        println("this.a1 : ${this.a1}") // 10000

        superMethod1()
        super.superMethod1()
    }

    override fun superMethod1() {
        super.superMethod1()
        println("SubClass 의 SuperMethod1")
    }
}

class SubClass2 : SuperClass {

    constructor(a1:Int) : super(a1) { // 보조 생성자에서 부모의 생성자를 호출한 경우

    }
    constructor(a1:Int, a2: Int) : super(a1) {

    }
}








