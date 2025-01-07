package com.unipu.microcart.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unipu.microcart.Item
import com.unipu.microcart.R

class CartItemAdapter(
    private val items: List<Item>,
    private val onDeleteClick: (Item) -> Unit
) : RecyclerView.Adapter<CartItemAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_cart_item, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.deleteButton.setOnClickListener {
            onDeleteClick(item)
        }
    }

    override fun getItemCount(): Int = items.size

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemName: TextView = itemView.findViewById(R.id.item_name)
        private val itemPrice: TextView = itemView.findViewById(R.id.item_price)
        private val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        private val itemSize: TextView = itemView.findViewById(R.id.item_size)

        val deleteButton: ImageButton = itemView.findViewById(R.id.delete_button)

        fun bind(item: Item) {
            itemName.text = item.name
            itemPrice.text = "${item.price} EUR"
            itemImage.setImageResource(item.image)
            itemSize.text = "Size: ${item.chosenSize}"
        }
    }
}
