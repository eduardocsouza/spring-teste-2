package cadastroUsuario.resoucer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.entity.Usuario;
import cadastroUsuario.service.UserService;

@Controller
public class UserResource {

	@Autowired
	private UserService services;
	
		
	@RequestMapping(value = "/cadastroUsuario", method= RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("usuario", new Usuario());
		return mv;
	}	
	
	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.POST)
	public String form(Usuario user) {
		services.addUser(user);
		return "redirect:/cadastroUsuario";
	}
		
	
	@RequestMapping("/listaUsuarios")
	public ModelAndView findAll(){
		return services.findAll();
		
	}
	
	@GetMapping("/editarUsuario/{id}")
	public ModelAndView editeUser(@PathVariable("id") long id) {
		return services.editar(id);
	}
	
	@GetMapping("/excluirUsuario/{id}")
	public ModelAndView excluirUser(@PathVariable("id") long id) {
		return services.excluir(id);
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
