package net.junzz.app.lcg

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import net.junzz.app.util.LogUtils

class CreateAdapter(val data: MutableList<CreateItemDO> = mutableListOf())
    : RecyclerView.Adapter<CreateAdapter.CreateHolder>() {

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = CreateHolder(LayoutInflater.from(parent.context).inflate(R.layout.create_item, parent, false))

    override fun onBindViewHolder(holder: CreateHolder, position: Int) {
        // 变换颜色
        var keyColor = Color.RED
        var valueColor = Color.BLUE
        if (position % 2 == 0) {
            keyColor = Color.BLUE
            valueColor = Color.RED
        }
        holder.keyView.setBackgroundColor(keyColor)
        holder.valueView.setBackgroundColor(valueColor)

        recordContent(holder.keyView, data[position].key) { s -> data[position].key = s }
        recordContent(holder.valueView, data[position].value) { s -> data[position].value = s }
    }

    /**
     * 根据 TextChanged 事件保存值
     */
    private fun recordContent(editText: EditText, query: String, save: (String) -> Unit) {
        val viewTag = editText.tag
        if (viewTag is TextWatcher) {
            editText.removeTextChangedListener(viewTag)
        }

        editText.setText(query)

        val keyWatcher = object : TextWatcher {
            override fun afterTextChanged(editable: Editable) {
                LogUtils.debug("afterTextChanged::$editable")
                save(editable.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        }
        editText.addTextChangedListener(keyWatcher)
        editText.tag = keyWatcher
    }

    fun insertItem(item: CreateItemDO) {
        data.add(item)
        notifyItemInserted(data.size)
    }

    class CreateHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val keyView = itemView.findViewById<EditText>(R.id.et_create_item_key)!!
        val valueView = itemView.findViewById<EditText>(R.id.et_create_item_value)!!
    }

}