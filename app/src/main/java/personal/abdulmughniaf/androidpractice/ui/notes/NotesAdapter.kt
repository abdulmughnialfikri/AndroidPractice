package personal.abdulmughniaf.androidpractice.ui.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_notes.view.*
import personal.abdulmughniaf.androidpractice.R
import personal.abdulmughniaf.androidpractice.models.Note

class NotesAdapter(
        private val notelist: MutableList<Note> = mutableListOf()
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false))

    override fun getItemCount(): Int = notelist.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(notelist[position])
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun onBind(notes: Note){
            view.textView.text = notes.description
        }
    }

}