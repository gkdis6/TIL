package com.study.model;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.study.model.BbsMapper;
import com.study.model.ReplyMapper;
 
@Service("com.study.model.BbsServiceImpl")
public class BbsServiceImpl implements BbsService {
  @Autowired
  private BbsMapper mapper;
 
  @Autowired
  private ReplyMapper rmapper;
 
  public void delete(int bbsno) throws Exception {
 
    rmapper.bdelete(bbsno);
    mapper.delete(bbsno);
  }
}