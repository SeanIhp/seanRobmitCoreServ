package cn.com.iherpai.common.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Sql {
    private StringBuilder where = new StringBuilder("");
    private StringBuilder whereAddition = new StringBuilder("");
    private String groupBy;
    private String having;
    private String orderBy;
 
    public StringBuilder getWhere() {
        return where;
    }
 
    public void setWhere(StringBuilder where) {
        this.where = where;
    }
 
    public StringBuilder getWhereAddition() {
		return whereAddition;
	}

	public void setWhereAddition(StringBuilder whereAddition) {
		this.whereAddition = whereAddition;
	}

	public String getGroupBy() {
        return groupBy;
    }
 
    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }
 
    public String getHaving() {
        return having;
    }
 
    public void setHaving(String having) {
        this.having = having;
    }
 
    public String getOrderBy() {
        return orderBy;
    }
 
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
 
    public Sql addOrderBy(String sortField, String order) {
        if (!isEmpty(sortField) && !isEmpty(order)) {
        	if( !isEmpty(this.orderBy) ){
        		this.orderBy += ", " + EntityUtil.toUnderScoreName(sortField) + " " + order;
        	} else {
                this.orderBy = EntityUtil.toUnderScoreName(sortField) + " " + order;
        	}
        }
        return this;
    }
 
    public Sql orLike(int msk, String columns, String value) {
        if (!isEmpty(value)) {
            StringBuffer strBuf = new StringBuffer("");
            for (String column : columns.split(",")) {
                strBuf.append(EntityUtil.toUnderScoreName(column) + " LIKE '%"
                        + value + "%' OR ");
            }
            String orLikeStr = strBuf.substring(0, strBuf.lastIndexOf("OR"));
            if ( msk < 0 ) {
            	where.append(" OR (" + orLikeStr + ")");
            } else {
                where.append(" AND (" + orLikeStr + ")");
            }
        }
        return this;
    }
 
    public Sql orMike(int msk, String columns, String value) {
        if (!isEmpty(value)) {
            StringBuffer strBuf = new StringBuffer("");
            for (String column : columns.split(",")) {
                strBuf.append(EntityUtil.toUnderScoreName(column) + " LIKE '"
                        + value + "%' OR ");
            }
            String orLikeStr = strBuf.substring(0, strBuf.lastIndexOf("OR"));
            if ( msk < 0 ) {
            	where.append(" OR (" + orLikeStr + ")");
            } else {
                where.append(" AND (" + orLikeStr + ")");
            }
        }
        return this;
    }
 
    public Sql orNike(int msk, String columns, String value) {
        if (!isEmpty(value)) {
            StringBuffer strBuf = new StringBuffer("");
            for (String column : columns.split(",")) {
                strBuf.append(EntityUtil.toUnderScoreName(column) + " LIKE '%"
                        + value + "' OR ");
            }
            String orLikeStr = strBuf.substring(0, strBuf.lastIndexOf("OR"));
            if ( msk < 0 ) {
            	where.append(" OR (" + orLikeStr + ")");
            } else {
                where.append(" AND (" + orLikeStr + ")");
            }
        }
        return this;
    }
 
    public Sql eq(int msk, String column, String value) {
        if (!isEmpty(value)) {
        	if(value.equals("##NULL##")){
                if ( msk < 0 ) {
                    where.append(" OR " + EntityUtil.toUnderScoreName(column) + " IS NULL");
                } else {
                    where.append(" AND " + EntityUtil.toUnderScoreName(column) + " IS NULL");
                }
        	}else{
                if ( msk < 0 ) {
                    where.append(" OR " + EntityUtil.toUnderScoreName(column) + " = '" + sqlParam(value) + "'");
                } else {
                    where.append(" AND " + EntityUtil.toUnderScoreName(column) + " = '" + sqlParam(value) + "'");
                }
        	}
        }
        return this;
    }

    public Sql eq(int msk, String column, Integer value) {
        if ( value !=null ) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " = " + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " = " + value );
            }
        }
        return this;
    }

    public Sql eq(int msk, String column, Float value) {
        if ( value !=null ) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " = " + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " = " + value );
            }
        }
        return this;
    }

    public Sql eq(int msk, String column, Boolean value) {
        if ( value !=null ) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " = " + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " = " + value );
            }
        }
        return this;
    }
 
    public Sql ne(int msk, String column, String value) {
        if (!isEmpty(value)) {
        	if(value.equals("##NULL##")){
                if ( msk < 0 ) {
                    where.append(" OR " + EntityUtil.toUnderScoreName(column) + " IS NOT NULL");
                } else {
                    where.append(" AND " + EntityUtil.toUnderScoreName(column) + " IS NOT NULL");
                }
        	}else{
	            if ( msk < 0 ) {
	                where.append(" OR " + EntityUtil.toUnderScoreName(column)
	                + " != '" + sqlParam(value) + "'");
	            } else {
	                where.append(" AND " + EntityUtil.toUnderScoreName(column)
	                + " != '" + sqlParam(value) + "'");
	            }
        	}
        }
        return this;
    }
    
    public Sql ne(int msk, String column, Integer value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            }
        }
        return this;
    }
    
    public Sql ne(int msk, String column, Float value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            }
        }
        return this;
    }
    
    public Sql ne(int msk, String column, Boolean value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            }
        }
        return this;
    }
 
    public Sql like(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " LIKE '%" + sqlParam(value) + "%'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " LIKE '%" + sqlParam(value) + "%'");
            }
        }
        return this;
    }
 
    public Sql notLike(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '%" + sqlParam(value) + "%'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '%" + sqlParam(value) + "%'");
            }
        }
        return this;
    }
 
    public Sql mike(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " LIKE '" + sqlParam(value) + "%'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " LIKE '" + sqlParam(value) + "%'");
            }
        }
        return this;
    }
 
    public Sql notMike(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '" + sqlParam(value) + "%'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '" + sqlParam(value) + "%'");
            }
        }
        return this;
    }
 
    public Sql nike(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " LIKE '%" + sqlParam(value) + "'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " LIKE '%" + sqlParam(value) + "'");
            }
        }
        return this;
    }
 
    public Sql notNike(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '%" + sqlParam(value) + "'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '%" + sqlParam(value) + "'");
            }
        }
        return this;
    }
 
    public Sql in(int msk, String column, String... values) {
        if (!isEmpty(values)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesString(values) + ")");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesString(values) + ")");
            }
        }
        return this;
    }
 
    public Sql in(int msk, String column, Integer... values) {
        if (values!=null && values.length>0) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesInteger(values) + ")");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesInteger(values) + ")");
            }
        }
        return this;
    }
 
    public Sql in(int msk, String column, Float... values) {
        if (values!=null && values.length>0) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesFloat(values) + ")");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesFloat(values) + ")");
            }
        }
        return this;
    }
 
    public Sql notIn(int msk, String column, String... values) {
        if (!isEmpty(values)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesString(values) + ")");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesString(values) + ")");
            }
        }
        return this;
    }
 
    public Sql notIn(int msk, String column, Integer... values) {
        if (values!=null && values.length>0) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesInteger(values) + ")");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesInteger(values) + ")");
            }
        }
        return this;
    }
 
    public Sql notIn(int msk, String column, Float... values) {
        if (values!=null && values.length>0) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesFloat(values) + ")");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesFloat(values) + ")");
            }
        }
        return this;
    }
 
    public Sql gt(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " > '"
                        + sqlParam(value) + "'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " > '"
                        + sqlParam(value) + "'");
            }
        }
        return this;
    }
    
    public Sql gt(int msk, String column, Integer value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
    
    public Sql gt(int msk, String column, Float value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
 
    public Sql gte(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " >= '" + sqlParam(value) + "'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " >= '" + sqlParam(value) + "'");
            }
        }
        return this;
    }

    public Sql gte(int msk, String column, Integer value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }

    public Sql gte(int msk, String column, Float value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
 
    public Sql lt(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " < '"
                        + sqlParam(value) + "'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " < '"
                        + sqlParam(value) + "'");
            }
        }
        return this;
    }
 
    public Sql lt(int msk, String column, Integer value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
 
    public Sql lt(int msk, String column, Float value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
 
    public Sql lte(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " <= '" + sqlParam(value) + "'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " <= '" + sqlParam(value) + "'");
            }
        }
        return this;
    }
 
    public Sql lte(int msk, String column, Integer value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
 
    public Sql lte(int msk, String column, Float value) {
        if (value!=null) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }

    public Sql between(int msk, String column, String from, String to) {
        if (isEmpty(from) && isEmpty(to)) {
            return this;
        }
        if ( msk < 0 ) {
            if (isEmpty(to)) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " >= '" + sqlParam(from) + "'");
            } else if (isEmpty(from)) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " <= '" + sqlParam(to) + "'");
            } else {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN '" + sqlParam(from) + "' AND '" + sqlParam(to)
                        + "'");
            }
        } else {
            if (isEmpty(to)) {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " >= '" + sqlParam(from) + "'");
            } else if (isEmpty(from)) {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " <= '" + sqlParam(to) + "'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN '" + sqlParam(from) + "' AND '" + sqlParam(to)
                        + "'");
            }
        }
        return this;
    }
 
    public Sql between(int msk, String column, Integer from, Integer to) {
        if (from==null && to==null) {
            return this;
        }
        if ( msk < 0 ) {
            if (to==null) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " >= " + from );
            } else if (from==null) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " <= " + to );
            } else {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN " + from + " AND " + to );
            }
        } else {
            if (to==null) {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " >= " + from );
            } else if (from==null) {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " <= " + to );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN " + from + " AND " + to );
            }
        }
        return this;
    }

    public Sql between(int msk, String column, Float from, Float to) {
        if (from==null && to==null) {
            return this;
        }
        if ( msk < 0 ) {
            if (to==null) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " >= " + from );
            } else if (from==null) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " <= " + to );
            } else {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN " + from + " AND " + to );
            }
        } else {
            if (to==null) {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " >= " + from );
            } else if (from==null) {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " <= " + to );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN " + from + " AND " + to );
            }
        }
        return this;
    }
    
    // ------------
 
    public Sql addOrderBy(String addi, String sortField, String order) {
        if (!isEmpty(sortField) && !isEmpty(order)) {
        	if( !isEmpty(this.orderBy) ){
        		this.orderBy += ", " + EntityUtil.toUnderScoreName(sortField) + " " + order;
        	} else {
                this.orderBy = EntityUtil.toUnderScoreName(sortField) + " " + order;
        	}
        }
        return this;
    }
 
    public Sql orLike(String addi, int msk, String columns, String value) {
        if (!isEmpty(value)) {
            StringBuffer strBuf = new StringBuffer("");
            for (String column : columns.split(",")) {
                strBuf.append(EntityUtil.toUnderScoreName(column) + " LIKE '%"
                        + value + "%' OR ");
            }
            String orLikeStr = strBuf.substring(0, strBuf.lastIndexOf("OR"));
            if ( msk < 0 ) {
            	whereAddition.append(" OR (" + orLikeStr + ")");
            } else {
                whereAddition.append(" AND (" + orLikeStr + ")");
            }
        }
        return this;
    }
 
    public Sql orMike(String addi, int msk, String columns, String value) {
        if (!isEmpty(value)) {
            StringBuffer strBuf = new StringBuffer("");
            for (String column : columns.split(",")) {
                strBuf.append(EntityUtil.toUnderScoreName(column) + " LIKE '"
                        + value + "%' OR ");
            }
            String orLikeStr = strBuf.substring(0, strBuf.lastIndexOf("OR"));
            if ( msk < 0 ) {
            	whereAddition.append(" OR (" + orLikeStr + ")");
            } else {
                whereAddition.append(" AND (" + orLikeStr + ")");
            }
        }
        return this;
    }
 
    public Sql orNike(String addi, int msk, String columns, String value) {
        if (!isEmpty(value)) {
            StringBuffer strBuf = new StringBuffer("");
            for (String column : columns.split(",")) {
                strBuf.append(EntityUtil.toUnderScoreName(column) + " LIKE '%"
                        + value + "' OR ");
            }
            String orLikeStr = strBuf.substring(0, strBuf.lastIndexOf("OR"));
            if ( msk < 0 ) {
            	whereAddition.append(" OR (" + orLikeStr + ")");
            } else {
                whereAddition.append(" AND (" + orLikeStr + ")");
            }
        }
        return this;
    }
 
    public Sql eq(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " = '" + sqlParam(value) + "'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " = '" + sqlParam(value) + "'");
            }
        }
        return this;
    }

    public Sql eq(String addi, int msk, String column, Integer value) {
        if ( value !=null ) {
        	if(value.equals("##NULL##")){
                if ( msk < 0 ) {
                	whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " IS NULL");
                } else {
                	whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " IS NULL");
                }
        	}else{
	            if ( msk < 0 ) {
	                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " = " + value );
	            } else {
	                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " = " + value );
	            }
        	}
        }
        return this;
    }

    public Sql eq(String addi, int msk, String column, Float value) {
        if ( value !=null ) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " = " + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " = " + value );
            }
        }
        return this;
    }

    public Sql eq(String addi, int msk, String column, Boolean value) {
        if ( value !=null ) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " = " + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " = " + value );
            }
        }
        return this;
    }
 
    public Sql ne(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
        	if(value.equals("##NULL##")){
                if ( msk < 0 ) {
                	whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " IS NOT NULL");
                } else {
                	whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " IS NOT NULL");
                }
        	}else{
	            if ( msk < 0 ) {
	                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
	                + " != '" + sqlParam(value) + "'");
	            } else {
	                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
	                + " != '" + sqlParam(value) + "'");
	            }
        	}
        }
        return this;
    }
    
    public Sql ne(String addi, int msk, String column, Integer value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            }
        }
        return this;
    }
    
    public Sql ne(String addi, int msk, String column, Float value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            }
        }
        return this;
    }
    
    public Sql ne(String addi, int msk, String column, Boolean value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " != " + value );
            }
        }
        return this;
    }
 
    public Sql like(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " LIKE '%" + sqlParam(value) + "%'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " LIKE '%" + sqlParam(value) + "%'");
            }
        }
        return this;
    }
 
    public Sql notLike(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '%" + sqlParam(value) + "%'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '%" + sqlParam(value) + "%'");
            }
        }
        return this;
    }
 
    public Sql mike(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " LIKE '" + sqlParam(value) + "%'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " LIKE '" + sqlParam(value) + "%'");
            }
        }
        return this;
    }
 
    public Sql notMike(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '" + sqlParam(value) + "%'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '" + sqlParam(value) + "%'");
            }
        }
        return this;
    }
 
    public Sql nike(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " LIKE '%" + sqlParam(value) + "'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " LIKE '%" + sqlParam(value) + "'");
            }
        }
        return this;
    }
 
    public Sql notNike(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '%" + sqlParam(value) + "'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT LIKE '%" + sqlParam(value) + "'");
            }
        }
        return this;
    }
 
    public Sql in(String addi, int msk, String column, String... values) {
        if (!isEmpty(values)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesString(values) + ")");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesString(values) + ")");
            }
        }
        return this;
    }
 
    public Sql in(String addi, int msk, String column, Integer... values) {
        if (values!=null && values.length>0) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesInteger(values) + ")");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesInteger(values) + ")");
            }
        }
        return this;
    }
 
    public Sql in(String addi, int msk, String column, Float... values) {
        if (values!=null && values.length>0) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesFloat(values) + ")");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " IN (" + inValuesFloat(values) + ")");
            }
        }
        return this;
    }
 
    public Sql notIn(String addi, int msk, String column, String... values) {
        if (!isEmpty(values)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesString(values) + ")");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesString(values) + ")");
            }
        }
        return this;
    }
 
    public Sql notIn(String addi, int msk, String column, Integer... values) {
        if (values!=null && values.length>0) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesInteger(values) + ")");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesInteger(values) + ")");
            }
        }
        return this;
    }
 
    public Sql notIn(String addi, int msk, String column, Float... values) {
        if (values!=null && values.length>0) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesFloat(values) + ")");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " NOT IN (" + inValuesFloat(values) + ")");
            }
        }
        return this;
    }
 
    public Sql gt(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " > '"
                        + sqlParam(value) + "'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " > '"
                        + sqlParam(value) + "'");
            }
        }
        return this;
    }
    
    public Sql gt(String addi, int msk, String column, Integer value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
    
    public Sql gt(String addi, int msk, String column, Float value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
 
    public Sql gte(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " >= '" + sqlParam(value) + "'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " >= '" + sqlParam(value) + "'");
            }
        }
        return this;
    }

    public Sql gte(String addi, int msk, String column, Integer value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }

    public Sql gte(String addi, int msk, String column, Float value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
 
    public Sql lt(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " < '"
                        + sqlParam(value) + "'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " < '"
                        + sqlParam(value) + "'");
            }
        }
        return this;
    }
 
    public Sql lt(String addi, int msk, String column, Integer value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
 
    public Sql lt(String addi, int msk, String column, Float value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
 
    public Sql lte(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " <= '" + sqlParam(value) + "'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " <= '" + sqlParam(value) + "'");
            }
        }
        return this;
    }
 
    public Sql lte(String addi, int msk, String column, Integer value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }
 
    public Sql lte(String addi, int msk, String column, Float value) {
        if (value!=null) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " > "
                        + value );
            }
        }
        return this;
    }

    public Sql between(String addi, int msk, String column, String from, String to) {
        if (isEmpty(from) && isEmpty(to)) {
            return this;
        }
        if ( msk < 0 ) {
            if (isEmpty(to)) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " >= '" + sqlParam(from) + "'");
            } else if (isEmpty(from)) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " <= '" + sqlParam(to) + "'");
            } else {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN '" + sqlParam(from) + "' AND '" + sqlParam(to)
                        + "'");
            }
        } else {
            if (isEmpty(to)) {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " >= '" + sqlParam(from) + "'");
            } else if (isEmpty(from)) {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " <= '" + sqlParam(to) + "'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN '" + sqlParam(from) + "' AND '" + sqlParam(to)
                        + "'");
            }
        }
        return this;
    }
 
    public Sql between(String addi, int msk, String column, Integer from, Integer to) {
        if (from==null && to==null) {
            return this;
        }
        if ( msk < 0 ) {
            if (to==null) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " >= " + from );
            } else if (from==null) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " <= " + to );
            } else {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN " + from + " AND " + to );
            }
        } else {
            if (to==null) {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " >= " + from );
            } else if (from==null) {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " <= " + to );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN " + from + " AND " + to );
            }
        }
        return this;
    }

    public Sql between(String addi, int msk, String column, Float from, Float to) {
        if (from==null && to==null) {
            return this;
        }
        if ( msk < 0 ) {
            if (to==null) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " >= " + from );
            } else if (from==null) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " <= " + to );
            } else {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN " + from + " AND " + to );
            }
        } else {
            if (to==null) {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " >= " + from );
            } else if (from==null) {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " <= " + to );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                        + " BETWEEN " + from + " AND " + to );
            }
        }
        return this;
    }
    
    
    //----------------------------------
 
    public String sql() {
        StringBuilder sql = new StringBuilder("");
        final int a = 4;
        final int b = 5;
        if (where.toString().length() > a) {
        	if ( whereAddition.toString().length()>a ) {
                sql.append(" @@@" + where.substring(b) + "### AND @@@"+ whereAddition.substring(b) +"###");
        	}else{
                sql.append(" @@@" + where.substring(b) + "### ");
        	}
        }
        if (!isEmpty(groupBy)) {
            sql.append(" GROUP BY " + groupBy + " ");
        }
        if (!isEmpty(having)) {
            sql.append(" HAVING " + having + " ");
        }
        if (!isEmpty(orderBy)) {
            sql.append(" ORDER BY " + orderBy + " ");
        }
        String res = sql.toString().replaceAll("@@@", "(").replaceAll("###", ")");
        System.out.println("--- [####] SQL CONDITON ---> " + res);
        return res;
    }

    
    public HashMap<String, String> sqlMap() {
    	HashMap<String, String> res = new HashMap<String, String>();
        StringBuilder sql = new StringBuilder("");
        final int a = 4;
        final int b = 5;
        if (where.toString().length() > a) {
        	if ( whereAddition.toString().length()>a ) {
                sql.append(" @@@" + where.substring(b) + "### AND @@@"+ whereAddition.substring(b) +"###");
        	}else{
                sql.append(" @@@" + where.substring(b) + "### ");
        	}
            String sqlStr = sql.toString().replaceAll("@@@", "(").replaceAll("###", ")");
            res.put("conditions", sqlStr);
        }
        if (!isEmpty(groupBy)) {
//            sql.append(" GROUP BY " + groupBy + " ");
            res.put("groupBy", " GROUP BY " + groupBy + " ");
        }
        if (!isEmpty(having)) {
//            sql.append(" HAVING " + having + " ");
            res.put("having", " HAVING " + having + " ");
        }
        if (!isEmpty(orderBy)) {
//            sql.append(" ORDER BY " + orderBy + " ");
            res.put("orderBy", " ORDER BY " + orderBy + " ");
        }
//        String res = sql.toString().replaceAll("@@@", "(").replaceAll("###", ")");
        System.out.println("--- [####] SQL MAP ---> " + res);
        return res;
    }
 
    public String toString() {
        return sql();
    }
 
    private static boolean isEmpty(String value) {
        return value == null || "".equals(value) || value.trim().length() == 0;
    }
 
    private static boolean isEmpty(String[] values) {
        if (values == null || values.length == 0) {
            return true;
        }
        for (String value : values) {
            if (!isEmpty(value)) {
                return false;
            }
        }
        return true;
    }
 
    private static String inValuesString(String[] values) {
        StringBuilder string = new StringBuilder("");
        for (String value : values) {
            if (isEmpty(value)) {
                continue;
            }
            string.append('\'');
            string.append(value);
            string.append('\'');
            string.append(',');
        }
        if (string.length() > 0) {
            string.deleteCharAt(string.length() - 1);
        }
        return string.toString();
    }
 
    private static String inValuesInteger(Integer[] values) {
        StringBuilder string = new StringBuilder("");
        for (Integer value : values) {
            string.append(value.toString());
            string.append(',');
        }
        if (string.length() > 0) {
            string.deleteCharAt(string.length() - 1);
        }
        return string.toString();
    }
 
    private static String inValuesFloat(Float[] values) {
        StringBuilder string = new StringBuilder("");
        for (Float value : values) {
            string.append(value.toString());
            string.append(',');
        }
        if (string.length() > 0) {
            string.deleteCharAt(string.length() - 1);
        }
        return string.toString();
    }
 
    private static String sqlParam(String sqlParam) {
        return sqlParam.replaceAll("([';]+|(--)+)", "");
    }
    
    public static String generate(ArrayList<HashMap> conditions, ArrayList<HashMap> additions) {
    	Sql sp = new Sql();
		for(HashMap condi : conditions){
			generatorCondition(sp, condi);
		}
		if(additions!=null){
			for(HashMap addi : additions){
				generatorAddition(sp, addi);
			}
		}
    	return sp.sql();
    }
    
    public static HashMap<String, String> generateMap(ArrayList<HashMap> conditions, ArrayList<HashMap> additions) {
    	Sql sp = new Sql();
		for(HashMap condi : conditions){
			generatorCondition(sp, condi);
		}
		if(additions!=null){
			for(HashMap addi : additions){
				generatorAddition(sp, addi);
			}
		}
    	return sp.sqlMap();
    }
    
    public static HashMap<String, Object> newSqlBox() {
    	return new HashMap<String, Object>();
    }
    
    public static ArrayList<HashMap> newSqlExp() {
    	return new ArrayList<HashMap>(0);
    }

	private static void generatorCondition(Sql sp, HashMap condi) {
		String key = (String)condi.get("key");
		String op = (String)condi.get("op");
		int msk = ((Integer)condi.get("msk")).intValue();
		int mskAbs = Math.abs(msk);
		if ( op.equalsIgnoreCase("OL") ) {			//----------------OR LIKE
			sp.orLike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("S") || op.equalsIgnoreCase("C") || op.equalsIgnoreCase("X") || op.equalsIgnoreCase("E") ) {			//----------------EQ
			if ( mskAbs == 18 ) {		// integer
				sp.eq(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.eq(msk, key, (Float)condi.get("val"));
			} else if ( mskAbs == 35 ) {		// boolean
				sp.eq(msk, key, (Boolean)condi.get("val"));
			} else {	// string
				sp.eq(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("NS") || op.equalsIgnoreCase("NC") || op.equalsIgnoreCase("NX") || op.equalsIgnoreCase("NE") ) {			//----------------NE
			if ( mskAbs == 18 ) {		// integer
				sp.ne(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.ne(msk, key, (Float)condi.get("val"));
			} else if ( mskAbs == 35 ) {		// boolean
				sp.ne(msk, key, (Boolean)condi.get("val"));
			} else {	// string
				sp.ne(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("LK") ) {			//----------------LIKE
			sp.like(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NLK") ) {			//----------------NOT LIKE
			sp.notLike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("OLK") ) {			//----------------OR LIKE
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orLike(msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("MK") ) {			//----------------MIKE
			sp.mike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NMK") ) {			//----------------NOT MIKE
			sp.notMike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("OMK") ) {			//----------------OR MIKE
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orMike(msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("NK") ) {			//----------------NIKE
			sp.nike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NNK") ) {			//----------------NOT NIKE
			sp.notNike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("ONK") ) {			//----------------OR NIKE
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orNike(msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("I") ) {			//----------------IN
			String[] valstr = ((String)condi.get("val")).split(",");
			if ( mskAbs == 18 ) {		// integer
				Integer[] vals = new Integer[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Integer(valstr[i]);
				}
				sp.in(msk, key, vals);
			} else if ( mskAbs == 24 ) {		// float
				Float[] vals = new Float[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Float(valstr[i]);
				}
				sp.in(msk, key, vals);
			} else {	// string
				sp.in(msk, key, valstr);	
			}
		} else if ( op.equalsIgnoreCase("NI") ) {			//----------------NOT IN
			String[] valstr = ((String)condi.get("val")).split(",");
			if ( mskAbs == 18 ) {		// integer
				Integer[] vals = new Integer[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Integer(valstr[i]);
				}
				sp.notIn(msk, key, vals);
			} else if ( mskAbs == 24 ) {		// float
				Float[] vals = new Float[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Float(valstr[i]);
				}
				sp.notIn(msk, key, vals);
			} else {	// string
				sp.notIn(msk, key, valstr);	
			}
		} else if ( op.equalsIgnoreCase("G") ) {			//----------------GT
			if ( mskAbs == 18 ) {		// integer
				sp.gt(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.gt(msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.gt(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("GS") || op.equalsIgnoreCase("GC") || op.equalsIgnoreCase("GX") || op.equalsIgnoreCase("GE") ) {			//----------------GTE
			if ( mskAbs == 18 ) {		// integer
				sp.gte(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.gte(msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.gte(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("L") ) {			//----------------LT
			if ( mskAbs == 18 ) {		// integer
				sp.lt(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.lt(msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.lt(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("LS") || op.equalsIgnoreCase("LC") || op.equalsIgnoreCase("LX") || op.equalsIgnoreCase("LE") ) {			//----------------LTE
			if ( mskAbs == 18 ) {		// integer
				sp.lte(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.lte(msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.lte(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("B") || op.equalsIgnoreCase("BTN") ) {			//----------------BETWEEN
			String[] valstr = ((String)condi.get("val")).split(",");
			if ( mskAbs == 18 ) {		// integer
				Integer[] vals = new Integer[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Integer(valstr[i]);
				}
				sp.between(msk, key, vals[0], vals[1]);
			} else if ( mskAbs == 24 ) {		// float
				Float[] vals = new Float[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Float(valstr[i]);
				}
				sp.between(msk, key, vals[0], vals[1]);
			} else {	// string
				sp.between(msk, key, valstr[0], valstr[1]);
			}
		} else if ( op.equalsIgnoreCase("O") || op.equalsIgnoreCase("OD") ) {			//----------------ORDER BY
			if ( msk > 0 ) {
				sp.addOrderBy(key, "ASC");
			} else {
				sp.addOrderBy(key, "DESC");
			}
		}
	}

	private static void generatorAddition(Sql sp, HashMap condi) {
		String key = (String)condi.get("key");
		String op = (String)condi.get("op");
		int msk = ((Integer)condi.get("msk")).intValue();
		int mskAbs = Math.abs(msk);
		if ( op.equalsIgnoreCase("OL") ) {			//----------------OR LIKE
			sp.orLike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("S") || op.equalsIgnoreCase("C") || op.equalsIgnoreCase("X") || op.equalsIgnoreCase("E") ) {			//----------------EQ
			if ( mskAbs == 18 ) {		// integer
				sp.eq("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.eq("Addi", msk, key, (Float)condi.get("val"));
			} else if ( mskAbs == 35 ) {		// boolean
				sp.eq("Addi", msk, key, (Boolean)condi.get("val"));
			} else {	// string
				sp.eq("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("NS") || op.equalsIgnoreCase("NC") || op.equalsIgnoreCase("NX") || op.equalsIgnoreCase("NE") ) {			//----------------NE
			if ( mskAbs == 18 ) {		// integer
				sp.ne("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.ne("Addi", msk, key, (Float)condi.get("val"));
			} else if ( mskAbs == 35 ) {		// boolean
				sp.ne("Addi", msk, key, (Boolean)condi.get("val"));
			} else {	// string
				sp.ne("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("LK") ) {			//----------------LIKE
			sp.like("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NLK") ) {			//----------------NOT LIKE
			sp.notLike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("OLK") ) {			//----------------OR LIKE
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orLike("Addi", msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("MK") ) {			//----------------MIKE
			sp.mike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NMK") ) {			//----------------NOT MIKE
			sp.notMike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("OMK") ) {			//----------------OR MIKE
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orMike("Addi", msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("NK") ) {			//----------------NIKE
			sp.nike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NNK") ) {			//----------------NOT NIKE
			sp.notNike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("ONK") ) {			//----------------OR NIKE
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orNike("Addi", msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("I") ) {			//----------------IN
			String[] valstr = ((String)condi.get("val")).split(",");
			if ( mskAbs == 18 ) {		// integer
				Integer[] vals = new Integer[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Integer(valstr[i]);
				}
				sp.in("Addi", msk, key, vals);
			} else if ( mskAbs == 24 ) {		// float
				Float[] vals = new Float[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Float(valstr[i]);
				}
				sp.in("Addi", msk, key, vals);
			} else {	// string
				sp.in("Addi", msk, key, valstr);	
			}
		} else if ( op.equalsIgnoreCase("NI") ) {			//----------------NOT IN
			String[] valstr = ((String)condi.get("val")).split(",");
			if ( mskAbs == 18 ) {		// integer
				Integer[] vals = new Integer[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Integer(valstr[i]);
				}
				sp.notIn("Addi", msk, key, vals);
			} else if ( mskAbs == 24 ) {		// float
				Float[] vals = new Float[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Float(valstr[i]);
				}
				sp.notIn("Addi", msk, key, vals);
			} else {	// string
				sp.notIn("Addi", msk, key, valstr);	
			}
		} else if ( op.equalsIgnoreCase("G") ) {			//----------------GT
			if ( mskAbs == 18 ) {		// integer
				sp.gt("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.gt("Addi", msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.gt("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("GS") || op.equalsIgnoreCase("GC") || op.equalsIgnoreCase("GX") || op.equalsIgnoreCase("GE") ) {			//----------------GTE
			if ( mskAbs == 18 ) {		// integer
				sp.gte("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.gte("Addi", msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.gte("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("L") ) {			//----------------LT
			if ( mskAbs == 18 ) {		// integer
				sp.lt("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.lt("Addi", msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.lt("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("LS") || op.equalsIgnoreCase("LC") || op.equalsIgnoreCase("LX") || op.equalsIgnoreCase("LE") ) {			//----------------LET
			if ( mskAbs == 18 ) {		// integer
				sp.lte("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.lte("Addi", msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.lte("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("B") || op.equalsIgnoreCase("BTN") ) {			//----------------BETWEEN
			String[] valstr = ((String)condi.get("val")).split(",");
			if ( mskAbs == 18 ) {		// integer
				Integer[] vals = new Integer[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Integer(valstr[i]);
				}
				sp.between("Addi", msk, key, vals[0], vals[1]);
			} else if ( mskAbs == 24 ) {		// float
				Float[] vals = new Float[valstr.length];
				for(int i=0; i<vals.length; i++){
					vals[i] = new Float(valstr[i]);
				}
				sp.between("Addi", msk, key, vals[0], vals[1]);
			} else {	// string
				sp.between("Addi", msk, key, valstr[0], valstr[1]);
			}
		} else if ( op.equalsIgnoreCase("O") || op.equalsIgnoreCase("OD") ) {			//----------------ORDER BY
			if ( msk > 0 ) {
				sp.addOrderBy(key, "ASC");
			} else {
				sp.addOrderBy(key, "DESC");
			}
		}
	}
	
	public static void addCondi(ArrayList<HashMap> conditionList, String key, String operate, String value, Integer msk) {
		HashMap condi = new HashMap();
		condi.put("key", key);
		condi.put("op", operate);
		condi.put("val", value);
		condi.put("msk", msk);
		conditionList.add(condi);
	}
	
	public static void addCondi(ArrayList<HashMap> conditionList, String key, String operate, Integer value, Integer msk) {
		HashMap condi = new HashMap();
		condi.put("key", key);
		condi.put("op", operate);
		condi.put("val", value);
		condi.put("msk", msk);
		conditionList.add(condi);
	}
	
	public static void addCondi(ArrayList<HashMap> conditionList, String key, String operate, Float value, Integer msk) {
		HashMap condi = new HashMap();
		condi.put("key", key);
		condi.put("op", operate);
		condi.put("val", value);
		condi.put("msk", msk);
		conditionList.add(condi);
	}
	
	public static void newAddi(ArrayList<HashMap> additionList, String key, String operate, String value, Integer msk) {
		HashMap addi = new HashMap();
		addi.put("key", key);
		addi.put("op", operate);
		addi.put("val", value);
		addi.put("msk", msk);
		additionList.add(addi);
	}
	
	public static void newAddi(ArrayList<HashMap> additionList, String key, String operate, Integer value, Integer msk) {
		HashMap addi = new HashMap();
		addi.put("key", key);
		addi.put("op", operate);
		addi.put("val", value);
		addi.put("msk", msk);
		additionList.add(addi);
	}
	
	public static void newAddi(ArrayList<HashMap> additionList, String key, String operate, Float value, Integer msk) {
		HashMap addi = new HashMap();
		addi.put("key", key);
		addi.put("op", operate);
		addi.put("val", value);
		addi.put("msk", msk);
		additionList.add(addi);
	}
    
    public static void main(String[] args){
//    	SqlHelper sp = new SqlHelper();
//    	sp.in(1, "name", "xxa, cc,dd,ee,ff,gg,zz,xx,yy".split(","));
//    	sp.eq(1, "code", "abcdefg");
//    	System.out.println("SQL: " + sp.sql());
    	ArrayList<HashMap> conditions = new ArrayList<HashMap>(0);
    	HashMap<String, Object> condi01 = new HashMap<String, Object>();
    	condi01.put("key", "Xqqqname");
    	condi01.put("op", "mk");
    	condi01.put("val", "superman");
    	condi01.put("msk", 1);

    	HashMap<String, Object> condi02 = new HashMap<String, Object>();
    	condi02.put("key", "level");
    	condi02.put("op", "g");
    	condi02.put("val", 300);
    	condi02.put("msk", -18);

    	HashMap<String, Object> condi03 = new HashMap<String, Object>();
    	condi03.put("key", "range");
    	condi03.put("op", "i");
    	condi03.put("val", "1,3,4,6,7");
    	condi03.put("msk", 18);

    	HashMap<String, Object> condi04 = new HashMap<String, Object>();
    	condi04.put("key", "name");
    	condi04.put("op", "od");
    	condi04.put("val", "sef");
    	condi04.put("msk", 21);

    	HashMap<String, Object> condi05 = new HashMap<String, Object>();
    	condi05.put("key", "range");
    	condi05.put("op", "od");
    	condi05.put("val", "1,3,4,6,7");
    	condi05.put("msk", -22);


    	conditions.add(condi01);
    	conditions.add(condi02);
    	conditions.add(condi03);
    	conditions.add(condi04);
    	conditions.add(condi05);
    	
    	ArrayList<HashMap> additions = new ArrayList<HashMap>(0);
    	HashMap<String, Object> addi01 = new HashMap<String, Object>();
    	addi01.put("key", "xxv");
    	addi01.put("op", "e");
    	addi01.put("val", "wuke");
    	addi01.put("msk", 1);
    	
    	HashMap<String, Object> addi02 = new HashMap<String, Object>();
    	addi02.put("key", "vsee");
    	addi02.put("op", "i");
    	addi02.put("val", "112,334,556,67");
    	addi02.put("msk", 1);
    	
    	additions.add(addi01);
    	additions.add(addi02);
    	
    	System.out.println("SQL: " + Sql.generate(conditions, additions));
    	System.out.println("SQL: " + Sql.generate(conditions, null));
    }
}
