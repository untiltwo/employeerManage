package com.until.team.service;

import java.time.temporal.Temporal;

/**
 * @ClassName TeamException
 * @Description TODO
 * @Author rick2
 * @Date 2020/10/2 15:40
 * @Version 1.0
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -338754229948L;
    public TeamException(){
        super();
    }
    public TeamException(String msg){
        super(msg);
    }
}
