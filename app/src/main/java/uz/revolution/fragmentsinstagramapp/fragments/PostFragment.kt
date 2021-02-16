package uz.revolution.fragmentsinstagramapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_post.view.*
import uz.revolution.fragmentsinstagramapp.R
import uz.revolution.fragmentsinstagramapp.adapters.PostAdapter
import uz.revolution.fragmentsinstagramapp.models.MyModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PostFragment : Fragment() {

    private var param1: String? = null
    private var list: ArrayList<MyModel>? = null
    lateinit var adapter:PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_post, container, false)

        loadData()

        adapter= PostAdapter(list!!)
        root.rv.adapter = adapter
        Log.d("AAAA", "onCreateView: $param1")
        root.rv.scrollToPosition(param1!!.toInt())

        root.back_btn.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        return root
    }

    private fun loadData() {
        list = ArrayList()

        for (i in 0 until 99) {

            when (i % 9) {
                0 -> {
                    list?.add(MyModel(i, R.drawable.rasm0))
                }
                1->{
                    list?.add(MyModel(i, R.drawable.rasm1))
                }
                2->{
                    list?.add(MyModel(i, R.drawable.rasm2))
                }
                3->{
                    list?.add(MyModel(i, R.drawable.rasm3))
                }
                4->{
                    list?.add(MyModel(i, R.drawable.rasm4))
                }
                5->{
                    list?.add(MyModel(i, R.drawable.rasm5))
                }
                6->{
                    list?.add(MyModel(i, R.drawable.rasm6))
                }
                7->{
                    list?.add(MyModel(i, R.drawable.rasm7))
                }
                8->{
                    list?.add(MyModel(i, R.drawable.rasm8))
                }
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            PostFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

}