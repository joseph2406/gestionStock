package tn.gestionstock.handlers;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.gestionstock.exception.ErrorCodes;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {
	private Integer httpCode;
	private ErrorCodes code;
	private String message;
	private List<String> errors=new ArrayList<String>();
}
