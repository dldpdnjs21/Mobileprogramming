package com.example.teamproject4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class play3Activity extends AppCompatActivity {

    static int mine = 10, com = 10, minebet = 0, combet = 0;

    int com_b = 2, mine_b = 2;
    int a;
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.bead_game);

        TextView t1 =findViewById(R.id.textView4);
        TextView t2 = findViewById(R.id.textView5);
        TextView t =findViewById(R.id.textView3);
        ImageView i = findViewById(R.id.imageView4);
        t.setText("상대 구슬 개수: 10개");
        t1.setText("나의 구슬 개수: 10개");
        t2.setText("상대 구슬 베팅 개수: ?개");

        Button odd = findViewById(R.id.oddbtn);
        Button even = findViewById(R.id.evenbtn);
        Button b = findViewById(R.id.button4); //베팅하는 버튼
        Button back = findViewById(R.id.button8);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), game3Activity.class);
                startActivity(intent);
            }
        });
        Random r = new Random();
        a = r.nextInt(2); // a는 0이랑 1 둘중 하나 배정되는거.. 0이면 컴이 공격 1이면 사용자가 공격
        if(a==0){

            t2.setText("컴퓨터가 먼저 공격합니다.\n구슬을 베팅하세요.");
        }else if(a==1){
            i.setImageDrawable(getResources().getDrawable(R.drawable.img));
            t2.setText("당신 먼저 공격합니다.\n구슬을 베팅하세요.");
        }
        odd.setClickable(false);
        even.setClickable(false);
        b.setOnClickListener(new View.OnClickListener() { //베팅하는 버튼.
            @Override
            public void onClick(View v) {
                EditText e = (EditText) findViewById(R.id.bet);
                minebet = Integer.parseInt(e.getText().toString());
                if (com > 5) {
                    combet = r.nextInt(5) + 1; // 1 2 3 4 5
                } else
                    combet = r.nextInt(com) + 1; //컴퓨터가 가진 구슬 갯수가 5개 이하일때는 얘가 가진만큼에서만 랜덤함수 돌아감

               //컴퓨터 공격일때
                if(a==0){
                    com_b = r.nextInt(2);//0이면 짝 1이면 홀 ..을 골랐다고 치는거임
                    if(minebet%2==0){ //내가 베팅한 구슬이 짝수임
                        mine_b=0;
                        if(com_b==0){//컴퓨터는 짝수를 골랐음
                            t2.setText("상대 구슬 베팅 개수는 "+combet+"개\n상대가 고른 결과는 짝수로 당신이 졌습니다.\n구슬"+combet+"개를 빼앗겼습니다!\n 이제 당신의 공격 차례입니다.");
                        }else
                            t2.setText("상대 구슬 베팅 개수는 "+combet+"개\n상대가 고른 결과는 홀수로 당신이 이겼습니다.\n구슬"+combet+"개를 빼앗았습니다!\n 이제 당신의 공격 차례입니다.");
                    }else{ //내가 베팅한 구슬이 홀수임
                        mine_b=1;
                        if(com_b==1){//컴퓨터도 홀수를 골랐을때
                            t2.setText("상대 구슬 베팅 개수는 "+combet+"개\n상대가 고른 결과는 홀수로 당신이 졌습니다.\n구슬"+combet+"개를 빼앗겼습니다!\n 이제 당신의 공격 차례입니다.");
                        }else
                            t2.setText("상대 구슬 베팅 개수는 "+combet+"개\n상대가 고른 결과는 짝수로 당신이 이겼습니다.\n구슬"+combet+"개를 빼앗았습니다!\n 이제 당신의 공격 차례입니다.");
                    }

                    if(mine_b==com_b){ //컴퓨터가 내 홀짝 맞춤
                        mine = mine - combet; //컴퓨터가 베팅한 만큼 내가 줘야함
                        com = com + combet; // 컴퓨터는 그만큼 받음
                        t1.setText("나의 구슬 개수: " + mine + "개");
                        t.setText("상대 구슬 개수: " + com + "개");
                    } else { //컴퓨터가 홀짝 맞추기에 실패함
                        mine = mine + combet; //나는 컴이 베팅한 구슬 가져감
                        com = com - combet; //자기가 베팅한만큼 잃음
                        t1.setText("나의 구슬 개수: " + mine + "개");
                        t.setText("상대 구슬 개수: " + com + "개");
                    }
                    a=1;
                    if(mine>=20||com>=20){
                        if(com>=20){
                            odd.setClickable(false);
                            even.setClickable(false);
                            b.setClickable(false);
                            //t3.setText("컴퓨터 승리");
                            t2.setText("상대 구슬 베팅 개수는 "+combet+"개\n상대가 고른 결과는 홀수로 당신이 졌습니다.\n모든 구슬을 빼앗겼습니다! ");
                        }
                        if(mine>=20){
                            odd.setClickable(false);
                            even.setClickable(false);
                            b.setClickable(false);
                            //t3.setText("나의 승리");
                            i.setImageDrawable(getResources().getDrawable(R.drawable.img));
                            t2.setText("상대 구슬 베팅 개수는 "+combet+"개\n상대가 고른 결과는 짝수로 당신이 이겼습니다.\n모든 구슬을 빼앗았습니다! "); //
                        }
                    }else{
                        i.setImageDrawable(getResources().getDrawable(R.drawable.img));
                        //t3.setText("나의 공격");
                        Toast.makeText(getApplicationContext(),"당신의 공격 차례입니다. 구슬을 베팅하세요!",Toast.LENGTH_LONG).show();
                    }
                }
                else if(a==1){ //베팅 버튼을 눌렀는데 나의 공격 차례 였을 때
                    if (combet % 2 == 0) { //컴퓨터가 건 구슬 개수 홀수인지 짝수인지
                        com_b = 0;
                    } else
                        com_b = 1;
                    Toast.makeText(getApplicationContext(),"상대가 베팅한 구슬의 개수는 홀수일까요 짝수일까요?",Toast.LENGTH_LONG).show();
                    odd.setClickable(true);
                    even.setClickable(true);
                    odd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mine_b = 1;//내가 고른건 홀수로 설정
                            if(com_b==0){ //상대방구슬이 짝수임
                                t2.setText("상대 구슬 베팅 개수는 " + combet + "개 짝수이므로 당신이 졌습니다.\n 구슬"+minebet+"개를 빼앗겼습니다!\n 이제 컴퓨터의 공격 차례입니다.");
                                mine = mine - minebet; //내가 졌으니까 내가 건만큼 뺏김
                                com = com + minebet;
                                t1.setText("나의 구슬 개수: " + mine + "개");
                                t.setText("상대 구슬 개수: " + com + "개");
                                a=0;
                            }else{ //상대방 구슬이 홀수임
                                t2.setText("상대 구슬 베팅 개수는 " + combet + "개 홀수이므로 당신이 이겼습니다.\n 구슬"+minebet+"개를 빼앗았습니다!\n 이제 컴퓨터의 공격 차례입니다.");
                                mine = mine + minebet; //내가 건 만큼 컴퓨터가 나한테 줘야돼
                                com = com - minebet; // 나한테 준 만큼 잃음
                                if(com<0){
                                    mine=20;
                                    com=0;
                                }
                                t1.setText("나의 구슬 개수: " + mine + "개");
                                t.setText("상대 구슬 개수: " + com + "개");
                                a=0;
                            }
                            if(mine>=20||com>=20){
                                if(com>=20){
                                    odd.setClickable(false);
                                    even.setClickable(false);
                                    b.setClickable(false);
                                    //t3.setText("컴퓨터 승리");
                                    i.setImageDrawable(getResources().getDrawable(R.drawable.com));
                                    t2.setText("상대 구슬 베팅 개수는 " + combet + "개 짝수이므로 당신이 졌습니다.\n모든 구슬을 빼앗겼습니다!\n컴퓨터의 승리 ");
                                }
                                if(mine>=20){
                                    odd.setClickable(false);
                                    even.setClickable(false);
                                    b.setClickable(false);
                                    //t3.setText("나의 승리");
                                    t2.setText("상대 구슬 베팅 개수는 " + combet + "개 홀수이므로 당신이 이겼습니다.\n모든 구슬을 빼앗었습니다!\n나의 승리 ");
                                }
                            }else{
                                i.setImageDrawable(getResources().getDrawable(R.drawable.com));
                                //t3.setText("컴퓨터의 공격");
                                Toast.makeText(getApplicationContext(),"컴퓨터의 공격 차례입니다. 구슬을 베팅하세요!",Toast.LENGTH_LONG).show();
                            }
                            odd.setClickable(false);
                            even.setClickable(false);
                        }
                    });
                    even.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mine_b = 0; //내가 고른건 짝수로 설정
                            if(com_b==0){
                                t2.setText("상대 구슬 베팅 개수는 " + combet + "개 짝수이므로 당신이 이겼습니다.\n 구슬"+minebet+"개를 빼앗았습니다!\n 이제 컴퓨터의 공격 차례입니다.");
                                mine = mine + minebet; //내가 건 만큼 컴퓨터가 나한테 줘야돼
                                com = com - minebet; // 나한테 준 만큼 잃음
                                t1.setText("나의 구슬 개수: " + mine + "개");
                                t.setText("상대 구슬 개수: " + com + "개");
                                a=0;
                            }else{
                                t2.setText("상대 구슬 베팅 개수는 " + combet + "개 홀수이므로 당신이 졌습니다.\n 구슬"+minebet+"개를 빼앗겼습니다!\n 이제 컴퓨터의 공격 차례입니다.");
                                mine = mine - minebet; //내가 졌으니까 내가 건만큼 뺏김
                                com = com + minebet;
                                if(com<0){
                                    mine=20;
                                    com=0;
                                }
                                t1.setText("나의 구슬 개수: " + mine + "개");
                                t.setText("상대 구슬 개수: " + com + "개");
                                a=0;

                            }

                            if(mine>=20||com>=20){
                                if(com>=20){
                                    odd.setClickable(false);
                                    even.setClickable(false);
                                    b.setClickable(false);
                                   // t3.setText("컴퓨터 승리");
                                    i.setImageDrawable(getResources().getDrawable(R.drawable.com));
                                    t2.setText("상대 구슬 베팅 개수는 " + combet + "개 홀수이므로 당신이 졌습니다.\n모든 구슬을 빼앗겼습니다!\n컴퓨터의 승리 ");
                                }
                                if(mine>=20){
                                    odd.setClickable(false);
                                    even.setClickable(false);
                                    b.setClickable(false);
                                    //t3.setText("나의 승리");
                                    t2.setText("상대 구슬 베팅 개수는 " + combet + "개 짝수이므로 당신이 이겼습니다.\n모든 구슬을 빼앗었습니다!\n나의 승리 ");
                                }
                            }else{
                                i.setImageDrawable(getResources().getDrawable(R.drawable.com));
                                //t3.setText("컴퓨터의 공격");
                                Toast.makeText(getApplicationContext(),"컴퓨터의 공격 차례입니다. 구슬을 베팅하세요!",Toast.LENGTH_LONG).show();
                            }
                            odd.setClickable(false);
                            even.setClickable(false);
                        }
                    });
                }
            }
        });
    }
}