package com.example.studiolife

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.studiolife.DataSource.questions
import com.example.studiolife.QuestionCardAdapter
import com.example.studiolife.R
import com.example.studiolife.DataSource
import kotlinx.coroutines.NonDisposableHandle.parent

class QuestionCardAdapter (
    private val context: Context?
): RecyclerView.Adapter<QuestionCardAdapter.QuestionCardViewHolder>() {

    //Initialize the data using the List found in data/DataSource
    private val qList = questions
    private var myData: ArrayList<String> = ArrayList()

    /**
     * Initialize view elements
     */
    class QuestionCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // Declare and initialize all of the list item UI components
        val questionText: TextView? = view!!.findViewById(R.id.question)
        val input1Text: TextView? = view!!.findViewById(R.id.input1_edit_text)
        val input2Text: TextView? = view!!.findViewById(R.id.input2_edit_text)
        val input3Text: TextView? = view!!.findViewById(R.id.input3_edit_text)
        val enterButton: Button = view!!.findViewById(R.id.enter_btn)
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
        var inputOne: String = ""
        var inputTwo: String = ""
        var inputThree: String = ""
        holder.questionText?.text = data.question
//        holder.input1Text?.text = data.input1
//        holder.input2Text?.text = data.input2
//        holder.input3Text?.text = data.input3
        holder.input1Text?.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                inputOne = s.toString()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        holder.input2Text?.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                inputTwo = s.toString()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        holder.input3Text?.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                inputThree = s.toString()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        holder.enterButton?.setOnClickListener() {
            myData.add(inputOne)
            myData.add(inputTwo)
            myData.add(inputThree)
            holder.enterButton.visibility = View.INVISIBLE
        }
    }
}