package com.example.fragmentinteraction

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.fragmentinteraction.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentFirstBinding

    /**
     * Declare listener to communicate with activity
     */
    private var listener: FirstFragmentListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

   /* override fun onAttach(context: Context) {
        super.onAttach(context)

        *//**
         * Initialize the listener to communicate with activity
         *//*
        listener = if(context is FirstFragmentListener){
            context
        }else{
            throw RuntimeException("$context must implement FirstFragmentListener")
        }
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //normal way
        /*binding.button.setOnClickListener{
            listener?.goToSecond(binding.editText.text.toString())
        }*/

        //nav_graph way
        binding.button.setOnClickListener{
            val text = binding.editText.text.toString()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(text)
            view.findNavController().navigate(action)

        }



    }

    /*fun setListener(listener: FirstFragmentListener){
        this.listener = listener
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentFirstBinding.inflate(
        inflater,
        container,
        false
    ).also { binding = it }.root


    //normal way of sending and receiving  data from fragments
    /*companion object {
        *//**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         *//*
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        *//*fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*//*

        fun newInstance() = FirstFragment()
                }*/

    }