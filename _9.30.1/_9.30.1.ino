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

  RFduinoBLE.advertisementInterval = 675;
  RFduinoBLE.advertisementData = "-DC";
  
  // start the BLE stack
  RFduinoBLE.begin();
  
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

  /*
  digitalWrite(Motor1direction, 1); //왼바퀴 모터 오류
  digitalWrite(Motor2direction, 1);
  analogWrite(Motor1speed, 50); 
  analogWrite(Motor2speed, 50); //오른바퀴
  */
}

void RFduinoBLE_onReceive(char *data, int len) {
  uint8_t M1speed = data[0];
  uint8_t M1direction = data[1];
  uint8_t M2speed = data[2];
  uint8_t M2direction = data[3];

  digitalWrite(Motor1direction, M1direction);
  digitalWrite(Motor2direction, M2direction);
  analogWrite(Motor1speed, M1speed);
  analogWrite(Motor2speed, M2speed);
}

  


