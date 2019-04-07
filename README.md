# 安卓移动开发试验三：UI组件

## 一、试验内容
1.利用SimpleAdapter实现实现老师要求的界面
2.创建自定义布局的AlertDialog
3.使用XML定义菜单
4.创建上下文操作模式(ActionMode)的上下文菜单
## 二、试验代码与截图
1.主界面

代码：

MainActivity.java
```
package com.example.testui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Test1.class);
                startActivity(intent1);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Test2.class);
                startActivity(intent2);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, Test3.class);
                startActivity(intent3);
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, Test4.class);
                startActivity(intent4);
            }
        });
    }
}

```
activity_min.xml

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button"
        android:layout_width="170dp"
        android:layout_height="82dp"
        android:text="SimpleAdapter"
        android:gravity="center"
        app:layout_constraintTop_toBottomOf="@+id/textView"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"/>

    <Button
        android:id="@+id/button2"
        android:layout_width="170dp"
        android:layout_height="82dp"
        android:text="AlertDialog"
        android:gravity="center"
        app:layout_constraintTop_toBottomOf="@+id/button"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent" />

    <Button
        android:id="@+id/button3"
        android:layout_width="170dp"
        android:layout_height="82dp"
        android:text="XML"
        android:gravity="center"
        app:layout_constraintTop_toBottomOf="@+id/button2"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"/>

    <Button
        android:id="@+id/button4"
        android:layout_width="170dp"
        android:layout_height="82dp"
        android:text="ActionMode"
        android:gravity="center"
        app:layout_constraintTop_toBottomOf="@+id/button3"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"/>

    <TextView
        android:id="@+id/textView"
        android:layout_width="183dp"
        android:layout_height="63dp"
        android:gravity="center"
        android:text="实验三"
        android:textSize="50sp"
        app:layout_constraintHorizontal_bias="0.513"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</android.support.constraint.ConstraintLayout>
```

截图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190407125516131.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2h1YWlxaTgzNzg=,size_16,color_FFFFFF,t_70)

2.利用SimpleAdapter实现实现老师要求的界面

代码：

Test1.java

```
package com.example.testui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.*;

public class Test1 extends AppCompatActivity {

    private String []names=new String []{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[]imgIds=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        final List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String,Object>showItem=new HashMap<String, Object>();
            showItem.put("img",imgIds[i]);
            showItem.put("name",names[i]);
            list.add(showItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.activity_test1_1,new String[]{"img","name"},new int[]{R.id.image,R.id.name});
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View view,int position,long id){
                Toast.makeText(Test1.this,names[position],Toast.LENGTH_LONG).show();
            }
        });
    }
}

```
activity_test1.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.testui.Test1">
    <ListView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:listSelector="#abc"
        android:id="@+id/list">

    </ListView>

</LinearLayout>
```
activity_test1_1.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_gravity="center_vertical"
    android:orientation="horizontal">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/name"
        android:textSize="15dp"
        />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="right">

        <ImageView
            android:id="@+id/image"
            android:layout_width="60dp"
            android:layout_height="60dp"
            />
    </LinearLayout>
</LinearLayout>
```

截图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190407125121195.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2h1YWlxaTgzNzg=,size_16,color_FFFFFF,t_70)

3.创建自定义布局的AlertDialog

代码：

test2.java

```
package com.example.testui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Test2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        Button button5=findViewById(R.id.button5);
        LayoutInflater inflater=Test2.this.getLayoutInflater();
        View v= inflater.inflate(R.layout.activity_test2_1,null,false);
        Context context=Test2.this;
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setView(v);
        builder.setCancelable(false);
        final AlertDialog alertDialog=builder.create();
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });
        v.findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Test2.this,"NO",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
        v.findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Test2.this,"YES",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
    }
}
```
activity_test2.xml

```
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Test2">

    <Button
        android:id="@+id/button5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="登录"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        />

</android.support.constraint.ConstraintLayout>
```
aactivity_test2_1.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/header_logo"/>

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Username"
        android:layout_marginLeft="5dp"
        android:layout_marginRight="5dp"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Password"
        android:inputType="textPassword"
        android:layout_marginLeft="5dp"
        android:layout_marginRight="5dp"/>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="10dp">

        <Button
            android:id="@+id/button6"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Cancel" />
        <Button
            android:id="@+id/button7"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Sign in"
            android:layout_weight="1"/>
    </LinearLayout>
</LinearLayout>
```

截图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190407125143834.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2h1YWlxaTgzNzg=,size_16,color_FFFFFF,t_70)

4.使用XML定义菜单

代码：

Test3.java

```
package com.example.testui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Test3 extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_test3_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textView = findViewById(R.id.textView2);
        switch (item.getItemId()) {
            case R.id.set_size:
                Toast.makeText(this, "设置字体大小", Toast.LENGTH_SHORT).show();
                break;
            case R.id.small:
                Toast.makeText(this, "小", Toast.LENGTH_SHORT).show();
                textView.setTextSize(10);
                break;
            case R.id.middle:
                Toast.makeText(this, "中", Toast.LENGTH_SHORT).show();
                textView.setTextSize(16);
                break;
            case R.id.big:
                Toast.makeText(this, "大", Toast.LENGTH_SHORT).show();
                textView.setTextSize(20);
                break;
            case R.id.menu_item:
                Toast.makeText(this, "普通菜单项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.set_color:
                Toast.makeText(this, "设置字体颜色", Toast.LENGTH_SHORT).show();
                break;
            case R.id.red:
                Toast.makeText(this, "红色", Toast.LENGTH_SHORT).show();
                int red = Color.parseColor("#FF0033");
                textView.setTextColor(red);
                break;
            case R.id.black:
                Toast.makeText(this, "黑色", Toast.LENGTH_SHORT).show();
                int black = Color.parseColor("#000000");
                textView.setTextColor(black);
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
    }
}
```
activity_test3.xml

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Test3">

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:background="#ccc"
        android:orientation="horizontal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <TextView
            android:id="@+id/textView2"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:gravity="center_vertical"
            android:text="测试文字..."
            android:textColor="#ffff00"
            android:textSize="20sp" />

    </TableRow>

</android.support.constraint.ConstraintLayout>
```
activity_test3_menu.xml

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/set_size"
        android:title="字体大小">
        <menu>
            <item
                android:id="@+id/small"
                android:title="小"/>
            <item
                android:id="@+id/middle"
                android:title="中"/>
            <item
                android:id="@+id/big"
                android:title="大"/>
        </menu>
    </item>
    <item
        android:id="@+id/menu_item"
        android:title="普通菜单项"/>
    <item
        android:id="@+id/set_color"
        android:title="字体颜色">
        <menu>
            <item
                android:id="@+id/red"
                android:title="红色"/>
            <item
                android:id="@+id/black"
                android:title="黑色"/>
        </menu>

    </item>
</menu>
```

截图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019040712515970.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2h1YWlxaTgzNzg=,size_16,color_FFFFFF,t_70)
![](https://img-blog.csdnimg.cn/20190407125210564.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2h1YWlxaTgzNzg=,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190407125231328.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2h1YWlxaTgzNzg=,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190407125249101.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2h1YWlxaTgzNzg=,size_16,color_FFFFFF,t_70)

5.创建上下文操作模式(ActionMode)的上下文菜单

代码：

Test4.java
```
package com.example.testui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.view.ActionMode;
import java.util.ArrayList;
import java.util.List;

public class Test4 extends AppCompatActivity {
    private ListView listView;
    private List<Item> list;
    private BaseAdapter adapter;
    private String [] name = {"One","Two","Three","Four","Five","Six"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4 );

        listView = findViewById(R.id.list_view);
        list = new ArrayList<Item>();
        //赋值
        for(int i = 0; i < 6; i++){
            list.add(new Item(name[i], false));
        }
        //适配
        adapter = new AdapterCur(list, Test4.this);
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {
            //选中数量
            int num = 0;
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                // 调整选定条目
                if (checked == true) {
                    list.get(position).setBo(true);
                    //实时刷新
                    adapter.notifyDataSetChanged();
                    num++;
                } else {
                    list.get(position).setBo(false);
                    //实时刷新
                    adapter.notifyDataSetChanged();
                    num--;
                }
                // 用TextView显示
                mode.setTitle("  " + num + " Selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {

                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.activity_test4_menu, menu);
                num = 0;
                adapter.notifyDataSetChanged();
                return true;

            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

                adapter.notifyDataSetChanged();
                return false;
            }
            public void refresh(){
                for(int i = 0; i < 6; i++){
                    list.get(i).setBo(false);
                }
            }
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    //删除
                    case R.id.delete:
                        adapter.notifyDataSetChanged();
                        num = 0;
                        refresh();
                        mode.finish();
                        return true;
                    default:
                        refresh();
                        adapter.notifyDataSetChanged();
                        num = 0;
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                refresh();
                adapter.notifyDataSetChanged();
            }
        });
    }
}
```
AdapterCur.java
```
package com.example.testui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterCur extends BaseAdapter {
    List<Item> list;
    Context context;

    //初始化
    public AdapterCur(List<Item> list, Context context) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return list.size();
    }

    public Item getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.activity_test4_1, null);
            viewHolder=new ViewHolder();
            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.img);
            viewHolder.textView=(TextView) convertView.findViewById(R.id.text_view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }

        int a = Color.parseColor("#ABC000");
        int b = Color.parseColor("#FFFFFF");
        viewHolder.textView.setText(list.get(position).getName());
        //改变选中颜色
        if(list.get(position).isBo() == true){
            viewHolder.textView.setBackgroundColor(a);
            viewHolder.imageView.setBackgroundColor(a);
        }
        else {
            viewHolder.textView.setBackgroundColor(b);
            viewHolder.imageView.setBackgroundColor(b);

        }
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
```
Item.java

```
package com.example.testui;

public class Item {
    private String name;
    private boolean bo;

    public Item(){
        super();
    }

    public Item(String name, boolean bo){
        super();
        this.name = name;
        this.bo = bo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isBo() {
        return bo;
    }

    public void setBo(boolean bo) {
        this.bo = bo;
    }
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ",bo=" + bo +
                '}';
    }
}
```

activity_test4.xml

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Test4">
    <LinearLayout android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="16dp"
        tools:layout_editor_absoluteY="0dp"
        tools:ignore="MissingConstraints">


        <ListView
            android:id="@+id/list_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:choiceMode="multipleChoiceModal"/>


    </LinearLayout>
</android.support.constraint.ConstraintLayout>
```

activity_test4_1.xml

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:paddingTop="5dp"
    android:paddingBottom="5dp">

    <ImageView
        android:id="@+id/img"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:src="@drawable/android" />
    <TextView
        android:id="@+id/text_view"
        android:layout_width="336dp"
        android:layout_height="70dp"
        android:gravity="center_vertical"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        android:layout_marginEnd="3dp"
        android:layout_marginRight="3dp"
        android:textAppearance="?android:textAppearanceLarge" />


</RelativeLayout>
```

activity_test4_menu.xml

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/delete"
        app:showAsAction="always"
        android:icon="@drawable/delete"
        android:title="item_delete"/>

</menu>
```

截图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190407125320554.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2h1YWlxaTgzNzg=,size_16,color_FFFFFF,t_70)
