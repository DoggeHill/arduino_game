#include <WiFi.h>
#include <HTTPClient.h>


const char*  password = "internety";
const char* ssid = "internety";



void setup() {

  pinMode(22, OUTPUT);  
  
  Serial.begin(115200);
  delay(4000);
  WiFi.begin(ssid, password);
 
  while (WiFi.status() != WL_CONNECTED) {
    delay(10000);
    Serial.println("Connecting to WiFi..");
  }
 
  Serial.println("Connected to the WiFi network");
 
}

void loop(){

  // digitalWrite(22, HIGH);
    
   if ((WiFi.status() == WL_CONNECTED)) { //Check the current connection status
 
    HTTPClient http;
 
    http.begin("http://internetypatrik.000webhostapp.com/getter.php"); //Specify the URL
    int httpCode = http.GET();                                        //Make the request
 
    if (httpCode > 0) { //Check for the returning code
 
        String payload = http.getString();
        Serial.println(httpCode + " httpCode ");
        Serial.println(payload + " payload ");
        if(payload.equals("jump")){
           Serial.println("I jumped");
           digitalWrite(22, HIGH);
          // delay(500);
        }
        else {
           Serial.println("Not jumped");
           digitalWrite(22, LOW);
         //  delay(500);
        }
      }
 
    else {
      Serial.println("Error on HTTP request");
    }
 
    http.end(); //Free the resources
  }
 
  
  
}
