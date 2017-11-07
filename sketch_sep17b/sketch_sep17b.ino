const int LMOTOR = 5;
const int RMOTOR = 6;

void setup() {
  pinMode(2, INPUT);
  pinMode(3, INPUT);
  
  pinMode(13, OUTPUT);
  pinMode(14, OUTPUT);

  pinMode(LMOTOR, OUTPUT);
  while(! Serial);
  Serial.println("speed 0 to 255");

 
  //pinMode(RMOTOR, OUTPUT):

  Serial.begin(9600);
}

void loop() {
  if(digitalRead(2) || digitalRead(3)) {
    //digitalWrite(13, HIGH); //디지털 출력 (해당 핀, 출력 값(High/Low)을 정한다.
    //digitalWrite(14, HIGH); //Startkit교본 p26
    Serial.println("White");
    delay(100);
    //digitalWrite(13, LOW);
    //digitalWrite(14, LOW);
    delay(100);
  }
  else {
    Serial.println("Black");
    //analogWrite(Enable, speed);
    if(Serial.available())
    {
      int speed = Serial.parseInt();
      if (speed >= 0 && speed <=255)
      {
        analogWrite(LMOTOR, speed);
      }
    }
    
    delay(100);
  }

}
