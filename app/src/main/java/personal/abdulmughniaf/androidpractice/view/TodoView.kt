package personal.abdulmughniaf.androidpractice.view

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.view_todo.view.*
import personal.abdulmughniaf.androidpractice.models.Todo

class TodoView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 1
): ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(todo: Todo, callback: (() -> Unit)? = null) {
        completeCheckBox.isChecked = todo.isComplete
        descriptionView.text = todo.description

        if (todo.isComplete) {
            createStrikeThrough()
        }
        setupCheckStateListener(todo, callback)
    }

    private fun setupCheckStateListener(todo: Todo, callback: (() -> Unit)? = null) {
        completeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            todo.isComplete = isChecked
            callback?.invoke()
            if (isChecked) {
                createStrikeThrough()
            } else {
                removeStrikeThrough()
            }
        }
    }

    private fun createStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags or  Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}
