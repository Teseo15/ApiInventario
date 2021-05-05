package group7.inventario.inventario.registration;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/user")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping(value="/registrar" )
    public String registrar(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @PostMapping(value="/form" )
    public String form() {
        //registrationService.register(request);
        return "register";
    }
    @GetMapping(path = "confirm")
    public String confirm (@RequestParam("token")String token){

        return registrationService.confirmToken(token);
    }

    @RequestMapping(value="/hola")
    public String hola() {
        //registrationService.register(request);
        return "hola";
    }
}
