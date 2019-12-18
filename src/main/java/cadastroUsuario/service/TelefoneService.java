package cadastroUsuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.entity.Telefone;
import cadastroUsuario.repository.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository repository;
	
				
		public Telefone addTel(Telefone tel) {
			return repository.save(tel);
		}
		
		public ModelAndView findAll(){
			ModelAndView mv = new ModelAndView("listaTelefone");
			List<Telefone> list = repository.findAll();
			mv.addObject("telefone", list);
			return mv;
		}
		
		public List<Telefone> listTelefone(){
			return repository.findAll();
		}
				

}
