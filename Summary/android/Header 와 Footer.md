# Header 와 Footer

Header와 Footer는 ListView에서 사용되는 것으로 각각의 레이아웃을 잡고 아래와 같이 추가할 수 있음

```kotlin
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // ... 코드 계속.
		// listview, header, footer 참조 획득.
        ListView listview = (ListView)findViewById(R.id.listview1) ;
        final View header = getLayoutInflater().inflate(R.layout.listview_header, null, false) ;
        View footer = getLayoutInflater().inflate(R.layout.listview_footer, null, false) ;

        // listView에 header, footer 추가.
        listview.addHeaderView(header) ;
        listview.addFooterView(footer) ;

        // 데이터를 지정하지 않은 adapter 생성하여 listview에 지정.
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1) ;
        listview.setAdapter(adapter) ;
        // ... 코드 계속.
    }
}
        
```

## Footer와 상호작용

activity 하단

```kotlin
 	Button addButton = (Button) footer.findViewById(R.id.add);
    addButton.setOnClickListener(new Button.OnClickListener() {
        public void onClick(View v) {
            int count ;

            // Adapter에서 현재 아이템 개수 얻어온 다음 아이템 추가.
            count = adapter.getCount() + 1 ;
            adapter.add("LIST" + Integer.toString(count)) ;

            // Header View의 "count" TextView에 아이템 개수 업데이트.
            TextView textView = (TextView) header.findViewById(R.id.count) ;
            textView.setText(Integer.toString(count)) ;
        }
    });
```