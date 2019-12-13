package cadastroUsuario.resoucer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.entity.Telefone;
import cadastroUsuario.service.TelefoneService;

@Controller
public class TelefoneResource {

	@Autowired
	private TelefoneService services;
	
		
	@RequestMapping(value = "/telefone", method = RequestMethod.POST)
	public String form(Telefone tel) {
		services.addTel(tel);
		return "redirect:usuario";
	}
	
	/*
	@RequestMapping(value = "/listaUsuarios")
	public ModelAndView findAll(){
		return services.findAll();
		
	}
	*/
}
