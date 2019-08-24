package com.indivara.auliariwayanto.memberiddevtest.adapter

import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.indivara.auliariwayanto.memberiddevtest.R
import com.indivara.auliariwayanto.memberiddevtest.data.Identification
import com.squareup.picasso.Picasso

class ListRewardAdapter(val listIdentifications: ArrayList<Identification>) : androidx.recyclerview.widget.RecyclerView.Adapter<ListRewardAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Identification)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_row, p0, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listIdentifications.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(p0: ListViewHolder, p1: Int) {
        val (name, poin, color,nominal,linkImage) = listIdentifications[p1]
        /*Glide.with(p0.itemView.context)
                .load(linkImage)
                .apply(RequestOptions().override(700, 400))
                .into(p0.ivColor)*/
        Picasso.get().load(linkImage)
                .resize(700,400)
                .into(p0.ivColor)

        p0.btVouchers.text = name
        p0.btPoin.text = poin
        p0.tvNominalReward.text = nominal
        when (name) {
            "Vouchers" -> p0.run { btVouchers.setBackgroundColor(p0.itemView.context.getColor(R.color.blue_500)) }
            "GiftCard" -> p0.run { btVouchers.setBackgroundColor(p0.itemView.context.getColor(R.color.red_500)) }
            "Products" -> p0.run { btVouchers.setBackgroundColor(p0.itemView.context.getColor(R.color.yellow_800)) }
        }
        p0.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listIdentifications[p0.adapterPosition]) }
    }

    inner class ListViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var ivColor: ImageView = itemView.findViewById(R.id.iv_color)
        var lvReward: LinearLayout = itemView.findViewById(R.id.lv_cardreward)
        var btVouchers: Button = itemView.findViewById(R.id.bt_vouchers)
        var btPoin: Button = itemView.findViewById(R.id.bt_poin)
        var tvNominalReward: TextView = itemView.findViewById(R.id.tv_nominalreward)
    }


}