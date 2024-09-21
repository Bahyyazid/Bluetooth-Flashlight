#include <EEPROM.h>
#include <OneButton.h>

int LED = 3; // set to 2 when turned off
int Laser = 2; // set to 5 when turned on
int CLK = A4;
int DT = A3;
int Reset = 4;

int Stop = 0;
int eepromknob =0;
int Dot = 0;
int Dash = 0;
int Long = Dash+Stop;
int Pause = 0;
int Space = 0;
int SpeedState = 0;
int LightType = 0; 
int WiLess = 0;
int In= 0;
char ch;
char ip;

String input;     

int State = EEPROM.read(1);
int S = 0;

OneButton Button = OneButton(A2,true,true);
int Max = 255;
int Min = 6;
int i = 1;
int p = 0;

int Difference = 3;
int CurrentBright = EEPROM.read(0);
int Brightness = CurrentBright;

int currentStateCLK;
int previousStateCLK;
unsigned long PreviousTime = 0;    //Knob millis
unsigned long PreviousTimeS = 0;    //Knob Strobe
unsigned long PreviousTimeB = 0;

void setup() {
 //EEPROM.write(1,0);
 //EEPROM.write(0,60);  //remove comments (//) if you want to install to a new microcontroller     
 pinMode (LED,OUTPUT);
 pinMode (Laser,OUTPUT);  
 pinMode (CLK,INPUT);
 pinMode (DT,INPUT);
 pinMode (Reset,OUTPUT);
 Serial.begin (57600);
 Serial.setTimeout(10);
 unsigned long CurrentTimeS = 0;
 previousStateCLK = digitalRead(CLK);
 digitalWrite(Reset,HIGH);
 Serial.println("Turned ON!!!");
 if(digitalRead(A2)== LOW){
 LightType = 1;
 }
   
 Button.attachClick(singleclick);
 Button.attachDoubleClick(doubleclick);
 Button.attachTripleClick(tripleclick);
 Button.attachLongPressStop(longclick);

 } 

void loop() {

 if (Serial.available()> 0){
    input=Serial.readString();
    int l=0;
    int X=0;
    ip ='|';
    while(ip >= '\0'){
       
      InputState(); 
      X++;
      if(X>l){
        ip=input.charAt(l);       // This code gets the charcter at a particular location in the string.
        morse(ip);
        l++;
        continue;
      }else if(X==l && In == 1){
        Serial.println("Finished");
        delay(1000);
        i=0;
        X=0;
        break;
      }else if(X==l && In == 0){
        i=0;
        X=0;
        break;    
      }
    }  
  }else{
    SetKnob();
    Status();
    Speed();
    Light();
    Button.tick(); 
  }   
}
void Status(){
  if(State == 0){
   normal(); 
  }else if(State == 1){ 
   Strobe(); 
  }else if(State == 2){ 
   Blink();
  }else if(State == 3){ 
   Flash();
  }else if(State == 4){
   SOS();
  }else if(State == 5){
   State = 0;
  }
}
void normal(){
  State = 0;  
  knob();
  Speed();
  Light();
  analogWrite(LED,Brightness);
  analogWrite(Laser,Brightness);
  PreviousTimeS = 0;
} 

/////////////////////////////////////////////////////////////////////  Modes   
void Blink(){
 State = 2;    
 unsigned long CurrentTime = millis();
 
 if(PreviousTime - CurrentTime >= 10){
  knob();  
  PreviousTime = millis();
  }
 if(PreviousTimeS <= 1000){
    if(PreviousTimeS == 50 && i == 1){
    analogWrite(LED,Brightness);
    analogWrite(Laser,Brightness);    
    i = 0;
    PreviousTimeS = 0;
    }else if(PreviousTimeS == 50 && i == 0){
    digitalWrite(LED,LOW);
    digitalWrite(Laser,LOW);    
    i = 1;
    PreviousTimeS = 0;
    
    }else if(PreviousTimeS < 50){
      if(i==1){  
      analogWrite(LED,Brightness);
      analogWrite(Laser,Brightness);
      PreviousTimeS++;  
      }else if (i==0){
      digitalWrite(LED,LOW);
      digitalWrite(Laser,LOW); 
      PreviousTimeS++;     
      }    
    }else if(PreviousTimeS >50){
      PreviousTimeS = 0;       
    }
 }delay(1);
}

void Flash(){
 State = 3;    
 unsigned long CurrentTime = millis();
 
 if(PreviousTime - CurrentTime >= 10){
  knob();  
  PreviousTime = millis();
  }
 if(PreviousTimeS <= 1000){
    if(PreviousTimeS == 100 && i == 1){
    analogWrite(LED,Brightness);
    analogWrite(Laser,Brightness);    
    i = 0;
    PreviousTimeS = 0;
    }else if(PreviousTimeS == 100 && i == 0){
    digitalWrite(LED,LOW);
    digitalWrite(Laser,LOW);    
    i = 1;
    PreviousTimeS = 0;
    
    }else if(PreviousTimeS < 100){
      if(i==1){  
      analogWrite(LED,Brightness);
      analogWrite(Laser,Brightness); 
      PreviousTimeS++;  
      }else if (i==0){
      digitalWrite(LED,LOW);
      digitalWrite(Laser,LOW);  
      PreviousTimeS++;     
      }          
    }else if(PreviousTimeS >100){
      PreviousTimeS = 0;
    }   
 }delay(1);
}

void Strobe(){
 State = 1;    
 unsigned long CurrentTime = millis();
 
 if(PreviousTime - CurrentTime >= 10){
  knob();  
  PreviousTime = millis();
  }
 if(PreviousTimeS <= 1000){
    if(PreviousTimeS == 30 && i == 1){
    analogWrite(LED,Brightness);
    analogWrite(Laser,Brightness);    
    i = 0;
    PreviousTimeS = 0;
    }else if(PreviousTimeS == 30 && i == 0){
    digitalWrite(LED,LOW);
    digitalWrite(Laser,LOW);    
    i = 1;
    PreviousTimeS = 0;
    
    }else if(PreviousTimeS < 30){
      if(i==1){  
      analogWrite(LED,Brightness);
      analogWrite(Laser,Brightness);
      PreviousTimeS++;  
      }else if (i==0){
      digitalWrite(LED,LOW);
      digitalWrite(Laser,LOW); 
      PreviousTimeS++;     
      }    
    }else if(PreviousTimeS >30){
      PreviousTimeS = 0;
    }   
 }delay(1);
}

void SOS(){
  
  if(S == 1 ||S == 2 ||S == 3 ||S == 9 ||S == 10 ||S == 11){
    dot();
  }else if(S == 5 ||S == 6 ||S == 7){
    dash();
  }else if(S == 4 ||S == 8){
    pause();
    i = 1;
  }else if(S == 12){
    space();
    i = 1;     
  }else if(S == 13 ||S == 0){
    S = 1;
    i = 1;                   
  }
  
  
  
}
/////////////////////////////////////////////////////////////////////  Morse Code

void morse(char ip){
  
  switch (ip){
    
    case 'A':
    case 'a':
    
       Serial.print("A ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1){
           dot();
         }else if(S == 2){
           dash();   
         }else if(S == 3){
           S = 0;
           i = 1;
           Serial.println(".-");
           break;                  
         }
       }while(S<=3); break; 

    case 'B':
    case 'b':
    
       Serial.print("B ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 2 || S == 3 || S == 4){
           dot();
         }else if(S == 1){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println("-...");
           break;                  
         }
       }while(S<=5); break; 

    case 'C':
    case 'c':
    
    Serial.print("C ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 2 || S == 4){
           dot();
         }else if(S == 1 || S == 3){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println("-.-.");
           break;                  
         }
       }while(S<=5); break;

    case 'D':
    case 'd':
 
    Serial.print("D ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 2 || S == 3){
           dot();
         }else if(S == 1){
           dash();   
         }else if(S == 4){
           S = 0;
           i = 1;
           Serial.println("-..");
           break;                  
         }
       }while(S<=4); break;   

    case 'E':
    case 'e':
    
    Serial.print("E ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1){
           dot();
         }else if(S == 2){
           S = 0;
           i = 1;
           Serial.println(".");
           break;                  
         }
       }while(S<=2); break;

    case 'F':
    case 'f':
 
    Serial.print("F ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2 || S == 4){
           dot();
         }else if(S == 3){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println("..-.");
           break;                  
         }
       }while(S<=5); break;   

    case 'G':
    case 'g':
 
    Serial.print("G ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 3){
           dot();
         }else if(S == 1 || S == 2 ){
           dash();   
         }else if(S == 4){
           S = 0;
           i = 1;
           Serial.println("--.");
           break;                  
         }
       }while(S<=4); break;
          
    case 'H':
    case 'h':
 
    Serial.print("H ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2 || S == 3 || S == 4){
           dot(); 
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println("....");
           break;                  
         }
       }while(S<=5); break;
          
    case 'I':
    case 'i':
 
    Serial.print("i ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2){
           dot(); 
         }else if(S == 3){
           S = 0;
           i = 1;
           Serial.println("..");
           break;                  
         }
       }while(S<=3); break;   

    case 'J':
    case 'j':
    
       Serial.print("J ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1){
           dot();
         }else if(S == 2 || S == 3 || S == 4){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println(".---");
           break;                  
         }
       }while(S<=5); break;
     
    case 'K':
    case 'k':
    
       Serial.print("K ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 2){
           dot();
         }else if(S == 1 || S == 3){
           dash();   
         }else if(S == 4){
           S = 0;
           i = 1;
           Serial.println("-.-");
           break;                  
         }
       }while(S<=4); break;

       
    case 'L':
    case 'l':
    
       Serial.print("L ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 3 || S == 4){
           dot();
         }else if(S == 2){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println(".-..");
           break;                  
         }
       }while(S<=5); break;   
    
    case 'M':
    case 'm':
    
       Serial.print("M ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2){
           dash();   
         }else if(S == 3){
           S = 0;
           i = 1;
           Serial.println("--");
           break;                  
         }
       }while(S<=3); break;
          
    case 'N':
    case 'n':
    
       Serial.print("N ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 2){
           dot();
         }else if(S == 1){
           dash();   
         }else if(S == 3){
           S = 0;
           i = 1;
           Serial.println("-.");
           break;                  
         }
       }while(S<=3); break;
    
    case 'O':
    case 'o':
    
       Serial.print("O ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2 || S == 3){
           dash();   
         }else if(S == 4){
           S = 0;
           i = 1;
           Serial.println("---");
           break;                  
         }
       }while(S<=4); break;
       
    case 'P':
    case 'p':
    
       Serial.print("P ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 4){
           dot();
         }else if(S == 2 || S == 3){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println(".--.");
           break;                  
         }
       }while(S<=5); break;

    case 'Q':
    case 'q':
    
       Serial.print("Q ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 3){
           dot();
         }else if(S == 1 || S == 2 ||  S == 4){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println("--.-");
           break;                  
         }
       }while(S<=5); break;
         
    case 'R':
    case 'r':
    
       Serial.print("R ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 3){
           dot();
         }else if(S == 2){
           dash();   
         }else if(S == 4){
           S = 0;
           i = 1;
           Serial.println(".-.");
           break;                  
         }
       }while(S<=4); break;
    
    case 'S':
    case 's':
    
       Serial.print("S ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2 || S == 3){
           dot();   
         }else if(S == 4){
           S = 0;
           i = 1;
           Serial.println("...");
           break;                  
         }
       }while(S<=4); break;
       
    case 'T':
    case 't':
    
    Serial.print("T ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1){
           dash();
         }else if(S == 2){
           S = 0;
           i = 1;
           Serial.println("-");
           break;                  
         }
       }while(S<=2); break;

    case 'U':
    case 'u':
    
       Serial.print("U ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2){
           dot();
         }else if(S == 3){
           dash();   
         }else if(S == 4){
           S = 0;
           i = 1;
           Serial.println("..-");
           break;                  
         }
       }while(S<=4); break;
    
    case 'V':
    case 'v':
    
       Serial.print("V ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2 || S == 3){
           dot();
         }else if(S == 4){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println("...-");
           break;                  
         }
       }while(S<=5); break;

    case 'W':
    case 'w':
    
       Serial.print("W ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1){
           dot();
         }else if( S == 2 || S == 3){
           dash();   
         }else if(S == 4){
           S = 0;
           i = 1;
           Serial.println(".--");
           break;                  
         }
       }while(S<=4); break;

    case 'X':
    case 'x':
    
       Serial.print("X ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 2 || S == 3){
           dot();
         }else if(S == 1 || S == 4){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println("-..-");
           break;                  
         }
       }while(S<=5); break;
    
    case 'Y':
    case 'y':
    
       Serial.print("Y ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 2){
           dot();
         }else if(S == 1 || S == 3 || S == 4){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println("-.--");
           break;                  
         }
       }while(S<=5); break;

    case 'Z':
    case 'z':
    
       Serial.print("Z ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 3 || S == 4){
           dot();
         }else if(S == 1 || S == 2){
           dash();   
         }else if(S == 5){
           S = 0;
           i = 1;
           Serial.println("--..");
           break;                  
         }
       }while(S<=5); break;

     case '0':
    
       Serial.print("0 ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2 || S == 3 || S == 4 || S == 5 ){
           dash();
         }else if(S == 6){
           S = 0;
           i = 1;
           Serial.println("-----");
           break;                  
         }
       }while(S<=6); break;  

     case '1':
    
       Serial.print("1 ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1){
           dot();
         }else if(S == 2 || S == 3  || S == 4  || S == 5){
           dash();   
         }else if(S == 6){
           S = 0;
           i = 1;
           Serial.println(".----");
           break;                  
         }
       }while(S<=6); break;

     case '2':
    
       Serial.print("2 ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2 ){
           dot();
         }else if(S == 3  || S == 4  || S == 5){
           dash();   
         }else if(S == 6){
           S = 0;
           i = 1;
           Serial.println("..---");
           break;                  
         }
       }while(S<=6); break;

    case '3':
    
       Serial.print("3 ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2 || S == 3 ){
           dot();
         }else if(S == 4  || S == 5){
           dash();   
         }else if(S == 6){
           S = 0;
           i = 1;
           Serial.println("...--");
           break;                  
         }
       }while(S<=6); break;      
      
    case '4':
    
       Serial.print("4 ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2 || S == 3 || S == 4 ){
           dot();
         }else if(S == 5){
           dash();   
         }else if(S == 6){
           S = 0;
           i = 1;
           Serial.println("....-");
           break;                  
         }
       }while(S<=6); break;      

     case '5':
    
       Serial.print("5 ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1 || S == 2 || S == 3 || S == 4 || S == 5 ){
           dot();
         }else if(S == 6){
           S = 0;
           i = 1;
           Serial.println(".....");
           break;                  
         }
       }while(S<=6); break;

    case '6':
    
       Serial.print("6 ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 1){
           dash();
         }else if(S == 2 || S == 3  || S == 4  || S == 5){
           dot(); 
         }else if(S == 6){
           S = 0;
           i = 1;
           Serial.println("-....");
           break;                  
         }
       }while(S<=6); break;

     case '7':
    
       Serial.print("7 ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 2 || S == 1){
           dash();
         }else if(S == 3  || S == 4  || S == 5){
           dot(); 
         }else if(S == 6){
           S = 0;
           i = 1;
           Serial.println("--...");
           break;                  
         }
       }while(S<=6); break;

     case '8':
    
       Serial.print("8 ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 3  || S == 2 || S == 1){
           dash();
         }else if(S == 4  || S == 5){
           dot(); 
         }else if(S == 6){
           S = 0;
           i = 1;
           Serial.println("---..");
           break;                  
         }
       }while(S<=6); break;
      
      case '9':
    
       Serial.print("9 ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 4  || S == 3  || S == 2 || S == 1){
           dash();
         }else if(S == 5){
           dot(); 
         }else if(S == 6){
           S = 0;
           i = 1;
           Serial.println("----.");
           break;                  
         }
       }while(S<=6); break;
      
   case ' ':
    
       Serial.print("Space ");
       do{  
         if (S == 0){
           space();
           i = 1; 
         }else if(S == 1){
           S = 0;
           i = 1;
           Serial.println(">_<");
           break;                  
         }
       }while(S<=1); break;
    
    case '.':
    
       Serial.print("Period ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if(S == 6 || S == 4 || S == 2 ){
           dash();
         }else if(S == 1  || S == 3 || S == 5 ){
           dot(); 
         }else if(S == 7){
           S = 0;
           i = 1;
           Serial.println(".-.-.-");
           break;                  
         }
       }while(S<=7); break;
     
     case ',':
    
       Serial.print("Coma ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if( S == 3  || S == 4 ){
           dot();
         }else if(S == 1 || S == 2|| S == 5 || S == 6 ){
           dash(); 
         }else if(S == 7){
           S = 0;
           i = 1;
           Serial.println("--..--");
           break;                  
         }
       }while(S<=7); break;
     
     case '?':
    
       Serial.print("Question ");
       do{  
         if (S == 0){
           pause();
           i = 1; 
         }else if( S == 3  || S == 4 ){
           dash();
         }else if(S == 1 || S == 2|| S == 5 || S == 6 ){
           dot(); 
         }else if(S == 7){
           S = 0;
           i = 1;
           Serial.println("..--..");
           break;                  
         }
       }while(S<=7); break;
       
       case '<' :
        if (Brightness > Min){
          Brightness = CurrentBright - Difference;
          Serial.print("Brightness: ");
          Serial.println(Brightness);
          CurrentBright = Brightness; p = 1;     
          knob();
        }
        i = 1; 
        S = 0;
       break;

      case '>' :
       if (Brightness < Max){
          Brightness = CurrentBright + Difference;
          Serial.print("Brightness: ");
          Serial.println(Brightness);
          CurrentBright = Brightness; p = 1;     
          knob();
       }
       i = 1; 
       S = 0; 
      break; 

      case '*':
        
       input = ' ';
       i = 1; 
       S = 0;
      break;
      
      case '^':      
       PreviousTimeS = 0;
       SpeedState++;
       
      break;
      
      case '#':
       p = 1;     
       State++;
       Eeprom();
       
      break;

      case '@':      
      LightType++;
       
      break;
  }
}


void dot(){
 Button.tick();  
 Speed();
 Light();
 SetKnob();
 knob(); 
 if(PreviousTimeS <= 1000){
    if(PreviousTimeS == Dot && i == 1){
    analogWrite(LED,Brightness);
    analogWrite(Laser,Brightness);     
    i = 0;
    PreviousTimeS = 0;
    }else if(PreviousTimeS == Stop && i == 0){
    digitalWrite(LED,LOW);
    digitalWrite(Laser,LOW);    
    i = 1;
    PreviousTimeS = 0;
    S++;
    }else if(PreviousTimeS < Stop){
      if(i==1){  
      analogWrite(LED,Brightness);
      analogWrite(Laser,Brightness);
      PreviousTimeS++;  
      }else if (i==0){
      digitalWrite(LED,LOW);
      digitalWrite(Laser,LOW); 
      PreviousTimeS++;     
      }    
    }else if(PreviousTimeS >Stop){
      PreviousTimeS = 0;
    }
 }delay(1);
}  

void dash(){
 Button.tick();  
 Speed();
 Light();
 SetKnob();
 knob(); 
 if(PreviousTimeS <= 1000){
    if(PreviousTimeS == Dash && i == 1){
    analogWrite(LED,Brightness);
    analogWrite(Laser,Brightness);    
    i = 0;
    PreviousTimeS = 0;
    }else if(PreviousTimeS == Stop && i == 0){
    digitalWrite(LED,LOW);
    digitalWrite(Laser,LOW);     
    i = 1;
    PreviousTimeS = 0;
    S++;
    }else if(PreviousTimeS < Long){
      if(i==1){  
      analogWrite(LED,Brightness);
      analogWrite(Laser,Brightness);
      PreviousTimeS++;  
      }else if (i==0){
      digitalWrite(LED,LOW);
      digitalWrite(Laser,LOW); 
      PreviousTimeS++;     
      }    
    }else if(PreviousTimeS > Long){
      PreviousTimeS = 0;
    }
 }delay(1);
}


void pause(){
 Button.tick(); 
 Speed();
 Light();
 SetKnob();
 knob(); 
 if(PreviousTimeS <= 1000){
    if(PreviousTimeS == Pause && i == 1){
    digitalWrite(LED,LOW);
    digitalWrite(Laser,LOW);    
    i = 0;
    PreviousTimeS = 0;
    S++;
    }else if(PreviousTimeS == Pause && i == 0){
    digitalWrite(LED,LOW);
    digitalWrite(Laser,LOW);    
    i = 1;
    PreviousTimeS = 0;
    S++;
    }else if(PreviousTimeS < Pause){
      if(i==1){  
      digitalWrite(LED,LOW);
      digitalWrite(Laser,LOW);
      PreviousTimeS++;  
      }else if (i==0){
      digitalWrite(LED,LOW);
      digitalWrite(Laser,LOW); 
      PreviousTimeS++;     
      }    
    }else if(PreviousTimeS >Pause){
      PreviousTimeS = 0;
    }
 }delay(1);
}

void space(){
 Button.tick(); 
 Speed();
 Light();
 SetKnob();
 knob();  
 if(PreviousTimeS <= 1000){
    if(PreviousTimeS == Space && i == 1){
    digitalWrite(LED,LOW);
    digitalWrite(Laser,LOW);    
    i = 0;
    PreviousTimeS = 0;
    S++;
    }else if(PreviousTimeS == Space && i == 0){
    digitalWrite(LED,LOW);
    digitalWrite(Laser,LOW);    
    i = 1;
    PreviousTimeS = 0;
    S++;
    }else if(PreviousTimeS < Space){
      if(i==1){  
      digitalWrite(LED,LOW);
      digitalWrite(Laser,LOW);
      PreviousTimeS++;  
      }else if (i==0){
      digitalWrite(LED,LOW);
      digitalWrite(Laser,LOW); 
      PreviousTimeS++;     
      }    
    }else if(PreviousTimeS >Space){
      PreviousTimeS = 0;
    }
 }delay(1);
}      
/////////////////////////////////////////////////////////////////////  Controls   
void singleclick(){                                 
State++;
p = 1;
Eeprom();
}

void longclick(){
 input = ' ';
 i = 1; 
 S = 0;  
}
void doubleclick(){
  PreviousTimeS = 0;
  SpeedState++;
}
void tripleclick(){
  LightType++;
}
void knob(){  
   currentStateCLK = digitalRead(CLK); 
   if (currentStateCLK != previousStateCLK){ 
       
     if (digitalRead(DT) != currentStateCLK && Brightness > Min) { 
       Brightness = CurrentBright - Difference ;
       Serial.print("Brightness: ");
       Serial.println(Brightness);
       CurrentBright = Brightness; p = 1; Eeprom();
       
     } else if (digitalRead(DT) == currentStateCLK && Brightness < Max ){
       Brightness = CurrentBright + Difference;
       Serial.print("Brightness: ");
       Serial.println(Brightness);
       CurrentBright = Brightness; p = 1; Eeprom();      
     }
       Brightness = CurrentBright;
   } 
   previousStateCLK = currentStateCLK; 
 }

void Light(){
  if(LightType == 0){
      LED = 3;
      Laser = 2;
      digitalWrite(5,LOW);
  }else if(LightType == 1){
      LED = 2;
      Laser = 5;
      digitalWrite(3,LOW);
  }else if(LightType == 2){
      LED = 3;
      Laser = 5;
  }else if(LightType == 3){
    LED = 3;
    Laser = 2;
    LightType = 0;
  }
}

void Speed(){
  if(SpeedState == 0){
    Stop = 180;
    Dot = 140;
    Dash = 260;
    Pause = 200;
    Space = 600;
    Long = Dash+Stop; 
   
  }else if(SpeedState == 1){
    Stop = 90;
    Dot = 70;
    Dash = 130;
    Pause = 100;
    Space = 300;
    Long = Dash+Stop;
    
   }else if(SpeedState == 2){
    Stop = 60;
    Dot = 50;
    Dash = 91;
    Pause = 140;
    Space = 420;
    Long = Dash+Stop;
    
   }else if(SpeedState == 3){
    SpeedState = 0;
   } 
}

void SetKnob(){
  WiLess = Serial.read();
  switch (WiLess){
      case '<' :
        if (Brightness > Min){
          Brightness = CurrentBright - Difference;
          Serial.print("Brightness: ");
          Serial.println(Brightness);
          CurrentBright = Brightness; p = 1;     
          knob();
        }
       break;

      case '>' :
       if (Brightness < Max){
          Brightness = CurrentBright + Difference;
          Serial.print("Brightness: ");
          Serial.println(Brightness);
          CurrentBright = Brightness; p = 1;     
          knob();
       } 
      break; 

      case '*': 
       input = ' ';
       i = 1; 
       S = 0;
       
      break;

      case '^':      
       PreviousTimeS = 0;
       SpeedState++;
       
      break;
      
      case '#':      
       State++;
       Eeprom(); 
       
      break;
      
      case '@':      
       LightType++;
       
      break;
  }
}
void Eeprom(){
if (PreviousTimeB <=100){  
  if (p == 1){
     EEPROM.write(0,Brightness);
    if(State == 0){
     EEPROM.write(1,0);  
    }else if(State == 1){
     EEPROM.write(1,1);
    }else if(State == 2){
     EEPROM.write(1,2);
    }else if(State == 3){
     EEPROM.write(1,3);
    }else if(State == 4){
     EEPROM.write(1,4);
    }else if(State == 5){
     EEPROM.write(1,5); 
    }
    p = 0;  
  }PreviousTimeB = 0;
 } PreviousTimeB++;   
}

void InputState(){
  if(ip == '<' || ip == '>' || ip == '*' || ip == '#' || ip == '^'|| ip == '@' || ip == '$' || ip == '|'){
    In = 0;
  }else if (ip != '<' && ip != '>' && ip != '*' && ip != '#' && ip != '^' && ip != '@' && ip != '$' && ip != '|' && ip != '\0'){
    In = 1;
  }  
} 
