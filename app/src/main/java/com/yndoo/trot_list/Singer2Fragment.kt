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


class Singer2Fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_singer2, container, false)

        val items = mutableListOf<String>()
        items.add("사랑은 늘 도망가")
        items.add("미운 사랑")
        items.add("이제 나만 믿어요")
        items.add("별빛 같은 나의 사랑아")
        items.add("Polaroid")
        items.add("보라빛 엽서")
        items.add("당신")
        items.add("바램")
        items.add("두 주먹")
        items.add("계단말고 엘리베이터")
        items.add("울면서 후회하네")
        items.add("어느 60대 노부부이야기")
        items.add("사랑은 늘 도망가")
        items.add("미운 사랑")
        items.add("이제 나만 믿어요")
        items.add("별빛 같은 나의 사랑아")
        items.add("Polaroid")
        items.add("보라빛 엽서")
        items.add("당신")
        items.add("바램")
        items.add("두 주먹")
        items.add("계단말고 엘리베이터")
        items.add("울면서 후회하네")
        items.add("어느 60대 노부부이야기")

        val rv = view.findViewById<RecyclerView>(R.id.singRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.img1).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer2Fragment_to_singer1Fragment)
        }
        view.findViewById<ImageView>(R.id.img3).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer2Fragment_to_singer3Fragment)
        }

        return view
    }


}