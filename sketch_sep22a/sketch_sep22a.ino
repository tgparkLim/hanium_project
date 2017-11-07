int data[4];
int LPWM;
int RPWM;

void setup() {
  Serial.begin(9600);
//핀번호 배정
  Serial.println("RC Car is ready to start");
}

void loop() {
  while (!Serial.available());
  while (Serial.available()) {
    data[0] = Serial.read();
    char d1= data[0];
    Serial.print(d1);

    
    LPWM = data[1];
    RPWM = data[3];
    if (data[0] == 0) {
      Serial.println("left wheel foward");
    } else {
      Serial.println("left wheel backward");
    }
    }
    if (data[2] == 0) {
      Serial.println("right wheel foward");
    } else {
      Serial.println("right wheel backward");
    }
}
  
