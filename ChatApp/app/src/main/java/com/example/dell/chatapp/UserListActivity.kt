package com.example.dell.chatapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_user_list.*
import java.util.ArrayList

class UserListActivity : AppCompatActivity() {

    var users = ArrayList<User>()
    var adapter: UserAdapter = UserAdapter(users)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        userList.layoutManager=layoutManager
        adapter.mContext=this
        userList.adapter=adapter
        addDummyUsers()
    }
    fun addDummyUsers() {
        val user1=User()
        user1.name="XYZ"
        user1.username="1"
        users.add(user1)
        //case: name of user does not exists...will display username instead of name
        //username ought to exist to distinguish users
        val user2=User()
        user2.username="2"
        users.add(user2)

        val user3=User()
        user3.name="ABC"
        user3.username="3"
        users.add(user3)

        val user4=User()
        user4.name="ZZZ"
        user4.username="4"
        users.add(user4)

        adapter.notifyDataSetChanged()
    }
}
