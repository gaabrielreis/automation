/* = ** ======================== ** ======================= // ================================== ** ===================================== |
|   --   -----  -----------     --   -   --    ---      --   --   ------  ----------   -------   --   --------      --   --     -----      |
|  |  | |  -  | ----   ----    |  | |  \|  | |   -  \  |  | |  | |  ====  ----  ----  |   --  | |  | |   --   |    |  | |  |   |  -  |     |
|  |  | | | | |    |  |        |  | |      | |  | |  | |  | |  | |      |    |  |     |  |_  <  |  | |  |__|  |    |   -   |   | | |       |
|  |  | |  -  |    |  |        |  | |  |\  | |   -  /  |   -   |  ====       |  |     |  | |  | |  | |  |  |  |     --- |  |   |  -  |     |
|   --   -----      --          --   --  --    ---      -------   ------      --       --   --   --   --    --           --  O  -----      |
| ======================================================================================================================================== | 
| PROJECT TO INDUSTRIA 4.0 THIS EXAMPLE DEMONSTRATION INTERFACE IN ESP8266 AND MQTT WITH CONSTRUCT 2.                                      |
| WITH THIS DESIGN WE CAN OPERATE DEVICES MONITOR TEMPERATURE, CURRENT, VIBRATION,                                                         | 
| ======================================================================================================================================== */

//========================================================== importações de bibliotecas ===============

#include <Servo.h>
#include <ESP8266WiFi.h>
#include <WiFiClientSecure.h>


// ========================================================= Variaveis de Rede ==============================

#ifndef STASSID
#define STASSID "AndroidAP23"
#define STAPSK  "digitaltabe"
#endif

const char* ssid = STASSID;
const char* password = STAPSK;

const char* host = "script.google.com";
const int httpsPort = 443;

// Use web browser to view and copy
// SHA1 fingerprint of the certificate
const char fingerprint[] PROGMEM = "03 25 c0 6b db 7e 2c 25 c4 dc d4 ac 1b d6 d7 bd 4d 6f";

// ========================================================= Variaveis de Motor ==============================

Servo servo_2;
unsigned long int time_b = millis();
int TempoLigado = 30000;        // Tempo do motor ligado 30segundos.
bool StartMotor = 0;            // Start do motor
int pos = 0;

// ========================================================= Variaveis de Relogio ==============================

void dunilay(unsigned long int tempo);
unsigned long int time_a = millis();

// Falta vir horas da internet, em caso de desligamento ele acertar automaticamente
int segundos = 0;
int minutos = 22;   //colocar a minuto atual
int horas = 9;      //colocar o hora atual
int dia = 30;        //colocar dia atual

// ========================================================= Variaveis de Temperatura ==============================

int TemperaturaAgua = 25; // Temperatura da agua em grau celsius

// ========================================================= Variaveis de Ultrassonico =============================

// Se o nivel de ração estiver ok o motor pode ligar
bool Racao = 0; 

// ======================================================= Rotinas ===============================

void setup(){
Serial.begin(115200);
servo_2.attach(2); // Pino 2 do nodemcu
}

void loop() {
  
Rede();
Relogio();
Temperatura();
Ultrassonico();
Motor();

}

//======================================================= Rotina Motor ===========================

void Motor(){
  
//Ligar servo 9 e 16 por 30 segundos
  
if(horas == 9 && minutos == 0 && segundos == 0 && Racao == 1){  // Liga motor às 9:00
StartMotor = 1;
}

if(horas == 16 && minutos == 0 && segundos == 0 && Racao == 1){ // Liga motor às 16:00
StartMotor = 1;
}
  
  
if(StartMotor == 1){
  
  pos = 180;// Liga motor;
  
  if(((millis() - time_b) > TempoLigado)){  // Aguarda tempo para desligar motor 
    pos = 0;// Desliga motor
    StartMotor = 0;
    time_b = millis();
    
}
}

if(StartMotor == 0){
  pos = 0;// Desliga motor;
}
servo_2.write(pos);



  //for (pos = 0; pos <= 180; pos += 1){
  // servo_9.write(pos);
  // delay(15); // Wait for 15 millisecond(s)
  //}
  //for (pos = 180; pos >= 0; pos -= 1) {
  //  servo_9.write(pos);
  // delay(15); // Wait for 15 millisecond(s)
  //}

}


//======================================================= Rotina Relogio ==========================
void Relogio(){
  
  if(((millis() - time_a) > 1000)){
    time_a = millis();
    segundos = segundos+1;
    
    Serial.print("Relogio ");
    Serial.print(horas); 
    Serial.print(":");
    Serial.print(minutos);
    Serial.print(":");
    Serial.println(segundos);
}

if(segundos == 60){
  minutos = minutos+1;
  segundos = 0;
}
if(minutos == 60){
  horas = horas +1;
  minutos = 0;
}
if((horas == 24)&&(minutos == 60)){
  dia = dia + 1;
}
if(dia == 30){
  dia = 0;
}


}

//======================================================= Rotina Temperatura ==========================
void Temperatura(){
  
// regra de três temperatura minima de 25º * tempo maximo de 30segundos = 750
TempoLigado = (750/TemperaturaAgua);  // tempo do motor ligado em segundos em função da temperatura.

}


//======================================================= Rotina Ultrassonico ==========================
void Ultrassonico(){
  
}

void Rede(){
  
  Serial.print("connecting to ");
  Serial.println(ssid);
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());

  // Use WiFiClientSecure class to create TLS connection
  WiFiClientSecure client;
  Serial.print("connecting to ");
  Serial.println(host);

  Serial.printf("Using fingerprint '%s'\n", fingerprint);
  client.setFingerprint(fingerprint);
  client.setTimeout(15000); //15 segundos
  delay(1000);

  Serial.print("HTTPS Connecting");
  int r=0; //retry counter
  while((!client.connect(host, httpsPort)) && (r <30)) {
      delay(100);
      Serial.print(".");
      r++;
  }
  if(r==30) {
    Serial.println("Connection failed");
  }
  else {
    Serial.println("Connected to web");
  }
  

  String url = "/macros/s/AKfycbwMQxC-zCUb-wSzBNGIZUrh-0xQLJxi15mQi1pUY3Wsp77cvaw/exec?temperatura=7&humidade=20";
  Serial.print("requesting URL: ");
  Serial.println(host+url);

  client.print(String("GET ") + url + " HTTP/1.1\r\n" +
               "Host: " + host + "\r\n" +
               "User-Agent: BuildFailureDetectorESP8266\r\n" +
               "Connection: close\r\n\r\n");

  Serial.println("request sent");
  while (client.connected()) {
    String line = client.readStringUntil('\n');
    if (line == "\r") {
      Serial.println("headers received");
      break;
    }
  }
  String line = client.readStringUntil('\n');
  if (line.startsWith("{\"state\":\"success\"")) {
    Serial.println("esp8266/Arduino CI successfull!");
  } else {
    Serial.println("esp8266/Arduino CI has failed");
  }
  Serial.println("reply was:");
  Serial.println("==========");
  Serial.println(line);
  Serial.println("==========");
  Serial.println("closing connection");
}

//=======================================================Rotina para substituir delay ==========================

void dunilay(unsigned long int tempo){
  unsigned long int tempo_Inicial = millis();
  while (millis() < tempo_Inicial + tempo) {}
}         
