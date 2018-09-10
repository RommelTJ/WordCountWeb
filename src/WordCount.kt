import org.w3c.dom.HTMLInputElement
import kotlin.browser.document

fun main(args: Array<String>) {
    println("Hello World")
    val myButton = document.getElementById("myButton")!!
    myButton.addEventListener("click", {
        val inputValue = (document.getElementById("myInput")!! as HTMLInputElement).value
        println(inputValue)
    })
}
