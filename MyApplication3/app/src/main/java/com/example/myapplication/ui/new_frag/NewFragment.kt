package com.example.myapplication.ui.new_frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentBlankBinding

class NewFragment: Fragment() {
    private var _binding: FragmentBlankBinding? = null

    // private var _binding: FragmentHomeBinding? = null
    //  private var _binding: FragmentBlankBinding? = null
    //  private var _binding: NewFragmentBinding? =
    // private var _binding: FragmentBlankBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentModel =
            ViewModelProvider(this).get(fragment_model::class.java)

        _binding = FragmentBlankBinding.inflate(inflater,container,false)
        //  _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.text
        fragmentModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}