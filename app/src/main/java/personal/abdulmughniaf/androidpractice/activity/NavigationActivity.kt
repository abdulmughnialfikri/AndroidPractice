package personal.abdulmughniaf.androidpractice.activity

import android.content.Intent
import android.os.Bundle

import com.google.android.material.bottomnavigation.BottomNavigationView

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import personal.abdulmughniaf.androidpractice.R
import personal.abdulmughniaf.androidpractice.ui.notes.NotesListFragment
import personal.abdulmughniaf.androidpractice.ui.task.TaskListFragment

class NavigationActivity : AppCompatActivity(), TaskListFragment.TouchActionDelegate, NotesListFragment.TouchActionDelegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        val appBarConfiguration = AppBarConfiguration.Builder(
                R.id.navigation_task, R.id.navigation_notes)
                .build()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }

    private fun goToCreateActivity(fragmentValue: String){
        startActivity(Intent(this, CreateActivity::class.java).apply {
            putExtra(FRAGMENT_TYPE_KEY, fragmentValue)
        })
    }
    override fun onAddButtonClicked(value: String) {
        goToCreateActivity(value)
    }

    companion object{
        const val FRAGMENT_TYPE_KEY = "f_t_k"
        const val FRAGMENT_TYPE_NOTE = "f_t_n"
        const val FRAGMENT_TYPE_TASK = "f_t_t"
    }

}
