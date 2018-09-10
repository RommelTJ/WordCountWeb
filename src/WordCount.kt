import org.w3c.dom.HTMLInputElement
import kotlin.browser.document

fun main(args: Array<String>) {
    val myButton = document.getElementById("myButton")!!
    myButton.addEventListener("click", {
        val allTheWords = (document.getElementById("myInput")!! as HTMLInputElement).value

        // Make a list of all the words separated out.
        val words = allTheWords
                .toLowerCase()
                .replace(",", "")
                .replace(".", "")
                .replace("!", "")
                .replace("?", "")
                .replace("\n", " ")
                .split(" ")

        // Get a counted list of all the words.
        val wordMap = mutableMapOf<String, Int>()
        for (word in words) {
            if (wordMap.containsKey(word)) {
                val currentCount = wordMap[word]!!
                wordMap[word] = currentCount + 1
            } else if (word != "") {
                wordMap[word] = 1
            }
        }

        // Convert map to list
        val wordList = wordMap.toList()

        // Sort the list.
        val sortedList = wordList.sortedWith(compareByDescending({it.second}))

        // Print a sorted list of most popular words.
        val divTag = document.getElementById("myList")!!
        var listItems = ""
        for (word in sortedList) {
            // Create the list items.
            listItems += "<li>${word.first} - ${word.second}</li>"
        }
        divTag.innerHTML = listItems
    })
}
