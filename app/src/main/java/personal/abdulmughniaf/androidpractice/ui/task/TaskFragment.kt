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
                        Task("Task 1", mutableListOf(
                                Todo("Testing One"),
                                Todo("Testing Two", true)
                        )),
                        Task("Task 2"),
                        Task("Task 3"),
                        Task("Task 4"),
                        Task("Task 5")
                )
        )
        recyclerView.adapter = adapter
    }
}