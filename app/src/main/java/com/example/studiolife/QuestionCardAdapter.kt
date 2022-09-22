package com.example.studiolife

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studiolife.DataSource.questions
import com.example.studiolife.QuestionCardAdapter
import com.example.studiolife.R
import com.example.studiolife.DataSource

class QuestionCardAdapter (
    private val context: Context?
): RecyclerView.Adapter<QuestionCardAdapter.QuestionCardViewHolder>() {

    //Initialize the data using the List found in data/DataSource
    private val qList = questions

    /**
     * Initialize view elements
     */
    class QuestionCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // Declare and initialize all of the list item UI components
        val questionText: TextView? = view!!.findViewById(R.id.question)
        val input1Text: TextView? = view!!.findViewById(R.id.input1_edit_text)
        val input2Text: TextView? = view!!.findViewById(R.id.input2_edit_text)
        val input3Text: TextView? = view!!.findViewById(R.id.input3_edit_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionCardViewHolder {
        val questionCard = LayoutInflater.from(parent.context).inflate(R.layout.entry_form, parent, false)
        return QuestionCardViewHolder(questionCard)
    }

    override fun getItemCount() : Int {
        // return the size of the data set instead of 0
        return qList.size
    }

    override fun onBindViewHolder(holder: QuestionCardViewHolder, position: Int) {
        // Get the data at the current position
        val data = qList[position]
        holder.questionText?.text = data.question
        holder.input1Text?.text = data.input1
        holder.input2Text?.text = data.input2
        holder.input3Text?.text = data.input3
    }
}