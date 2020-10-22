package com.example.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class KopiAdapter internal constructor(private val  context: Context) : BaseAdapter() {
    internal var coffee = arrayListOf<Kopi>()
    override fun getCount(): Int = coffee.size

    override fun getItem(i: Int): Any = coffee[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_kopi, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val coffee = getItem(position) as Kopi
        viewHolder.bind(coffee)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(coffee: Kopi) {
            txtName.text = coffee.name
            txtDescription.text = coffee.description
            imgPhoto.setImageResource(coffee.photo)
        }
    }
}