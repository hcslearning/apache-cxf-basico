package cl.hcslearning.cxf;

import jakarta.jws.WebService;

@WebService(endpointInterface = "cl.hcslearning.cxf.HolaMundo",
    serviceName = "HolaMundo")
public class HolaMundoImp implements HolaMundo {

    @Override
    public String decirHola(String nombre) {
        return "Hola "+nombre;
    }
}
