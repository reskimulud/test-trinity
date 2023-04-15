package io.github.reskimulud.testtrinity.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.reskimulud.testtrinity.Contact
import io.github.reskimulud.testtrinity.databinding.ContactItemBinding

class GridContactAdapter(
    private val onClickCallback: (itemId: String) -> Unit,
): RecyclerView.Adapter<GridContactAdapter.ViewHolder>() {
    private val listContacts = ArrayList<Contact>()

    fun setData(contacts: ArrayList<Contact>) {
        listContacts.addAll(contacts)
        notifyDataSetChanged()
    }

    class ViewHolder(itemContact: ContactItemBinding) : RecyclerView.ViewHolder(itemContact.root) {
        private val tvName = itemContact.tvName

        fun bind(data: Contact) {
            tvName.text = StringBuilder(data.firstName).append(" ").append(data.lastName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listContacts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = listContacts[position]
        holder.bind(contact)
        holder.itemView.setOnClickListener {
            onClickCallback(contact.id)
        }
    }
}