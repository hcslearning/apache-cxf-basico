package cl.hcslearning.cxf;

import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService
public interface HolaMundo {
    @WebResult(name = "saludo")
    String decirHola(
        @WebParam(name = "nombre") String nombre
    );
}
