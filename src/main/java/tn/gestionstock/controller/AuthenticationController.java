package tn.gestionstock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.gestionstock.Dto.auth.AuthenticationRequest;
import tn.gestionstock.Dto.auth.AuthenticationResponse;
import tn.gestionstock.Dto.auth.ExtendedUser;
import tn.gestionstock.service.auth.ApllicationUserDetailsService;
import tn.gestionstock.utils.JwtUtils;

import static tn.gestionstock.utils.Constant.AUTHENTICATION_END_POINT;
@RestController
@RequestMapping(AUTHENTICATION_END_POINT)
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private ApllicationUserDetailsService userDetailService;
	@Autowired
	private JwtUtils jwtUtils;
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
				(request.getLogin(), request.getPassword()));
		  final UserDetails userDetails=userDetailService.loadUserByUsername(request.getLogin()); 
		  final String jwt=jwtUtils.generateToken((ExtendedUser)userDetails);
		return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
	}
}
