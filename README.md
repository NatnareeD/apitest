java version 11
database : ssotest

* host : localhost
* port : 5432
* database : ssotest
* username : ssodev
* password : sso2022ok

swagger ling
http://localhost:8080/apitest/swagger-ui.html

ใส่ข้อมูลใน POST service/generateToken ดังตัวอย่างด้านล่าง

{
  "request_date": "2023-08-23T06:45:57.559Z",
  "ssotype": "SSOData",
  "systemid": "VATDEDEV",
  "systemname": "ระบบบันทึกข้อมูลภาษีมูลค่าเพิ่มทดสอบ",
  "systemtransactions": "PRIV-010,PRIV-020,PRIV-040,PRIV-050",
  "systemprivileges": "0|0|0|0",
  "systemusergroup": "GRP-010,GRP-020,GRP-040",
  "systemlocationgroup": "CliC001",
  "userid": "WS233999",
  "userfullname": "ประสาท จันทร์อังคาร",
  "userrdofficecode": "01000999",
  "userofficecode": "01001139",
  "clientlocation": "01001139",
  "locationmachinenumber": "CLI00000718-9999",
  "tokenid": "eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9"
}

กด refresh ใน database


