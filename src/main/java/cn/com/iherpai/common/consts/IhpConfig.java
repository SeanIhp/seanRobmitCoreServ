/**
 * Copyright (C), 2003-2014, 
 * FileName:	IhpConfig.java
 * Author:		Sean
 * Date:		2014-04-20	10:30
 * Description:	
 * History:
 * <author>		<time>			<version>		<description> 
 */
package cn.com.iherpai.common.consts;

/**
 * @author		Sean
 * @description	当前应用中的通用设置 
 */				
public class IhpConfig {
	public static String			rootPath = null;
	public static final long		ID_GENERATOR_SERVER_CODE 				= 1L;					//ID生成器所在的服务器编号
	public static final long		ID_GENERATOR_DATA_DATABASE_CODE 		= 1L;					//数据库所在的服务器编号
	public static final long		ID_GENERATOR_DATA_TABLE_CODE 			= 1L;					//数据所在的表编号
	

	
	
	public static final int			ID_GENERATOR_MINSEED 				= 100;						//ID生成器批量产生随机数最小值
	public static final int			ID_GENERATOR_MAXSEED 				= 1000;						//ID生成器批量产生随机数最大值
	
	public static final long		ID_DATA_DATABASE_CODE 		= 1L;					//数据库所在的服务器编号
	public static final long		ID_DATA_TABLE_CODE 			= 1L;					//数据所在的表编号
	
	//最大值：226,980
	public static final long		SID_$ACCOUNT 						= 100101L;					//ID生成器: 数据用途所: Account
	
	
	
	
	public static final long		ID_DICT__$DICT 						= 110021L;					//ID生成器: 数据用途所: Dict
	public static final long		ID_DICT__$DICTGROUP 				= 110041L;					//ID生成器: 数据用途所: DictGroup
	
	
	public static final long		ID_GROUP__$GROUP 					= 110021L;					//ID生成器: 数据用途所: Group
	public static final long		ID_GROUP__$GROUPMEMBER 				= 110041L;					//ID生成器: 数据用途所: GroupMember
	public static final long		ID_GROUP__$REPLY 					= 110061L;					//ID生成器: 数据用途所: Reply
	public static final long		ID_GROUP__$TOPIC 					= 110081L;					//ID生成器: 数据用途所: Topic
	
	
	public static final long		ID_HEPAI__$HEPAI 					= 100021L;					//ID生成器: 数据用途所: Hepai
	public static final long		ID_HEPAI__$HEPAICOUNT 				= 100041L;					//ID生成器: 数据用途所: HepaiCount
	public static final long		ID_HEPAI__$LOCATION 				= 100061L;					//ID生成器: 数据用途所: Location
	public static final long		ID_HEPAI__$REGION 					= 100081L;					//ID生成器: 数据用途所: Region
	public static final long		ID_HEPAI__$TEMPHEPAI 				= 100101L;					//ID生成器: 数据用途所: TempHepai
	
	
	public static final long		ID_IMAGE__$ITEMCOVER 				= 100021L;					//ID生成器: 数据用途所: ItemCover

	
	public static final long		ID_ITEM__$ITEM 						= 100021L;					//ID生成器: 数据用途所: Item
	public static final long		ID_ITEM__$SKU 						= 100041L;					//ID生成器: 数据用途所: Sku
	public static final long		ID_ITEM__$TEMPITEM 					= 100061L;					//ID生成器: 数据用途所: TempItem
	
	
	public static final long		ID_USER__$AUTHENTICATION 			= 100021L;					//ID生成器: 数据用途所: Authentication
	public static final long		ID_USER__$FANS 						= 100041L;					//ID生成器: 数据用途所: Fans
	public static final long		ID_USER__$FOLLOW 					= 100061L;					//ID生成器: 数据用途所: Follow
	public static final long		ID_USER__$SHOPPINGCART 				= 100081L;					//ID生成器: 数据用途所: ShoppingCart
	public static final long		ID_USER__$USERACCOUNT 				= 100101L;					//ID生成器: 数据用途所: UserAccount
	public static final long		ID_USER__$USERGROUP 				= 100121L;					//ID生成器: 数据用途所: UserGroup
	public static final long		ID_USER__$USERPERMISSION 			= 100141L;					//ID生成器: 数据用途所: UserPermission
	public static final long		ID_USER__$USERROLE 					= 100161L;					//ID生成器: 数据用途所: UserRole
	public static final long		ID_USER__$VISITORTRACE 				= 100181L;					//ID生成器: 数据用途所: VisitorTrace
	
	public static final long		ID_MAPPING__$GROUPS_TOPICS 						= 100021L;				//ID生成器: 数据用途所: Groups_Topics
	public static final long		ID_MAPPING__$HEPAI_ITEMS 						= 100041L;				//ID生成器: 数据用途所: Hepai_Items
	public static final long		ID_MAPPING__$HEPAI_LOCATIONS 					= 100061L;				//ID生成器: 数据用途所: Hepai_Locations
	public static final long		ID_MAPPING__$TEMPHEPAI_TEMPITEMS 				= 100081L;				//ID生成器: 数据用途所: TempHepai_TempItems
	public static final long		ID_MAPPING__$USER_GROUPS 						= 100101L;				//ID生成器: 数据用途所: User_Groups
	public static final long		ID_MAPPING__$USERGROUP_USERROLES 				= 100121L;				//ID生成器: 数据用途所: UserGroup_UserRoles
	public static final long		ID_MAPPING__$USERS_USERGROUPS 					= 100141L;				//ID生成器: 数据用途所: Users_UserGroups
	public static final long		ID_MAPPING__$USERS_USERROLES 					= 100161L;				//ID生成器: 数据用途所: Users_UserRoles
	
	
	
	
	public static final String	EXCEPTION__UNKNOWN						=	"服务器内部错误！";
	
	
}
