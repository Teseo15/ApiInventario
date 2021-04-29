package group7.inventario.inventario.registration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/fazadmin")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }



    @PostMapping("/login")
    public String register(@RequestBody RegistrationRequest request) {
        registrationService.register(request);
        return "login";
    }
    @GetMapping(path = "confirm")
    public String confirm (@RequestParam("token")String token){

        return registrationService.confirmToken(token);
    }
}
