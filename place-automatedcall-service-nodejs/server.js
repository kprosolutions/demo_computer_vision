const app = require("express")();
const bodyParser = require("body-parser");
const config = require("./config/config");
const { port,account_sid,auth_token,senderPhone } = config;
app.use(bodyParser.json());
const client = require("twilio")(account_sid,auth_token);


app.get('/', function (req, res) {
  res.send(JSON.stringify({ 'Hello': 'World'}));
 });

app.post("/automatedCall", (req, res) => {
  let error;
  let data;
  let st;
  let message = req.body;
  console.log(client);
  client.calls
  .create({
     url: 'http://demo.twilio.com/docs/voice.xml',
     to: message.to,
     from: senderPhone
   })
  .then(call => console.log(call.sid));
  res.send({
      status:200
  });
});

app.listen(port || 3000, () => {
  console.log(`Listening server on port for database--service ${port}`);
});