package shared;

public class ResponseDto {
    private String responseMsg;
    private String responseStatus;

    public ResponseDto(String responseMsg, String responseStatus) {
        this.responseMsg = responseMsg;
        this.responseStatus = responseStatus;
    }

    public ResponseDto () {}

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }
}
