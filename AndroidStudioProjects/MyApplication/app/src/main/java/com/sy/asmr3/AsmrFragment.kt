package com.sy.asmr3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sy.asmr.Items
import com.sy.asmr.recyclerAdapter
import com.sy.asmr3.Items
import com.sy.asmr3.databinding.FragmentAsmrBinding
import com.sy.asmr3.recyclerAdapter

class AsmrFragment : Fragment() {
    lateinit var binding: FragmentAsmrBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAsmrBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: MutableList<Items> = loadData()
        var adapter = recyclerAdapter()
        adapter.Data = data
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(binding.root.context, 2)
    }
}