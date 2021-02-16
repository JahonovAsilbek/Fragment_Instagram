package uz.revolution.fragmentsinstagramapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_main.view.*
import uz.revolution.fragmentsinstagramapp.R
import uz.revolution.fragmentsinstagramapp.adapters.InstaAdapter
import uz.revolution.fragmentsinstagramapp.models.MyModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MainFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var list: ArrayList<MyModel>? = null
    lateinit var adapter: InstaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_main, container, false)

        loadData()
        adapter = InstaAdapter(list!!)
        val layoutManager = GridLayoutManager(root.context, 3)
        root.rv.layoutManager = layoutManager
        root.rv.adapter = adapter

        adapter.setOnItemClickListener(object : InstaAdapter.OnItemClickListener {
            override fun onClick(id: Int) {

                val postFragment = PostFragment()
                val bundle = Bundle()
                bundle.putString("param1",id.toString())
                postFragment.arguments=bundle

                fragmentManager?.beginTransaction()?.replace(R.id.container, postFragment, "post")
                    ?.addToBackStack("post")
                    ?.commit()

            }

        })

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

        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}