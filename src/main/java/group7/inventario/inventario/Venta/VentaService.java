package group7.inventario.inventario.Venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;

    @Autowired
    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }
    public List<Venta> getVenta(){ return ventaRepository.findAll(); }

    public Venta addNewVenta(Venta venta) {

        return ventaRepository.save(venta);
    }
}
