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

class Singer3Fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_singer3, container, false)

        val items = mutableListOf<String>()
        items.add("거문고야")
        items.add("가인이어라")
        items.add("당신을 만나")
        items.add("Tears")
        items.add("서울의 달")
        items.add("오늘같이 좋은 날")
        items.add("엄마아리랑")
        items.add("진정인가요")
        items.add("내 마음의 사진")
        items.add("비 내리는 금강산")
        items.add("무명배우")
        items.add("월하가약")
        items.add("거문고야")
        items.add("가인이어라")
        items.add("당신을 만나")
        items.add("Tears")
        items.add("서울의 달")
        items.add("오늘같이 좋은 날")
        items.add("엄마아리랑")
        items.add("진정인가요")
        items.add("내 마음의 사진")
        items.add("비 내리는 금강산")
        items.add("무명배우")
        items.add("월하가약")

        val rv = view.findViewById<RecyclerView>(R.id.singRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.img1).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer3Fragment_to_singer1Fragment)
        }
        view.findViewById<ImageView>(R.id.img2).setOnClickListener {
            it.findNavController().navigate(R.id.action_singer3Fragment_to_singer2Fragment)
        }

        return view
    }

}