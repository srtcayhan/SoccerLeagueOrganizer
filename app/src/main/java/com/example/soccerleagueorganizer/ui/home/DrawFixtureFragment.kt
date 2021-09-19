package com.example.soccerleagueorganizer.ui.home

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.soccerleagueorganizer.R
import com.example.soccerleagueorganizer.databinding.FragmentDrawFixtureBinding
import com.example.soccerleagueorganizer.utils.ZoomOutPageTransformer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrawFixtureFragment : Fragment() {

    private lateinit var binding: FragmentDrawFixtureBinding

    private val viewModel : DrawFixtureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDrawFixtureBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerAdapter(viewModel.listWeek())
        binding.viewpager.adapter = adapter
        binding.viewpager.setPageTransformer(ZoomOutPageTransformer())
    }

}