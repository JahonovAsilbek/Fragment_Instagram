package uz.revolution.fragmentsinstagramapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_insta.view.*
import kotlinx.android.synthetic.main.item_post.view.*
import uz.revolution.fragmentsinstagramapp.R
import uz.revolution.fragmentsinstagramapp.models.MyModel

class PostAdapter(var list: ArrayList<MyModel>) : RecyclerView.Adapter<PostAdapter.VH>() {

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(myModel: MyModel) {

            itemView.post_image.setImageResource(myModel.image)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}