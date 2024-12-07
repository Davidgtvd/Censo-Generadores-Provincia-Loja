
import com.lojageneradores.dao.CasaDao;
import com.lojageneradores.models.Casa;
import com.lojageneradores.respuesta.Respuesta;
import com.lojageneradores.tda.Lista;

public class CasaApi {

    public static void main(String[] args) {
        // You can add code here to test the CasaApi class
    }

    private final CasaDao casaDao;

    public CasaApi() {
        casaDao = new CasaDao();
    }

    public boolean guardarCasa(Casa casa) {
        casaDao.setServicio(casa);
        return casaDao.save();
    }

    public boolean actualizarCasa(Casa casa) {
        casaDao.setServicio(casa);
        return casaDao.update();
    }

    public boolean eliminarCasa(Integer id) {
        return casaDao.eliminar(id);
    }

    public Casa buscarCasaPorId(Integer id) {
        return casaDao.buscar(id);
    }
}
