package com.cpc.permission.pr.helper;

public class GlobalVariable {
	//table name
	public static final String TBL_P_USER = "tbl_p_user";
	public static final String TBL_P_DONVI = "tbl_p_donvi";
	public static final String TBL_P_USER_DONVI = "tbl_p_user_pdonvi";
	public static final String TBL_P_USER_DONVI_CHUCVU = "tbl_p_user_pdonvi_chucvu";
	public static final String TBL_P_CHUCVU = "tbl_p_chucvu";
	public static final String TBL_P_CHUCVU_ROLE = "tbl_p_chucvu_prole";
	public static final String TBL_P_ROLE = "tbl_p_role";
	//FORMAT DATE 
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	public static enum BIENDONG_TYPE{
		KHONG_SU_DUNG,
		TANG_DOT_BIEN, 
		GIAM_DOT_BIEN,
		BINH_THUONG
	}
	public static final String RFSPIDER_APP = "RFSPIDER";
	public static final String DSPM_APP = "DSPM";
	
	public static final String QB_PC_PREFIX = "PC01";//1
	public static final String QT_PC_PREFIX = "PC02";//2
	public static final String TTH_PC_PREFIX = "PC03";//3
	public static final String DN_PC_PREFIX = "PP";//4
	public static final String QNA_PC_PREFIX = "PC05";//5
	public static final String QNG_PC_PREFIX = "PC06";//6
	public static final String BD_PC_PREFIX = "PC07";//7
	public static final String PY_PC_PREFIX = "PC08";//8
	public static final String KH_PC_PREFIX = "PQ";//9
	public static final String KT_PC_PREFIX = "PC11";//10
	public static final String GL_PC_PREFIX = "PC10";//11
	public static final String DL_PC_PREFIX = "PC12";//12
	public static final String DNO_PC_PREFIX = "PC13";//13
	public static enum GET_DDO_TYPE {
		AUTO_ALL,
		MANUAL_SOME
	}
}
