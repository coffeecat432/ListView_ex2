package com.amigo.listview_ex2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class ListViewAdapter(val List : MutableList<ListViewModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var converView = convertView

        if (converView == null){
            converView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent, false)
        }

        // listview_item.xml의 첫번째 TextView를 id로 가져와서 title 변수에 넣는다.
        // 해당 title의 내용을 <ListViewModel>을 받아온 내용을 중에서, ListViewModel로 가보면 title과 content로 구성되어 있는데, title만 넣는다.
        val title = converView!!.findViewById<TextView>(R.id.listviewItem)
        title.text = List[position].title
        // List[0] -> ListViewModel("ModelA",B")
        // List[1] -> ListViewModel("ModelC",D")
        // List[2] -> ListViewModel("ModelE",F")


        // listview_item.xml의 두번째 TextView를 id로 가져와서 content 변수에 넣는다.
        // 해당 content의 내용을 <ListViewModel>을 받아온 내용을 중에서, ListViewModel로 가보면 title과 content로 구성되어 있는데, content만 넣는다.
        val content = converView!!.findViewById<TextView>(R.id.listviewItem2)
        content.text = List[position].content
        // List[0] -> ListViewModel("ModelA",B")
        // List[1] -> ListViewModel("ModelC",D")
        // List[2] -> ListViewModel("ModelE",F")


        return converView!!
    }

}