package com.assignment.clothes;

import java.util.ArrayList;
import java.util.Random;


public class Clothes {
	public String Tpath, SWpath, SHpath, T_Spath,Jpath;
	public ArrayList<String> TpathA, SWpathA, SHpathA, T_SpathA,JpathA;
	public float tprice, swprice, shprice, t_sprice, jprice;
	public ArrayList<Float> TpriceA, SWpriceA, SHpriceA, T_SpriceA,JpriceA;
	public ArrayList<String> tname, swname, shname, tsname, jname;
	
	
	  
	int t = 1;
	int sw = 1;
	int sh = 1;
	int t_s = 1;
	int j = 1;
	
	database details = new database();
	
	public Clothes() throws Exception{
		
		TpathA = new ArrayList<String>();
		TpathA.addAll(details.Trousers);
		JpathA = new ArrayList<String>();
		JpathA.addAll(details.jackets);
		SHpathA = new ArrayList<String>();
		SHpathA.addAll(details.Shoes);
		T_SpathA = new ArrayList<String>();
		T_SpathA.addAll(details.t_shirt);
		SWpathA = new ArrayList<String>();
		SWpathA.addAll(details.Sweaters);
		
		
		Tpath = TpathA.get(t);
		SWpath = SWpathA.get(sw);
		SHpath = SHpathA.get(sh);
		T_Spath = T_SpathA.get(t_s);
		Jpath = JpathA.get(j);
		
		TpriceA = new ArrayList<Float>();
		TpriceA.addAll(details.Tprice);
		tprice =  TpriceA.get(t);
		SWpriceA = new ArrayList<Float>();
		SWpriceA.addAll(details.SWprice);
		swprice = SWpriceA.get(sw);
		SHpriceA = new ArrayList<Float>();
		SHpriceA.addAll(details.SHprice);
		shprice = SHpriceA.get(sh);
		T_SpriceA = new ArrayList<Float>();
		T_SpriceA.addAll(details.TSprice);
		t_sprice = T_SpriceA.get(t_s);
		JpriceA = new ArrayList<Float>();
		JpriceA.addAll(details.Jprice);
		jprice = JpriceA.get(j);
		
		tname = new ArrayList<String>(); 
		swname = new ArrayList<String>();
		shname = new ArrayList<String>();
		jname = new ArrayList<String>();
		tsname = new ArrayList<String>();
		
			for(int i = 0 ; i< details.Tname.size(); i++){
				tname.add(details.Tname.get(i));
			}
			
			for(int i = 0 ; i< details.TSname.size(); i++){
				tsname.add(details.TSname.get(i));
			}
			
			for(int i = 0 ; i< details.SWname.size(); i++){
				swname.add(details.SWname.get(i));
			}
			
			for(int i = 0 ; i< details.SHname.size(); i++){
				shname.add(details.SHname.get(i));
			}
			
			for(int i = 0 ; i< details.Jname.size(); i++){
				jname.add(details.Jname.get(i));
			}
			
			
		}	
	}


