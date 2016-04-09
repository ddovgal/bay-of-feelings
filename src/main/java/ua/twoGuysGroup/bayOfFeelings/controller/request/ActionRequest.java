package ua.twoGuysGroup.bayOfFeelings.controller.request;

public class ActionRequest {

    private String action;

    public ActionRequest() {
    }

    public ActionRequest(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
