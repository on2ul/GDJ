package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Gesipan;

public class GesipanDao {

	// field - SqlSessionFactory
	private SqlSessionFactory factory;
	
	// singleton pattern
	private static GesipanDao dao = new  GesipanDao();
	private GesipanDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static GesipanDao getInstance() {
		return dao;
	}
	
	

	public List<Gesipan> selectAllGesipans(){
		SqlSession ss = factory.openSession();  
		List<Gesipan> gesipans = ss.selectList("mybatis.mapper.gesipan.selectAllGesipans"); 
		ss.close();  
		return gesipans;
	}
	

	public Gesipan selectGesipanByNo(int gesipanNo) {
		SqlSession ss = factory.openSession();
		Gesipan gesipan = ss.selectOne("mybatis.mapper.board.selectBoardByNo", gesipanNo);  
		ss.close();
		return gesipan;
	}
	

	public int insertGesipan(Gesipan gesipan) {
		SqlSession ss = factory.openSession(false);  
		int result = ss.insert("mybatis.mapper.gesipan.insertGesipan", gesipan);  
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	public int deleteGesipan(int gesipanNo) {
		SqlSession ss = factory.openSession(false); 
		int result = ss.delete("mybatis.mapper.board.deleteBoard", gesipanNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	public int updateGesipan(Gesipan gesipan) {
		SqlSession ss = factory.openSession(false);  
		int result = ss.update("mybatis.mapper.gesipan.updateGesipan", gesipan);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
}