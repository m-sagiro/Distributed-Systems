package Sockets;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {
    private String operation;
    private String f_name;
    private String[] params;
    private ArrayList<String> objects;


    Message(String operation, String f_object, String[] params){
        this.operation = operation;
        this.f_name = f_object;
        this.params = params;
        this.objects = new ArrayList<>();
    }

    public String getOperation() {
        return operation;
    }

    public String getF_name() {
        return f_name;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setObjects(ArrayList<String> objects) {
        this.objects = objects;
    }

    public void addObjects(String i){
        this.objects.add(i);
    }

    public ArrayList<String> getObjects() {
        return objects;
    }
}
