package com.example.myquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPossition:Int=1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var userName:String?=null
    private var correctAnswers:Int=0

    private var progressBar:ProgressBar?=null
    private var tvProgress: TextView?=null
    private var tvQuestion:TextView?=null
    private var ivImage: ImageView?=null
    private var btnSubmit: Button?=null

    private var tvQptionOne:TextView?=null
    private var tvQptionTwo:TextView?=null
    private var tvQptionThree:TextView?=null
    private var tvQptionFour:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        userName=intent.getStringExtra(Constants.USER_NAME)

        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)
        tvQptionOne=findViewById(R.id.tv_option_one)
        tvQptionTwo=findViewById(R.id.tv_option_two)
        tvQptionThree=findViewById(R.id.tv_option_three)
        tvQptionFour=findViewById(R.id.tv_option_four)
        btnSubmit=findViewById(R.id.btn_submit)

        tvQptionOne?.setOnClickListener(this)
        tvQptionTwo?.setOnClickListener(this)
        tvQptionThree?.setOnClickListener(this)
        tvQptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()


    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionsList!![mCurrentPossition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPossition
        tvProgress?.text =  "$mCurrentPossition" + "/" + progressBar?.max
        tvQuestion?.text = question.question
        tvQptionOne?.text = question.optionOne
        tvQptionTwo?.text = question.optionTwo
        tvQptionThree?.text = question.optionThree
        tvQptionFour?.text = question.optionFour

        if(mCurrentPossition==mQuestionsList!!.size){
            btnSubmit?.text="FINISH"
        }else{
            btnSubmit?.text="SUBMIT"
        }
        progressBar?.progress =
            mCurrentPossition // Setting the current progress in the progressbar using the position of question
        tvProgress?.text =
            "$mCurrentPossition" + "/" + 8 // Setting up the progress text

        // Now set the current question and the options in the UI
        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)
        tvQptionOne?.text = question.optionOne
        tvQptionTwo?.text = question.optionTwo
        tvQptionThree?.text = question.optionThree
        tvQptionFour?.text = question.optionFour
    }
    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        tvQptionOne?.let{
            options.add(0,it)
        }
        tvQptionTwo?.let{
            options.add(1,it)
        }
        tvQptionThree?.let{
            options.add(2,it)
        }
        tvQptionFour?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg
       )
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#e8be13"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one->{
                    tvQptionOne?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_two->{
                tvQptionTwo?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_three->{
                tvQptionThree?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four->{
                tvQptionFour?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition==0){
                    mCurrentPossition++
                    when{
                        mCurrentPossition<=mQuestionsList!!.size->{
                            setQuestion()
                        }
                        else->{
                            val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,userName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,correctAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question=mQuestionsList?.get(mCurrentPossition-1)
                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        correctAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if(mCurrentPossition==mQuestionsList!!.size){
                        btnSubmit?.text="FINISH"
                    }else{
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }

            }

        }
    }
    private fun answerView(answer:Int,drawableView: Int){
        when(answer){
            1->{
                tvQptionOne?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                tvQptionTwo?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                tvQptionThree?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                tvQptionFour?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
    }




