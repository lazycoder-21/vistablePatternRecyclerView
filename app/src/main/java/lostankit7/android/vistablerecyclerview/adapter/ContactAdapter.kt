package lostankit7.android.vistablerecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lostankit7.android.vistablerecyclerview.base.AbstractViewHolder
import lostankit7.android.vistablerecyclerview.base.BaseItemModel
import lostankit7.android.vistablerecyclerview.factory.ItemTypeFactory

class ContactAdapter(
    private val adapterTypeFactory: ItemTypeFactory,
    private val items: ArrayList<BaseItemModel> = arrayListOf(),
) : RecyclerView.Adapter<AbstractViewHolder<BaseItemModel>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AbstractViewHolder<BaseItemModel> {
        val view = inflateItem(parent, viewType)
        return adapterTypeFactory.createViewHolder(view, viewType)
                as AbstractViewHolder<BaseItemModel>
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AbstractViewHolder<BaseItemModel>, position: Int) {
        holder.bind(items[position])
    }

    private fun inflateItem(viewGroup: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(viewGroup.context).inflate(viewType, viewGroup, false)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type(adapterTypeFactory)
    }

    fun addItem(items: List<BaseItemModel>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun removeItem(item: BaseItemModel) {
        this.items.remove(item)
        notifyDataSetChanged()
    }

}