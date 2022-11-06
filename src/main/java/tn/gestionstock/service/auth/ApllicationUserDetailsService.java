package tn.gestionstock.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.gestionstock.Dto.UtilisateurDto;
import tn.gestionstock.Dto.auth.ExtendedUser;
import tn.gestionstock.service.UtilisateurService;

@Service
public class ApllicationUserDetailsService implements UserDetailsService{
	@Autowired
	private UtilisateurService utilSer;
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		UtilisateurDto util=utilSer.findByEmail(mail);
		List<SimpleGrantedAuthority> authorities= new ArrayList();
		util.getRoles().forEach(role->authorities
				.add(new SimpleGrantedAuthority(role.getRoleName())));
		return new ExtendedUser(util.getEmail(),util.getPassword(),authorities,util.getEntreprise().getId());
	}
	

}
