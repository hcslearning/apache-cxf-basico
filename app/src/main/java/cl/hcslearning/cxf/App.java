package cl.hcslearning.cxf;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.ext.logging.LoggingFeature;

public class App {

    public static void main(String[] args) {
        HolaMundo service = new HolaMundoImp();
        String url = "http://localhost:9000/holaMundo";
        LoggingFeature logging = new LoggingFeature();
        Endpoint.publish(url, service, logging);
    }

}

