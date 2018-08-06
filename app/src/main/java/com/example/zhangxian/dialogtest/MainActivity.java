package com.example.zhangxian.dialogtest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    /**
     * 弹出确定取消对话框
     * @param view
     */
    public void click01(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告");
        builder.setMessage("是否继续");
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"no",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click02(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择性别");
        final String[] items = {"男","女"};
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"您性别为："+items[i],Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }
    public void click03(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("爱吃水果");
        final String[] items = {"苹果","梨子","香蕉","菠萝"};
        final boolean[] checkeds = {true,false,true,false};
        builder.setMultiChoiceItems(items, checkeds, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(MainActivity.this,items[i] + b,Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("提交", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                StringBuffer stringBuffer = new StringBuffer();
                for(int x=0;x<checkeds.length;x++){
                    stringBuffer.append(items[x]+" ");
                }
                Toast.makeText(MainActivity.this,"喜欢吃："+stringBuffer.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click04(View view)
    {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("警告");
        pd.setMessage("是否继续？");
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pd.dismiss();
            }
        }.start();
        pd.show();
    }
    public void click05(View view)
    {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("请稍后");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("加载中");
        pd.setMax(100);
        pd.show();
        new Thread()
        {
            @Override
            public void run() {
                for(int i =0 ; i<100 ;i++)
                {
                    try {
                        Thread.sleep(300);
                        pd.setProgress(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                pd.dismiss();
            }

        }.start();


    }
}
