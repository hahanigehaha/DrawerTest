package com.example.drawertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RoomInfo(val name:String, val user_count:Int, val region:String,val url:String)
class RoomRow(val left:RoomInfo, val right:RoomInfo)

class RoomAdapter(val RoomList:List<RoomRow>) :
        RecyclerView.Adapter<RoomAdapter.ViewHolder>(){

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val roomLeftImage : ImageView = view.findViewById(R.id.room_left_image)
        val roomLeftName : TextView = view.findViewById(R.id.room_left_name)
        val roomLeftCount : TextView = view.findViewById(R.id.room_left_count)
        val roomLeftRegion : TextView = view.findViewById(R.id.room_left_region)

        val roomRightImage : ImageView = view.findViewById(R.id.room_right_image)
        val roomRightName : TextView = view.findViewById(R.id.room_right_name)
        val roomRightCount : TextView = view.findViewById(R.id.room_right_count)
        val roomRightRegion : TextView = view.findViewById(R.id.room_right_region)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.room_row,parent,false)
        val viewHolder = ViewHolder(view)
        viewHolder.roomLeftImage.setOnClickListener {
            Toast.makeText(parent.context,"点击进入左边主播房间",Toast.LENGTH_SHORT).show()
        }
        viewHolder.roomRightImage.setOnClickListener {
            Toast.makeText(parent.context,"点击进入右边主播房间",Toast.LENGTH_SHORT).show()
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row = RoomList[position]
        holder.roomLeftCount.text = row.left.user_count.toString()
        holder.roomLeftName.text = row.left.name
        holder.roomLeftRegion.text = row.left.region

        holder.roomRightCount.text = row.right.user_count.toString()
        holder.roomRightName.text = row.right.name
        holder.roomRightRegion.text = row.right.region

    }

    override fun getItemCount(): Int {
        return RoomList.size
    }
}