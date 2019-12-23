package personal.abdulmughniaf.androidpractice.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_task.*

import personal.abdulmughniaf.androidpractice.R
import personal.abdulmughniaf.androidpractice.models.Task
import personal.abdulmughniaf.androidpractice.models.Todo

class TaskFragment : Fragment() {

    private var taskViewModel: TaskViewModel? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)

        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(
                mutableListOf(
                        Task("Cleaning up my Room", mutableListOf(
                                Todo("Tidy up table",true),
                                Todo("Sweeping"),
                                Todo("Mop")
                        )),
                        Task("Finishing Final Project", mutableListOf(
                                Todo("BAB 1"),
                                Todo("BAB 2"),
                                Todo("BAB 3"),
                                Todo("BAB 4")
                        ))
                )
        )
        recyclerView.adapter = adapter
    }
}