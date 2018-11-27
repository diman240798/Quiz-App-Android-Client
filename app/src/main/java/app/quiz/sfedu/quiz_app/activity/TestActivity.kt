package app.quiz.sfedu.quiz_app.activity

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v7.app.AppCompatActivity
import app.quiz.sfedu.quiz_app.R
import app.quiz.sfedu.quiz_app.db_model.QuestionModel
import app.quiz.sfedu.quiz_app.db_model.TestModel
import app.quiz.sfedu.quiz_app.fragment.TestFragment
import kotlinx.android.synthetic.main.test_activity.*

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity)

        val testFragment = TestFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.test_root_lay, testFragment)
            .commit();

        val motionLayout = testActivityMotionContainer as MotionLayout
        motionLayout.setTransitionListener(
            object: MotionLayout.TransitionListener {
                override fun onTransitionChange(p0: MotionLayout?, startId: Int, endId: Int, progress: Float) {

                }

                override fun onTransitionCompleted(p0: MotionLayout?, currentId: Int) {
                    if(currentId == R.id.ending_set) {
                        // load fake Data
                        var questionsFake = arrayOf(
                            QuestionModel(
                                1, "Are you dumb?",
                                1, arrayOf("yes", "yes", "yes", "yes")
                            )
                        )
                        var tests = listOf<TestModel>(TestModel(1, questionsFake))
                        var test = tests.get(0)
                        val questions = test.questions
                        var question = questions[0]
                        testFragment.setQuestion(question)

                    }
                }
            }
        )
        motionLayout.transitionToEnd()



    }

    override fun onResume() {
        super.onResume()
        test_back_bt.setOnClickListener {

        }

        test_next_bt.setOnClickListener {

        }

    }

}
