package com.example.dell.chatapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var messages = ArrayList<Message>()
    var adapter: MessageAdapter = MessageAdapter(messages)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name : String= intent.extras.getString("name")
        supportActionBar?.title=name
        //set layout manager
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        layoutManager.stackFromEnd=true
        layoutManager.reverseLayout=true
        chatList.layoutManager=layoutManager
        chatList.adapter=adapter
        adapter.notifyDataSetChanged()
        button_send.setOnClickListener {
            if(edit_text_message.text.toString() != "")
            {
                var m=edit_text_message.text.toString()
                edit_text_message.setText("")
                edit_text_message.text.clear()
                val message:Message=Message()
                message.name="username"
                message.text=m
                message.time=System.currentTimeMillis()
                messages.add(message)
                adapter.notifyDataSetChanged()
                scrollToBottom()
            }
        }
    }

    fun scrollToBottom() {
        chatList.scrollToPosition(0)
    }

}
