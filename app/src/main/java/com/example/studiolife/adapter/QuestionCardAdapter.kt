package com.example.studiolife.adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studiolife.R
import com.example.studiolife.data.DataSource.questions

class QuestionCardAdapter (
    private val context: Context?,
    private val optionList: ArrayList<String>
): RecyclerView.Adapter<QuestionCardAdapter.QuestionCardViewHolder>() {

    //Initialize the data using the List found in data/DataSource
    private val qList = questions

    /**
     * Initialize view elements
     */
    class QuestionCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // Declare and initialize all of the list item UI components
        val qImage: ImageView? = view!!.findViewById(R.id.question_image)
        val questionText: TextView? = view!!.findViewById(R.id.question);
        var input1Text: EditText? = view!!.findViewById(R.id.input1_text)
        var input2Text: EditText? = view!!.findViewById(R.id.input2_text)
        var input3Text: EditText? = view!!.findViewById(R.id.input3_text)
        val button: Button? = view!!.findViewById(R.id.done_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionCardViewHolder {
        val questionCard = LayoutInflater.from(parent.context).inflate(R.layout.entry_form, parent, false)
        return QuestionCardViewHolder(questionCard)
    }

    override fun getItemCount() : Int {
        // return the size of the data set instead of 0
        return qList.size
    }

    var inputOne: String = "null"
    var inputTwo: String = "null"
    var inputThree: String = "null"

    override fun onBindViewHolder(holder: QuestionCardViewHolder, position: Int) {
        // Get the data at the current position
        val data = qList[position]
        holder.questionText?.text = data.question

        holder.qImage?.setImageResource(data.imageResourceId)

        //tracking the user input and updating the strings from the edit text boxes
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

        //user signals they are done with the question input, store the values in the option list
        holder.button?.setOnClickListener {
            optionList.add(inputOne)
            optionList.add(inputTwo)
            optionList.add(inputThree)
            holder.button.visibility = View.INVISIBLE;
        }
    }
}