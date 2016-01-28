/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/1/28 11:37:44                           */
/*==============================================================*/


drop table if exists lab_bluetooth;

drop table if exists lab_check_work;

drop table if exists lab_class;

drop table if exists lab_course_list;

drop table if exists lab_curriculum_name;

drop table if exists lab_notice;

drop table if exists lab_position;

drop table if exists lab_status_course;

drop table if exists lab_student;

drop table if exists lab_student_phone;

drop table if exists lab_teacher;

drop table if exists lab_term;

drop table if exists lab_time;

drop table if exists lab_trajectory;

/*==============================================================*/
/* Table: lab_bluetooth                                         */
/*==============================================================*/
create table lab_bluetooth
(
   bluetooth_id         int not null auto_increment comment 'ID',
   bluetooth_number     int comment '蓝牙编号',
   manufactor           char(200) comment '厂家',
   status               int comment '状态',
   position_id          int,
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (bluetooth_id)
);

alter table lab_bluetooth comment '蓝牙设备';

/*==============================================================*/
/* Table: lab_check_work                                        */
/*==============================================================*/
create table lab_check_work
(
   check_id             int not null auto_increment comment '考勤id',
   class_id             int comment '班级ID',
   curriculum_id        int comment '课程id',
   status               int comment '考勤状态',
   student_id           int comment '学生id',
   section              int comment '节数',
   start_date           date comment '上课签到时间',
   end_date             date comment '下课签到时间',
   term                 int comment '学期',
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (check_id)
);

alter table lab_check_work comment '考勤记录';

/*==============================================================*/
/* Table: lab_class                                             */
/*==============================================================*/
create table lab_class
(
   class_id             int not null auto_increment comment '班级id',
   calss_name           char(50) comment '班级名称',
   college_id           int,
   department_id        int comment '院系ID',
   major                int comment '专业',
   headmaster           int comment '班主任',
   instructor           int comment '辅导员',
   level_id             int comment '级',
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (class_id)
);

alter table lab_class comment '班级';

/*==============================================================*/
/* Table: lab_course_list                                       */
/*==============================================================*/
create table lab_course_list
(
   course_id            int not null auto_increment comment '课程表ID',
   curriculum_id        int,
   week                 int comment '周几',
   section              int comment '节数（第几节）',
   class_id             int,
   term                 int comment '学期',
   position_id          int,
   course_type          int,
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (course_id)
);

alter table lab_course_list comment '课程表';

/*==============================================================*/
/* Table: lab_curriculum_name                                   */
/*==============================================================*/
create table lab_curriculum_name
(
   curriculum_id        int not null auto_increment comment '课程id',
   curriculum_name      char(100) comment '课程名称',
   teacher_id           int comment '任课老师ID',
   start_week           int comment '开始时间（周）',
   end_week             int comment '结束时间（周）',
   college_id           int,
   department_id        int comment '院系ID',
   tremI_id             int comment '学期id',
   level                int comment '级',
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (curriculum_id)
);

alter table lab_curriculum_name comment '课程名称';

/*==============================================================*/
/* Table: lab_notice                                            */
/*==============================================================*/
create table lab_notice
(
   notice_id            int not null auto_increment comment 'ID',
   content              char(1000) comment '内容',
   title                char(100) comment '标题',
   creat_date           date comment '创建时间',
   edit_date            date comment '修改时间',
   display_date         int comment '展示时间',
   del                  int comment '删除标识',
   teacher_id           int comment '创建人id',
   class_id             char comment '接收班级',
   top                  int comment '置顶标识',
   primary key (notice_id)
);

alter table lab_notice comment '通知';

/*==============================================================*/
/* Table: lab_position                                          */
/*==============================================================*/
create table lab_position
(
   position_id          int not null auto_increment comment '位置ID',
   academic_field       char(100) comment '场地',
   number               char(20) comment '编号',
   position_type        int comment '位置类型',
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除',
   primary key (position_id)
);

alter table lab_position comment '位置';

/*==============================================================*/
/* Table: lab_status_course                                     */
/*==============================================================*/
create table lab_status_course
(
   status_id            int not null auto_increment comment '课程表修改ID',
   curriculum_id        int,
   week                 int comment '周几',
   section              int comment '节数',
   term                 int comment '学期',
   class_id             int,
   position_id          int,
   course_type          int,
   course_id            int comment '课程表ID',
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (status_id)
);

alter table lab_status_course comment '课程修改表';

/*==============================================================*/
/* Table: lab_student                                           */
/*==============================================================*/
create table lab_student
(
   student_id           int not null auto_increment comment '学生ID',
   student_number       int not null comment '学号',
   student_name         char comment '姓名',
   nickname             char(50) comment '昵称',
   sex                  bit comment '性别',
   age                  int(3) comment '年龄',
   nation               char(20) comment '民族',
   phone                int(11) comment '手机号码',
   id_card              char(18) comment '身份证号码',
   type                 int comment '职位',
   email                char comment 'Email',
   major                int comment '专业',
   class_id             int,
   department_id        int comment '学系ID',
   college_id           int comment '学院id',
   head_image           char comment '头像',
   note                 char(500) comment '备注',
   password             char comment '密码',
   creat_date           date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (student_id)
);

alter table lab_student comment '学生信息';

/*==============================================================*/
/* Table: lab_student_phone                                     */
/*==============================================================*/
create table lab_student_phone
(
   mac_id               int not null auto_increment comment 'id',
   student_id           int not null comment '学生id',
   mac                  char comment '手机物理地址',
   creat_date           date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (mac_id)
);

alter table lab_student_phone comment '手机';

/*==============================================================*/
/* Table: lab_teacher                                           */
/*==============================================================*/
create table lab_teacher
(
   teacher_id           int not null auto_increment comment '教职工ID',
   teacher_number       int not null comment '工号',
   teacher_name         char(20) comment '姓名',
   nickname             char(50) comment '昵称',
   sex                  bit comment '性别',
   age                  int(3) comment '年龄',
   nation               char(20) comment '民族',
   phone                int(11) comment '手机号码',
   id_card              int(18) comment '身份证号码',
   email                char comment 'Email',
   professional         int,
   college_id           int,
   department_id        char comment '院系ID',
   head_image           char comment '头像',
   role                 int comment '角色',
   note                 char(500) comment '备注',
   password             char comment '密码',
   creat_date           date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (teacher_id)
);

alter table lab_teacher comment '教职工信息';

/*==============================================================*/
/* Table: lab_term                                              */
/*==============================================================*/
create table lab_term
(
   tremI_id             int not null auto_increment comment '学期ID',
   start_date           date comment '开始时间',
   end_date             date comment '结束时间',
   create_date          date comment '创建时间',
   edite_date           date comment '修改时间',
   del                  int comment '删除标识',
   primary key (tremI_id)
);

alter table lab_term comment '学期表';

/*==============================================================*/
/* Table: lab_time                                              */
/*==============================================================*/
create table lab_time
(
   id                   int not null auto_increment comment 'id',
   section              int comment '节数',
   term                 int comment '学期',
   start_date           date comment '开始时间',
   end_date             date comment '结束时间',
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (id)
);

alter table lab_time comment '时间表';

/*==============================================================*/
/* Table: lab_trajectory                                        */
/*==============================================================*/
create table lab_trajectory
(
   itrajectory_d        int not null auto_increment comment 'id',
   student_id           int comment '学生id',
   position_id          int comment '位置',
   create_date          date comment '创建时间',
   primary key (itrajectory_d)
);

alter table lab_trajectory comment '轨迹表';

alter table lab_bluetooth add constraint FK_Reference_7 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_1 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_2 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_3 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_4 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_5 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_status_course add constraint FK_Reference_6 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

