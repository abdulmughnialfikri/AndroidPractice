package personal.abdulmughniaf.androidpractice.models

data class Task @JvmOverloads constructor(
        var title: String,
        val todo: MutableList<Todo> = mutableListOf(),
        var tag: Tag? = null
)

data class Todo(
    var description: String,
    var isComplete: Boolean
)
data class Note(
    var description: String,
    var tag: Tag? = null
)
data class Tag(
    var name: String,
    var colorResID: Int
)