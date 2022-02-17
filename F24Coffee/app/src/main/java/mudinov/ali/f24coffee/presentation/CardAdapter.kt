package mudinov.ali.f24coffee.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mudinov.ali.f24coffee.R
import mudinov.ali.f24coffee.data.models.CardModel
import mudinov.ali.f24coffee.databinding.CardItemBinding

class CardAdapter ():
    RecyclerView.Adapter<CardAdapter.CardHolder>() {

    private val productsFromCard = ArrayList<CardModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CardItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.card_item, parent, false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(productsFromCard[position])
    }

    override fun getItemCount(): Int {
        return productsFromCard.size
    }

    fun setList(cardList: List<CardModel>) {
        productsFromCard.clear()
        productsFromCard.addAll(cardList)
    }

    class CardHolder(val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(cardModel: CardModel)
        {

            val getImage = cardModel.image
            Picasso.get().load(getImage).into(binding.imageProductCard)
            binding.nameProductCard.text = cardModel.name
            binding.countProductBasket.text = cardModel.count
            binding.priceProductCard.text = cardModel.price

        }




    }
}