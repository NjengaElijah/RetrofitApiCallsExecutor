

import java.io.Serializable;

/**
 * Created by NE on 2/12/2019.
 */

public class ServerResponse implements Serializable {
    private String Type, Message;
    private Object Data;

    public ServerResponse() {
        this.Type = "ERROR";
        this.Message = "Sorry ! A Technical error has occurred";
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getData() {
        return Data.toString();
    }

    public void setData(String data) {
        Data = data;
    }

    public boolean isPositive() {
        if (Type != null) {
            if (getType().equalsIgnoreCase("ERROR")) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "Type='" + Type + '\'' +
                ", Message='" + Message + '\'' +
                ", Data='" + Data + '\'' +
                ", ISPOS='" + isPositive() + '\'' +
                '}';
    }

    public boolean isNull() {
        if (Type != null) {
            if (getMessage() == null || getMessage().isEmpty() || getType() == null || getType().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
