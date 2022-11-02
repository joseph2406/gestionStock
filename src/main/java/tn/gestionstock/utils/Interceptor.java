package tn.gestionstock.utils;

import org.hibernate.EmptyInterceptor;
import org.springframework.util.StringUtils;

public class Interceptor extends EmptyInterceptor{

	@Override
	public String onPrepareStatement(String sql) {
		if(StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
			if(sql.contains("where")) {
				sql=sql+" and idEntreprise=2";
			}
			else {
				sql=sql+" where idEntreprise=2";
			}
		}
		return super.onPrepareStatement(sql);
		
	}
}
