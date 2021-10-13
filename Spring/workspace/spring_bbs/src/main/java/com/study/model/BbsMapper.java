package com.study.model;

import java.util.*;

public interface BbsMapper {

	int create(BbsDTO dto);

	List<BbsDTO> list(Map map);

	int total(Map map);

	void upViewcnt(int bbsno);

	BbsDTO read(int bbsno);

	int passCheck(Map map);

	int update(BbsDTO dto);

	Object readReply(int bbsno);

	void upAnsnum(Map map);

	int createReply(BbsDTO dto);

	int delete(int bbsno);

	int checkRefnum(int bbsno);

}
