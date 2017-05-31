package com.example.dell.chatapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList
import kotlinx.android.synthetic.main.message_row.*
import kotlinx.android.synthetic.main.message_row.view.*

/**
 * Created by dell on 5/31/2017.
 */

class MessageAdapter(internal var messages: ArrayList<Message>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View, internal var mlistener: ViewHolder.MyClickHandler) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            mlistener.doSomething(v, adapterPosition)
        }

        interface MyClickHandler {
            fun doSomething(v: View, pos: Int)
        }
        fun setUI(message: Message)
        {
            with(itemView)
            {
                username.text=message.name
                description.text=message.text
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val customView = LayoutInflater.from(parent.context)
                .inflate(R.layout.message_row, parent, false)
        val vh = ViewHolder(customView, object : ViewHolder.MyClickHandler {

            override fun doSomething(v: View, pos: Int) {
                //do something
                //left fror future reference
            }
        })
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message : Message = messages.get(position)
        holder.setUI(message)
    }

    override fun getItemCount(): Int {
        return messages.size
    }

}
