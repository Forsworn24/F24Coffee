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
import mudinov.ali.f24coffee.data.models.CardModel
import mudinov.ali.f24coffee.data.models.CoffeeModel
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

        binding?.clearCard?.setOnClickListener(this)
        binding?.checkoutCard?.setOnClickListener(this)
        return binding?.root
    }

    private fun initRecyclerCard() {

        binding?.listCard?.layoutManager =
            LinearLayoutManager(context)
        cardAdapter = CardAdapter ({ cardModel: CardModel ->
            deleteFromCard(cardModel)}, { cardModel: CardModel ->
            lessCount(
                cardModel
            )
        }, { cardModel: CardModel ->
            moreCount(
                cardModel
            )
        })
        binding?.listCard?.adapter = cardAdapter

    }

    private fun loadCoffeeFromCard() {

        cardViewModel.loadCoffeeFromCard.observe(viewLifecycleOwner, Observer {
            cardAdapter?.setList(it)
            cardAdapter?.notifyDataSetChanged()

            val total:Int = it.sumOf<CardModel> { it.totalPrice.toInt() }

            binding?.totalOrder?.text = total.toString()
        })
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.clearCard -> cardViewModel.clearCard()

            R.id.checkoutCard -> {

                val checkout = Checkout()
                checkout.show((context as FragmentActivity).supportFragmentManager, "checkout")

            }
        }
    }

    private fun deleteFromCard(cardModel: CardModel) {
        cardViewModel.deleteProductFromCard(cardModel.id)
    }

    private fun lessCount(cardModel:CardModel) {

        var count: Int = cardModel.count.toInt()
        count--

        if (count<1) {
            cardViewModel.updateProductToCard(
                CardModel(cardModel.id, cardModel.name,
                    cardModel.image, cardModel.price, cardModel.idProduct, "1",
                    (cardModel.price.toInt()*1).toString())
            )

        }
        else {

            cardViewModel.updateProductToCard(
                CardModel(cardModel.id, cardModel.name,
                    cardModel.image, cardModel.price, cardModel.idProduct, count.toString(),
                    (cardModel.price.toInt()*count).toString())
            )

        }
    }

    private fun moreCount(cardModel:CardModel) {

        var count: Int = cardModel.count.toInt()
        count++

        cardViewModel.updateProductToCard(
            CardModel(cardModel.id, cardModel.name,
                cardModel.image, cardModel.price, cardModel.idProduct, count.toString(),
                (cardModel.price.toInt()*count).toString())
        )
    }
}