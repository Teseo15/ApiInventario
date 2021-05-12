package group7.inventario.inventario.registration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@Controller
@RequestMapping(path ="/user/registrar")
public class RegistrationController {
    public String mensaje;
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
    @GetMapping(path = "confirm")
    public Object confirm (@RequestParam("token")String token){
        mensaje = registrationService.confirmToken(token);

        if(mensaje == "confirmed"){
            return dashboard();
        }else{
            return mensaje;
        }

    }

    @RequestMapping("/dasboard")
    public RedirectView dashboard(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/dasboard");
        return redirectView;
    }
}
