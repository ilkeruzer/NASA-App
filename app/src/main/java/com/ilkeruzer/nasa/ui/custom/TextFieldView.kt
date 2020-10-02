package com.ilkeruzer.nasa.ui.custom

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ilkeruzer.nasa.R


class TextFieldView : ConstraintLayout{
    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    private var txtTitle: TextView? = null
    private var txtText: TextView? = null

    private fun init(context: Context, attrs: AttributeSet?) {
        inflate(context, R.layout.view_text_field_layout, this)
        txtTitle = findViewById(R.id.txtTitle)
        txtText = findViewById(R.id.txtText)
        setAttr(attrs)
    }

    private fun setAttr(attrs: AttributeSet?) {
        val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.TextFieldView)
        try {
            if (ta.hasValue(R.styleable.TextFieldView_textField_title)) {
                val title = ta.getString(R.styleable.TextFieldView_textField_title)
                setTxtTitle(title)
            }
            if (ta.hasValue(R.styleable.TextFieldView_textField_text)) {
                val text = ta.getString(R.styleable.TextFieldView_textField_text)
                setTxtText(text)
            }

        } finally {
            ta.recycle()
        }
    }





    fun setTxtTitle(title: String?) {
        txtTitle!!.text = title
    }

    fun setTxtText(text: String?) {
        txtText!!.text = text
    }


    fun getTxtTitle(): String {
        return txtTitle!!.text.toString()
    }

    fun getTxtText(): String {
        return txtText!!.text.toString()
    }



}
