package jp.org.web.sql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface LoginMapper {

	@Select("select loginId, password from samurai_login")
	List<Map<String, String>> getUserMap();
}
