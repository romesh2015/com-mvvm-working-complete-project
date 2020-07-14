package com.romesh.dagger_mvvm_room_coroutine.activity.main

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.romesh.dagger_mvvm_room_coroutine.CoroutinesDispatcherProvider
import com.romesh.dagger_mvvm_room_coroutine.Factory.ViewModelFactory
import com.romesh.dagger_mvvm_room_coroutine.R
import com.romesh.dagger_mvvm_room_coroutine.Users
import com.romesh.dagger_mvvm_room_coroutine.adapter.CustomAdapter
import com.romesh.dagger_mvvm_room_coroutine.db.UsersDao
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.Serializable
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MainActivity : DaggerAppCompatActivity(), CustomAdapter.Interaction {
    private val mainActivityViewModel : MainActivityViewModel by viewModels{ viewModelFactory }
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var usersDao: UsersDao
    @Inject
    lateinit var coroutinesDispatcherProvider: CoroutinesDispatcherProvider
    lateinit var adapter : CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeViewState()
        observeUsersInDatabase()
    }
    private fun observeViewState() {
        mainActivityViewModel.state.observe(this,  Observer { state ->
            when(state){
                is MainActivityViewState.ShowLoading -> {
                  //  initialUiState()
                    showLoading()
                }
                is MainActivityViewState.ShowError -> {
                    showError(state.error)
                }
            }
        })
    }
    private fun observeUsersInDatabase() {
        CoroutineScope(coroutinesDispatcherProvider.main).launch {
            usersDao.getAllUsersDistinctUntilChanged().collect {
                    users -> showData(users)
            }
        }
    }
    private fun initialUiState(){
        progress_circular.visibility = View.GONE
        recyclerview.visibility = View.GONE
       // adapter = CustomAdapter()
      //  recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
    }

    private fun showLoading(){
        progress_circular.visibility = View.VISIBLE
    }

    private fun showData(data: List<Users>) {
        removeProgressDialog()
        progress_circular.visibility = View.GONE
        recyclerview.visibility = View.VISIBLE
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        adapter = CustomAdapter(data,this@MainActivity)
        recyclerview.adapter = adapter
    }

    private fun showError(error: Throwable) {
        removeProgressDialog()
        showToast(error.message, Toast.LENGTH_LONG)
    }

    private fun removeProgressDialog() {
        progress_circular.visibility = View.GONE
    }

    override fun onItemSelected(position: Int, users: Users) {
       // print("Result=>"+item.first_name)
        val intent = Intent(this,UserActivity::class.java)
        /*intent.putExtra("first",item.first_name);
        intent.putExtra("last",item.last_name);*/
        val test=Test("Romesh","4788533")
        intent.putExtra("test",test)
        startActivity(intent)

    }


}