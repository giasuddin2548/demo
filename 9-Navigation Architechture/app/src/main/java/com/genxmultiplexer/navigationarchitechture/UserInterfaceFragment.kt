package com.genxmultiplexer.navigationarchitechture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.genxmultiplexer.navigationarchitechture.databinding.FragmentMainBinding
import com.genxmultiplexer.navigationarchitechture.databinding.FragmentUserInterfaceBinding
import com.genxmultiplexer.navigationarchitechture.fragments.BaseFragment


class UserInterfaceFragment : BaseFragment() {
    private lateinit var binding: FragmentUserInterfaceBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_user_interface, container, false)

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        binding.textViewUserInfoNameId.text=arguments?.getString("INPUTVALUE")
        binding.buttonUserFragmentId.setOnClickListener{
            it.findNavController().navigate(R.id.action_userInterfaceFragment_to_mainFragment)
        }
    }


}