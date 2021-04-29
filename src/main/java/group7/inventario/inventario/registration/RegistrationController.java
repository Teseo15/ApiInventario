package group7.inventario.inventario.registration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }



    @PostMapping("/registration")
    public String register(@RequestBody RegistrationRequest request) {
        registrationService.register(request);
        return "registro";
    }
    @GetMapping(path = "confirm")
    public String confirm (@RequestParam("token")String token){

        return registrationService.confirmToken(token);
    }
}
