package REST;

import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class MyDate {
  public int id;
  public int hour;
  public int  min;
  public int  sec;
  
  public String	toString() {
    return "ID: " + id + " Hour: " + hour + " Minutes: " + min  + " Seconds: " + sec;
  } 
}