package com.example.acitivtytojump.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.acitivtytojump.R
import com.example.acitivtytojump.TestActivity
import com.example.acitivtytojump.databinding.FragmentHomeBinding
import com.example.acitivtytojump.ui.OtherActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        //Navigation間の Notifications fragment へ遷移(特殊のボトムナビゲーション遷移)
        binding.toNotification.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.navigation_notifications)
        }
        //fragmentから別のOtherActivityへ遷移
        binding.toTestActivity.setOnClickListener{
            var intent = Intent(this.activity, OtherActivity().javaClass)
            startActivity(intent)

        }
        //fragmentからへ遷移TestActivityのFirst fragmentへ遷移
        binding.toTestSecondFragment.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            intent.putExtra("id", 1)
            startActivity(intent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}