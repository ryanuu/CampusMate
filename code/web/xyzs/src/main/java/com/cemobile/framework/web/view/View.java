package com.cemobile.framework.web.view;

public interface View {
    public interface DEMO {
        public static String DEMOLIST = "demo/demo_list";
        public static String ADDDEMO = "demo/demo_add";
        public static String UPDATEDEMO = "demo/demo_update";
        public static String DETAILDEMO = "demo/demo_detail";
        public static String SEARCHDEMO = "demo/demo_search";
    }
    //时间设置（学期、上下课时间）
    public interface Time {
        public static String TERMLIST = "xyzs/timeSeting/term_list";
        public static String TERMADD = "xyzs/timeSeting/term_add";
        public static String UPDATTERM = "xyzs/timeSeting/term_update";
        public static String DETAILTERM = "xyzs/timeSeting/term_detail";
        public static String SEARCHTERM = "xyzs/timeSeting/term_search";
        
        public static String TIMELIST = "xyzs/timeSeting/time_list";
        public static String TIMEADD = "xyzs/timeSeting/time_add";
        public static String UPDATTIME= "xyzs/timeSeting/time_update";
        public static String DETAILTIME = "xyzs/timeSeting/time_detail";
        public static String SEARCHTIME = "xyzs/timeSeting/time_search";
    }
    //组织管理
    public static abstract interface ORG {
		public static final String LIST = "xyzs/org/org_list";
		public static final String ADD = "xyzs/org/org_add";
		public static final String EDIT = "xyzs/org/org_edit";
		public static final String MOVE = "xyzs/org/org_move";
	}
}
