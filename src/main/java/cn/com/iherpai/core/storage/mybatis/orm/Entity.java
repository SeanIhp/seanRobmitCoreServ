package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;

import cn.com.iherpai.common.underware.DataValidator;

public class Entity implements Serializable {
	private static final long serialVersionUID = 3976397733925312959L;
	
	public String validId(String _id, boolean _allowNull){
		String res = null;
		if( !DataValidator.isNullString(_id) ){	//不为空	
			if( DataValidator.ckLength(_id, 32, 32) ){	//32个字符长度
				if( !DataValidator.IsIdStr(_id) ){	//由字母、数字、下划线组成
					res = "异常的【ID】";
				}
			}else{
				res = "异常的【ID】";
			}
		}else{
			if(!_allowNull){
				res = "【ID】不允许为空";				 
			}
		}
		return res;
	}
	
	
	public String validSerial_id(String _serial_id, boolean _allowNull){
		String res = null;
		if( !DataValidator.isNullString(_serial_id) ){	//不为空	
			if( DataValidator.ckLength(_serial_id, 32, 32) ){	//32个字符长度
				if( !DataValidator.IsIdStr(_serial_id) ){	//由字母、数字、下划线组成
					res = "异常的【序列号】";
				}
			}else{
				res = "异常的【序列号】";
			}
		}else{
			if(!_allowNull){
				res = "【序列号】不允许为空";				 
			}
		}
		return res;
	}
	
	
	public String validCode(String _code, boolean _allowNull){
		String res = null;
		if( !DataValidator.isNullString(_code) ){	//不为空	
			if( DataValidator.ckLength(_code, 1, 64) ){	//1~64个字符长度
				if( !DataValidator.IsIdStr(_code) ){	//由字母、数字、下划线组成序列号
					res = "异常的【编号】";
				}
			}else{
				res = "异常的【编号】";
			}
		}else{
			if(!_allowNull){
				res = "【编号】不允许为空";				 
			}
		}
		return res;
	}
	
	
	public String validCreate_time(String _create_time, boolean _allowNull){
		String res = null;
		if( !DataValidator.isNullString(_create_time) ){
			if( !DataValidator.isDatetime(_create_time)){
				res = "异常的【创建时间】";
			}
		}else{
			if(!_allowNull){
				res = "【创建时间】不允许为空";				 
			}
		}
		return res;
	}
	
	
	public String validStatus(String _status, boolean _allowNull){
		String res = null;
		if( !DataValidator.isNullString(_status) ){
			if( DataValidator.IsIntNumber(_status) ){
				if( !DataValidator.ckIntRange(_status, -99999, 99999)){
					res = "异常的【状态】";
				}
			}else{
				res = "异常的【状态】";
			}
		}else{
			if(!_allowNull){
				res = "【状态】不允许为空";
			}
		}
		return res;
	}
	
	
	public String validOrder_no(String _order_no, boolean _allowNull){
		String res = null;
		if( !DataValidator.isNullString(_order_no) ){
			if( DataValidator.IsIntNumber(_order_no) ){
				if( !DataValidator.ckIntRange(_order_no, 0, 99999)){
					res = "异常的【排序号】";
				}
			}else{
				res = "异常的【排序号】";
			}
		}else{
			if(!_allowNull){
				res = "【排序号】不允许为空";
			}
		}
		return res;
	}
	
	
	public String validMapping_data(String _mapping_data, boolean _allowNull){
		String res = null;
		if( !DataValidator.isNullString(_mapping_data) ){
			if( !DataValidator.ckLength(_mapping_data, 0, 50000) ){	//0~20000个字符长度
				res = "【MD】长度不正确，不可超出50000个字符";
			}
		}else{
			if(!_allowNull){
				res = "【MD】不允许为空";				 
			}
		}
		return res;
	}
	
	
}
