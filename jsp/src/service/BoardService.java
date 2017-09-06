package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BoardService {

	List<Map<String, String>> selectBoardList();
	
	Map<String, String> selectBoard(Map<String, String> hm);
	
	int insertBoard(Map<String, String> hm);
	
	int deleteBoard(Map<String, String> hm);
	
	int modifyBoard(Map<String, String> hm);
	
}
