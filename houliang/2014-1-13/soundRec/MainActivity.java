package com.example.soundres;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends Activity {
	Button mBtnSound;
	public static final int REQUEST_CODE_DOUND_REQ = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBtnSound = (Button) findViewById(R.id.btnSound);
		mBtnSound.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Intent i = new Intent(
							RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
					startActivityForResult(i, REQUEST_CODE_DOUND_REQ);
				} catch (Exception e) {
					new AlertDialog.Builder(MainActivity.this)
							.setTitle("NotFound")
							.setMessage("没有找到谷歌语音识别模块，是否安装？")
							.setPositiveButton("是", new OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									FileOutputStream out = null;
									InputStream in = null;
									try {
										// 获取输入流
										in = getAssets()
												.open("goolesearch.apk");
										// 获取本地文件夹目录
										File dir = Environment
												.getExternalStorageDirectory();
										File file = new File(dir,
												"/goolesearch.apk");
										// File file=new
										// File("/mnt/goolesearch.apk");
										out = new FileOutputStream(file);
										int len;
										byte[] buf = new byte[1024];
										while ((len = in.read(buf)) != -1) {
											out.write(buf, 0, len);
										}
										Intent i = new Intent();
										// 设置启动模式
										i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
										//
										i.setAction(android.content.Intent.ACTION_VIEW);
										i.setDataAndType(Uri.fromFile(file),
												"application/vnd.android.package-archive");
										startActivity(i);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} finally {
										try {
											if (out != null) {
												out.close();
											}
											if (in != null) {
												in.close();
											}
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								}
							}).setNegativeButton("否", null).create().show();
				}
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case REQUEST_CODE_DOUND_REQ:
				ArrayList<String> speeks = null;
				speeks = data
						.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
				// for (int i = 0; i < speeks.size(); i++) {
				// Log.i("speek", speeks.get(i));
				// }
				TextView mTv = (TextView) findViewById(R.id.tvSpeek);
				mTv.setText(speeks.get(0));
				break;
			default:
				break;
			}
		}
		super.onActivityResult(requestCode, resultCode, data);

	}

}
