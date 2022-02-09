package mudinov.ali.f24coffee.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import mudinov.ali.f24coffee.R
import mudinov.ali.f24coffee.databinding.CardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class Card : Fragment(), View.OnClickListener {

    private var binding: CardBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.card, container, false)

        return binding?.root
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}