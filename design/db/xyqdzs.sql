/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/2/24 17:25:48                           */
/*==============================================================*/


drop table if exists LAB_TERM;

drop table if exists LAB_TIME;

drop table if exists lab_bluetooth_dev;

drop table if exists lab_check_work;

drop table if exists lab_class;

drop table if exists lab_college;

drop table if exists lab_course_list;

drop table if exists lab_curriculum_name;

drop table if exists lab_department;

drop table if exists lab_exam;

drop table if exists lab_modify_course;

drop table if exists lab_motion_trail;

drop table if exists lab_notice;

drop table if exists lab_position;

drop table if exists lab_student;

drop table if exists lab_student_phone;

drop table if exists lab_subject;

drop table if exists lab_teacher;

/*==============================================================*/
/* Table: LAB_TERM                                              */
/*==============================================================*/
create table LAB_TERM
(
   term_id              bigint not null auto_increment comment '学期ID',
   term_name            char(30),
   start_date           date comment '开始时间',
   end_date             date comment '结束时间',
   college_id           bigint,
   create_date          date comment '创建时间',
   edite_date           date comment '修改时间',
   del                  int comment '删除标识',
   primary key (term_id)
);

alter table LAB_TERM comment '学期表';

/*==============================================================*/
/* Table: LAB_TIME                                              */
/*==============================================================*/
create table LAB_TIME
(
   id                   bigint not null auto_increment comment 'id',
   section              int comment '节数',
   term_id              bigint comment '学期',
   start_date           time comment '开始时间',
   end_date             time comment '结束时间',
   college_id           bigint,
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (id)
);

alter table LAB_TIME comment '课间表';

/*==============================================================*/
/* Table: lab_bluetooth_dev                                     */
/*==============================================================*/
create table lab_bluetooth_dev
(
   dev_id               bigint not null auto_increment comment 'ID',
   dev_number           bigint comment '蓝牙编号',
   manufactor           char(200) comment '厂家',
   status               int comment '状态',
   position_id          bigint,
   uuid                 char(35),
   major                bigint,
   minor                bigint,
   dev_type             char(50),
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   dev_sn               char,
   dev_mac              char(20),
   measuredPower        int(11),
   name                 char(30),
   primary key (dev_id)
);

alter table lab_bluetooth_dev comment '蓝牙设备';

/*==============================================================*/
/* Table: lab_check_work                                        */
/*==============================================================*/
create table lab_check_work
(
   check_id             bigint not null auto_increment comment '考勤id',
   class_id             bigint comment '班级ID',
   curriculum_id        bigint comment '课程id',
   curriculum_name      char(100),
   status               char comment '考勤状态',
   student_id           bigint comment '学生id',
   weekNo               int,
   weekday              int,
   section              int comment '节数',
   start_date           date comment '上课签到时间',
   end_date             date comment '下课签到时间',
   term_id              bigint comment '学期',
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
   class_id             bigint not null auto_increment comment '班级id',
   class_name           char(50) not null comment '班级名称',
   college_id           bigint not null,
   department_id        bigint not null comment '院系ID',
   subject_id           bigint not null comment '专业',
   headmaster           bigint comment '班主任',
   instructor           bigint comment '辅导员',
   grade                int not null comment '级',
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (class_id)
);

alter table lab_class comment '班级';

/*==============================================================*/
/* Table: lab_college                                           */
/*==============================================================*/
create table lab_college
(
   college_id           bigint not null auto_increment,
   college_name         char(30) not null,
   short_name           char(10),
   college_profile      varchar(500),
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (college_id)
);

/*==============================================================*/
/* Table: lab_course_list                                       */
/*==============================================================*/
create table lab_course_list
(
   course_list_id       bigint not null auto_increment comment '课程表ID',
   curriculum_id        bigint,
   weekday              int not null comment '周几',
   section              int not null comment '节数（第几节）',
   class_id             bigint not null,
   term_id              bigint not null comment '学期',
   position_id          bigint,
   course_type          int not null,
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (course_list_id)
);

alter table lab_course_list comment '课程表';

/*==============================================================*/
/* Table: lab_curriculum_name                                   */
/*==============================================================*/
create table lab_curriculum_name
(
   curriculum_id        bigint not null auto_increment comment '课程id',
   curriculum_name      char(100) comment '课程名称',
   teacher_id           bigint comment '任课老师ID',
   teacher_name         char(20),
   start_week           int comment '开始时间（周）',
   end_week             int comment '结束时间（周）',
   subject_id           bigint not null,
   term_id              bigint not null comment '学期id',
   level                int comment '级',
   course_type          int,
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (curriculum_id)
);

alter table lab_curriculum_name comment '课程名称';

/*==============================================================*/
/* Table: lab_department                                        */
/*==============================================================*/
create table lab_department
(
   department_id        bigint not null auto_increment,
   department_name      char(30) not null,
   short_name           char(10),
   department_profile   varchar(500),
   college_id           bigint not null,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (department_id)
);

/*==============================================================*/
/* Table: lab_exam                                              */
/*==============================================================*/
create table lab_exam
(
   exam_id              bigint not null auto_increment,
   curriculum_id        bigint,
   curriculum_name      char(100),
   start_time           time,
   end_time             time,
   week                 int,
   subject_id           bigint not null,
   level                int,
   term_id              bigint,
   teacher_id           bigint,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (exam_id)
);

/*==============================================================*/
/* Table: lab_modify_course                                     */
/*==============================================================*/
create table lab_modify_course
(
   modify_id            bigint not null auto_increment comment '课程表修改ID',
   curriculum_id        bigint,
   weekday              int not null comment '周几',
   section              int not null comment '节数',
   term_id              bigint not null comment '学期',
   class_id             bigint not null,
   position_id          bigint,
   course_type          int not null,
   course_id            bigint comment '课程表ID',
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (modify_id)
);

alter table lab_modify_course comment '课程修改表';

/*==============================================================*/
/* Table: lab_motion_trail                                      */
/*==============================================================*/
create table lab_motion_trail
(
   trail_d              bigint not null auto_increment comment 'id',
   student_id           bigint comment '学生id',
   position_id          bigint comment '位置',
   residence_tim        bigint,
   start_time           date,
   leave_time           date,
   create_date          date comment '创建时间',
   primary key (trail_d)
);

alter table lab_motion_trail comment '轨迹表';

/*==============================================================*/
/* Table: lab_notice                                            */
/*==============================================================*/
create table lab_notice
(
   notice_id            bigint not null auto_increment comment 'ID',
   content              varchar(1000) comment '内容',
   title                char(100) comment '标题',
   display_date         int comment '展示时间',
   teacher_id           bigint comment '创建人id',
   source               char,
   class_id             char comment '接收班级',
   department_id        bigint,
   college_id           bigint,
   top                  int comment '置顶标识',
   creat_date           date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (notice_id)
);

alter table lab_notice comment '通知';

/*==============================================================*/
/* Table: lab_position                                          */
/*==============================================================*/
create table lab_position
(
   position_id          bigint not null auto_increment comment '位置ID',
   place                char(100) comment '场地',
   number               char(20) comment '编号',
   position_type        int comment '位置类型',
   create_date          date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除',
   primary key (position_id)
);

alter table lab_position comment '位置';

/*==============================================================*/
/* Table: lab_student                                           */
/*==============================================================*/
create table lab_student
(
   student_id           bigint not null auto_increment comment '学生ID',
   student_number       bigint not null comment '学号',
   student_name         char comment '姓名',
   nickname             char(50) comment '昵称',
   sex                  bit comment '性别',
   age                  int(3) comment '年龄',
   nation               char(20) comment '民族',
   phone                bigint(11) comment '手机号码',
   id_card              char(18) comment '身份证号码',
   type                 bigint comment '职位',
   email                char comment 'Email',
   class_id             bigint,
   head_image           char comment '头像',
   note                 varchar(500) comment '备注',
   password             char comment '密码',
   creat_date           date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   useri_id             bigint,
   primary key (student_id)
);

alter table lab_student comment '学生信息';

/*==============================================================*/
/* Table: lab_student_phone                                     */
/*==============================================================*/
create table lab_student_phone
(
   mac_id               bigint not null auto_increment comment 'id',
   student_id           bigint not null comment '学生id',
   mac                  char comment '手机物理地址',
   creat_date           date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   primary key (mac_id)
);

alter table lab_student_phone comment '手机';

/*==============================================================*/
/* Table: lab_subject                                           */
/*==============================================================*/
create table lab_subject
(
   subject_id           bigint not null auto_increment,
   subject_name         char(30) not null,
   short_name           char(10),
   subject_profile      varchar(500),
   college_id           bigint not null,
   department_id        bigint not null,
   create_date          date,
   edit_date            date,
   del                  int,
   primary key (subject_id)
);

/*==============================================================*/
/* Table: lab_teacher                                           */
/*==============================================================*/
create table lab_teacher
(
   teacher_id           bigint not null auto_increment comment '教职工ID',
   teacher_number       bigint not null comment '工号',
   teacher_name         char(20) comment '姓名',
   nickname             char(50) comment '昵称',
   sex                  bit comment '性别',
   age                  bigint(3) comment '年龄',
   nation               char(20) comment '民族',
   phone                bigint(11) comment '手机号码',
   id_card              bigint(18) comment '身份证号码',
   email                char comment 'Email',
   professional         bigint,
   college_id           bigint,
   department_id        bigint comment '院系ID',
   head_image           char comment '头像',
   role                 bigint comment '角色',
   note                 varchar(500) comment '备注',
   password             char comment '密码',
   creat_date           date comment '创建时间',
   edit_date            date comment '修改时间',
   del                  int comment '删除标识',
   user_id              bigint,
   primary key (teacher_id)
);

alter table lab_teacher comment '教职工信息';

alter table lab_bluetooth_dev add constraint FK_Reference_11 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_class add constraint FK_Reference_12 foreign key (subject_id)
      references lab_subject (subject_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_4 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_5 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_course_list add constraint FK_Reference_6 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

alter table lab_curriculum_name add constraint FK_Reference_16 foreign key (term_id)
      references LAB_TERM (term_id) on delete restrict on update restrict;

alter table lab_department add constraint FK_Reference_2 foreign key (college_id)
      references lab_college (college_id) on delete restrict on update restrict;

alter table lab_modify_course add constraint FK_Reference_10 foreign key (class_id)
      references lab_class (class_id) on delete restrict on update restrict;

alter table lab_modify_course add constraint FK_Reference_7 foreign key (curriculum_id)
      references lab_curriculum_name (curriculum_id) on delete restrict on update restrict;

alter table lab_modify_course add constraint FK_Reference_9 foreign key (position_id)
      references lab_position (position_id) on delete restrict on update restrict;

alter table lab_subject add constraint FK_Reference_1 foreign key (department_id)
      references lab_department (department_id) on delete restrict on update restrict;

