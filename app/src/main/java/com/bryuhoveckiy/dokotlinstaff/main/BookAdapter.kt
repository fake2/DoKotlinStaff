package com.bryuhoveckiy.dokotlinstaff.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bryuhoveckiy.dokotlinstaff.R
import com.bryuhoveckiy.dokotlinstaff.databinding.ItemBookBinding

class BookAdapter(var data: MutableList<Book>, private val listener: OnBookListener) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemBookBinding.bind(itemView)

        init {

        }

        //val f=itemView.setOnClickListener()
        fun bind(book: Book) {
            with(binding) {
                tvName.text = book.title
                tvSite.text = book.site
                if (book.site.isEmpty())
                    tvSite.visibility = View.GONE
                else
                    tvSite.visibility = View.VISIBLE
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener { listener.onBookClick(data[position]) }
    }

    fun dispatch(newData: List<Book>) {
        val diffCallback = BookDiffCallback(this.data, newData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.data.clear()
        this.data.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    interface OnBookListener {
        fun onBookClick(book: Book)
    }
}