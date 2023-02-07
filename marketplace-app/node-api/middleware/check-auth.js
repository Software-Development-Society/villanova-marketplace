const HttpError = require("../models/http-error");
const jwt = require('jsonwebtoken');
//require('dotenv').config()

module.exports = (req, res, next) => {
    //console.log("auth", req.headers.authorization)
    try {
        const token = req.headers.authorization.split(' ')[1];
        if(!token){
            throw new Error('Authentication failed');
        }
        const decodedToken = jwt.verify(token, "jwttemp"/*process.env.SECRET_JWT_KEY*/);
        req.userData = {userId: decodedToken.userId, email: decodedToken.email};
        next();
    } catch (err) {
        const error = new HttpError('Authentication failed!', 401);
        return next(error);
    }
    
}