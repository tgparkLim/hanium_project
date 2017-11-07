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
  //pinMode(7, INPUT);
  pinMode(8, INPUT);
  //pinMode(9, INPUT);
  Serial.begin(9600);
}

void loop() {
  /*if(digitalRead(7)) {
    Serial.println("7white");
    delay(100);
  }
  else {
    Serial.println("7black");
    delay(100);
  }
  if(digitalRead(8)) {
    Serial.println("8white");
    delay(100);
  }
  else {
    Serial.println("8black");
    delay(100);
  }
  if(digitalRead(9)) {
    Serial.println("9white");
    delay(100);
  }
  else {
    Serial.println("9black");
    delay(100);
  }
  */

  /*
  digitalWrite(Motor1direction, 1);
  digitalWrite(Motor2direction, 1);
  analogWrite(Motor1speed, 50); 
  analogWrite(Motor2speed, 50); //오른바퀴
  */
  if(digitalRead(8)) {
    Serial.println("8white");
    delay(100);
  }
  else {
    Serial.println("8black");
    digitalWrite(Motor1direction, 0);
    digitalWrite(Motor2direction, 0);
    analogWrite(Motor1speed, 50); 
    analogWrite(Motor2speed, 50); //오른바퀴
    delay(100);
  }
  

}
