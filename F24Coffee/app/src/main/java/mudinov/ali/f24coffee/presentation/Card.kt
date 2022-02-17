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
import mudinov.ali.f24coffee.presentation.viewModel.CardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Card : Fragment(), View.OnClickListener {

    private var binding: CardBinding? = null
    private var cardAdapter: CardAdapter? = null
    private val cardViewModel: CardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.card, container, false)

        initRecyclerCard()
        loadCoffeeFromCard()
        return binding?.root
    }

    private fun initRecyclerCard() {

        binding?.listCard?.layoutManager =
            LinearLayoutManager(context)
        cardAdapter = CardAdapter()
        binding?.listCard?.adapter = cardAdapter

    }

    private fun loadCoffeeFromCard() {

        cardViewModel.loadCoffeeFromCard.observe(viewLifecycleOwner, Observer {
            cardAdapter?.setList(it)
            cardAdapter?.notifyDataSetChanged()
        })
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}