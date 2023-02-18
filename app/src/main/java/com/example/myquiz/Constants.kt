package com.example.myquiz

object Constants {
    const val USER_NAME :String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()

        val que1=Question(
            id = 1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Australia",
            "Armenia","Austria",
            1
        )
        val que2=Question(
            id = 2,"What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Armenia","Australia",
            "Argentina","Austria",
            2
        )
        val que3=Question(
            id = 3,"What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Denmark","Belgium",
            "Germany","Brazil",
            2
        )
        val que4=Question(
            id = 4,"What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Denmark","Belgium",
            "Germany","India",
            3
        )
        val que5=Question(
            id = 5,"What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina","Austria",
            "Germany","New Zeland",
            4
        )
        val que6=Question(
            id = 6,"What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India","Australia",
            "Belgium","Brazil",
            1
        )
        val que7=Question(
            id = 7,"What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Denmark","Belgium",
            "Germany","Brazil",
            4
        )
        val que8=Question(
            id = 8,"What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium","India",
            "Germany","Brazil",
            1
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        return questionsList
    }
}