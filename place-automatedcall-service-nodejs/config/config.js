const { PORT,SENDER_PHONE,ACCOUNT_SID,AUTH_TOKEN } = process.env;
module.exports= {
    port: PORT || 3030,
    auth_token : AUTH_TOKEN,
    account_sid : ACCOUNT_SID,
    senderPhone:SENDER_PHONE
}