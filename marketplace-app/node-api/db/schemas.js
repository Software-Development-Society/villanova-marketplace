const path = require('path')
//require('dotenv').config({path: path.resolve(__dirname, '../.env')});
const mongoose =  require('mongoose');
const findOrCreate = require('mongoose-findorcreate');

//mongoose.connect(process.env.MONGO_DB_ATLAS, {useNewUrlParser: true});

//mongoose.connect("mongodb://localhost:27017/", {useNewUrlParser: true})
mongoose.set('strictQuery', false);
mongoose.connect("mongodb+srv://vsds:lnBKl03NLjuCiieO@vsds.nio2wr0.mongodb.net/villanovaMarketplace?retryWrites=true&w=majority" , {useNewUrlParser:true} );
const Schema = mongoose.Schema;


const userSchema = new Schema({
    msId: String,
    name: String,
    email: String,
    classYear: Number,
    major: String,
    wishList: Array,
    registrationComplete: Boolean
});
const unAuthedUserSchema = new Schema({
    msId: String,
    name: String,
    email: String,
    classYear: Number,
    major: String,
    wishList: Array,
    registrationComplete: Boolean
});


  

userSchema.plugin(findOrCreate);
unAuthedUserSchema.plugin(findOrCreate);


const UnAuthedUser = mongoose.model("unAuthedUser", unAuthedUserSchema);
const User = mongoose.model("user", userSchema);

module.exports = {
    UserModel: User,
    UnAuthedUserModel: UnAuthedUser
}