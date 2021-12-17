package com.example.dialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionAarry = new String[] {"apple","kiwi","melon"}; //문자열 배열
                final boolean[] checkArray = new boolean[] {true,false,false};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); //대화상자 설정
                dlg.setTitle("좋아하는 과일은?");
                dlg.setIcon(R.mipmap.ic_launcher);

                /*//.setItems 목록 출력
                dlg.setItems(versionAarry, new DialogInterface.OnClickListener() { //아이템을 클릭했을 때
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        button.setText(versionAarry[which]); //which번째 선택했는지 클릭되고 바로 닫힘 (그렇지 않을 경우는 라디오버튼 or 체크박스 사용하기):하단 재입력
                    }
                });
                dlg.setPositiveButton("닫기",null);*/

                /*//.setSingleChoiceItems 라디오 버튼
                dlg.setSingleChoiceItems(versionAarry, 0, new DialogInterface.OnClickListener() { //문자열 배열, 초기 선택 인덱스, 리스너
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                button.setText(versionAarry[which]);
                            }
                        });
                dlg.setPositiveButton("닫기",null);
                */

                //.setMultiChoiceItems 체크박스 여러개 선택 가능
                dlg.setMultiChoiceItems(versionAarry, checkArray, new DialogInterface.OnMultiChoiceClickListener() { //boolean배열 사용
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) { //체크여부 isChecked
                        button.setText(versionAarry[which]);
                    }
                });
                dlg.setPositiveButton("닫기",null);

                /*dlg.setTitle("제목"); //제목설정
                dlg.setMessage("내용"); //내용 설정
                dlg.setIcon(R.mipmap.ic_launcher); //아이콘 설정
                //dlg.setPositiveButton("확인",null); //문자열,리스너(동작) 널값은 아무것도 없다.
                dlg.setNegativeButton("취소",null);
                //확인을 눌렀을 때 값을 토스트로 수행
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"확인을 눌렀습니다.",Toast.LENGTH_SHORT).show();
                    }
                });*/
                        dlg.show(); //보여주기
            }
        });
    }
}