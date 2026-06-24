import com.sistemacontable.modulo8.dao.DatosFinancierosDAO;
import com.sistemacontable.modulo8.modelo.ResultadoPrediccion;
import com.sistemacontable.modulo8.servicio.MotorPrediccionIA;
import com.sistemacontable.modulo8.util.ExportadorPDF;

public class TestBug {
    public static void main(String[] args) throws Exception {
        DatosFinancierosDAO dao = new DatosFinancierosDAO();
        MotorPrediccionIA motor = new MotorPrediccionIA();
        ExportadorPDF exportador = new ExportadorPDF();

        var hist = dao.obtenerHistorial(1);
        String nom = dao.obtenerNombreEmpresa(1);
        ResultadoPrediccion res = motor.predecir(hist, nom, 1);
        System.out.println("Prediccion lista");

        exportador.generarPDF(res, "test.pdf");
        System.out.println("PDF generado.");
    }
}
