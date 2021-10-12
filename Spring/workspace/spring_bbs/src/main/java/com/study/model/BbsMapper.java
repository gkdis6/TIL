package com.study.model;

import java.util.*;

public interface BbsMapper {

	int create(BbsDTO dto);

	List<BbsDTO> list(Map map);

	int total(Map map);

	void upViewcnt(int bbsno);

	BbsDTO read(int bbsno);

}
