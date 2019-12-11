package cadastroUsuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.entity.Usuario;
import cadastroUsuario.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
			
	public Usuario addUser(Usuario user) {
		return repository.save(user);
	}
	
	public ModelAndView findAll(){
		ModelAndView mv = new ModelAndView("lista");
		List<Usuario> list = repository.findAll();
		mv.addObject("usuario", list);
		return mv;
	}

}
