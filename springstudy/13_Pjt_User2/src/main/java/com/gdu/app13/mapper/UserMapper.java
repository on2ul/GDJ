package com.gdu.app13.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app13.domain.RetireUserDTO;
import com.gdu.app13.domain.SleepUserDTO;
import com.gdu.app13.domain.UserDTO;

@Mapper
public interface UserMapper {

	public UserDTO selectUserByMap(Map<String, Object> map);
	public RetireUserDTO selectRetireUserById(String id);
	public int insertUser(UserDTO user);
	public int updateAccessLog(String id);
	public int insertAccessLog(String id);
	public int deleteUser(int userNo);
	public int insertRetireUser(RetireUserDTO retireUser);
	public int updateSessionInfo(UserDTO user);
	public int updateUserPassword(UserDTO user);
	public int insertSleepUser();
	public int deleteUserForSleep();
	public SleepUserDTO selectSleepUserById(String id);
	public int insertRestoreUser(String id);  
	public int deleteSleepUser(String id);
	
	
	
	
	
	
}