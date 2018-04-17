package aide.voln520;

import android.app.*;
import android.content.*;
import android.os.*;

public class LOGO extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
		new Handler().postDelayed(new Runnable() {
				@Override
				public void run()
				{
					Intent intent = new Intent(LOGO.this,Main.class);
					startActivity(intent);
					LOGO.this.finish();
				}
			}, 1500);
		}
}
