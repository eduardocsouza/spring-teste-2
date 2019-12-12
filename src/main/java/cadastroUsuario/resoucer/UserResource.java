package cadastroUsuario.resoucer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.entity.Usuario;
import cadastroUsuario.service.UserService;

@Controller
@RequestMapping("usuario")
public class UserResource {

	@Autowired
	private UserService services;
			
	@GetMapping
	public String form() {
		return "cadastro";
	}	
	
	@PostMapping
	public String form(Usuario user) {
		services.addUser(user);
		return "redirect:usuario";
	}
		
	
	@RequestMapping("/listaUsuarios")
	public ModelAndView findAll(){
		return services.findAll();
		
	}
}

/*
 * @RequestMapping(value="/cadastrouser", method = RequestMethod.GET)
	public String form() {
		return "cadastro";
	}	
	
	@RequestMapping(value="/cadastrouser", method = RequestMethod.POST)
	public String form(Usuario user) {
		services.addUser(user);
		return "redirect:/cadastrouser";
	}
		
	
	@RequestMapping("/listaUsuarios")
	public ModelAndView findAll(){
		return services.findAll();
		
	}
 * 
 */
