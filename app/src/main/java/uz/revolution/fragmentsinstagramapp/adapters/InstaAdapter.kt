package uz.revolution.fragmentsinstagramapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_insta.view.*
import uz.revolution.fragmentsinstagramapp.R
import uz.revolution.fragmentsinstagramapp.fragments.PostFragment
import uz.revolution.fragmentsinstagramapp.models.MyModel

class InstaAdapter(var list: ArrayList<MyModel>) : RecyclerView.Adapter<InstaAdapter.VH>() {

    private var onItemClickListener:OnItemClickListener?=null

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(myModel: MyModel) {

            itemView.rv_images.setImageResource(myModel.image)

            itemView.rv_images.setOnClickListener {
                if (onItemClickListener != null) {
                    onItemClickListener?.onClick(myModel.id)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_insta, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener{
        fun onClick(id:Int)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener=onItemClickListener
    }


}