package tn.gestionstock.Dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
	private String login;
	private String password;
	private String accessToken;
}
