package personal.abdulmughniaf.androidpractice.ui.notes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notes.*
import kotlinx.android.synthetic.main.fragment_task.*
import kotlinx.android.synthetic.main.fragment_task.recyclerView

import personal.abdulmughniaf.androidpractice.R
import personal.abdulmughniaf.androidpractice.models.Note
import personal.abdulmughniaf.androidpractice.ui.task.TaskListFragment

class NotesListFragment : Fragment() {

    private var notesViewModel: NotesViewModel? = null
    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context?.let {
            if (it is TouchActionDelegate){
                touchActionDelegate =it
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notes, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = NotesAdapter(mutableListOf(
                Note("Don't forget to take laundry"),
                Note("Go to groceries"),
                Note("Go jogging")
        ), touchActionDelegate)
        recyclerView.adapter = adapter
    }

    interface TouchActionDelegate{
        fun onAddButtonClicked(value: String)
    }
}