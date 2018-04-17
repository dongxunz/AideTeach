package aide.voln520;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.webkit.*;
import android.widget.*;

import java.io.*;

import org.apache.http.util.*;

public class Content extends Activity {
    private int l1, l2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        WebView web = (WebView) findViewById(R.id.web);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        String str;
        l1 = Integer.parseInt(intent.getStringExtra("l1"));
        l2 = Integer.parseInt(intent.getStringExtra("l2"));
        if (l2 < 10) {
            str = "file:///android_asset/" + l1 + "0" + l2 + ".html";
        } else {
            str = "file:///android_asset/" + l1 + l2 + ".html";
        }

        web.loadUrl(str);
        final Button b = (Button) findViewById(R.id.img);
        if (l1 == 5) {
            b.setBackgroundColor(Color.TRANSPARENT);
        } else {
            DisplayMetrics dm = getResources().getDisplayMetrics();
            final int screenWidth = dm.widthPixels;
            final int screenHeight = dm.heightPixels - 50;
            b.setOnTouchListener(new OnTouchListener() {
                int lastX, lastY, left, right, top, bottom, left1, right1, top1, bottom1;
                int ii = 0;

                public boolean onTouch(View v, MotionEvent event) {
                    int ea = event.getAction();
                    Log.i("TAG", "Touch:" + ea);
                    String kk = null;
                    switch (ea) {
                        case MotionEvent.ACTION_DOWN:
                            if (ii > 0) {
                                lastX = (int) event.getRawX();
                                lastY = (int) event.getRawY();
                            }
                            break;
                        case MotionEvent.ACTION_MOVE:
                            if (ii > 0) {
                                int dx = (int) event.getRawX() - lastX;
                                int dy = (int) event.getRawY() - lastY;
                                left = v.getLeft() + dx;
                                top = v.getTop() + dy;
                                right = v.getRight() + dx;
                                bottom = v.getBottom() + dy;
                                if (left < 0) {
                                    left = 0;
                                    right = left + v.getWidth();
                                }
                                if (right > screenWidth) {
                                    right = screenWidth;
                                    left = right - v.getWidth();
                                }
                                if (top < 0) {
                                    top = 0;
                                    bottom = top + v.getHeight();
                                }
                                if (bottom > screenHeight) {
                                    bottom = screenHeight;
                                    top = bottom - v.getHeight();
                                }
                                v.layout(left, top, right, bottom);
                                Log.i("", "position：" + left + ", " + top + ", " + right + ", " + bottom);
                                lastX = (int) event.getRawX();
                                lastY = (int) event.getRawY();
                            }
                            break;
                        case MotionEvent.ACTION_UP:
                            if (ii == 0) {
                                left1 = b.getLeft();
                                top1 = b.getTop();
                                right1 = b.getRight();
                                bottom1 = b.getBottom();
                                ii = 1;
                                b.layout(left1 + 10, top1 + 10, right1 + 10, bottom1 + 10);
                                Toast.makeText(Content.this, R.string.fuzhi, Toast.LENGTH_LONG).show();
                            } else if (right == screenWidth) {
                                b.layout(left1, top1, right1, bottom1);
                                right = right1;
                                ii = 0;
                                String str = "";
                                InputStream in = null;
                                try {
                                    if (l1 == 1) {
                                        if (l2 == 0) {
                                            in = getResources().openRawResource(R.raw.j103);
                                        } else if (l2 == 1) {
                                            in = getResources().openRawResource(R.raw.j102);
                                        } else if (l2 == 2) {
                                            in = getResources().openRawResource(R.raw.j103);
                                        } else if (l2 == 3) {
                                            in = getResources().openRawResource(R.raw.j102);
                                        } else if (l2 == 4) {
                                            in = getResources().openRawResource(R.raw.j105);
                                        } else if (l2 == 5) {
                                            in = getResources().openRawResource(R.raw.j103);
                                        } else {
                                            in = getResources().openRawResource(R.raw.j102);
                                        }
                                    } else {
                                        in = getResources().openRawResource(R.raw.j102);
                                    }

                                    int length = in.available();
                                    byte[] buffer = new byte[length];
                                    in.read(buffer);
                                    str = EncodingUtils.getString(buffer, "UTF-8");
                                    //res = EncodingUtils.getString(buffer, "UNICODE");
                                    //res = EncodingUtils.getString(buffer, "BIG5");
                                    in.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                ClipboardManager clipboard = (ClipboardManager)
                                        getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clip = ClipData.newPlainText("text", str);
                                //Intent appIntent = new Intent(this, Content.class);
                                //ClipData clip = ClipData.newIntent("Intent",appIntent);
                                clipboard.setPrimaryClip(clip);
                                Toast.makeText(Content.this, str, Toast.LENGTH_LONG).show();
                            } else if (bottom == screenHeight) {
                                b.layout(left1, top1, right1, bottom1);
                                bottom = bottom1;
                                ii = 0;
                                String str = "";
                                InputStream in = null;
                                try {
                                    if (l1 == 1) {
                                        if (l2 == 0) {
                                            in = getResources().openRawResource(R.raw.x103);
                                        } else if (l2 == 1) {
                                            in = getResources().openRawResource(R.raw.x102);
                                        } else if (l2 == 2) {
                                            in = getResources().openRawResource(R.raw.x103);
                                        } else if (l2 == 3) {
                                            in = getResources().openRawResource(R.raw.x102);
                                        } else if (l2 == 4) {
                                            in = getResources().openRawResource(R.raw.x105);
                                        } else if (l2 == 5) {
                                            in = getResources().openRawResource(R.raw.x106);
                                        } else {
                                            in = getResources().openRawResource(R.raw.x102);
                                        }
                                    } else {
                                        in = getResources().openRawResource(R.raw.x102);
                                    }
                                    int length = in.available();
                                    byte[] buffer = new byte[length];
                                    in.read(buffer);
                                    str = EncodingUtils.getString(buffer, "UTF-8");
                                    //res = EncodingUtils.getString(buffer, "UNICODE");
                                    //res = EncodingUtils.getString(buffer, "BIG5");
                                    in.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                ClipboardManager clipboard = (ClipboardManager)
                                        getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clip = ClipData.newPlainText("text", str);
                                clipboard.setPrimaryClip(clip);
                                Toast.makeText(Content.this, str, Toast.LENGTH_LONG).show();
                            } else {
                                b.layout(left1 - 10, top1 - 10, right1 - 10, bottom1 - 10);
                            }
                            break;
                    }
                    return true;
                }

            });
        }
    }
}
