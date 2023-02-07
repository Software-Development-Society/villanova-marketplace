const express = require('express');
const bodyParser = require('body-parser');

const HttpError = require('./models/http-error');
var cors = require('cors')
const checkAuth = require('./middleware/check-auth');
const loginRoutes = require('./routes/ms-auth')

const app = express();

app.use(bodyParser.urlencoded({extended: true}));

app.use(cors());

app.use('/auth', loginRoutes);


app.use((req, res, next) =>{
    const error = new HttpError('Could not find this route.', 404);
    throw error;
});

app.use((error, req, res, next) =>{
    if(res.headerSent){
        return next(error);
    }
    res.status(error.code || 500);
    res.json({message: error.message || "An unknown error occured."});
});


app.listen(/*process.env.PORT ||*/ 5000);


// if(!doesntExist){
//     return next(new HttpError("Error message", 404))
// }

// if(!doesntExist){
//     throw new HttpError('Could not do something', 404);;
// }
