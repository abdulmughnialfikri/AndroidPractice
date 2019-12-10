package personal.abdulmughniaf.androidpractice.ui.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_notes.view.*
import personal.abdulmughniaf.androidpractice.R
import personal.abdulmughniaf.androidpractice.foundation.BaseRecyclerAdapter
import personal.abdulmughniaf.androidpractice.models.Note

class NotesAdapter(
        noteList: MutableList<Note> = mutableListOf()
): BaseRecyclerAdapter<Note>(noteList){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
        = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false))

    class ViewHolder(view: View): BaseViewHolder<Note>(view){
        override fun onBind(data: Note) {
            view.titleNotes.text = data.description
        }

    }
}
