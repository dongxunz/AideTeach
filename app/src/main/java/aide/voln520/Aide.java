package aide.voln520;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Aide extends Activity
{	public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.aide);
		final Button b=(Button)findViewById(R.id.aimg);
	DisplayMetrics dm = getResources().getDisplayMetrics();
	final int screenWidth = dm.widthPixels;   
	final int screenHeight = dm.heightPixels - 50;
	b.setOnTouchListener(new OnTouchListener(){
		int lastX, lastY,left,right,top,bottom,left1,right1,top1,bottom1; 
		int ii=0;
	public boolean onTouch(View v, MotionEvent event) {   
		int ea=event.getAction();  
		Log.i("TAG", "Touch:"+ea);
		switch(ea){   
			case MotionEvent.ACTION_DOWN:
				if(ii>0){	
					lastX = (int) event.getRawX();   
					lastY = (int) event.getRawY();}   
				break; 
			case MotionEvent.ACTION_MOVE:
				if(ii>0){
					int dx =(int)event.getRawX() - lastX;   
					int dy =(int)event.getRawY() - lastY;   
					left = v.getLeft() + dx;   
					top = v.getTop() + dy;   
					right = v.getRight() + dx;   
					bottom = v.getBottom() + dy;   
					if(left < 0){   
						left = 0;   
						right = left + v.getWidth();   
					}   
					if(right > screenWidth){   
						right = screenWidth;   
						left = right - v.getWidth();   
					}   
					if(top < 0){   
						top = 0;   
						bottom = top + v.getHeight();   
					}   
					if(bottom > screenHeight){   
						bottom = screenHeight;   
						top = bottom - v.getHeight();   
					}   
					v.layout(left, top, right, bottom);   
					Log.i("", "position：" + left +", " + top + ", " + right + ", " + bottom);
					lastX = (int) event.getRawX();   
					lastY = (int) event.getRawY(); }
				break;   
			case MotionEvent.ACTION_UP:
				TextView t=(TextView)findViewById(R.id.atxt);
				if(ii==0){left1 = b.getLeft();
					top1 = b.getTop();
					right1 = b.getRight();
					bottom1 = b.getBottom();
					left=left1;top=top1;
					ii=1;
					t.setText(R.string.aide7);
					b.setBackgroundResource(R.drawable.ic_launcher);}
				else if(left==0){
					b.layout(left1, top1, right1, bottom1);
					left=left1;right=right1;top=top1;bottom=bottom1;
					ii=0;
					t.setText(R.string.sorry);
					b.setBackgroundResource(R.drawable.ax);
					}
				else if(right==screenWidth){
					b.layout(left1, top1, right1, bottom1);
					left=left1;right=right1;top=top1;bottom=bottom1;
					ii=0;
					t.setText(R.string.aide4);
					b.setBackgroundResource(R.drawable.ax);
					openUrl("http://tieba.baidu.com/p/2775177946");}
				else if(top==0){
					b.layout(left1, top1, right1, bottom1);
					left=left1;right=right1;top=top1;bottom=bottom1;
					ii=0;
					t.setText(R.string.aide1);
					b.setBackgroundResource(R.drawable.ax);
					openUrl("http://tieba.baidu.com/f?kw=aide");
					}
				else if(bottom==screenHeight){
					b.layout(left1, top1, right1, bottom1);
					left=left1;right=right1;top=top1;bottom=bottom1;
					ii=0;
					t.setText(R.string.aide2);
					b.setBackgroundResource(R.drawable.ax);
					openUrl("http://pan.baidu.com/s/1i3KCbBJ");}
				else{b.layout(left1, top1, right1, bottom1);
				}
				break;                 
		}   
		return true;   
	 }});  
	 }
	
	private void openUrl(String url) {
		Uri uri = Uri.parse(url);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}
}
