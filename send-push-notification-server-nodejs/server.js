const app = require("express")();
const bodyParser = require("body-parser");
const config = require("./config/config");
const { port } = config;
app.use(bodyParser.json());
const admin = require("firebase-admin");

const serviceAccount = require("./keys/serviceAccountKey.json");
const registrationToken ="daac7wrqAn0:APA91bGAK5Dg3ZiQIN5lzDb2bR3RasCO60b1okGQALrsWU6ItozJJYOlB6MyCl3rEN5Oo8_Tonmf0iptdOgo8vxxtAJ0XXS_1WuUe4mOEJtS015rm7i1VMdwRouKq5oWEdk_rEiMUrOE";
//"f3qigZobrR0:APA91bEYwglXy1FyrpaChnET8HCQDmAEf-LrBBUoyBkpC7X1vw_gWtot_mvPSmShnBsOCelufMc6Zdd92zr6by3Gl2Hip2GEe1F6AI4_FqDHDf7OiAGLTtMNAZkGpZ611p8stQ1rwgzi";
  //"dEl0x4EQwVM:APA91bHOSMK0HJyxCL-WLAT_x-tyIB7c_utzPmh1t-OuKowhaIEGg3ohSjTpZ36cZ30m-_E4j34Fc2txnG5HjYdsFouCXdA48yeoDHfkeouMlDzVPSdSOHCokTcvSPm74niAD1MQJg1O";

  admin.initializeApp({
    credential: admin.credential.cert(serviceAccount),
    databaseURL: "REPLACE_ME_AS_PER_DOCUMENTATION"
    //databaseURL: "https://notificationapp-e6966.firebaseio.com"
  });

app.post("/pushmessages", (req, res) => {
  let error;
  let data;
  let st;
  let message = req.body;
  let payload = {
    data: message
  };
  let options = {
    priority: "high",
    timeToLive: 60 * 60 * 24
  };
  admin
    .messaging()
    .sendToDevice(registrationToken, payload, options)
    .then(function(response) {
      console.log(`send notification`);
      console.log(response);
      data=response;
      st=201;
    })
    .catch(function(err) {
      console.log(`Error in sending to firebase server  ${err}`);
      console.log(err);
      error=err;
      st=500;
    });
  return res.send({
    message: "Got response from firebase server",
    service: "Sending notification to firebase",
    status: st,
    payload: data || error
  });
});

app.listen(port, () => {
  console.log(`Listening server on port for fire-base notification on the port ${port}`);
});