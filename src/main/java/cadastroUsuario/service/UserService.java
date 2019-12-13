package cadastroUsuario.service;

import java.util.List;
import java.util.Optional;

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
	
	public ModelAndView editar(long id) {
		ModelAndView mv = new ModelAndView("cadastro");
		Optional<Usuario> user = repository.findById(id);
		mv.addObject("usuario", user.get());
		return mv;
	}
	
	public ModelAndView excluir(long id) {
		ModelAndView mv = new ModelAndView("lista");
		repository.deleteById(id);
		List<Usuario> list = repository.findAll();
		mv.addObject("usuario", list);
		return mv;
	}

}
