import kotlin.browser.document

fun main(args: Array<String>) {
    println("Hello World")
    val myButton = document.getElementById("myButton")!!
    myButton.addEventListener("click", {
        println("Clicked")
    })
}
