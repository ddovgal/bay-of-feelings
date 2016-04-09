package ua.twoGuysGroup.bayOfFeelings.controller.request;

public class CollectionsControlRequest {

    private String action;
    private String items;

    public CollectionsControlRequest() {
    }

    public CollectionsControlRequest(String action, String items) {
        this.action = action;
        this.items = items;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
