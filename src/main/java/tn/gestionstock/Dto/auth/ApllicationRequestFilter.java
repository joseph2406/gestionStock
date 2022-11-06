package tn.gestionstock.Dto.auth;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import tn.gestionstock.service.auth.ApllicationUserDetailsService;
import tn.gestionstock.utils.JwtUtils;
@Component
public class ApllicationRequestFilter extends OncePerRequestFilter{
	@Autowired
	private JwtUtils jwtUtil;
	@Autowired
	private ApllicationUserDetailsService userSer;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authHeader=request.getHeader("Authorization");
		String username=null;
		String jwt=null;
		String idEntreprise=null;
		if((StringUtils.hasLength(authHeader)) && (authHeader.startsWith("Bearer "))){
			jwt = authHeader.substring(7);
			username=jwtUtil.extractUserName(jwt);
		}
		if(StringUtils.hasLength(username) && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails =userSer.loadUserByUsername(username);
			if(jwtUtil.valdateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
						new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		MDC.put("idEntreprise", idEntreprise);
		filterChain.doFilter(request,response);
	}
}
