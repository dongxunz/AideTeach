package aide.voln520;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

import java.util.*;

public class List extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ListView listview = (ListView) findViewById(R.id.list);
        listview.setDividerHeight(0);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        Intent intent = getIntent();
        int titil = Integer.parseInt(intent.getStringExtra("list"));
        TextView t = (TextView) findViewById(R.id.listtext);
        if (titil == 1) {
            for (int i = 0; i < 12; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("ItemImage", R.drawable.ic_launcher);
                map.put("ItemTitle", this.getResources().getStringArray(R.array.list1)[i]);
                listItem.add(map);
            }
            t.setText(R.string.name11);
            listview.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                        long arg3) {
                    Intent intent = new Intent(List.this, Content.class);
                    Map<String, String> map = (Map<String, String>) listview.getItemAtPosition(arg2);
                    intent.putExtra("l1", "1");
                    intent.putExtra("l2", arg2 + "");
                    if (arg2 < 10) {
                        intent.putExtra("l2", arg2 + "");
                    }
                    startActivity(intent);
                }
            });
        } else if (titil == 2) {
            for (int i = 0; i < 14; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("ItemImage", R.drawable.ic_launcher);
                map.put("ItemTitle", this.getResources().getStringArray(R.array.list2)[i]);
                listItem.add(map);
            }
            t.setText(R.string.name22);
            listview.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                        long arg3) {
                    Intent intent = new Intent(List.this, Content.class);
                    Map<String, String> map = (Map<String, String>) listview.getItemAtPosition(arg2);
                    intent.putExtra("l1", "2");
                    intent.putExtra("l2", arg2 + "");
                    if (arg2 < 10) {
                        intent.putExtra("l2", arg2 + "");
                    }
                    startActivity(intent);
                }
            });
        } else if (titil == 3) {
            for (int i = 0; i < 2; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("ItemImage", R.drawable.ic_launcher);
                map.put("ItemTitle", this.getResources().getStringArray(R.array.list3)[i]);
                listItem.add(map);
            }
            t.setText(R.string.name3);
            listview.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                        long arg3) {
                    Intent intent = new Intent(List.this, Content.class);
                    Map<String, String> map = (Map<String, String>) listview.getItemAtPosition(arg2);
                    intent.putExtra("l1", "3");
                    intent.putExtra("l2", arg2 + "");
                    if (arg2 < 10) {
                        intent.putExtra("l2", arg2 + "");
                    }
                    startActivity(intent);
                }
            });
        } else {
            for (int i = 0; i < 2; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("ItemImage", R.drawable.ic_launcher);
                map.put("ItemTitle", this.getResources().getStringArray(R.array.list5)[i]);
                listItem.add(map);
            }
            t.setText(R.string.name55);
            listview.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                        long arg3) {
                    Intent intent = new Intent(List.this, Content.class);
                    Map<String, String> map = (Map<String, String>) listview.getItemAtPosition(arg2);
                    intent.putExtra("l1", "5");
                    intent.putExtra("l2", arg2 + "");
                    if (arg2 < 10) {
                        intent.putExtra("l2", arg2 + "");
                    }
                    startActivity(intent);
                }
            });
        }
        SimpleAdapter sim = new SimpleAdapter(this, listItem, R.layout.listitem1,
                new String[]{"ItemImage", "ItemTitle"},
                new int[]{R.id.ItemImage1, R.id.ItemTitle1});
        listview.setAdapter(sim);
    }
}
