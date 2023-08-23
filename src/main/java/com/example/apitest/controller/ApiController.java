package com.example.apitest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.apitest.model.ApiModel;
import com.example.apitest.service.ApiService;
import com.example.apitest.service.ExceptionData;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiservice;

    @GetMapping("/findAll")
    public Object findAll() {
        return apiservice.findAll();
    }

    @PostMapping("/service/generateToken")
    public ResponseEntity<ApiResponse> insert(@RequestBody ApiModel apiModel) {
        ApiResponse response = new ApiResponse();
        if (apiModel.getSsotype() == null || apiModel.getSystemid() == null || apiModel.getSystemname() == null
                || apiModel.getSystemtransactions() == null || apiModel.getSystemprivileges() == null
                || apiModel.getSystemusergroup() == null || apiModel.getSystemlocationgroup() == null
                || apiModel.getUserid() == null || apiModel.getUserfullname() == null
                || apiModel.getUserrdofficecode() == null || apiModel.getUserofficecode() == null
                || apiModel.getClientlocation() == null || apiModel.getLocationmachinenumber() == null
                || apiModel.getTokenid() == null) {
            response.setResponseCode("E00001");
            response.setResponseMessage("ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้");

            ApiResponse.ResponseData responseData = new ApiResponse.ResponseData();
            responseData.setUserId(apiModel.getUserid());
            responseData.setTokenId(apiModel.getTokenid());
            response.setResponseData(responseData);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            String result = apiservice.insert(apiModel);
            response.setResponseCode("I07000");
            response.setResponseMessage("ทำรายการเรียบร้อย");

            ApiResponse.ResponseData responseData = new ApiResponse.ResponseData();
            responseData.setUserId(apiModel.getUserid());
            responseData.setTokenId(apiModel.getTokenid());

            response.setResponseData(responseData);

            return ResponseEntity.ok(response);
        } catch (ExceptionData data) {
            response.setResponseCode("E00001");
            response.setResponseMessage("ไม่พบฐานข้อมูล หรือ ดาต้าเบส not connected");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public static class ApiResponse {
        private String responseCode;
        private String responseMessage;
        private ResponseData responseData;

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
        }

        public ResponseData getResponseData() {
            return responseData;
        }

        public void setResponseData(ResponseData responseData) {
            this.responseData = responseData;
        }

        public static class ResponseData {
            private String userId;
            private String tokenId;

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getTokenId() {
                return tokenId;
            }

            public void setTokenId(String tokenId) {
                this.tokenId = tokenId;
            }
        }
    }
}
