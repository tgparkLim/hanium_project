#include <RFduinoBLE.h>

// Motor1 speed control,(PWM Control)
int Motor1speed = 0;

// Motor1 direction control,(Forward, Backward)
int Motor1direction = 1;

// Motor2 speed control,(PWM Control)
int Motor2speed = 2;

// Motor2 direction control,(Forward, Backward)
int Motor2direction = 3; //각각 포트

  uint8_t M1speed;
  uint8_t M1direction;
  uint8_t M2speed;
  uint8_t M2direction;

void setup() {
  pinMode(Motor1speed, OUTPUT);
  pinMode(Motor2speed, OUTPUT);  
  pinMode(Motor1direction, OUTPUT);
  pinMode(Motor2direction, OUTPUT);
  
  // put your setup code here, to run once:
  pinMode(7, INPUT);
  pinMode(8, INPUT);
  pinMode(9, INPUT);
  Serial.begin(9600);
}

void loop() {
 if(digitalRead(7)&&digitalRead(9)) {  //오른쪽, 왼쪽 센서가 High(흰색)이면
  digitalWrite(Motor1direction, 0);
  digitalWrite(Motor2direction, 0);
  analogWrite(Motor1speed, 50); 
  analogWrite(Motor2speed, 50); //오른바퀴
 }
 else if(digitalRead(7)&&digitalRead(8)){  //왼쪽, 중앙 센서가 High(흰색)이면
  digitalWrite(Motor1direction, 0);
  digitalWrite(Motor2direction, 0);
  analogWrite(Motor1speed, 50); 
  analogWrite(Motor2speed, 20); //오른바퀴
 }
 else if(digitalRead(8)&&digitalRead(9)){  //중앙, 오른쪽 센서가 High이면
  digitalWrite(Motor1direction, 0);
  digitalWrite(Motor2direction, 0);
  analogWrite(Motor1speed, 20);
  analogWrite(Motor2speed, 50); //오른바퀴
 }
 else{
  digitalWrite(Motor1direction, 0);
  digitalWrite(Motor2direction, 0);
  analogWrite(Motor1speed, 0); 
  analogWrite(Motor2speed, 0); //오른바퀴
 }
}
