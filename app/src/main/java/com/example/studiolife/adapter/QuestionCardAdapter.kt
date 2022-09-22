package com.example.studiolife.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studiolife.adapter.QuestionCardAdapter
import com.example.studiolife.R
import com.example.studiolife.data.DataSource

class QuestionCardAdapter (
//    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<QuestionCardAdapter.QuestionCardViewHolder>() {

    //Initialize the data using the List found in data/DataSource
    private val qList = DataSource.questions

    /**
     * Initialize view elements
     */
    class QuestionCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // Declare and initialize all of the list item UI components
//        val qImage: ImageView? = view!!.findViewById(R.id.dog_image)
        val questionText: TextView? = view!!.findViewById(R.id.question);
//        val qinput1Text: TextView? = view!!.findViewById(R.id.input1)
//        val qinput2Text: TextView? = view!!.findViewById(R.id.input2)
//        val qinput3Text: TextView? = view!!.findViewById(R.id.input3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionCardViewHolder {
        // Use a conditional to determine the layout type and set it accordingly.

//        val layout = when (layout) {
//            GRID -> R.layout.grid_list_item
//
//            else -> R.layout.vertical_horizontal_list_item
//        }
//         Inflate the layout
        val questionCard = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        // Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return QuestionCardViewHolder(questionCard)
    }

    override fun getItemCount() : Int {
        // return the size of the data set instead of 0
        return qList.size
    }

    override fun onBindViewHolder(holder: QuestionCardViewHolder, position: Int) {
        // Get the data at the current position
        val data = qList[position]
        // Set the image resource for the current dog
//        holder.catImage?.setImageResource(data.imageResourceId)
        holder.questionText?.text = data.question
        // Set the text for the current dog's name
//        holder.qinput1Text?.text = data.input1
        // Set the text for the current dog's age
//        holder.qinput2Text?.text = data.input2
//        holder.qinput3Text?.text = data.input3
//        val resources = context?.resources
        // Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
//        if (resources != null) {
//            holder.qinput1Text?.text = resources.getString(R.string.input1_text, data.age)
//            holder.qinput2Text?.text = resources.getString(R.string.dog_hobbies, data.hobbies)
//        }
    }
}