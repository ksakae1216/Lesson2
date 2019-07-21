package jp.org.web.sql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface LoginMapper {

	@Select("select loginId from samurai_login where loginId=#{id} and password=#{pass}")
	String getUserMap(@Param("id") String loginId, @Param("pass") String password);
}
