
# Call to Firebase Service using Node JS for sending notification

Automated call API is node based service to voice over message using Twilio API.

  - [Node JS](https://nodejs.org/en/)
  - [Google Firebase](https://console.firebase.google.com/)

### New Features!

  - Sending notification to a registered device (Token should be registered with service)
  - In ```send-push-notification-server-nodejs``` folder go to ```server.js``` and look for ```const registrationToken = ""``` assign here the ```device-token``` which you get it from Android app debug.

### Future features!
  - Sending Notification to all device which download the app
  - for this need to ```create a database to store the device token``` when installed first time
  - Sending to the server from android app, the ```device-token```

### Tech

This project uses below technology and API 

* [Node JS](https://nodejs.org/) - service for web apps!
* [Google Firebase](https://console.firebase.google.com/) - API to send notification

### Installation

##### Install key
- Create the firebase apllication using below [URL](https://console.firebase.google.com/u/0/)
- Go to Project setting and Service account -> ```Admin SDK configuration snippet```
- Click on Generate new private key and keep it name as ```serviceAccountKey.json``` and put inside ```key``` folder of application 
- On the same page you might find the below code, please copy database URL and pase to ```server.js``` file on appropriate code line search for string ```REPLACE_ME_AS_PER_DOCUMENTATION```

```sh
    admin.initializeApp({
      credential: admin.credential.cert(serviceAccount),
      databaseURL: "https://notificationapp-e6966.firebaseio.com"
    });
```
##### Development Server -on Local machine
requires [Node.js](https://nodejs.org/) v4+ to run.
chekout the [PROJECT](https://github.com/kprosolutions/demo_computer_vision) 

goto the directory 
```sh
$ cd send-push-notification-server-nodejs
```
create a ```.env ``` file inside the directory and put the below configuration 
```sh
NODE_ENV=production
PORT=3000
```

Install the dependencies and devDependencies and start the server.

```sh
$ npm install
$ node -r dotenv\config server.js
```

##### Production Server 

```NOT AVAILABLE```

### Development

Want to contribute? Great!
install nodemon ```npm install -g nodemon```
Open your favorite Terminal and run these commands.
```sh
$ nodemon -r dotenv\config server.js
```
Make a change in your file and instantanously see your updates!

### TEST
 To Test the app, install [Postman](https://www.getpostman.com/)
 Test the post service ```URL:port/pushmessages```
 with below data 
 
 ```sh
    {
	"image":"image URL PUBLIC _ REPLACE THIS WITH YOUR IMAGE URL ",
	"name":"SOME NAME ",
	"message":"SOME MESSAGE "
}
 ```
 
 #### Firebase trail account 
 To use firebase trail account only 100 message and device speicific message can be sent.

# THANK YOU 
