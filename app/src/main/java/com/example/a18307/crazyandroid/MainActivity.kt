package com.example.a18307.crazyandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
//    定义图片数组，图片不能是纯数字
    internal var images= intArrayOf(R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,
    R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listItems=ArrayList<Map<String,Any>>()
        for(i in images.indices){
            var listItem=HashMap<String,Any>()
            listItem["image"]=images[i]
            listItems.add(listItem)
        }

        var imageView:ImageView=findViewById(R.id.imageView)
        //this表示当前环境，listItems是传入的map列表，R.layout.image是每一个子项的布局
        //arrayOf("image")是每个子项的键名（在上面的循环中都统一成了image，这里要和map中的key保持一致)
        //intArrayOf(R.id.image1)表示图片放置的控件id,这里都统一成一个
        var simpleAdapter =SimpleAdapter(this,listItems,R.layout.image,arrayOf("image"),intArrayOf(R.id.image1))
        var gridView:GridView=findViewById(R.id.grid01)
        gridView.adapter=simpleAdapter

        gridView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //?表示可以为空，避免空指针异常
            //在这个例子中，这个函数其实没有作用，但是他可以实现比如修改选中图片的颜色等功能
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                imageView.setImageResource(images[position])
            }
            //注意中该函数里面不需要写东西，把原来的删掉
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        //监听到选中的图片，并放到下方
        gridView.onItemClickListener=AdapterView.OnItemClickListener{parent,view,position,id->
            imageView.setImageResource(images[position])

        }
    }
}
