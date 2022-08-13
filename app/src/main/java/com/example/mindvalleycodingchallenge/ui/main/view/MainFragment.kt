package com.example.mindvalleycodingchallenge.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mindvalleycodingchallenge.R
import com.example.mindvalleycodingchallenge.ui.main.viewmodel.MainViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class MainFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val viewModel: MainViewModel by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}