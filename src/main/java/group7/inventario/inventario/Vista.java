package group7.inventario.inventario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Vista {
    
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
    @RequestMapping("/products")
    public String dashboard()
    {
        return "products";
    }

    @RequestMapping("/login")
    public String eliminar() {

        return "login";
    }
    @RequestMapping("/registrar")
    public String eliminaar() {

        return "registrar";
    }
}
