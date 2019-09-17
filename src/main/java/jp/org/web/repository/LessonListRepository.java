package jp.org.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Component;

import jp.org.web.form.LessonListForm;

@Component
public interface LessonListRepository {
	@Select("select * from samurai_lessonlist")
	List<LessonListForm> getLessonListMap();
	
	@Select("select * from samurai_lessonlist where userId=#{id}")
	LessonListForm getLessonListOne(@Param("id") String userId);

	@Update("update samurai_lessonlist set userFirstName = #{userFirstName}"
										+ ", userLastName = #{userLastName}"
										+ ", lesson1st = #{lesson1st}"
										+ ", lesson2nd = #{lesson2nd}"
										+ " where userId = #{userId}")
	void update(@Param("userFirstName") String userFirstName
					,@Param("userLastName") String userLastName
					,@Param("lesson1st") String lesson1st
					,@Param("lesson2nd") String lesson2nd
					,@Param("userId") String userId);
	
}
