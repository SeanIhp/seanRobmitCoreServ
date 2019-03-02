package cn.com.iherpai.common.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class SqlHelper {
    private StringBuilder where = new StringBuilder(" ");
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
 
    public SqlHelper addOrderBy(String sortField, String order) {
        if (!isEmpty(sortField) && !isEmpty(order)) {
        	if( !isEmpty(this.orderBy) ){
        		this.orderBy += ", " + EntityUtil.toUnderScoreName(sortField) + " " + order;
        	} else {
                this.orderBy = EntityUtil.toUnderScoreName(sortField) + " " + order;
        	}
        }
        return this;
    }
 
    public SqlHelper orLike(int msk, String columns, String value) {
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
 
    public SqlHelper orMike(int msk, String columns, String value) {
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
 
    public SqlHelper orNike(int msk, String columns, String value) {
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
 
    public SqlHelper eq(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " = '" + sqlParam(value) + "'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " = '" + sqlParam(value) + "'");
            }
        }
        return this;
    }

    public SqlHelper eq(int msk, String column, Integer value) {
        if ( value !=null ) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " = " + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " = " + value );
            }
        }
        return this;
    }

    public SqlHelper eq(int msk, String column, Float value) {
        if ( value !=null ) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column) + " = " + value );
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column) + " = " + value );
            }
        }
        return this;
    }
 
    public SqlHelper ne(int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                where.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " != '" + sqlParam(value) + "'");
            } else {
                where.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " != '" + sqlParam(value) + "'");
            }
        }
        return this;
    }
    
    public SqlHelper ne(int msk, String column, Integer value) {
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
    
    public SqlHelper ne(int msk, String column, Float value) {
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
 
    public SqlHelper like(int msk, String column, String value) {
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
 
    public SqlHelper notLike(int msk, String column, String value) {
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
 
    public SqlHelper mike(int msk, String column, String value) {
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
 
    public SqlHelper notMike(int msk, String column, String value) {
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
 
    public SqlHelper nike(int msk, String column, String value) {
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
 
    public SqlHelper notNike(int msk, String column, String value) {
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
 
    public SqlHelper in(int msk, String column, String... values) {
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
 
    public SqlHelper in(int msk, String column, Integer... values) {
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
 
    public SqlHelper in(int msk, String column, Float... values) {
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
 
    public SqlHelper notIn(int msk, String column, String... values) {
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
 
    public SqlHelper notIn(int msk, String column, Integer... values) {
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
 
    public SqlHelper notIn(int msk, String column, Float... values) {
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
 
    public SqlHelper gt(int msk, String column, String value) {
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
    
    public SqlHelper gt(int msk, String column, Integer value) {
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
    
    public SqlHelper gt(int msk, String column, Float value) {
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
 
    public SqlHelper gte(int msk, String column, String value) {
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

    public SqlHelper gte(int msk, String column, Integer value) {
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

    public SqlHelper gte(int msk, String column, Float value) {
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
 
    public SqlHelper lt(int msk, String column, String value) {
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
 
    public SqlHelper lt(int msk, String column, Integer value) {
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
 
    public SqlHelper lt(int msk, String column, Float value) {
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
 
    public SqlHelper lte(int msk, String column, String value) {
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
 
    public SqlHelper lte(int msk, String column, Integer value) {
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
 
    public SqlHelper lte(int msk, String column, Float value) {
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

    public SqlHelper between(int msk, String column, String from, String to) {
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
 
    public SqlHelper between(int msk, String column, Integer from, Integer to) {
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

    public SqlHelper between(int msk, String column, Float from, Float to) {
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
 
    public SqlHelper addOrderBy(String addi, String sortField, String order) {
        if (!isEmpty(sortField) && !isEmpty(order)) {
        	if( !isEmpty(this.orderBy) ){
        		this.orderBy += ", " + EntityUtil.toUnderScoreName(sortField) + " " + order;
        	} else {
                this.orderBy = EntityUtil.toUnderScoreName(sortField) + " " + order;
        	}
        }
        return this;
    }
 
    public SqlHelper orLike(String addi, int msk, String columns, String value) {
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
 
    public SqlHelper orMike(String addi, int msk, String columns, String value) {
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
 
    public SqlHelper orNike(String addi, int msk, String columns, String value) {
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
 
    public SqlHelper eq(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " = '" + sqlParam(value) + "'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " = '" + sqlParam(value) + "'");
            }
        }
        return this;
    }

    public SqlHelper eq(String addi, int msk, String column, Integer value) {
        if ( value !=null ) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " = " + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " = " + value );
            }
        }
        return this;
    }

    public SqlHelper eq(String addi, int msk, String column, Float value) {
        if ( value !=null ) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column) + " = " + value );
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column) + " = " + value );
            }
        }
        return this;
    }
 
    public SqlHelper ne(String addi, int msk, String column, String value) {
        if (!isEmpty(value)) {
            if ( msk < 0 ) {
                whereAddition.append(" OR " + EntityUtil.toUnderScoreName(column)
                + " != '" + sqlParam(value) + "'");
            } else {
                whereAddition.append(" AND " + EntityUtil.toUnderScoreName(column)
                + " != '" + sqlParam(value) + "'");
            }
        }
        return this;
    }
    
    public SqlHelper ne(String addi, int msk, String column, Integer value) {
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
    
    public SqlHelper ne(String addi, int msk, String column, Float value) {
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
 
    public SqlHelper like(String addi, int msk, String column, String value) {
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
 
    public SqlHelper notLike(String addi, int msk, String column, String value) {
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
 
    public SqlHelper mike(String addi, int msk, String column, String value) {
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
 
    public SqlHelper notMike(String addi, int msk, String column, String value) {
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
 
    public SqlHelper nike(String addi, int msk, String column, String value) {
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
 
    public SqlHelper notNike(String addi, int msk, String column, String value) {
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
 
    public SqlHelper in(String addi, int msk, String column, String... values) {
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
 
    public SqlHelper in(String addi, int msk, String column, Integer... values) {
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
 
    public SqlHelper in(String addi, int msk, String column, Float... values) {
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
 
    public SqlHelper notIn(String addi, int msk, String column, String... values) {
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
 
    public SqlHelper notIn(String addi, int msk, String column, Integer... values) {
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
 
    public SqlHelper notIn(String addi, int msk, String column, Float... values) {
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
 
    public SqlHelper gt(String addi, int msk, String column, String value) {
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
    
    public SqlHelper gt(String addi, int msk, String column, Integer value) {
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
    
    public SqlHelper gt(String addi, int msk, String column, Float value) {
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
 
    public SqlHelper gte(String addi, int msk, String column, String value) {
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

    public SqlHelper gte(String addi, int msk, String column, Integer value) {
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

    public SqlHelper gte(String addi, int msk, String column, Float value) {
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
 
    public SqlHelper lt(String addi, int msk, String column, String value) {
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
 
    public SqlHelper lt(String addi, int msk, String column, Integer value) {
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
 
    public SqlHelper lt(String addi, int msk, String column, Float value) {
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
 
    public SqlHelper lte(String addi, int msk, String column, String value) {
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
 
    public SqlHelper lte(String addi, int msk, String column, Integer value) {
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
 
    public SqlHelper lte(String addi, int msk, String column, Float value) {
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

    public SqlHelper between(String addi, int msk, String column, String from, String to) {
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
 
    public SqlHelper between(String addi, int msk, String column, Integer from, Integer to) {
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

    public SqlHelper between(String addi, int msk, String column, Float from, Float to) {
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
        if (where.length() > a) {
        	if ( whereAddition.length()>0 ) {
                sql.append(" (" + where.substring(b) + ") AND ( 1=1 AND "+ whereAddition +")");
        	}else{
                sql.append(" " + where.substring(b) + " ");
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
        return sql.toString();
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
    	SqlHelper sp = new SqlHelper();
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

	private static void generatorCondition(SqlHelper sp, HashMap condi) {
		String key = (String)condi.get("key");
		String op = (String)condi.get("op");
		int msk = ((Integer)condi.get("msk")).intValue();
		int mskAbs = Math.abs(msk);
		if ( op.equalsIgnoreCase("ORLIKE") ) {
			sp.orLike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("EQ") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.eq(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.eq(msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.eq(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("NE") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.ne(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.ne(msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.ne(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("LIKE") ) {
			sp.like(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NOTLIKE") ) {
			sp.notLike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("ORLIKE") ) {
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orLike(msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("MIKE") ) {
			sp.mike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NOTMIKE") ) {
			sp.notMike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("ORMIKE") ) {
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orMike(msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("NIKE") ) {
			sp.nike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NOTNIKE") ) {
			sp.notNike(msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("ORNIKE") ) {
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orNike(msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("IN") ) {
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
		} else if ( op.equalsIgnoreCase("NOTIN") ) {
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
		} else if ( op.equalsIgnoreCase("GT") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.gt(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.gt(msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.gt(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("GTE") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.gte(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.gte(msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.gte(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("LT") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.lt(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.lt(msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.lt(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("LTE") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.lte(msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.lte(msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.lte(msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("BETWEEN") ) {
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
		} else if ( op.equalsIgnoreCase("OD") ) {
			if ( msk > 0 ) {
				sp.addOrderBy(key, "ASC");
			} else {
				sp.addOrderBy(key, "DESC");
			}
		}
	}

	private static void generatorAddition(SqlHelper sp, HashMap condi) {
		String key = (String)condi.get("key");
		String op = (String)condi.get("op");
		int msk = ((Integer)condi.get("msk")).intValue();
		int mskAbs = Math.abs(msk);
		if ( op.equalsIgnoreCase("ORLIKE") ) {
			sp.orLike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("EQ") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.eq("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.eq("Addi", msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.eq("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("NE") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.ne("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.ne("Addi", msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.ne("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("LIKE") ) {
			sp.like("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NOTLIKE") ) {
			sp.notLike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("ORLIKE") ) {
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orLike("Addi", msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("MIKE") ) {
			sp.mike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NOTMIKE") ) {
			sp.notMike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("ORMIKE") ) {
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orMike("Addi", msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("NIKE") ) {
			sp.nike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("NOTNIKE") ) {
			sp.notNike("Addi", msk, key, (String)condi.get("val"));
		} else if ( op.equalsIgnoreCase("ORNIKE") ) {
			String[] valstr = ((String)condi.get("val")).split(",");
			sp.orNike("Addi", msk, key, (String)condi.get("val"));
			
		} else if ( op.equalsIgnoreCase("IN") ) {
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
		} else if ( op.equalsIgnoreCase("NOTIN") ) {
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
		} else if ( op.equalsIgnoreCase("GT") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.gt("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.gt("Addi", msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.gt("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("GTE") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.gte("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.gte("Addi", msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.gte("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("LT") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.lt("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.lt("Addi", msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.lt("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("LTE") ) {
			if ( mskAbs == 18 ) {		// integer
				sp.lte("Addi", msk, key, (Integer)condi.get("val"));
			} else if ( mskAbs == 24 ) {		// float
				sp.lte("Addi", msk, key, (Float)condi.get("val"));
			} else {	// string
				sp.lte("Addi", msk, key, (String)condi.get("val"));	
			}
		} else if ( op.equalsIgnoreCase("BETWEEN") ) {
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
		} else if ( op.equalsIgnoreCase("OD") ) {
			if ( msk > 0 ) {
				sp.addOrderBy(key, "ASC");
			} else {
				sp.addOrderBy(key, "DESC");
			}
		}
	}
    
    public static void main(String[] args){
//    	SqlHelper sp = new SqlHelper();
//    	sp.in(1, "name", "xxa, cc,dd,ee,ff,gg,zz,xx,yy".split(","));
//    	sp.eq(1, "code", "abcdefg");
//    	System.out.println("SQL: " + sp.sql());
    	ArrayList<HashMap> conditions = new ArrayList<HashMap>(0);
    	HashMap<String, Object> condi01 = new HashMap<String, Object>();
    	condi01.put("key", "Xqqqname");
    	condi01.put("op", "mike");
    	condi01.put("val", "superman");
    	condi01.put("msk", 1);

    	HashMap<String, Object> condi02 = new HashMap<String, Object>();
    	condi02.put("key", "level");
    	condi02.put("op", "gt");
    	condi02.put("val", 300);
    	condi02.put("msk", -18);

    	HashMap<String, Object> condi03 = new HashMap<String, Object>();
    	condi03.put("key", "range");
    	condi03.put("op", "in");
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
    	addi01.put("op", "eq");
    	addi01.put("val", "wuke");
    	addi01.put("msk", 1);
    	
    	HashMap<String, Object> addi02 = new HashMap<String, Object>();
    	addi02.put("key", "vsee");
    	addi02.put("op", "in");
    	addi02.put("val", "112,334,556,67");
    	addi02.put("msk", 1);
    	
    	additions.add(addi01);
    	additions.add(addi02);
    	
    	System.out.println("SQL: " + SqlHelper.generate(conditions, additions));
    	System.out.println("SQL: " + SqlHelper.generate(conditions, null));
    }
}
