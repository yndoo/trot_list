package com.yndoo.trot_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Singer1Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_singer1, container, false)

        val items = mutableListOf<String>()
        items.add("니가 왜 거기서나와")
        items.add("이불")
        items.add("찐이야")
        items.add("비상")
        items.add("옆집오빠")
        items.add("전복 먹으러 갈래")
        items.add("니편이야")
        items.add("막걸리 한잔")
        items.add("담")
        items.add("사랑의 트위스트")
        items.add("머선 129")
        items.add("보약 같은 친구")
        items.add("니가 왜 거기서나와")
        items.add("이불")
        items.add("찐이야")
        items.add("비상")
        items.add("옆집오빠")
        items.add("전복 먹으러 갈래")
        items.add("니편이야")
        items.add("막걸리 한잔")
        items.add("담")
        items.add("사랑의 트위스트")
        items.add("머선 129")
        items.add("보약 같은 친구")

        val rv = view.findViewById<RecyclerView>(R.id.singRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)


        //view.findViewById<ImageView>(R.id.img2).setOnClickListener {  }
        val img2 = view.findViewById<ImageView>(R.id.img2)
        val img3 = view.findViewById<ImageView>(R.id.img3)

        img2.setOnClickListener {
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer2Fragment)
        }
        img3.setOnClickListener {
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer3Fragment)
        }

        return view
    }

}