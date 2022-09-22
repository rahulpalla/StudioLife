package com.example.studiolife.adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studiolife.adapter.QuestionCardAdapter
import com.example.studiolife.R
import com.example.studiolife.data.DataSource
import com.example.studiolife.data.DataSource.questions
import com.google.android.material.textfield.TextInputEditText

class QuestionCardAdapter (
    private val context: Context?,
): RecyclerView.Adapter<QuestionCardAdapter.QuestionCardViewHolder>() {

    //Initialize the data using the List found in data/DataSource
    private val qList = questions

    /**
     * Initialize view elements
     */
    class QuestionCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // Declare and initialize all of the list item UI components
//        val qImage: ImageView? = view!!.findViewById(R.id.dog_image)
        val questionText: TextView? = view!!.findViewById(R.id.question);
        var input1Text: EditText? = view!!.findViewById(R.id.input1_text)
        var input2Text: EditText? = view!!.findViewById(R.id.input2_text)
        var input3Text: EditText? = view!!.findViewById(R.id.input3_text)

//        init {
//            editText.addTextChangedListener(object : TextWatcher {
//                override fun afterTextChanged(s: Editable?) {
//                    qList[adapterPosition].input1 = s.toString()
//                }
//
//                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//                }
//
//                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//                }
//
//            })
//        }
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
//        holder.input1Text?.text = data.input1
        holder.input1Text?.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                data.input1 = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
//        holder.input2Text?.text = data.input2
        holder.input2Text?.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                data.input2 = s.toString()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
//        holder.input3Text?.text = data.input3
        holder.input3Text?.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                data.input3 = s.toString()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}