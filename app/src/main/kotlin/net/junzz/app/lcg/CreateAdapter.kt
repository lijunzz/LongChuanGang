package net.junzz.app.lcg

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import net.junzz.app.lcg.common.logDebug
import net.junzz.app.lcg.common.toJson

class CreateAdapter(var data: List<CreateItemDO>) : RecyclerView.Adapter<CreateAdapter.ViewHolder>() {

    private lateinit var keyWatcher: TextWatcher
    private lateinit var valueWatcher: TextWatcher

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.create_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 变换颜色
        var keyColor = Color.RED
        var valueColor = Color.BLUE
        if (position % 2 == 0) {
            keyColor = Color.BLUE
            valueColor = Color.RED
        }
        holder.key.setBackgroundColor(keyColor)
        holder.value.setBackgroundColor(valueColor)

        val watcherState: Boolean
        val keyTag = holder.key.tag
        if (keyTag == null) {
            watcherState = false
        } else {
            watcherState = keyTag as Boolean
        }


        if (!watcherState) {
            logDebug("@@@::$watcherState::$position")

            holder.key.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    data[position].key = p0.toString()
                }

            })

            holder.key.tag = true
        }

        holder.key.setText(data[position].key)
        holder.value.setText(data[position].value)
    }

//    override fun onViewAttachedToWindow(holder: ViewHolder) {
//        super.onViewAttachedToWindow(holder)
//        val position = holder.key.tag as Int
//        keyWatcher = ItemWatcher(position, 1)
//        valueWatcher = ItemWatcher(position, 2)
//        holder.key.addTextChangedListener(keyWatcher)
//        holder.value.addTextChangedListener(valueWatcher)
//
//        logDebug("onViewAttachedToWindow::${holder.key.tag}")
//    }
//
//    override fun onViewDetachedFromWindow(holder: ViewHolder) {
//        super.onViewDetachedFromWindow(holder)
//        holder.key.removeTextChangedListener(keyWatcher)
//        holder.value.removeTextChangedListener(valueWatcher)
//
//        logDebug("onViewDetachedFromWindow::${holder.key.tag}")
//    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val key = itemView.findViewById<EditText>(R.id.et_create_item_key)!!
        val value = itemView.findViewById<EditText>(R.id.et_create_item_value)!!
    }

    /**
     * @param type 1: key, 2: value
     */
    private inner class ItemWatcher(val position: Int, val type: Int) : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            val sequence = p0.toString()
            val key = data[position].key
            val value = data[position].value
            when (type) {
                1 -> {
                    if (sequence != key) {
                        data[position].key = sequence
                        logDebug("onTextChanged::$sequence::$position")
                    }
                }
                2 -> {
                    if (sequence != value) {
                        data[position].value = sequence
                    }
                }
            }
        }
    }
}