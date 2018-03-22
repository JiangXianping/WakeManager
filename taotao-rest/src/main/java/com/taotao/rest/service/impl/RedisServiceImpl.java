package com.taotao.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.rest.service.RedisService;
import com.toatao.rest.dao.JedisClient;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	@Override
	public TaotaoResult syncContent(long contentCid) {
		try{
			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid+"");
		}catch(Exception exception){
			exception.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(exception));
		}
		return TaotaoResult.ok();
	}

}
