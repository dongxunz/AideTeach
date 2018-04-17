package aide.voln520;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Main extends Activity implements OnClickListener {
    Button button[] = new Button[6];
    long current = 0;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int w = this.getWindowManager().getDefaultDisplay().getWidth();
        int h = this.getWindowManager().getDefaultDisplay().getHeight();
        if (w > h) {
            setContentView(R.layout.main);
            for (int i = 0; i < 6; i++) {
                button[i] = (Button) findViewById(getResources().getIdentifier("button" + (i + 1), "id", getPackageName()));
                button[i].setOnClickListener(this);
            }
            //button1.setLayoutParams(new RelativeLayout.LayoutParams
            //(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.FILL_PARENT));
            RelativeLayout.LayoutParams l1 = (RelativeLayout.LayoutParams) button[0].getLayoutParams();
            l1.width = w / 4;
            button[0].setLayoutParams(l1);
            RelativeLayout.LayoutParams l2 = (RelativeLayout.LayoutParams) button[1].getLayoutParams();
            l2.width = w / 2;
            l2.height = h / 7 * 2;
            button[1].setLayoutParams(l2);
            RelativeLayout.LayoutParams l3 = (RelativeLayout.LayoutParams) button[2].getLayoutParams();
            l3.height = 2 * h / 3;
            button[2].setLayoutParams(l3);
            RelativeLayout.LayoutParams l4 = (RelativeLayout.LayoutParams) button[3].getLayoutParams();
            l4.width = 3 * w / 10;
            button[3].setLayoutParams(l4);
        } else {
            setContentView(R.layout.main1);
            for (int i = 0; i < 6; i++) {
                button[i] = (Button) findViewById(getResources().getIdentifier("button0" + (i + 1), "id", getPackageName()));
                button[i].setOnClickListener(this);
            }
            RelativeLayout.LayoutParams l1 = (RelativeLayout.LayoutParams) button[0].getLayoutParams();
            l1.height = h / 4;
            button[0].setLayoutParams(l1);
            RelativeLayout.LayoutParams l2 = (RelativeLayout.LayoutParams) button[1].getLayoutParams();
            l2.height = h / 2;
            l2.width = w / 7 * 2;
            button[1].setLayoutParams(l2);
            RelativeLayout.LayoutParams l3 = (RelativeLayout.LayoutParams) button[2].getLayoutParams();
            l3.width = 2 * w / 3;
            button[2].setLayoutParams(l3);
            RelativeLayout.LayoutParams l4 = (RelativeLayout.LayoutParams) button[3].getLayoutParams();
            l4.height = 3 * h / 10;
            button[3].setLayoutParams(l4);
        }

    }

    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        if (id == R.id.button06 || id == R.id.button6) {
            intent = new Intent(this, About.class);
            startActivity(intent);
        } else if (id == R.id.button04 || id == R.id.button4) {
            intent = new Intent(this, Aide.class);
            startActivity(intent);
        } else {
            intent = new Intent(this, List.class);
            if (id == R.id.button05 || id == R.id.button5) {
                intent.putExtra("list", "5");
            } else if (id == R.id.button03 || id == R.id.button3) {
                intent.putExtra("list", "3");
            } else if (id == R.id.button02 || id == R.id.button2) {
                intent.putExtra("list", "2");
            } else {
                intent.putExtra("list", "1");
            }
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - current > 2000) {
            current = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_LONG).show();
        } else {
            finish();
            System.exit(0);
        }
    }

}
