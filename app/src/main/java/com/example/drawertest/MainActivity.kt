package com.example.drawertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val roomList = ArrayList<RoomRow>()
    private lateinit var gestureDetector : GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRoomInfo()
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager

        val adapter = RoomAdapter(roomList)
        recyclerview.adapter = adapter
        drawer_layout.visibility = View.INVISIBLE

        gestureDetector = GestureDetector(this,object : GestureDetector.OnGestureListener {
            override fun onShowPress(e: MotionEvent?) {
                Log.d("Gesture","ShowPress")
            }

            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                Log.d("Gesture","SingleTapUp")
                return true
            }

            override fun onDown(e: MotionEvent?): Boolean {
                if (e != null) {
                    if(e.x < 184)
                        drawer_layout.visibility = View.INVISIBLE
                        return true
                }
                return false
            }

            override fun onScroll(
                e1: MotionEvent?,
                e2: MotionEvent?,
                distanceX: Float,
                distanceY: Float
            ): Boolean {
                Log.d("Gesture","Scroll")
                return true
            }

            override fun onLongPress(e: MotionEvent?) {
                Log.d("Gesture","LongPress")
            }

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent?,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                if(velocityX < 0){
                    drawer_layout.visibility = View.VISIBLE
                }
                //Toast.makeText(this@MainActivity,"滑动了",Toast.LENGTH_SHORT).show()
                return true
            }
        })

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(ev)
        return super.dispatchTouchEvent(ev)
    }


    private fun initRoomInfo(){
        repeat(10){
            roomList.add(RoomRow(RoomInfo("你好，左房间名",14,"北极",""),RoomInfo("你好，右房间名",14,"北极","")))
        }
    }

}
