class HttpError extends Error {
    constructor(message, errorCode) {
        super(message); //Adds message
        this.code = errorCode; //Sets error code
    }
}

module.exports = HttpError;