package com.example.chatbot2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbot2.ViewHolder

class MyAdapter(var messages_list:List<item> ):RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_message,parent,false)
        return com.example.chatbot2.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return messages_list.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
       val item = messages_list[position]
        holder.handlle_message(item)
    }

}
class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val textView: TextView = itemView.findViewById(R.id.show_message)
    val messageContainer: CardView = itemView.findViewById(R.id.message_container)
    init {

    }
    fun handlle_message(mess:item){
        textView.text=mess.message
        if(!mess.is_user){
            val prams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            prams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE)
            textView.setBackgroundResource(R.color.secondary)
//            messageContainer.layoutParams
            messageContainer.layoutParams= prams
        }
    }
}