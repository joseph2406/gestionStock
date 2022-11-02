package tn.gestionstock.service.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.gestionstock.Dao.UtilisateurRepository;
import tn.gestionstock.entities.Utilisateur;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ErrorCodes;

@Service
public class ApllicationUserDetailsService implements UserDetailsService{
	@Autowired
	private UtilisateurRepository utilRepo;
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
	Utilisateur util=utilRepo.findByEmail(mail).orElseThrow(()->
	new EntityNotFoundException("utilisateur non trouvé",ErrorCodes.UTILISATEUR_NOT_FOUND));
		return new User(util.getEmail(),util.getPassword(),Collections.emptyList());
	}
	

}
