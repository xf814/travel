package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.Plan;



public interface PlanDao {
   public int insert(Plan p)throws SQLException;
   public int deleteByPlanId(int id) throws SQLException;
   
  // public int update(Plan p,int id)throws SQLException;
   public ArrayList<Plan> queryByName(String name) throws SQLException;
   public ArrayList<Plan> queryPlanIdByName(String name) throws SQLException;
public Plan queryById(int plan_id) throws SQLException;

}
