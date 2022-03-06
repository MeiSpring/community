package com.newcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaHibernatel")
public class AlphaDaoHibernatelmpl implements AlphaDao{

    @Override
    public String select() {
        return "Hibernatel";
    }
}
