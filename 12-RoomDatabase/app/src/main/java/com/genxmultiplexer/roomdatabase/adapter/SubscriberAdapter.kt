package com.genxmultiplexer.roomdatabase.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.genxmultiplexer.roomdatabase.R
import com.genxmultiplexer.roomdatabase.database.SubscriberEntity
import com.genxmultiplexer.roomdatabase.databinding.ActivityMainBinding
import com.genxmultiplexer.roomdatabase.databinding.SimpleListItemBinding
import com.genxmultiplexer.roomdatabase.generated.callback.OnClickListener

class SubscriberAdapter(private val clickListener: (SubscriberEntity) -> Unit) :
    RecyclerView.Adapter<SubscriberViewHolder>() {

    private val subscriberList = ArrayList<SubscriberEntity>()

    fun setList(subscriberEntity: List<SubscriberEntity>) {
        subscriberList.clear()
        subscriberList.addAll(subscriberEntity)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        val view: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: SimpleListItemBinding = DataBindingUtil.inflate(view, R.layout.simple_list_item, parent, false)

        return SubscriberViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return subscriberList.size
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {

        val myPosition = subscriberList[itemCount-position-1]
        holder.bind(myPosition, clickListener)
    }
}

class SubscriberViewHolder(private val binding: SimpleListItemBinding) : RecyclerView.ViewHolder(binding.root) {


    @SuppressLint("SetTextI18n")
    fun bind(subscriberEntity: SubscriberEntity, clickListener: (SubscriberEntity) -> Unit) {

        binding.textViewSimpleNameId.text =subscriberEntity.sub_id.toString()+subscriberEntity.sub_name

        binding.textViewSimpleEmailId.text = subscriberEntity.sub_email

        binding.listItemLayoutId.setOnClickListener {
            clickListener(subscriberEntity)
        }
    }

}