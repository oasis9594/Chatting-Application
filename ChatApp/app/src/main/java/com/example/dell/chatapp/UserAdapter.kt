package com.example.dell.chatapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_row.view.*
import java.util.ArrayList

class UserAdapter(internal var users: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    var mContext: Context?=null
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
        fun setUI(user:User)
        {
            with(itemView)
            {
                if(user.name!=null)
                    name_user.setText(user.name)
                else
                    name_user.setText(user.username)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val customView = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_row, parent, false)
        val vh = ViewHolder(customView, object : ViewHolder.MyClickHandler {

            override fun doSomething(v: View, pos: Int) {
                if( mContext!=null)
                {
                    val user = users.get(pos)
                    var s:String?=null
                    s=user.name
                    if(s==null)
                        s=user.username
                    mContext!!.startActivity(Intent(mContext, MainActivity::class.java).putExtra("name", s))
                }
            }
        })
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user : User = users.get(position)
        holder.setUI(user)
    }

    override fun getItemCount(): Int {
        return users.size
    }

}