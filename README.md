
# Automated Call API

Automated call API is node based service to voice over message using Twilio API.

  - Node JS
  - TWILIO API (https://www.twilio.com/)
  - Magic

### New Features!

  - Calling a verified number (Should be verified with Twilio account -https://www.twilio.com/console/voice/numbers)
  - The message is a demo message from Twilio server


### Future features!
  - Create our own server using node and provide the message from the hookup server 
    The future is more interesting with paid account!

### Tech

This project uses below technology and API 

* [Node JS](https://nodejs.org/) - service for web apps!
* [Twilio](https://www.twilio.com/) - API to send service

### Installation

##### Development Server -on Local machine
requires [Node.js](https://nodejs.org/) v4+ to run.
chekout the [PROJECT](https://github.com/kprosolutions/demo_computer_vision) 

goto the directory 
```sh
$ cd place-automatedcall-service-nodejs
```
create a ```.env ``` file inside the directory and put the below configuration 
```sh
NODE_ENV=production
PORT=3000
# Set your TWILIO ACCOUNT DETAILS here
AUTH_TOKEN=YOUR_AUTH_TOKEN
ACCOUNT_SID=YOUR_ACCOUNT_SID
# this is from twilio console, you need to get a new number
SENDER_PHONE=+8911239103921(YOUR_SENDE_NUMBER) 
```

Install the dependencies and devDependencies and start the server.

```sh
$ npm install
$ node -r dotenv\config server.js
```

##### Production Server - on [HEROKU](https://devcenter.heroku.com/articles/deploying-nodejs)

install the [heroku-cli] and create an account
chekout the [PROJECT](https://github.com/kprosolutions/demo_computer_vision) 
Copy this ```place-automatedcall-service-nodejs``` folder and put in a new location to deploy it on heroku

Go to terminal and navigate to new location of the folder ```cd YOUR_NEW_LOCATION/place-automatedcall-service-nodejs```
```sh
npm init -fy
git init
git add -a -m “Initial commit”
heroku login
Enter your Heroku credentials.
...
heroku create
    #Creating arcane-lowlands-8408... done, stack is cedar
    #http://arcane-lowlands-8408.herokuapp.com/ | #@heroku.com:arcane-lowlands-8408.git
    #Git remote heroku added
git push heroku master
    #...
    #-----> Node.js app detected
    #...
    #-----> Launching... done
    #       http://arcane-lowlands-8408.herokuapp.com deployed to Heroku
```
Set the enviornment variable as ```.env``` don't go to production

```sh
heroku config:set ACCOUNT_SID=YOUR_ACCOUNT_SID
heroku config:set AUTH_TOKEN=YOUR_AUTH_CODE
heroku config:set SENDER_PHONE =+423423423424#(TWILIO_PHONE_NUMBER)

# run it again 
git push heroku master

# open the app
heroku open
```

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
 Test the post service ```URL/automatedCall```
 with below data 
 
 ```{"to":"+91823290023"}```
 
 #### Twilio trail account 
 To use trail account all number to send voice SMS should be verified in the TWILIO console.

# THANK YOU 
