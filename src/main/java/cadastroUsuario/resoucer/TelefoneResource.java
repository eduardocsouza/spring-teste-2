package cadastroUsuario.resoucer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.entity.Telefone;
import cadastroUsuario.repository.UserRepository;
import cadastroUsuario.service.TelefoneService;

@Controller
public class TelefoneResource {

	@Autowired
	private TelefoneService services;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/cadastroTelefone")
	public String form() {
		return "telefone";
	}
	
	@RequestMapping(value = "/cadastroTelefone", method = RequestMethod.POST)
	public String form(Telefone tel) {
		services.addTel(tel);
		return "redirect:/cadastroUsuario";
	}
	
	@GetMapping(value="/listaTelefone")
	public ModelAndView findAll(){
		return services.findAll();
		
	}
		
	
	/*
	@RequestMapping(value = "/listaUsuarios")
	public ModelAndView findAll(){
		return services.findAll();
		
	}
	*/
}
