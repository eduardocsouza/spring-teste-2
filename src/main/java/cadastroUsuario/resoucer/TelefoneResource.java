package cadastroUsuario.resoucer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.entity.Telefone;
import cadastroUsuario.service.TelefoneService;

@Controller
@RequestMapping("telefone")
public class TelefoneResource {

	@Autowired
	private TelefoneService services;
	
		
	@PostMapping
	public String form(Telefone tel) {
		services.addTel(tel);
		return "redirect:usuario";
	}
	
	@GetMapping
	public ModelAndView findAll(){
		return services.findAll();
		
	}
}
