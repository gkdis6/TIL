package com.sy.asmr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.asmr2.databinding.FragmentAsmrBinding

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