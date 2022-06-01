package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

class ItemAdapter(
    private val context: Context,
    private val dataSet: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //contiene referencias a las vistas individuales dentro de un diseño de elemento de lista
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // El administrador de diseño lo llama a fin de crear nuevas interfaces de vista para
        //Create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // El administrador de diseño llama a este método para reemplazar el contenido de una vista de elementos de lista.
        val item = dataSet[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }

    //debe mostrar el tamaño de tu conjunto de datos
    override fun getItemCount() = dataSet.size
}