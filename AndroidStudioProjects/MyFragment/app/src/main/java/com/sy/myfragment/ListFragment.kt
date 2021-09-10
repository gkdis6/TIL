package com.sy.myfragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sy.myfragment.databinding.FragmentListBinding

class ListFragment : Fragment() {
    var mainActivity: MainActivity? =null
    lateinit var binding:FragmentListBinding //1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_list, container, false) 원본코드 프래그먼트의 버튼을 사용하기 위해 수정
        binding = FragmentListBinding.inflate(inflater, container, false)//2 1이 생겨서 2의 val가 주석처리
        binding.btnNext.setOnClickListener { mainActivity?.goDetail() }

        binding.textTitle.text = arguments?.getString("key1")
        binding.textValue.text = "${arguments?.getInt("key2")}"
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is MainActivity) mainActivity = context
    }

    fun setValue(value:String){
        binding.textFromActivity.text = value
    }
}