package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BoardService {

	List<Map<String, String>> selectBoardList();
	
	Map<String, String> selectBoard();
	
	int inserBoard();
	
	int deleteBoard();
	
	int updateBoard();
	
}
