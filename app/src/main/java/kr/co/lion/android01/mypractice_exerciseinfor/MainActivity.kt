package kr.co.lion.android01.mypractice_exerciseinfor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.co.lion.android01.mypractice_exerciseinfor.databinding.ActivityMainBinding

lateinit var activityMainBinding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBinding
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.apply {
            radioButton.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    weightEdit.setVisibility(View.VISIBLE)
                } else {
                    weightEdit.setVisibility(View.GONE)
                }
            }

            switch1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked){
                    checkBox.setVisibility(View.VISIBLE)
                    checkBox2.setVisibility(View.VISIBLE)
                    checkBox3.setVisibility(View.VISIBLE)
                    checkBox4.setVisibility(View.VISIBLE)

                }else{
                    checkBox.setVisibility(View.GONE)
                    checkBox2.setVisibility(View.GONE)
                    checkBox3.setVisibility(View.GONE)
                    checkBox4.setVisibility(View.GONE)
                }
            }
            resultButton.setOnClickListener {
                result.text = ""
                when(toggleGroup.checkedButtonId){
                    R.id.manbutton -> result.append("남자입니다\n")
                    R.id.girlbutton -> result.append("여자입니다\n")
                }
                var age = ageEdit.text.toString()
                var height = heightEdit.text.toString()
                var weight = weightEdit.text.toString()


                when(RadioGroup.checkedRadioButtonId){
                    R.id.radioButton10 -> result.append("40kg 이하\n")
                    R.id.radioButton9 -> result.append("40~50kg 사이\n")
                    R.id.radioButton8 -> result.append("50~60kg 사이\n")
                    R.id.radioButton7 -> result.append("60~70kg 사이\n")
                    R.id.radioButton6 -> result.append("70~80kg 사이\n")
                    R.id.radioButton5 -> result.append("80~90kg 사이\n")
                    R.id.radioButton4 -> result.append("90~100kg 사이\n")
                    R.id.radioButton3 -> result.append("100~110kg 사이\n")
                    R.id.radioButton2 -> result.append("110kg 이상\n")
                    else -> result.append("몸무게 : ${weight}kg\n")

                }
                var str1 = when(checkBox.isChecked){
                        true -> "좋아하는 운동은 헬스입니다"
                        false -> ""
                    }

                var str2 = when(checkBox2.isChecked){
                        true -> "좋아하는 운동은 필라테스입니다"
                        false -> ""
                    }

                var str3 = when(checkBox3.isChecked){
                        true -> "좋아하는 운동은 구기종목입니다"
                        false -> ""
                    }

                var str4 = when(checkBox4.isChecked){
                        true -> "보기에 좋아하는 운동이 없습니다"
                        false -> ""
                    }


                result.append("나이 : ${age}살\n키 : ${height}cm\n좋아하는 운동 : ${str1}\n${str2}\n${str3}\n${str4}\n")


                }
            }
            
            
        }
    }
