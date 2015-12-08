int red_leds[9]={24, 22, 38, 30, 28, 26, 36, 34, 32};
int green_leds[9]={25, 23, 41, 33, 29, 27, 39, 37, 35};
int switches[9]={43, 53, 52, 49, 48, 51, 45, 47, 46};
int board[9]={0, 0, 0, 0, 0, 0, 0, 0, 0};

int active_player=1;
int winner = 0;
int total_moves=0;

void setup(){
  Serial.begin(9600);
  
  for (int i = 0; i<9; i++){
    pinMode(red_leds[i], OUTPUT);
    pinMode(green_leds[i], OUTPUT);
    pinMode(switches[i], INPUT);
  }
}

void loop(){
  int move_position=-1;
   for (int i = 0; i<9; i++){
     if(digitalRead(switches[i])==HIGH){
       while(switches[i]==HIGH){
       }
       move_position=i;
     }
   }
  if(move_position!=-1){
    int temp = check_position(move_position);
    if(temp==0){
      update_board(move_position);
    }
    int winner = check_win();
    if(winner!=0){
      win_loop(winner);
    } else if (total_moves==9){
      draw_loop();
    }
  }
}

int check_position(int pos){
  return board[pos];
}

void update_board(int pos){
  if(active_player==1){
    digitalWrite(red_leds[pos], HIGH);
    board[pos]=1;
  } else if(active_player==-1){
    digitalWrite(green_leds[pos], HIGH);
    board[pos]=-1;
  } else{
  }
  active_player*=-1;
  total_moves++;
}

int check_win(){
  //check columns
  for(int i=0; i<3; i++){
    if((board[i]==board[i+3])&&(board[i]==board[i+6])){
      return board[i];
    }  
  }
  
  //check rows
  for(int i = 0; i<9; i+=3){
     if((board[i]==board[i+1])&&(board[i]==board[i+2])){
      return board[i];
    }  
  }
  //check diagonals
  if((board[0]==board[4])&&(board[0]==board[8])){
    return board[0];
  }else if((board[2]==board[4])&&(board[2]==board[6])){
    return board[2];
  }
  return 0;
}

void win_loop(int winner){
  delay(250);
  
  for(int i=0; i<9; i++){
    digitalWrite(red_leds[i], LOW);
    digitalWrite(green_leds[i], LOW);
  }
  
  while(true){
    if(winner == 1){
      for(int i=0; i<9; i++){
        digitalWrite(red_leds[i], HIGH);
        delay(100);
      }
      for(int i=0; i<9; i++){
        digitalWrite(red_leds[i], LOW);
        delay(100);
      }
    }else if(winner==-1){
      for(int i=0; i<9; i++){
        digitalWrite(green_leds[i], HIGH);
        delay(100);
      }
      for(int i=0; i<9; i++){
        digitalWrite(green_leds[i], LOW);
        delay(100);
      }
    }
  }
}

int draw_loop(){
  for(int i=0; i<9; i++){
      digitalWrite(red_leds[i], LOW);
      digitalWrite(green_leds[i], LOW);
    }
  while(true){
    for(int i=0; i<9; i++){
      digitalWrite(red_leds[i], HIGH);
    }
    delay(250);
    for(int i=0; i<9; i++){
      digitalWrite(red_leds[i], LOW);
    }
    delay(250);
    for(int i=0; i<9; i++){
      digitalWrite(green_leds[i], HIGH);
    }
    delay(250);
    for(int i=0; i<9; i++){
      digitalWrite(green_leds[i], LOW);
    }
    delay(250);
  }
}


