package com.genxmultiplexer.roomdatabase.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.genxmultiplexer.roomdatabase.R
import com.genxmultiplexer.roomdatabase.adapter.SubscriberAdapter
import com.genxmultiplexer.roomdatabase.database.RoomDbClass
import com.genxmultiplexer.roomdatabase.database.SubscriberEntity
import com.genxmultiplexer.roomdatabase.database.SubscriberRepository
import com.genxmultiplexer.roomdatabase.model.ViewModelClass
import com.genxmultiplexer.roomdatabase.databinding.ActivityMainBinding
import com.genxmultiplexer.roomdatabase.model.SubscriberViewModelFactory
import com.genxmultiplexer.roomdatabase.utils.toast

class MainView : AppCompatActivity() {

    private lateinit var viewModel: ViewModelClass
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SubscriberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val dao = RoomDbClass.invoke(application).getSubscriberDao


        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)



        viewModel = ViewModelProvider(this, factory).get(ViewModelClass::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this



        initRecyclerView()



        viewModel.message.observe(this, Observer {myEvent ->
            myEvent.getContentIfNotHandled()?.let {
                toast(it)
            }
        })






    }

    private fun initRecyclerView() {
        binding.recyclerViewSubscriberId.layoutManager = GridLayoutManager(this, 1)
        adapter=SubscriberAdapter { selectedItem:SubscriberEntity ->itemClick(selectedItem)}
        binding.recyclerViewSubscriberId.adapter=adapter
        displaySubscriberList()


    }

    private fun displaySubscriberList() {
        viewModel.subscriber.observe(this, Observer {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }





    private fun itemClick(subscriberEntity: SubscriberEntity){
        viewModel.updateAndDelete(subscriberEntity)
    }


}