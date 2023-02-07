const express = require('express');
const bodyParser = require('body-parser');
const passport = require('passport');
var MicrosoftStrategy = require('passport-microsoft').Strategy;
//require('dotenv').config()
const jwt = require('jsonwebtoken');
const { UserModel, UnAuthedUserModel } = require('../db/schemas');
const checkAuth = require('../middleware/check-auth');


const User = UserModel;
const UnAuthedUser = UnAuthedUserModel;

const router = express.Router();


passport.use(new MicrosoftStrategy({
  clientID: "25edda00-5ff3-4300-8ad5-4674943afe76",
  clientSecret: "5X78Q~otkD4H_6DvpXONFx1VCk9zuZ1Im311Tcxa",
  callbackURL: "http://localhost:5000/auth/ms",
  scope: ['user.read'],
},
  async function (accessToken, refreshToken, profile, cb) {
    const regex = new RegExp('^[A-Za-z0-9._%+-]+@villanova.edu$')
    //console.log("profile info:", profile);
    const email = profile.emails[0].value;

    //console.log(profile.emails[0].value, email);
    const allowedEmails = ["test"]//process.env.EMAILS.split(' ');
    if (regex.test(email) || (allowedEmails.includes(email))) {
      let token;
      let firstTime = await User.find({ email: email }).then(results => {
        console.log(results);
        if (results.length < 1) {
          return true;
        } else {
          return false;
        }
      }).catch(error => {
        console.log(error);
      });
      console.log("first time", firstTime);
      if (firstTime) {
        await User.findOrCreate({
          msId: profile.id,
          name: profile._json.displayName,
          email: profile.emails[0].value,
          classYear: 0,
          major: '',
          wishList: [],
          registrationComplete: false
        },
          function (err, user) {
            console.log("44", user);
            if (!err) {
              try {
                token = jwt.sign({
                  userId: profile.id,
                  name: profile._json.displayName,
                  email: email,
                  classYear: user.classYear,
                  major: user.major,
                  wishList: user.wishList,
                  registrationComplete: user.registrationComplete
                }, /*process.env.SECRET_JWT_KEY*/"jwttemp", { expiresIn: '3d' });
              } catch (error) {
                console.log(error);
              }
            }
            //console.log("token", token);
            return cb(err, user, { token, firstTime }, "teststuff");
          });
      } else {
        await User.findOrCreate({
          msId: profile.id,
        },
          function (err, user) {
            console.log("44", user.major);
            if (!err) {
              try {
                token = jwt.sign({
                  userId: profile.id,
                  name: profile._json.displayName,
                  email: email,
                  classYear: user.classYear,
                  major: user.major,
                  wishList: user.wishlist,
                  registrationComplete: user.registrationComplete
                }, /*process.env.SECRET_JWT_KEY*/"jwttemp", { expiresIn: '3d' });
              } catch (error) {
                console.log(error);
              }
            }
            //console.log("token", token);
            return cb(err, user, { token, firstTime }, "teststuff");
          });
      }
    } else {
      console.log('xxxx')
      UnAuthedUser.findOrCreate({ 
        msId: profile.id, name: profile._json.displayName, 
        email: profile.emails[0].value 
      }, function (err, user) {
        return cb(err, undefined);
      });
    }

  }
));

//Make sure to know that it's /auth/login and 
router.get('/login', passport.authenticate('microsoft'));
//Make sure to use referrerpolicy='no-referrer' in react when you do this

router.get('/test', (req, res) => {
  res.send("Good");
});

router.get('/ms',
  passport.authenticate('microsoft', { session: false, failWithError: true }),
  function (req, res) {
    // Successful authentication, redirect home.
    //console.log("68", req.user);
    //console.log("\nAuth info", req.user)
    //console.log(req)
    let token = req.authInfo.token;
    let firstTime = req.authInfo.firstTime;
    if (firstTime) {
      console.log("first time")
      res.redirect("http://localhost:3000/login?token=" + token + "&firsttime=" + firstTime);
    } else {
      console.log("Not first time")
      res.redirect("http://localhost:3000/login?token=" + token);
    }

    //res.json({"Message": "Success", token: req.authInfo, userId: req.user.id, email: req.user.email, picture: req.user.picture});
  }, function (err, req, res, next) {
    console.log("ms-auth 105: ", err)
    res.redirect("http://localhost:3000/login?failed=true");
  });

router.use(checkAuth);
router.get("/verify", (req, res) => {
  try {
    //throw error
    const token = req.headers.authorization.split(' ')[1];
    if (!token) {
      throw new Error('Authentication failed');
    }
    const decodedToken = jwt.verify(token, "jwttemp"/*process.env.SECRET_JWT_KEY*/);
    res.json({ userId: decodedToken.userId, token: token, name: decodedToken.name, email: decodedToken.email, major: decodedToken.major }).status(225);
  } catch (err) {
    const error = new HttpError('Authentication failed!', 401);
    return next(error);
  }
})

module.exports = router;