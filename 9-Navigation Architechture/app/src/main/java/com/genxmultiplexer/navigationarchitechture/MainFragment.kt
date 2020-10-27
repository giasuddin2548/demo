package com.genxmultiplexer.navigationarchitechture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.genxmultiplexer.navigationarchitechture.databinding.FragmentMainBinding
import com.genxmultiplexer.navigationarchitechture.fragments.BaseFragment

class MainFragment : BaseFragment() {

    private lateinit var binding:FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false)


        return binding.root


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.buttonMainFragmentId.setOnClickListener{
            val bundle:Bundle= bundleOf("INPUTVALUE" to binding.eTMainFragemntId.text.toString())
            it.findNavController().navigate(R.id.action_main_to_userFragmentId,bundle)
        }
    }


}