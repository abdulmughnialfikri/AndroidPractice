package personal.abdulmughniaf.androidpractice.ui.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_add_button.view.*
import personal.abdulmughniaf.androidpractice.R
import personal.abdulmughniaf.androidpractice.foundation.BaseRecyclerAdapter
import personal.abdulmughniaf.androidpractice.models.Note
import personal.abdulmughniaf.androidpractice.view.NoteView

class NotesAdapter(
        noteList: MutableList<Note> = mutableListOf()
): BaseRecyclerAdapter<Note>(noteList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if (viewType == TYPE_INFO) {
        NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false))
    }else{
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
    }

    class NoteViewHolder(view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(data: Note) {
            (view as NoteView).initView(data)
        }
    }

    class AddButtonViewHolder(view: View) : BaseRecyclerAdapter.AddButtonViewHolder(view) {
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)
        }
    }
}
