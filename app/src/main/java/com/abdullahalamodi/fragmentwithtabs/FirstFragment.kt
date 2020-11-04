package com.abdullahalamodi.fragmentwithtabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

const val ARG_TITLE = "title";

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView = view.findViewById(R.id.textView) as TextView;
        arguments?.let {
            val title = it.getString(ARG_TITLE);
            textView.text = title;
            Toast.makeText(context,title,Toast.LENGTH_SHORT).show();
        }
    }

    companion object {
        fun newInstance(title: String): FirstFragment {
            val args = Bundle().apply {
                putString(ARG_TITLE, title)
            }
            return FirstFragment().apply {
                arguments = args;
            }
        }

    }

}