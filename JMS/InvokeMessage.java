package JMS;

import java.io.Serializable;
import java.util.ArrayList;

public class InvokeMessage implements Serializable {
    private String fund_name;
    private String method;
    private String[] parameters;
    private ArrayList<String> return_values;

    public InvokeMessage(String fund_name, String method, String[] parameters) {
        this.fund_name = fund_name;
        this.method = method;
        this.parameters = parameters;
    }

    public InvokeMessage(String fund_name, String method, String[] parameters, ArrayList<String> return_values) {
        this.fund_name = fund_name;
        this.method = method;
        this.parameters = parameters;
        this.return_values = return_values;
    }

    public String getFund_name() {
        return fund_name;
    }

    public void setFund_name(String fund_name) {
        this.fund_name = fund_name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public ArrayList<String> getReturn_values() {
        return return_values;
    }

    public void setReturn_values(ArrayList<String> return_values) {
        this.return_values = return_values;
    }
}
