/*
 Navicat Premium Data Transfer

 Source Server         : 59.56.96.9
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 59.56.96.9
 Source Database       : doubi

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : utf-8

 Date: 01/29/2016 16:31:23 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `form_info`
-- ----------------------------
DROP TABLE IF EXISTS `form_info`;
CREATE TABLE `form_info` (
  `FORM_ID` decimal(65,30) NOT NULL COMMENT '表单编号',
  `TITLE` varchar(100) DEFAULT NULL COMMENT '标题',
  `NAME` varchar(100) DEFAULT NULL COMMENT '表单NAME',
  `CLASS_NAME` text COMMENT '表单CLASS',
  `METHOD` text COMMENT '提交方法，GET/POST',
  `URL` text COMMENT '提交表单动作的URL地址',
  `PAGE_TYPE` varchar(10) DEFAULT NULL COMMENT '页面类型',
  `HTML` longtext COMMENT 'HTML脚本',
  `TEMPLATE_NAME` varchar(100) DEFAULT NULL COMMENT '页面模板名',
  `SHOW_GROUP` text COMMENT '展示表单执行SQL组',
  `SAVE_GROUP` text COMMENT '保存表单执行SQL组',
  PRIMARY KEY (`FORM_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='表单信息表';

-- ----------------------------
--  Records of `form_info`
-- ----------------------------
BEGIN;
INSERT INTO `form_info` VALUES ('-15.000000000000000000000000000000', '表单详情', 'detail_form', null, 'get', null, null, null, 'custom/DETAIL', '1', null), ('-11.000000000000000000000000000000', '创建列表', 'add_grid', null, 'post', null, null, null, 'custom/ADD', null, '1'), ('-12.000000000000000000000000000000', '添加列表字段', 'add_grid_field', null, 'post', null, null, null, 'custom/ADD', null, '1'), ('-16.000000000000000000000000000000', '列表详情', 'detail_grid', null, 'get', null, null, null, 'custom/DETAIL', '1', null), ('-8.000000000000000000000000000000', '创建表单', 'add_form', null, 'post', null, null, null, 'custom/ADD', null, '1'), ('-13.000000000000000000000000000000', '添加列表按钮', 'add_grid_button', null, 'post', null, null, null, 'custom/ADD', null, '1'), ('-9.000000000000000000000000000000', '添加表单SQL', 'add_form_sql', null, 'post', null, null, ' ', 'custom/ADD', null, '1'), ('-10.000000000000000000000000000000', '添加表单控件', 'add_form_widget', null, 'post', null, null, null, 'custom/ADD', null, '1'), ('-14.000000000000000000000000000000', '添加查询条件', 'add_grid_query', null, 'post', null, null, null, 'custom/ADD', null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `form_sql`
-- ----------------------------
DROP TABLE IF EXISTS `form_sql`;
CREATE TABLE `form_sql` (
  `ID` decimal(65,30) NOT NULL,
  `RUN_ID` decimal(65,30) DEFAULT NULL COMMENT '关联表单则为表单ID\n关联其它模块为其它模块的ID',
  `TYPE` varchar(2) DEFAULT NULL COMMENT 'SQL类型  1.查询  0.非查询',
  `SQL_TEXT` longtext COMMENT 'SQL语句',
  `RUN_ORDER` decimal(65,30) DEFAULT NULL COMMENT '排序',
  `RUN_GROUP` varchar(50) DEFAULT NULL COMMENT '根据这个分组\n1为保存表单数据\n2为获取初始化绑定数据',
  `KEY_TEXT` varchar(50) DEFAULT NULL COMMENT '映射键名',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='表单SQL队列表';

-- ----------------------------
--  Records of `form_sql`
-- ----------------------------
BEGIN;
INSERT INTO `form_sql` VALUES ('-109.000000000000000000000000000000', '-14.000000000000000000000000000000', '1', 'select t.title,\n       t.name,\n       t.class_name,\n       case when t.type = 1 then \'文本框\' when t.type = 2 then \'下拉列表框\' when t.type = 3 then \'日期输入框\' end type,\n       t.auth_code,\n       t.data_option,\n       t.value,\n       t.formatter,\n       t.validator_name,\n       t.validator_regex,\n       t.validator_message,\n       t.display_order\n  from grid_query t\n where t.id = #{id}             ', '1.000000000000000000000000000000', '5', 'RootMap'), ('-118.000000000000000000000000000000', '-10.000000000000000000000000000000', '1', 'select t.MAX_NUMBER from tb_auto_number t where t.table_name = \'FORM_WIDGET\'', '2.000000000000000000000000000000', '1', 'RootMap'), ('-126.000000000000000000000000000000', '-14.000000000000000000000000000000', '1', 'select t.MAX_NUMBER from tb_auto_number t where t.table_name = \'GRID_QUERY\'', '2.000000000000000000000000000000', '1', 'RootMap'), ('-103.000000000000000000000000000000', '-15.000000000000000000000000000000', '1', 'select form_id,title,name,class_name,method,url,page_type,html,template_name,show_group,save_group from form_info where form_id=#{id}', '1.000000000000000000000000000000', '1', 'RootMap'), ('-84.000000000000000000000000000000', '-12.000000000000000000000000000000', '1', 'select * from grid_field where id=#{id}', '1.000000000000000000000000000000', '2', 'RootMap'), ('-23.000000000000000000000000000000', '-10.000000000000000000000000000000', '0', 'delete from form_widget where id in (${id}) and id>0', '1.000000000000000000000000000000', '4', 'RootMap'), ('-30.000000000000000000000000000000', '-12.000000000000000000000000000000', '0', 'insert into grid_field(id,grid_id,title,field,width,rowspan,colspan,isson,display,format,align,onselect,frozen,auth_code,field_json,display_order,sortable) values(#{MAX_NUMBER},#{id},#{title},#{field},#{width,jdbcType=VARCHAR},#{rowspan,jdbcType=VARCHAR},#{colspan,jdbcType=VARCHAR},#{isson,jdbcType=VARCHAR},#{display,jdbcType=VARCHAR},#{format,jdbcType=VARCHAR},#{align,jdbcType=VARCHAR},#{onselect,jdbcType=VARCHAR},#{frozen,jdbcType=VARCHAR},#{auth_code,jdbcType=VARCHAR},#{field_json,jdbcType=VARCHAR},#{display_order,jdbcType=DECIMAL},#{sortable,jdbcType=VARCHAR})', '3.000000000000000000000000000000', '1', 'RootMap'), ('-93.000000000000000000000000000000', '-14.000000000000000000000000000000', '0', 'update grid_query set title=#{title},name=#{name},class_name=#{class_name,jdbcType=VARCHAR},type=#{type,jdbcType=VARCHAR},auth_code=#{auth_code,jdbcType=VARCHAR},data_option=#{data_option,jdbcType=VARCHAR},value=#{value,jdbcType=VARCHAR},formatter=#{formatter,jdbcType=VARCHAR},validator_name=#{validator_name,jdbcType=VARCHAR},validator_regex=#{validator_regex,jdbcType=VARCHAR},validator_message=#{validator_message,jdbcType=VARCHAR},display_order=#{display_order,jdbcType=DECIMAL} where id=#{id}', '1.000000000000000000000000000000', '3', 'RootMap'), ('-86.000000000000000000000000000000', '-12.000000000000000000000000000000', '0', 'delete from grid_field where id in (${id}) and id>0', '1.000000000000000000000000000000', '4', 'RootMap'), ('-22.000000000000000000000000000000', '-10.000000000000000000000000000000', '0', 'update form_widget set\ntitle=#{title},class_name=#{class_name},name=#{name},value=#{value},type=#{type},formatter=#{formatter},validator_name=#{validator_name},validator_regex=#{validator_regex},validator_message=#{validator_message},display_order=#{display_order},json=#{json},data_options=#{data_options} where id=#{id}', '1.000000000000000000000000000000', '3', 'RootMap'), ('-91.000000000000000000000000000000', '-14.000000000000000000000000000000', '0', 'insert into grid_query(id,grid_id,title,name,class_name,type,auth_code,data_option,value,formatter,validator_name,validator_regex,validator_message,display_order) values(#{MAX_NUMBER},#{id},#{title},#{name},#{class_name,jdbcType=VARCHAR},#{type,jdbcType=VARCHAR},#{auth_code,jdbcType=VARCHAR},#{data_option,jdbcType=VARCHAR},#{value,jdbcType=VARCHAR},#{formatter,jdbcType=VARCHAR},#{validator_name,jdbcType=VARCHAR},#{validator_regex,jdbcType=VARCHAR},#{validator_message,jdbcType=VARCHAR},#{display_order,jdbcType=DECIMAL})', '3.000000000000000000000000000000', '1', 'RootMap'), ('-28.000000000000000000000000000000', '-11.000000000000000000000000000000', '1', 'select * from grid_panel where grid_id=#{id}', '1.000000000000000000000000000000', '2', 'RootMap'), ('-92.000000000000000000000000000000', '-14.000000000000000000000000000000', '1', 'select * from grid_query where id=#{id}', '1.000000000000000000000000000000', '2', 'RootMap'), ('-94.000000000000000000000000000000', '-14.000000000000000000000000000000', '0', 'delete from grid_query where id in(${id}) and id > 0', '1.000000000000000000000000000000', '4', 'RootMap'), ('-11.000000000000000000000000000000', '-8.000000000000000000000000000000', '0', 'insert into form_info(form_id,title,name,class_name,method,url,page_type,html,template_name,show_group,save_group) values(#{MAX_NUMBER},#{title},#{name},#{class_name},#{method},#{url},#{page_type},#{html},#{template_name},#{show_group},#{save_group})', '3.000000000000000000000000000000', '1', 'RootMap'), ('-20.000000000000000000000000000000', '-10.000000000000000000000000000000', '1', 'select * from form_widget where id=#{id}', '1.000000000000000000000000000000', '2', 'RootMap'), ('-27.000000000000000000000000000000', '-11.000000000000000000000000000000', '0', 'insert into GRID_PANEL(grid_id,TITLE,FIT,LOADMSG,CLASS_NAME,SIGLESELECT,BORDER,PAGELIST,ONCLICKROW,ONDBCLICKROWLICK,ONLOADSUCCESS,SHOWFOOT,IFCHECK,DEFAULT_QUERY_JSON,ORDERBY_FIELD,ISLOAD,LOAD_TYPE,URL,SQL_TEXT,SQL_COUNT,HTML,DATA_OPTIONS) values(#{MAX_NUMBER},#{title},#{fit},#{loadmsg},#{class_name},#{sigleselect},#{border},#{pagelist},#{onclickrow},#{ondbclickrowlick},#{onloadsuccess},#{showfoot},#{ifcheck},#{default_query_json},#{orderby_field},#{isload},#{load_type},#{url},#{sql_text},#{sql_count},#{html},#{data_options})', '3.000000000000000000000000000000', '1', 'RootMap'), ('-87.000000000000000000000000000000', '-13.000000000000000000000000000000', '0', 'insert into grid_button(id,grid_id,name,iconcls,handle,url,auth_code,event_type,display,display_order,button_json) values(#{MAX_NUMBER},#{id},#{name},#{iconcls},#{handle},#{url},#{auth_code},#{event_type},#{display},#{display_order},#{button_json})', '3.000000000000000000000000000000', '1', 'RootMap'), ('-88.000000000000000000000000000000', '-13.000000000000000000000000000000', '1', 'select * from grid_button where id=#{id}', '1.000000000000000000000000000000', '2', 'RootMap'), ('-89.000000000000000000000000000000', '-13.000000000000000000000000000000', '0', 'update grid_button set name=#{name},iconcls=#{iconcls},handle=#{handle},url=#{url},auth_code=#{auth_code},event_type=#{event_type},display=#{display},\ndisplay_order=#{display_order},button_json=#{button_json} where id=#{id}', '1.000000000000000000000000000000', '3', 'RootMap'), ('-90.000000000000000000000000000000', '-13.000000000000000000000000000000', '0', 'delete from grid_button where id in(${id}) and id > 0', '1.000000000000000000000000000000', '4', 'RootMap'), ('-12.000000000000000000000000000000', '-9.000000000000000000000000000000', '0', 'insert into form_sql(id,run_id,type,sql_text,run_order,run_group,key_text) values(#{MAX_NUMBER},#{id},#{type},#{sql_text},#{run_order},#{run_group},#{key_text})', '3.000000000000000000000000000000', '1', 'RootMap'), ('-13.000000000000000000000000000000', '-10.000000000000000000000000000000', '0', 'insert into form_widget(id,form_id,title,class_name,name,value,type,formatter,validator_name,validator_regex,validator_message,display_order,json,data_options) values(#{MAX_NUMBER},#{id},#{title},#{class_name},#{name},#{value},#{type},#{formatter},#{validator_name},#{validator_regex},#{validator_message},#{display_order},#{json},#{data_options})', '3.000000000000000000000000000000', '1', 'RootMap'), ('-14.000000000000000000000000000000', '-8.000000000000000000000000000000', '1', 'select title,name,class_name,method,url,page_type,html,template_name,show_group,save_group from form_info where form_id=#{id}', '1.000000000000000000000000000000', '2', 'RootMap'), ('-24.000000000000000000000000000000', '-9.000000000000000000000000000000', '0', 'delete from form_sql where id=#{id} and id >0', '1.000000000000000000000000000000', '4', 'RootMap'), ('-85.000000000000000000000000000000', '-12.000000000000000000000000000000', '0', 'update grid_field set title= #{title},field= #{field},width= #{width,jdbcType=VARCHAR},rowspan= #{rowspan,jdbcType=VARCHAR},colspan= #{colspan,jdbcType=VARCHAR},isson= #{isson,jdbcType=VARCHAR},display= #{display,jdbcType=VARCHAR},format = #{format,jdbcType=VARCHAR},align= #{align,jdbcType=VARCHAR},onselect= #{onselect,jdbcType=VARCHAR},frozen = #{frozen,jdbcType=VARCHAR},auth_code= #{auth_code,jdbcType=VARCHAR},field_json= #{field_json,jdbcType=VARCHAR},display_order= #{display_order,jdbcType=DECIMAL},sortable= #{sortable,jdbcType=VARCHAR} where id = #{id}', '1.000000000000000000000000000000', '3', 'RootMap'), ('-25.000000000000000000000000000000', '-9.000000000000000000000000000000', '0', 'update form_sql set type=#{type},sql_text=#{sql_text},run_order=#{run_order},run_group=#{run_group},key_text=#{key_text} where id=#{id}', '1.000000000000000000000000000000', '3', 'RootMap'), ('-26.000000000000000000000000000000', '-9.000000000000000000000000000000', '1', 'select id,run_id,type,sql_text,run_order,run_group,key_text from form_sql where id=#{id}', '1.000000000000000000000000000000', '2', 'RootMap'), ('-29.000000000000000000000000000000', '-11.000000000000000000000000000000', '0', 'update grid_panel set title=#{title},fit=#{fit},loadmsg=#{loadmsg},class_name=#{class_name},sigleselect=#{sigleselect},border=#{border},pagelist=#{pagelist},\nonclickrow=#{onclickrow},ondbclickrowlick=#{ondbclickrowlick},onloadsuccess=#{onloadsuccess},showfoot=#{showfoot},ifcheck=#{ifcheck},default_query_json=#{default_query_json},orderby_field=#{orderby_field},isload=#{isload},load_type=#{load_type},url=#{url},sql_text=#{sql_text},sql_count=#{sql_count},html=#{html},data_options=#{data_options} where grid_id=#{id}', '1.000000000000000000000000000000', '3', 'RootMap'), ('-107.000000000000000000000000000000', '-11.000000000000000000000000000000', '0', 'delete from grid_query where grid_id in (${id}) and grid_id>0', '4.000000000000000000000000000000', '6', 'RootMap'), ('-106.000000000000000000000000000000', '-11.000000000000000000000000000000', '0', 'delete from grid_button where grid_id in (${id}) and grid_id > 0', '3.000000000000000000000000000000', '6', 'RootMap'), ('-105.000000000000000000000000000000', '-11.000000000000000000000000000000', '0', 'DELETE FROM GRID_FIELD WHERE GRID_ID IN (${id}) and grid_id > 0', '2.000000000000000000000000000000', '6', 'RootMap'), ('-104.000000000000000000000000000000', '-11.000000000000000000000000000000', '0', 'delete from grid_panel where grid_id in (${id}) and grid_id > 0', '1.000000000000000000000000000000', '6', 'RootMap'), ('-96.000000000000000000000000000000', '-16.000000000000000000000000000000', '1', 'select \np.grid_id,p.title,p.fit,p.loadmsg,p.class_name,p.sigleselect,\np.border,p.pagelist,p.onclickrow,p.ondbclickrowlick,p.onloadsuccess,\np.showfoot,p.ifcheck,p.default_query_json,p.orderby_field,\ncase when p.isload = 0 then \'不加载数据\' When p.ISLOAD =1 then \'加载数据\' end isload,\ncase when p.load_type=1 then \'采用配置SQL，自动分页插件\' when p.load_type = 2  then  \'采用配分页SQL，配置查询总条数\' when p.LOAD_TYPE = 3 then \'采用URL地址加载\' end load_type,\np.url,p.sql_text,p.sql_count,p.html,p.data_options \nfrom grid_panel p\nwhere p.grid_id=#{id}                                       ', '1.000000000000000000000000000000', '1', 'RootMap'), ('-99.000000000000000000000000000000', '-8.000000000000000000000000000000', '0', 'update form_info set title=#{title},name=#{name},class_name=#{class_name},method=#{method},url=#{url},page_type=#{page_type},html=#{html},template_name=#{template_name},show_group=#{show_group},save_group=#{save_group} where form_id=#{id}', '1.000000000000000000000000000000', '3', 'RootMap'), ('-102.000000000000000000000000000000', '-9.000000000000000000000000000000', '1', 'select t.run_id,\n       case when t.type=0 then \'非查询\' when t.type=1 then \'查询\' end type,\n       t.sql_text,\n       t.run_order,\n       t.run_group,\n       t.key_text\n  from form_sql t\n where t.id = #{id}     ', '1.000000000000000000000000000000', '5', 'RootMap'), ('-17.000000000000000000000000000000', '-8.000000000000000000000000000000', '0', 'delete from FORM_INFO WHERE FORM_ID in (${FORM_ID}) and form_id > 0', '1.000000000000000000000000000000', '7', 'RootMap'), ('-18.000000000000000000000000000000', '-8.000000000000000000000000000000', '0', 'delete from FORM_WIDGET WHERE FORM_ID in (${FORM_ID}) and form_id > 0', '2.000000000000000000000000000000', '7', 'RootMap'), ('-19.000000000000000000000000000000', '-8.000000000000000000000000000000', '0', 'DELETE FROM  FORM_SQL WHERE RUN_ID in (${FORM_ID}) and run_id>0', '3.000000000000000000000000000000', '7', 'RootMap'), ('-108.000000000000000000000000000000', '-13.000000000000000000000000000000', '1', 'select b.name,\n       b.iconcls,\n       b.handle,\n       b.url,\n       b.auth_code,\n       case\n         when b.event_type = 1 then\n          \'自定义点击事件handle\'\n         when b.event_type = 2 then\n          \'加载URL中的HTML片段\'\n         when b.event_type = 3 then\n          \'用IFRAME打开URL中的HTML页面\'\n         when b.event_type = 4 then\n          \'异步提交\'\n       end event_type,\n       case\n         when b.display = \'true\' then\n           \'显示\'\n         when b.display = \'false\' then\n           \'不显示\'\n       end display,\n       b.display_order,\n       b.button_json\n  from grid_button b\n where id = #{id}                             ', '1.000000000000000000000000000000', '5', 'RootMap'), ('-101.000000000000000000000000000000', '-10.000000000000000000000000000000', '1', 'select w.title,\n       w.class_name,\n       w.name,\n       w.value,\n       case when w.type=1 then \'文本框\' when w.type=2 then \'密码框\' when w.type=3 then \'下拉框\' when w.type=4 then \'日期框\' when w.type=5 then \'附件\' end type,\n       w.formatter,\n       w.validator_name,\n       w.validator_regex,\n       w.validator_message,\n       w.display_order,\n       w.json,\n       w.data_options\n  from form_widget w\n where w.id = #{id}              ', '1.000000000000000000000000000000', '5', 'RootMap'), ('-115.000000000000000000000000000000', '-9.000000000000000000000000000000', '0', 'update tb_auto_number t set t.max_number=t.max_number+1 where t.table_name = \'FORM_SQL\'', '1.000000000000000000000000000000', '1', 'RootMap'), ('-113.000000000000000000000000000000', '-8.000000000000000000000000000000', '0', 'update tb_auto_number t set t.max_number=t.max_number+1 where t.table_name = \'FORM_INFO\'', '1.000000000000000000000000000000', '1', 'RootMap'), ('-114.000000000000000000000000000000', '-8.000000000000000000000000000000', '1', 'select t.MAX_NUMBER from tb_auto_number t\r\nwhere t.table_name = \'FORM_INFO\'', '2.000000000000000000000000000000', '1', 'RootMap'), ('-116.000000000000000000000000000000', '-9.000000000000000000000000000000', '1', 'select t.MAX_NUMBER from tb_auto_number t\r\nwhere t.table_name = \'FORM_SQL\'', '2.000000000000000000000000000000', '1', 'RootMap'), ('-120.000000000000000000000000000000', '-11.000000000000000000000000000000', '1', 'select t.MAX_NUMBER from tb_auto_number t\r\nwhere t.table_name = \'GRID_PANEL\'', '2.000000000000000000000000000000', '1', 'RootMap'), ('-117.000000000000000000000000000000', '-10.000000000000000000000000000000', '0', 'update tb_auto_number t set t.max_number=t.max_number+1 where t.table_name = \'FORM_WIDGET\'', '1.000000000000000000000000000000', '1', 'RootMap'), ('-119.000000000000000000000000000000', '-11.000000000000000000000000000000', '0', 'update tb_auto_number t set t.max_number=t.max_number+1 where t.table_name = \'GRID_PANEL\'', '1.000000000000000000000000000000', '1', 'RootMap'), ('-121.000000000000000000000000000000', '-12.000000000000000000000000000000', '0', 'update tb_auto_number t set t.max_number=t.max_number+1 where t.table_name = \'GRID_FIELD\'', '1.000000000000000000000000000000', '1', 'RootMap'), ('-122.000000000000000000000000000000', '-12.000000000000000000000000000000', '1', 'select t.MAX_NUMBER from tb_auto_number t\r\nwhere t.table_name = \'GRID_FIELD\'', '2.000000000000000000000000000000', '1', 'RootMap'), ('-123.000000000000000000000000000000', '-13.000000000000000000000000000000', '0', 'update tb_auto_number t set t.max_number=t.max_number+1 where t.table_name = \'GRID_BUTTON\'', '1.000000000000000000000000000000', '1', 'RootMap'), ('-124.000000000000000000000000000000', '-13.000000000000000000000000000000', '1', 'select t.MAX_NUMBER from tb_auto_number t where t.table_name = \'GRID_BUTTON\'', '2.000000000000000000000000000000', '1', 'RootMap'), ('-125.000000000000000000000000000000', '-14.000000000000000000000000000000', '0', 'update tb_auto_number t set t.max_number=t.max_number+1 where t.table_name = \'GRID_QUERY\'', '1.000000000000000000000000000000', '1', 'RootMap');
COMMIT;

-- ----------------------------
--  Table structure for `form_widget`
-- ----------------------------
DROP TABLE IF EXISTS `form_widget`;
CREATE TABLE `form_widget` (
  `ID` decimal(65,30) NOT NULL,
  `FORM_ID` decimal(65,30) DEFAULT NULL COMMENT '表单编号',
  `TITLE` varchar(100) DEFAULT NULL COMMENT '控件标题',
  `CLASS_NAME` text COMMENT '控件样式',
  `NAME` varchar(100) DEFAULT NULL COMMENT '控件名称',
  `VALUE` varchar(100) DEFAULT NULL COMMENT '默认值',
  `TYPE` varchar(2) DEFAULT NULL COMMENT '控件类型 1.文本框  2.密码框  3.下拉列表框  4.日期输入框  5.附件',
  `FORMATTER` text COMMENT '格式化方法名',
  `VALIDATOR_NAME` varchar(100) DEFAULT NULL COMMENT '验证名称',
  `VALIDATOR_REGEX` text COMMENT '验证表达式',
  `VALIDATOR_MESSAGE` varchar(200) DEFAULT NULL COMMENT '验证提示信息',
  `JSON` text COMMENT '控件JSON',
  `DATA_OPTIONS` text COMMENT '自定义控件属性',
  `DISPLAY_ORDER` decimal(65,30) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='表单控件';

-- ----------------------------
--  Records of `form_widget`
-- ----------------------------
BEGIN;
INSERT INTO `form_widget` VALUES ('-119.000000000000000000000000000000', '-14.000000000000000000000000000000', 'validator_regex', null, 'validator_regex', null, '1', null, null, null, null, null, null, '10.000000000000000000000000000000'), ('-120.000000000000000000000000000000', '-14.000000000000000000000000000000', 'validator_message', null, 'validator_message', null, '1', null, null, null, null, null, null, '11.000000000000000000000000000000'), ('-118.000000000000000000000000000000', '-14.000000000000000000000000000000', 'validator_name', null, 'validator_name', null, '1', null, null, null, null, null, null, '9.000000000000000000000000000000'), ('-1.000000000000000000000000000000', '-8.000000000000000000000000000000', 'title', null, 'title', null, '1', null, null, null, null, null, 'required:true', '1.000000000000000000000000000000'), ('-2.000000000000000000000000000000', '-8.000000000000000000000000000000', 'name', null, 'name', null, '1', null, null, null, null, null, 'required:true', '2.000000000000000000000000000000'), ('-3.000000000000000000000000000000', '-8.000000000000000000000000000000', 'class_name', null, 'class_name', null, '1', null, null, null, null, null, null, '3.000000000000000000000000000000'), ('-4.000000000000000000000000000000', '-8.000000000000000000000000000000', 'method', null, 'method', null, '3', null, null, null, null, null, 'editable:false,data:[{ text:\'get\', value:\'get\'},{ text:\'post\', value:\'post\'}]', '4.000000000000000000000000000000'), ('-5.000000000000000000000000000000', '-8.000000000000000000000000000000', 'URL', null, 'url', null, '1', null, null, null, null, null, null, '8.000000000000000000000000000000'), ('-6.000000000000000000000000000000', '-8.000000000000000000000000000000', 'page_type', null, 'page_type', null, '3', null, null, null, null, null, 'editable:false,data:[{ text:\'ADD\', value:\'ADD\'},{ text:\'ADD_PAGE\', value:\'ADD_PAGE\'},{ text:\'EDIT\', value:\'EDIT\'},{ text:\'EDIT_PAGE\', value:\'EDIT_PAGE\'},{ text:\'DETAIL\', value:\'DETAIL\'},{ text:\'DETAIL_PAGE\', value:\'DETAIL_PAGE\'}]', '5.000000000000000000000000000000'), ('-7.000000000000000000000000000000', '-8.000000000000000000000000000000', 'html', null, 'html', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '9.000000000000000000000000000000'), ('-8.000000000000000000000000000000', '-8.000000000000000000000000000000', 'template_name', null, 'template_name', null, '1', null, null, null, null, null, null, '5.000000000000000000000000000000'), ('-9.000000000000000000000000000000', '-8.000000000000000000000000000000', 'show_group', null, 'show_group', null, '1', null, null, null, null, null, null, '6.000000000000000000000000000000'), ('-10.000000000000000000000000000000', '-8.000000000000000000000000000000', 'save_group', null, 'save_group', null, '1', null, null, null, null, null, null, '7.000000000000000000000000000000'), ('-11.000000000000000000000000000000', '-15.000000000000000000000000000000', 'page_type', null, 'page_type', null, '1', null, null, null, null, null, null, '5.000000000000000000000000000000'), ('-12.000000000000000000000000000000', '-11.000000000000000000000000000000', 'border', null, 'border', 'false', '3', null, null, null, null, null, 'editable:false,data:[{ text:\'true\', value:\'true\'},{ text:\'false\', value:\'false\'}]', '8.000000000000000000000000000000'), ('-13.000000000000000000000000000000', '-11.000000000000000000000000000000', 'ondbclickrowlick', null, 'ondbclickrowlick', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '18.000000000000000000000000000000'), ('-14.000000000000000000000000000000', '-11.000000000000000000000000000000', 'onclickrow', null, 'onclickrow', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '17.000000000000000000000000000000'), ('-15.000000000000000000000000000000', '-11.000000000000000000000000000000', 'sigleselect', null, 'sigleselect', 'true', '3', null, null, null, null, null, 'editable:false,data:[{ text:\'true\', value:\'true\'},{ text:\'false\', value:\'false\'}]', '6.000000000000000000000000000000'), ('-16.000000000000000000000000000000', '-11.000000000000000000000000000000', 'fit', null, 'fit', 'true', '3', null, null, null, null, null, 'editable:false,data:[{ text:\'true\', value:\'true\'},{ text:\'false\', value:\'false\'}]', '2.000000000000000000000000000000'), ('-17.000000000000000000000000000000', '-11.000000000000000000000000000000', 'title', null, 'title', null, '1', null, null, null, null, null, 'required:true', '1.000000000000000000000000000000'), ('-18.000000000000000000000000000000', '-11.000000000000000000000000000000', 'SQL_count', null, 'sql_count', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '16.000000000000000000000000000000'), ('-19.000000000000000000000000000000', '-11.000000000000000000000000000000', 'class_name', null, 'class_name', null, '1', null, null, null, null, null, null, '5.000000000000000000000000000000'), ('-20.000000000000000000000000000000', '-11.000000000000000000000000000000', 'loadmsg', null, 'loadmsg', '正在加载...', '1', null, null, null, null, null, null, '3.000000000000000000000000000000'), ('-21.000000000000000000000000000000', '-11.000000000000000000000000000000', 'pagelist', null, 'pagelist', null, '1', null, null, null, null, null, null, '9.000000000000000000000000000000'), ('-22.000000000000000000000000000000', '-11.000000000000000000000000000000', 'sql_text', null, 'sql_text', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '15.000000000000000000000000000000'), ('-23.000000000000000000000000000000', '-15.000000000000000000000000000000', 'show_group', null, 'show_group', null, '1', null, null, null, null, null, null, '7.000000000000000000000000000000'), ('-24.000000000000000000000000000000', '-11.000000000000000000000000000000', 'html', null, 'html', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '20.000000000000000000000000000000'), ('-25.000000000000000000000000000000', '-11.000000000000000000000000000000', 'data_options', null, 'data_options', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '21.000000000000000000000000000000'), ('-26.000000000000000000000000000000', '-11.000000000000000000000000000000', 'load_type', null, 'load_type', '1', '3', null, null, null, null, null, 'editable:false,width:250,\ndata:[{\n      text:\'采用配置 SQL，自动分页插件\',\n      value:\'1\'\n},{\n      text:\'采用配 分页SQL，配置查询总条数\',\n      value:\'2\'\n},{\n      text:\'采用URL地址加载\',\n      value:\'3\'\n}]', '13.000000000000000000000000000000'), ('-27.000000000000000000000000000000', '-13.000000000000000000000000000000', 'name', null, 'name', null, '1', null, null, null, null, null, 'required:true', '1.000000000000000000000000000000'), ('-67.000000000000000000000000000000', '-13.000000000000000000000000000000', 'iconcls', null, 'iconcls', null, '1', null, null, null, null, null, null, '5.000000000000000000000000000000'), ('-68.000000000000000000000000000000', '-13.000000000000000000000000000000', 'handle', null, 'handle', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '7.000000000000000000000000000000'), ('-69.000000000000000000000000000000', '-13.000000000000000000000000000000', 'url', null, 'url', null, '1', null, null, null, null, null, null, '8.000000000000000000000000000000'), ('-70.000000000000000000000000000000', '-13.000000000000000000000000000000', 'auth_code', null, 'auth_code', null, '1', null, null, null, null, null, null, '4.000000000000000000000000000000'), ('-71.000000000000000000000000000000', '-13.000000000000000000000000000000', 'event_type', null, 'event_type', '2', '3', null, null, null, null, null, 'editable:false,width:200,data:[{      text:\'自定义点击事件handle\',      value:\'1\',},{      text:\'加载URL中的HTML片段\',      value:\'2\'},{      text:\'用IFRAME打开URL中的HTML页面\',      value:\'3\'},{      text:\'异步提交\',      value:\'4\'}]', '6.000000000000000000000000000000'), ('-72.000000000000000000000000000000', '-13.000000000000000000000000000000', 'display', null, 'display', 'true', '3', null, null, null, null, null, 'editable:false,data:[{      text:\'true\',      value:\'true\'},{      text:\'false\',      value:\'false\'}]', '2.000000000000000000000000000000'), ('-73.000000000000000000000000000000', '-13.000000000000000000000000000000', 'display_order', null, 'display_order', null, '1', null, 'number', '^[0-9]+$', '只能输入数字', null, 'validType:\'number\'', '3.000000000000000000000000000000'), ('-74.000000000000000000000000000000', '-13.000000000000000000000000000000', 'button_json', null, 'button_json', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '9.000000000000000000000000000000'), ('-86.000000000000000000000000000000', '-15.000000000000000000000000000000', 'template_name', null, 'template_name', null, '1', null, null, null, null, null, null, '6.000000000000000000000000000000'), ('-87.000000000000000000000000000000', '-15.000000000000000000000000000000', 'name', null, 'name', null, '1', null, null, null, null, null, null, '3.000000000000000000000000000000'), ('-88.000000000000000000000000000000', '-15.000000000000000000000000000000', 'title', null, 'title', null, '1', null, null, null, null, null, null, '2.000000000000000000000000000000'), ('-89.000000000000000000000000000000', '-15.000000000000000000000000000000', 'class_name', null, 'class_name', null, '1', null, null, null, null, null, null, '4.000000000000000000000000000000'), ('-90.000000000000000000000000000000', '-15.000000000000000000000000000000', 'URL', null, 'url', null, '1', null, null, null, null, null, null, '9.000000000000000000000000000000'), ('-91.000000000000000000000000000000', '-15.000000000000000000000000000000', 'method', null, 'method', null, '1', null, null, null, null, null, null, '5.000000000000000000000000000000'), ('-92.000000000000000000000000000000', '-15.000000000000000000000000000000', 'save_group', null, 'save_group', null, '1', null, null, null, null, null, null, '8.000000000000000000000000000000'), ('-93.000000000000000000000000000000', '-15.000000000000000000000000000000', 'form_id', null, 'form_id', null, '1', null, null, null, null, null, null, '1.000000000000000000000000000000'), ('-85.000000000000000000000000000000', '-15.000000000000000000000000000000', 'html', null, 'html', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '10.000000000000000000000000000000'), ('-94.000000000000000000000000000000', '-16.000000000000000000000000000000', 'default_query_json', null, 'default_query_json', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '1.000000000000000000000000000000'), ('-95.000000000000000000000000000000', '-16.000000000000000000000000000000', 'url', null, 'url', null, '1', null, null, null, null, null, null, '1.000000000000000000000000000000'), ('-96.000000000000000000000000000000', '-16.000000000000000000000000000000', 'orderby_field', null, 'orderby_field', null, '1', null, null, null, null, null, null, '1.000000000000000000000000000000'), ('-97.000000000000000000000000000000', '-16.000000000000000000000000000000', 'onloadsuccess', null, 'onloadsuccess', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '1.000000000000000000000000000000'), ('-98.000000000000000000000000000000', '-16.000000000000000000000000000000', 'isload', null, 'isload', '1', '3', null, null, null, null, null, 'editable:false,data:[{      text:\'加载数据\',      value:\'1\'},{      text:\'不加载数据\',      value:\'0\'}]', '4.000000000000000000000000000000'), ('-99.000000000000000000000000000000', '-16.000000000000000000000000000000', 'data_options', null, 'data_options', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '2.000000000000000000000000000000'), ('-100.000000000000000000000000000000', '-16.000000000000000000000000000000', 'pagelist', null, 'pagelist', null, '1', null, null, null, null, null, null, '9.000000000000000000000000000000'), ('-101.000000000000000000000000000000', '-16.000000000000000000000000000000', 'loadmsg', null, 'loadmsg', null, '1', null, null, null, null, null, null, '3.000000000000000000000000000000'), ('-102.000000000000000000000000000000', '-16.000000000000000000000000000000', 'SQL_TEXT', null, 'sql_text', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '1.000000000000000000000000000000'), ('-103.000000000000000000000000000000', '-16.000000000000000000000000000000', 'html', null, 'html', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '2.000000000000000000000000000000'), ('-104.000000000000000000000000000000', '-16.000000000000000000000000000000', 'class_name', null, 'class_name', null, '1', null, null, null, null, null, null, '5.000000000000000000000000000000'), ('-105.000000000000000000000000000000', '-16.000000000000000000000000000000', 'sigleselect', null, 'sigleselect', 'true', '1', null, null, null, null, null, null, '6.000000000000000000000000000000'), ('-106.000000000000000000000000000000', '-16.000000000000000000000000000000', 'fit', null, 'fit', 'true', '1', null, null, null, null, null, null, '2.000000000000000000000000000000'), ('-107.000000000000000000000000000000', '-16.000000000000000000000000000000', 'onclickrow', null, 'onclickrow', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '1.000000000000000000000000000000'), ('-108.000000000000000000000000000000', '-16.000000000000000000000000000000', 'border', null, 'border', 'false', '1', null, null, null, null, null, null, '8.000000000000000000000000000000'), ('-109.000000000000000000000000000000', '-16.000000000000000000000000000000', 'ondbclickrowlick', null, 'ondbclickrowlick', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '1.000000000000000000000000000000'), ('-110.000000000000000000000000000000', '-16.000000000000000000000000000000', 'ifcheck', null, 'ifcheck', 'true', '3', null, null, null, null, null, 'editable:false,data:[{      text:\'true\',      value:\'true\'},{      text:\'false\',      value:\'false\'}]', '7.000000000000000000000000000000'), ('-111.000000000000000000000000000000', '-16.000000000000000000000000000000', 'showfoot', null, 'showfoot', null, '1', null, null, null, null, null, null, '1.000000000000000000000000000000'), ('-112.000000000000000000000000000000', '-16.000000000000000000000000000000', 'load_type', null, 'load_type', '1', '3', null, null, null, null, null, 'editable:false,width:250,data:[{      text:\'采用配置 SQL，自动分页插件\',      value:\'1\'},{      text:\'采用配 分页SQL，配置查询总条数\',      value:\'2\'},{      text:\'采用URL地址加载\',      value:\'3\'}]', '1.000000000000000000000000000000'), ('-113.000000000000000000000000000000', '-16.000000000000000000000000000000', 'title', null, 'title', null, '1', null, null, null, null, null, null, '1.000000000000000000000000000000'), ('-114.000000000000000000000000000000', '-16.000000000000000000000000000000', 'SQL_count', null, 'sql_count', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '1.000000000000000000000000000000'), ('-115.000000000000000000000000000000', '-16.000000000000000000000000000000', 'grid_id', null, 'grid_id', null, '1', null, null, null, null, null, null, '1.000000000000000000000000000000'), ('-28.000000000000000000000000000000', '-9.000000000000000000000000000000', 'sql_text', null, 'sql_text', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100,required:true', '5.000000000000000000000000000000'), ('-29.000000000000000000000000000000', '-9.000000000000000000000000000000', 'run_order', null, 'run_order', null, '1', null, 'number', '^[0-9]+$', '只能输入数字', null, 'validType:\'number\'', '2.000000000000000000000000000000'), ('-30.000000000000000000000000000000', '-9.000000000000000000000000000000', 'run_group', null, 'run_group', null, '1', null, null, null, null, null, 'required:true', '3.000000000000000000000000000000'), ('-31.000000000000000000000000000000', '-9.000000000000000000000000000000', 'type', null, 'type', '0', '3', null, null, null, null, null, 'editable:false,\ndata:[{\n      text:\'非查询\',\n      value:\'0\'\n},{\n      text:\'查询\',\n      value:\'1\'\n}]', '1.000000000000000000000000000000'), ('-32.000000000000000000000000000000', '-9.000000000000000000000000000000', 'key_text', null, 'key_text', 'RootMap', '1', null, null, null, null, null, 'required:true', '4.000000000000000000000000000000'), ('-47.000000000000000000000000000000', '-11.000000000000000000000000000000', 'ifcheck', null, 'ifcheck', 'true', '3', null, null, null, null, null, 'editable:false,\ndata:[{\n      text:\'true\',\n      value:\'true\'\n},{\n      text:\'false\',\n      value:\'false\'\n}]', '7.000000000000000000000000000000'), ('-46.000000000000000000000000000000', '-11.000000000000000000000000000000', 'showfoot', null, 'showfoot', 'false', '3', null, null, null, null, null, 'editable:false,data:[{ text:\'true\', value:\'true\'},{ text:\'false\', value:\'false\'}]', '10.000000000000000000000000000000'), ('-45.000000000000000000000000000000', '-11.000000000000000000000000000000', 'onloadsuccess', null, 'onloadsuccess', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '19.000000000000000000000000000000'), ('-50.000000000000000000000000000000', '-11.000000000000000000000000000000', 'isload', null, 'isload', '1', '3', null, null, null, null, null, 'editable:false,\ndata:[{\n      text:\'加载数据\',\n      value:\'1\'\n},{\n      text:\'不加载数据\',\n      value:\'0\'\n}]', '4.000000000000000000000000000000'), ('-49.000000000000000000000000000000', '-11.000000000000000000000000000000', 'orderby_field', null, 'orderby_field', null, '1', null, null, null, null, null, null, '11.000000000000000000000000000000'), ('-48.000000000000000000000000000000', '-11.000000000000000000000000000000', 'default_query_json', null, 'default_query_json', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '12.000000000000000000000000000000'), ('-51.000000000000000000000000000000', '-11.000000000000000000000000000000', 'url', null, 'url', null, '1', null, null, null, null, null, null, '14.000000000000000000000000000000'), ('-59.000000000000000000000000000000', '-12.000000000000000000000000000000', 'format', null, 'format', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '10.000000000000000000000000000000'), ('-58.000000000000000000000000000000', '-12.000000000000000000000000000000', 'display', null, 'display', 'true', '3', null, null, null, null, null, 'editable:false,data:[{ text:\'true\', value:\'true\'},{ text:\'false\', value:\'false\'}]', '9.000000000000000000000000000000'), ('-57.000000000000000000000000000000', '-12.000000000000000000000000000000', 'isson', null, 'isson', 'false', '3', null, null, null, null, null, 'editable:false,data:[{ text:\'true\', value:\'true\'},{ text:\'false\', value:\'false\'}]', '8.000000000000000000000000000000'), ('-56.000000000000000000000000000000', '-12.000000000000000000000000000000', 'display_order', null, 'display_order', null, '1', null, 'number', '^[0-9]+$', '只能输入数字', null, 'validType:\'number\'', '7.000000000000000000000000000000'), ('-55.000000000000000000000000000000', '-12.000000000000000000000000000000', 'colspan', null, 'colspan', null, '1', null, null, null, null, null, null, '5.000000000000000000000000000000'), ('-54.000000000000000000000000000000', '-12.000000000000000000000000000000', 'rowspan', null, 'rowspan', null, '1', null, null, null, null, null, null, '4.000000000000000000000000000000'), ('-53.000000000000000000000000000000', '-12.000000000000000000000000000000', 'width', null, 'width', null, '1', null, null, null, null, null, null, '3.000000000000000000000000000000'), ('-52.000000000000000000000000000000', '-12.000000000000000000000000000000', 'field', null, 'field', null, '1', null, null, null, null, null, 'required:true', '2.000000000000000000000000000000'), ('-65.000000000000000000000000000000', '-12.000000000000000000000000000000', 'title', null, 'title', null, '1', null, null, null, null, null, 'required:true', '1.000000000000000000000000000000'), ('-64.000000000000000000000000000000', '-12.000000000000000000000000000000', 'field_json', null, 'field_json', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '15.000000000000000000000000000000'), ('-63.000000000000000000000000000000', '-12.000000000000000000000000000000', 'auth_code', null, 'auth_code', null, '1', null, null, null, null, null, null, '13.000000000000000000000000000000'), ('-62.000000000000000000000000000000', '-12.000000000000000000000000000000', 'frozen', null, 'frozen', 'false', '3', null, null, null, null, null, 'editable:false,data:[{ text:\'true\', value:\'true\'},{ text:\'false\', value:\'false\'}]', '11.000000000000000000000000000000'), ('-61.000000000000000000000000000000', '-12.000000000000000000000000000000', 'onselect', null, 'onselect', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '14.000000000000000000000000000000'), ('-60.000000000000000000000000000000', '-12.000000000000000000000000000000', 'align', null, 'align', 'center', '3', null, null, null, null, null, 'editable:false,data:[{ text:\'right\', value:\'right\'},{ text:\'center\', value:\'center\'},{ text:\'left\', value:\'left\'}]', '12.000000000000000000000000000000'), ('-75.000000000000000000000000000000', '-14.000000000000000000000000000000', 'title', null, 'title', null, '1', null, null, null, null, null, 'required:true', '1.000000000000000000000000000000'), ('-77.000000000000000000000000000000', '-14.000000000000000000000000000000', 'name', null, 'name', null, '1', null, null, null, null, null, 'required:true', '2.000000000000000000000000000000'), ('-78.000000000000000000000000000000', '-14.000000000000000000000000000000', 'class_name', null, 'class_name', null, '1', null, null, null, null, null, null, '3.000000000000000000000000000000'), ('-79.000000000000000000000000000000', '-14.000000000000000000000000000000', 'display_order', null, 'display_order', null, '1', null, 'number', '^[0-9]+$', '只能输入数字', null, 'validType:\'number\'', '12.000000000000000000000000000000'), ('-80.000000000000000000000000000000', '-14.000000000000000000000000000000', 'type', null, 'type', null, '3', null, null, null, null, null, 'editable:false,data:[{      text:\'文本框\',      value:\'1\'},{      text:\'下拉框\',      value:\'3\'},{      text:\'日期框\',      value:\'4\'}]', '4.000000000000000000000000000000'), ('-81.000000000000000000000000000000', '-14.000000000000000000000000000000', 'auth_code', null, 'auth_code', null, '1', null, null, null, null, null, null, '5.000000000000000000000000000000'), ('-83.000000000000000000000000000000', '-14.000000000000000000000000000000', 'data_option', null, 'data_option', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '6.000000000000000000000000000000'), ('-84.000000000000000000000000000000', '-14.000000000000000000000000000000', 'value', null, 'value', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '7.000000000000000000000000000000'), ('-33.000000000000000000000000000000', '-10.000000000000000000000000000000', 'title', null, 'title', null, '1', null, null, null, null, null, 'required:true', '1.000000000000000000000000000000'), ('-34.000000000000000000000000000000', '-10.000000000000000000000000000000', 'class_name', null, 'class_name', null, '1', null, null, null, null, null, null, '3.000000000000000000000000000000'), ('-35.000000000000000000000000000000', '-10.000000000000000000000000000000', 'name', null, 'name', null, '1', null, null, null, null, null, 'required:true', '2.000000000000000000000000000000'), ('-36.000000000000000000000000000000', '-10.000000000000000000000000000000', 'value', null, 'value', null, '1', null, null, null, null, null, null, '4.000000000000000000000000000000'), ('-37.000000000000000000000000000000', '-10.000000000000000000000000000000', 'type', null, 'type', '1', '3', null, null, null, null, null, 'editable:false,\ndata:[{\n      text:\'文本框\',\n      value:\'1\',\n},{\n      text:\'密码框\',\n      value:\'2\'\n},{\n      text:\'下拉框\',\n      value:\'3\'\n},{\n      text:\'日期框\',\n      value:\'4\'\n},{\n      text:\'附件\',\n      value:\'5\'\n}]', '5.000000000000000000000000000000'), ('-38.000000000000000000000000000000', '-10.000000000000000000000000000000', 'formatter', null, 'formatter', null, '1', null, null, null, null, null, null, '6.000000000000000000000000000000'), ('-39.000000000000000000000000000000', '-10.000000000000000000000000000000', 'validator_name', null, 'validator_name', null, '1', null, null, null, null, null, null, '8.000000000000000000000000000000'), ('-40.000000000000000000000000000000', '-10.000000000000000000000000000000', 'validator_regex', null, 'validator_regex', null, '1', null, null, null, null, null, null, '9.000000000000000000000000000000'), ('-41.000000000000000000000000000000', '-10.000000000000000000000000000000', 'validator_message', null, 'validator_message', null, '1', null, null, null, null, null, null, '10.000000000000000000000000000000'), ('-42.000000000000000000000000000000', '-10.000000000000000000000000000000', 'display_order', null, 'display_order', null, '1', null, 'order', '^[0-9]{1,2}$', '只允许输入数字,1到2位字符', null, 'validType:\'order\'', '7.000000000000000000000000000000'), ('-43.000000000000000000000000000000', '-10.000000000000000000000000000000', 'json', null, 'json', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '12.000000000000000000000000000000'), ('-44.000000000000000000000000000000', '-10.000000000000000000000000000000', 'data_options', null, 'data_options', null, '1', null, null, null, null, null, 'multiline:true,width:300,height:100', '11.000000000000000000000000000000'), ('-66.000000000000000000000000000000', '-12.000000000000000000000000000000', 'sortable', null, 'sortable', 'true', '3', null, null, null, null, null, 'editable:false,data:[{ text:\'true\', value:\'true\'},{ text:\'false\', value:\'false\'}]', '6.000000000000000000000000000000'), ('-117.000000000000000000000000000000', '-14.000000000000000000000000000000', 'formatter', null, 'formatter', null, '1', null, null, null, null, null, null, '8.000000000000000000000000000000');
COMMIT;

-- ----------------------------
--  Table structure for `grid_button`
-- ----------------------------
DROP TABLE IF EXISTS `grid_button`;
CREATE TABLE `grid_button` (
  `ID` decimal(65,30) NOT NULL,
  `GRID_ID` decimal(65,30) DEFAULT NULL COMMENT '对应的网格id',
  `NAME` varchar(20) DEFAULT NULL COMMENT '按钮的名称',
  `ICONCLS` varchar(30) DEFAULT NULL COMMENT '按钮的背景图',
  `HANDLE` varchar(200) DEFAULT NULL COMMENT '按钮的点击事件',
  `URL` text COMMENT 'URL',
  `AUTH_CODE` varchar(30) DEFAULT NULL COMMENT '按钮权限',
  `EVENT_TYPE` varchar(10) DEFAULT NULL COMMENT '事件类型: 1 自定义点击事件  2  加载URL中的 HTML片段 3  用IFRAME打开URL中的HTML页面  4 删除记录 ',
  `DISPLAY` varchar(20) DEFAULT NULL COMMENT 'true:显示  false:不显示',
  `DISPLAY_ORDER` varchar(10) DEFAULT NULL COMMENT '排序',
  `BUTTON_JSON` text COMMENT '按钮数据JSON',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='网格按钮';

-- ----------------------------
--  Records of `grid_button`
-- ----------------------------
BEGIN;
INSERT INTO `grid_button` VALUES ('-1.000000000000000000000000000000', '-6.000000000000000000000000000000', '创建表单', 'icon-add', null, '/admin/form/view/-8', null, '2', 'true', '1', null), ('-3.000000000000000000000000000000', '-6.000000000000000000000000000000', '查看控件', 'icon-search', '{sigle:true}', '/admin/grid/view/-7?id=#{FORM_ID}', null, '3', 'true', '3', null), ('-4.000000000000000000000000000000', '-6.000000000000000000000000000000', '删除表单', 'icon-remove', '{sigle:false}', '/admin/form/submit/-8?saveGroup=7&FORM_ID=#{FORM_ID}', null, '4', 'true', '5', null), ('-6.000000000000000000000000000000', '-7.000000000000000000000000000000', '添加控件', 'icon-add', 'function(){\nvar id=getQueryString(\'id\');\nloadHtml(\'../../form/view/-10?id=\'+id, \'添加控件\');\n}', null, null, '1', 'true', '1', null), ('-9.000000000000000000000000000000', '-8.000000000000000000000000000000', '添加SQL', 'icon-add', 'function(){\nvar id=getQueryString(\'id\');\nloadHtml(\'../../form/view/-9?id=\'+id, \'添加SQL\');\n}', null, null, '1', 'true', '1', null), ('-10.000000000000000000000000000000', '-8.000000000000000000000000000000', '删除SQL', 'icon-remove', null, '/admin/form/submit/-9?id=#{ID}&saveGroup=4', null, '4', 'true', '3', null), ('-11.000000000000000000000000000000', '-8.000000000000000000000000000000', '修改SQL', 'icon-edit', '{sigle:true}', '/admin/form/view/-9?id=#{ID}&showGroup=2&saveGroup=3', null, '2', 'true', '2', null), ('-17.000000000000000000000000000000', '-9.000000000000000000000000000000', '查看查询条件', 'icon-search', '{sigle:true}', '/admin/grid/view/-12?id=#{GRID_ID}', null, '3', 'true', '4', null), ('-7.000000000000000000000000000000', '-7.000000000000000000000000000000', '修改控件', 'icon-edit', '{sigle:true}', '/admin/form/view/-10?id=#{ID}&showGroup=2&saveGroup=3', null, '2', 'true', '2', null), ('-8.000000000000000000000000000000', '-7.000000000000000000000000000000', '删除控件', 'icon-remove', null, '/admin/form/submit/-10?id=#{ID}&saveGroup=4', null, '4', 'true', '3', null), ('-12.000000000000000000000000000000', '-9.000000000000000000000000000000', '修改配置', 'icon-edit', '{sigle:true}', '/admin/form/view/-11?id=#{GRID_ID}&showGroup=2&saveGroup=3', null, '2', 'true', '2', null), ('-13.000000000000000000000000000000', '-9.000000000000000000000000000000', '查看字段', 'icon-search', '{sigle:true}', '/admin/grid/view/-10?id=#{GRID_ID}', null, '3', 'true', '3', null), ('-14.000000000000000000000000000000', '-9.000000000000000000000000000000', '删除配置', 'icon-remove', '{sigle:false}', '/admin/form/submit/-11?saveGroup=6&id=#{GRID_ID}', null, '4', 'true', '5', null), ('-15.000000000000000000000000000000', '-9.000000000000000000000000000000', '查看按钮', 'icon-search', '{sigle:true}', '/admin/grid/view/-11?id=#{GRID_ID}', null, '3', 'true', '4', null), ('-16.000000000000000000000000000000', '-9.000000000000000000000000000000', '创建列表配置', 'icon-add', null, '/admin/form/view/-11', null, '2', 'true', '1', null), ('-5.000000000000000000000000000000', '-6.000000000000000000000000000000', '修改表单', 'icon-edit', '{sigle:true}', '/admin/form/view/-8?id=#{FORM_ID}&showGroup=2&saveGroup=3', null, '2', 'true', '2', null), ('-2.000000000000000000000000000000', '-6.000000000000000000000000000000', '查看SQL', 'icon-search', '{sigle:true}', '/admin/grid/view/-8?id=#{FORM_ID}', null, '3', 'true', '4', null), ('-18.000000000000000000000000000000', '-10.000000000000000000000000000000', '添加字段', 'icon-add', 'function(){\nvar id=getQueryString(\'id\');\nloadHtml(\'../../form/view/-12?id=\'+id, \'添加字段\');\n}', null, null, '1', 'true', '1', null), ('-19.000000000000000000000000000000', '-10.000000000000000000000000000000', '修改字段', 'icon-edit', '{sigle:true}', '/admin/form/view/-12?id=#{ID}&showGroup=2&saveGroup=3', null, '2', 'true', '2', null), ('-20.000000000000000000000000000000', '-10.000000000000000000000000000000', '删除字段', 'icon-remove', null, '/admin/form/submit/-12?id=#{ID}&saveGroup=4', null, '4', 'true', '3', null), ('-23.000000000000000000000000000000', '-11.000000000000000000000000000000', '删除按钮', 'icon-remove', null, '/admin/form/submit/-13?id=#{ID}&saveGroup=4', null, '4', 'true', '3', null), ('-22.000000000000000000000000000000', '-11.000000000000000000000000000000', '修改按钮', 'icon-edit', '{sigle:true}', '/admin/form/view/-13?id=#{ID}&showGroup=2&saveGroup=3', null, '2', 'true', '2', null), ('-21.000000000000000000000000000000', '-11.000000000000000000000000000000', '添加按钮', 'icon-add', 'function(){\nvar id=getQueryString(\'id\');\nloadHtml(\'../../form/view/-13?id=\'+id, \'添加按钮\');\n}', null, null, '1', 'true', '1', null), ('-26.000000000000000000000000000000', '-12.000000000000000000000000000000', '删除查询条件', 'icon-remove', null, '/admin/form/submit/-14?id=#{ID}&saveGroup=4', null, '4', 'true', '3', null), ('-25.000000000000000000000000000000', '-12.000000000000000000000000000000', '修改查询条件', 'icon-edit', '{sigle:true}', '/admin/form/view/-14?id=#{ID}&showGroup=2&saveGroup=3', null, '2', 'true', '2', null), ('-24.000000000000000000000000000000', '-12.000000000000000000000000000000', '添加查询条件', 'icon-add', 'function(){\nvar id=getQueryString(\'id\');\nloadHtml(\'../../form/view/-14?id=\'+id, \'添加查询条件\');\n}', null, null, '1', 'true', '1', null), ('-27.000000000000000000000000000000', '-9.000000000000000000000000000000', '刷新缓存', 'icon-reload', '{sigle:true,type:\'get\'}', '/admin/grid/reloadCache/#{GRID_ID}/0', null, '4', 'true', '7', null), ('-45.000000000000000000000000000000', '-6.000000000000000000000000000000', '刷新缓存', 'icon-reload', '{sigle:true,type:\'get\'}', '/admin/form/reloadCache/#{FORM_ID}', null, '4', 'true', '6', null);
COMMIT;

-- ----------------------------
--  Table structure for `grid_field`
-- ----------------------------
DROP TABLE IF EXISTS `grid_field`;
CREATE TABLE `grid_field` (
  `ID` decimal(65,30) NOT NULL,
  `GRID_ID` decimal(65,30) DEFAULT NULL COMMENT '对应的网格id',
  `TITLE` varchar(20) DEFAULT NULL COMMENT '显示的表头标题',
  `FIELD` varchar(20) DEFAULT NULL COMMENT '对应的后台提供数据的字段名',
  `WIDTH` varchar(10) DEFAULT NULL COMMENT '字段宽',
  `ROWSPAN` varchar(2) DEFAULT NULL COMMENT '所占行',
  `COLSPAN` varchar(2) DEFAULT NULL COMMENT '所占列',
  `ISSON` varchar(20) DEFAULT NULL COMMENT '是否是子表头',
  `DISPLAY` varchar(10) DEFAULT NULL COMMENT '是否显示',
  `FORMAT` text COMMENT '格式化方法名',
  `ALIGN` varchar(20) DEFAULT NULL COMMENT '字段位置',
  `ONSELECT` varchar(50) DEFAULT NULL COMMENT '下拉框 日期框等 选择后的事件',
  `FROZEN` varchar(30) DEFAULT NULL COMMENT '是否锁定列',
  `AUTH_CODE` varchar(30) DEFAULT NULL COMMENT '字段权限',
  `FIELD_JSON` text COMMENT '网格字段数据JSON',
  `DISPLAY_ORDER` decimal(65,30) DEFAULT NULL COMMENT '字段顺序',
  `SORTABLE` varchar(10) DEFAULT NULL COMMENT '是否排序',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='网格列表字段';

-- ----------------------------
--  Records of `grid_field`
-- ----------------------------
BEGIN;
INSERT INTO `grid_field` VALUES ('-46.000000000000000000000000000000', '-10.000000000000000000000000000000', 'FROZEN', 'FROZEN', null, null, null, null, 'true', null, 'center', null, 'false', null, null, '7.000000000000000000000000000000', 'true'), ('-47.000000000000000000000000000000', '-10.000000000000000000000000000000', 'DISPLAY_ORDER', 'DISPLAY_ORDER', null, null, null, null, 'true', null, 'center', null, 'false', null, null, '8.000000000000000000000000000000', 'true'), ('-20.000000000000000000000000000000', '-7.000000000000000000000000000000', 'FORMATTER', 'FORMATTER', null, null, null, null, 'true', null, null, null, 'false', null, null, '10.000000000000000000000000000000', 'true'), ('-21.000000000000000000000000000000', '-7.000000000000000000000000000000', 'VALIDATOR_NAME', 'VALIDATOR_NAME', null, null, null, null, 'true', null, null, null, 'false', null, null, '6.000000000000000000000000000000', 'true'), ('-19.000000000000000000000000000000', '-7.000000000000000000000000000000', 'VALIDATOR_MESSAGE', 'VALIDATOR_MESSAGE', '200', null, null, null, 'true', null, null, null, 'false', null, null, '8.000000000000000000000000000000', 'true'), ('-11.000000000000000000000000000000', '-7.000000000000000000000000000000', 'TITLE', 'TITLE', '120', null, null, null, 'true', null, null, null, 'true', null, null, '1.000000000000000000000000000000', 'true'), ('-12.000000000000000000000000000000', '-7.000000000000000000000000000000', 'CLASS_NAME', 'CLASS_NAME', null, null, null, null, 'true', null, null, null, 'false', null, null, '9.000000000000000000000000000000', 'true'), ('-13.000000000000000000000000000000', '-7.000000000000000000000000000000', 'NAME', 'NAME', null, null, null, null, 'true', null, null, null, 'false', null, null, '2.000000000000000000000000000000', 'true'), ('-14.000000000000000000000000000000', '-7.000000000000000000000000000000', 'VALUE', 'VALUE', null, null, null, null, 'true', null, null, null, 'false', null, null, '4.000000000000000000000000000000', 'true'), ('-15.000000000000000000000000000000', '-7.000000000000000000000000000000', 'TYPE', 'TYPE', null, null, null, null, 'true', 'function(value){\n if(value==1)\n   return \'文本框\';\n if(value==2)\n   return \'密码框\';\n if(value==3)\n   return \'下拉框\';\n if(value==4)\n   return \'日期框\';\n if(value==5)\n   return \'附件\'\n}', null, null, 'false', null, null, '3.000000000000000000000000000000', 'true'), ('-16.000000000000000000000000000000', '-7.000000000000000000000000000000', 'DISPLAY_ORDER', 'DISPLAY_ORDER', null, null, null, null, 'true', null, null, null, 'false', null, null, '5.000000000000000000000000000000', 'true'), ('-17.000000000000000000000000000000', '-7.000000000000000000000000000000', 'VALIDATOR_REGEX', 'VALIDATOR_REGEX', null, null, null, null, 'true', null, null, null, 'false', null, null, '7.000000000000000000000000000000', 'true'), ('-18.000000000000000000000000000000', '-7.000000000000000000000000000000', '操作', null, null, null, null, null, 'true', 'function(value,row, index){\n  return \'<a href=\"javascript:;\" onclick=\"loadHtml(\\\'../../form/view/-10?templateName=custom/DETAIL&showGroup=5&id=\'+ row.ID + \'\\\', \\\'详情\\\')\">详情</a>\';\n}', null, null, 'false', null, null, '11.000000000000000000000000000000', 'true'), ('-1.000000000000000000000000000000', '-6.000000000000000000000000000000', 'TITLE', 'TITLE', null, null, null, 'false', 'true', null, 'center', null, 'true', null, null, '1.000000000000000000000000000000', 'true'), ('-28.000000000000000000000000000000', '-9.000000000000000000000000000000', 'TITLE', 'TITLE', null, null, null, 'false', 'true', null, 'center', null, 'true', null, null, '1.000000000000000000000000000000', 'true'), ('-29.000000000000000000000000000000', '-9.000000000000000000000000000000', 'FIT', 'FIT', null, null, null, 'false', 'true', null, 'center', null, 'true', null, null, '2.000000000000000000000000000000', 'true'), ('-30.000000000000000000000000000000', '-9.000000000000000000000000000000', 'LOADMSG', 'LOADMSG', null, null, null, null, 'true', null, null, null, 'false', null, null, '3.000000000000000000000000000000', 'true'), ('-32.000000000000000000000000000000', '-9.000000000000000000000000000000', 'SIGLESELECT', 'SIGLESELECT', null, null, null, null, 'true', null, null, null, 'false', null, null, '5.000000000000000000000000000000', 'true'), ('-33.000000000000000000000000000000', '-9.000000000000000000000000000000', 'BORDER', 'BORDER', null, null, null, 'false', 'true', null, 'center', null, 'false', null, null, '9.000000000000000000000000000000', 'true'), ('-35.000000000000000000000000000000', '-9.000000000000000000000000000000', 'SHOWFOOT', 'SHOWFOOT', null, null, null, null, 'true', null, null, null, 'false', null, null, '8.000000000000000000000000000000', 'true'), ('-36.000000000000000000000000000000', '-9.000000000000000000000000000000', 'IFCHECK', 'IFCHECK', null, null, null, null, 'true', null, null, null, 'false', null, null, '6.000000000000000000000000000000', 'true'), ('-37.000000000000000000000000000000', '-9.000000000000000000000000000000', 'ISLOAD', 'ISLOAD', null, null, null, null, 'true', 'function(value){ if(value==1)   return \'加载数据\'; if(value==0)   return \'不加载数据\';}', 'center', null, 'false', null, null, '4.000000000000000000000000000000', 'true'), ('-38.000000000000000000000000000000', '-9.000000000000000000000000000000', '操作', 'op', null, null, null, 'false', 'true', 'function(value, row, index) {	return \'<a href=\"javascript:;\" onclick=\"loadHtml(\\\'../../form/view/-16?id=\'			+ row.GRID_ID + \'\\\', \\\'详情\\\')\">详情</a>\'+\'&nbsp;&nbsp;<a href=\"javascript:;\" onclick=\"preview(path_web+\\\'/admin/grid/view/\'			+ row.GRID_ID + \'\\\', \\\'\'+row.TITLE+\'(预览)\\\')\">预览</a>\';}', 'center', null, 'false', null, null, '12.000000000000000000000000000000', 'true'), ('-39.000000000000000000000000000000', '-10.000000000000000000000000000000', 'TITLE', 'TITLE', null, null, null, null, 'true', null, 'center', null, 'false', null, null, '1.000000000000000000000000000000', 'true'), ('-40.000000000000000000000000000000', '-10.000000000000000000000000000000', 'FIELD', 'FIELD', null, null, null, null, 'true', null, 'center', null, 'false', null, null, '2.000000000000000000000000000000', 'true'), ('-41.000000000000000000000000000000', '-10.000000000000000000000000000000', 'WIDTH', 'WIDTH', null, null, null, null, 'true', null, 'center', null, 'false', null, null, '3.000000000000000000000000000000', 'true'), ('-42.000000000000000000000000000000', '-10.000000000000000000000000000000', 'SORTABLE', 'SORTABLE', null, null, null, null, 'true', null, 'center', null, 'false', null, null, '4.000000000000000000000000000000', 'true'), ('-43.000000000000000000000000000000', '-10.000000000000000000000000000000', 'DISPLAY', 'DISPLAY', null, null, null, null, 'true', null, 'center', null, 'false', null, null, '5.000000000000000000000000000000', 'true'), ('-44.000000000000000000000000000000', '-10.000000000000000000000000000000', 'AUTH_CODE', 'AUTH_CODE', null, null, null, null, 'true', null, 'center', null, 'false', null, null, '6.000000000000000000000000000000', 'true'), ('-45.000000000000000000000000000000', '-10.000000000000000000000000000000', '操作', null, null, null, null, null, 'true', 'function(value,row, index){  return \'<a href=\"javascript:;\" onclick=\"loadHtml(\\\'../../form/view/-12?templateName=custom/DETAIL&showGroup=2&id=\'+ row.ID + \'\\\', \\\'详情\\\')\">详情</a>\';}', 'center', null, 'false', null, null, '9.000000000000000000000000000000', 'false'), ('-49.000000000000000000000000000000', '-11.000000000000000000000000000000', 'ICONCLS', 'ICONCLS', null, null, null, null, 'true', null, null, null, 'false', null, null, '2.000000000000000000000000000000', 'true'), ('-48.000000000000000000000000000000', '-11.000000000000000000000000000000', 'NAME', 'NAME', null, null, null, null, 'true', null, null, null, 'false', null, null, '1.000000000000000000000000000000', 'true'), ('-50.000000000000000000000000000000', '-11.000000000000000000000000000000', 'AUTH_CODE', 'AUTH_CODE', null, null, null, null, 'true', null, null, null, 'false', null, null, '4.000000000000000000000000000000', 'true'), ('-51.000000000000000000000000000000', '-11.000000000000000000000000000000', 'DISPLAY', 'DISPLAY', null, null, null, null, 'true', 'function(value){\n if(value==\'true\')\n   return \'显示该列\';\n if(value==\'false\')\n   return \'不显示该列\';\n}', null, null, 'false', null, null, '5.000000000000000000000000000000', 'true'), ('-52.000000000000000000000000000000', '-11.000000000000000000000000000000', 'DISPLAY_ORDER', 'DISPLAY_ORDER', null, null, null, null, 'true', null, null, null, 'false', null, null, '6.000000000000000000000000000000', 'true'), ('-53.000000000000000000000000000000', '-11.000000000000000000000000000000', '操作', null, null, null, null, null, 'true', 'function(value,row, index){\n  return \'<a href=\"javascript:;\" onclick=\"loadHtml(\\\'../../form/view/-13?templateName=custom/DETAIL&showGroup=5&id=\'+ row.ID + \'\\\', \\\'详情\\\')\">详情</a>\';\n}', null, null, 'false', null, null, '7.000000000000000000000000000000', 'true'), ('-2.000000000000000000000000000000', '-6.000000000000000000000000000000', 'NAME', 'NAME', null, null, null, null, 'true', null, null, null, 'false', null, null, '2.000000000000000000000000000000', 'true'), ('-3.000000000000000000000000000000', '-6.000000000000000000000000000000', 'SHOW_GROUP', 'SHOW_GROUP', null, null, null, null, 'true', null, null, null, 'false', null, null, '3.000000000000000000000000000000', 'true'), ('-4.000000000000000000000000000000', '-6.000000000000000000000000000000', 'SAVE_GROUP', 'SAVE_GROUP', null, null, null, null, 'true', null, null, null, 'false', null, null, '4.000000000000000000000000000000', 'true'), ('-6.000000000000000000000000000000', '-6.000000000000000000000000000000', 'METHOD', 'METHOD', null, null, null, null, 'true', null, null, null, 'false', null, null, '6.000000000000000000000000000000', 'true'), ('-7.000000000000000000000000000000', '-6.000000000000000000000000000000', 'PAGE_TYPE', 'PAGE_TYPE', null, null, null, null, 'true', null, null, null, 'false', null, null, '8.000000000000000000000000000000', 'true'), ('-8.000000000000000000000000000000', '-6.000000000000000000000000000000', 'TEMPLATE_NAME', 'TEMPLATE_NAME', null, null, null, null, 'true', null, null, null, 'false', null, null, '7.000000000000000000000000000000', 'true'), ('-9.000000000000000000000000000000', '-6.000000000000000000000000000000', '操作', 'OPT', null, null, null, 'false', 'true', 'function(value,row, index){ return \'<a href=\"javascript:;\" onclick=\"loadHtml(\\\'../../form/view/-15?id=\'+ row.FORM_ID + \'\\\', \\\'详情\\\')\">详情</a>\'+\'&nbsp;&nbsp;<a href=\"javascript:;\" onclick=\"preview(path_web+\\\'/admin/form/view/\'	+ row.FORM_ID + \'?templateName=custom/ADD_PAGE\\\', \\\'\'+row.TITLE+\'(预览)\\\')\">预览</a>\';}', 'center', null, 'false', null, null, '11.000000000000000000000000000000', 'true'), ('-22.000000000000000000000000000000', '-8.000000000000000000000000000000', 'TYPE', 'TYPE', null, null, null, null, 'true', 'function(value){\n if(value==0)\n   return \'非查询\';\n if(value==1)\n   return \'查询\';\n}', null, null, 'false', null, null, '1.000000000000000000000000000000', 'true'), ('-23.000000000000000000000000000000', '-8.000000000000000000000000000000', 'RUN_ORDER', 'RUN_ORDER', null, null, null, null, 'true', null, null, null, 'false', null, null, '2.000000000000000000000000000000', 'true'), ('-24.000000000000000000000000000000', '-8.000000000000000000000000000000', 'RUN_GROUP', 'RUN_GROUP', null, null, null, null, 'true', null, null, null, 'false', null, null, '3.000000000000000000000000000000', 'true'), ('-25.000000000000000000000000000000', '-8.000000000000000000000000000000', 'KEY_TEXT', 'KEY_TEXT', null, null, null, 'false', 'true', null, 'center', null, 'false', null, null, '4.000000000000000000000000000000', 'true'), ('-26.000000000000000000000000000000', '-8.000000000000000000000000000000', '操作', null, null, null, null, null, 'true', 'function(value,row, index){\n  return \'<a href=\"javascript:;\" onclick=\"loadHtml(\\\'../../form/view/-9?templateName=custom/DETAIL&showGroup=5&id=\'+ row.ID + \'\\\', \\\'详情\\\')\">详情</a>\';\n}', null, null, 'false', null, null, '6.000000000000000000000000000000', 'true'), ('-54.000000000000000000000000000000', '-12.000000000000000000000000000000', 'TITLE', 'TITLE', null, null, null, null, 'true', null, null, null, 'false', null, null, '1.000000000000000000000000000000', 'true'), ('-55.000000000000000000000000000000', '-12.000000000000000000000000000000', 'VALUE', 'VALUE', null, null, null, null, 'true', null, 'center', null, 'false', null, null, '2.000000000000000000000000000000', 'true'), ('-56.000000000000000000000000000000', '-12.000000000000000000000000000000', 'NAME', 'NAME', null, null, null, null, 'true', null, null, null, 'false', null, null, '3.000000000000000000000000000000', 'true'), ('-57.000000000000000000000000000000', '-12.000000000000000000000000000000', 'TYPE', 'TYPE', null, null, null, 'false', 'true', 'function(value){ if(value==1)   return \'文本框\'; if(value==3)   return \'下拉框\'; if(value==4)   return \'日期框\';}', 'center', null, 'false', null, null, '4.000000000000000000000000000000', 'true'), ('-58.000000000000000000000000000000', '-12.000000000000000000000000000000', 'AUTH_CODE', 'AUTH_CODE', null, null, null, null, 'true', null, null, null, 'false', null, null, '5.000000000000000000000000000000', 'true'), ('-59.000000000000000000000000000000', '-12.000000000000000000000000000000', 'DISPLAY_ORDER', 'DISPLAY_ORDER', null, null, null, null, 'true', null, 'center', null, 'false', null, null, '6.000000000000000000000000000000', 'true'), ('-60.000000000000000000000000000000', '-12.000000000000000000000000000000', '操作', null, null, null, null, null, 'true', 'function(value,row, index){\n  return \'<a href=\"javascript:;\" onclick=\"loadHtml(\\\'../../form/view/-14?templateName=custom/DETAIL&showGroup=5&id=\'+ row.ID + \'\\\', \\\'详情\\\')\">详情</a>\';\n}', null, null, 'false', null, null, '7.000000000000000000000000000000', 'true'), ('-66.000000000000000000000000000000', '-6.000000000000000000000000000000', '表单地址', 'vist_url', null, null, null, 'false', 'true', 'function(value,row, index){ return path_web+\'/admin/form/view/\'+ row.FORM_ID;}', 'center', null, 'false', null, null, '10.000000000000000000000000000000', 'true'), ('-67.000000000000000000000000000000', '-9.000000000000000000000000000000', '列表地址', 'vist_url', null, null, null, 'false', 'true', 'function(value,row, index){ return path_web+\'/admin/grid/view/\'+ row.GRID_ID;}', 'center', null, 'false', null, null, '11.000000000000000000000000000000', 'true');
COMMIT;

-- ----------------------------
--  Table structure for `grid_panel`
-- ----------------------------
DROP TABLE IF EXISTS `grid_panel`;
CREATE TABLE `grid_panel` (
  `GRID_ID` decimal(65,30) NOT NULL,
  `TITLE` varchar(200) DEFAULT NULL COMMENT '网格标题',
  `FIT` varchar(20) DEFAULT NULL COMMENT '网格是否自适应高度',
  `LOADMSG` varchar(50) DEFAULT NULL COMMENT '加载等待的时候显示的信息',
  `CLASS_NAME` varchar(50) DEFAULT NULL,
  `SIGLESELECT` varchar(15) DEFAULT NULL COMMENT '设置网格是否单选',
  `BORDER` varchar(10) DEFAULT NULL COMMENT '边框',
  `PAGELIST` varchar(100) DEFAULT NULL COMMENT '设置分页下拉框\n格式如下：\n[10,20,30,40]',
  `ONCLICKROW` text,
  `ONDBCLICKROWLICK` text COMMENT '网格记录的双击事件方法名',
  `ONLOADSUCCESS` text COMMENT '网格加载成功的事件名',
  `SHOWFOOT` varchar(20) DEFAULT NULL COMMENT '配置 统计字段 的文本\n显示1到10,共23记录',
  `IFCHECK` varchar(10) DEFAULT NULL COMMENT '是否需要选择框',
  `DEFAULT_QUERY_JSON` varchar(200) DEFAULT NULL COMMENT '设置条件的默认值到初始化的GRID中',
  `ORDERBY_FIELD` varchar(200) DEFAULT NULL COMMENT '排序语句 如 order by cityid asc,orgid asc',
  `ISLOAD` decimal(65,30) DEFAULT NULL,
  `LOAD_TYPE` decimal(65,30) DEFAULT NULL COMMENT '1=采用配置 SQL，自动分页插件\n2=采用配 分页SQL，配置的查询总条数\n3=采用URL地址加载',
  `URL` text,
  `SQL_TEXT` longtext COMMENT '网格sql语句',
  `SQL_COUNT` longtext,
  `HTML` longtext,
  `DATA_OPTIONS` text,
  PRIMARY KEY (`GRID_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `grid_panel`
-- ----------------------------
BEGIN;
INSERT INTO `grid_panel` VALUES ('2.000000000000000000000000000000', '测试', 'true', '正在加载...', null, 'true', 'false', null, null, null, null, 'false', 'true', null, null, '1.000000000000000000000000000000', '1.000000000000000000000000000000', null, null, null, null, null), ('-9.000000000000000000000000000000', '列表定制列表', 'true', '正在加载...', null, 'false', 'false', null, null, null, null, 'false', 'true', null, 'order by grid_id desc', '1.000000000000000000000000000000', '1.000000000000000000000000000000', null, '<script>select GRID_ID,TITLE,FIT,LOADMSG,CLASS_NAME,SIGLESELECT,BORDER,PAGELIST,SHOWFOOT,IFCHECK,ISLOAD from grid_panel<where>  <if test=\"title != null and title !=\'\'\">      and title like \'%\' || #{title} || \'%\'  </if></where></script>', null, '<script type=\"text/javascript\">function preview(url, title) {$.messager.prompt(\'提示\', \'以下地址为您要访问的,可以为此地址添加额外参数：\', function(_url) { if (_url) {openUrl(_url, title);}});$(\".messager-input\").val(url);}</script>', null), ('-12.000000000000000000000000000000', '列表条件列表', 'true', '正在加载...', null, 'true', 'false', null, null, null, null, 'false', 'true', null, 'order by id desc', '1.000000000000000000000000000000', '1.000000000000000000000000000000', null, '<script>select ID,TITLE,NAME,CLASS_NAME,DISPLAY_ORDER,TYPE,AUTH_CODE,VALUE from grid_query<where><if test=\"id != null and id !=\'\'\"> and grid_id=#{id}</if> <if test=\"title!= null and title!=\'\'\"> and title like \'%\'||#{title}||\'%\'</if></where></script>', null, '<script>function getQueryString(key) {    var regex = new RegExp(\"[?&]\" + encodeURIComponent(key) + \"\\\\=([^&#]+)\");    var value = (location.search.match(regex) || [\"\", \"\"])[1];    return decodeURIComponent(value);}</script>', 'nowrap:true'), ('-11.000000000000000000000000000000', '列表按钮列表', 'true', '正在加载...', null, 'true', 'false', null, null, null, null, 'false', 'true', null, 'order by id desc', '1.000000000000000000000000000000', '1.000000000000000000000000000000', null, '<script>select ID,GRID_ID,NAME,ICONCLS,HANDLE,URL,AUTH_CODE,EVENT_TYPE,DISPLAY,BUTTON_JSON,DISPLAY_ORDER from grid_button<where>  <if test=\"id != null and id !=\'\'\">      and grid_id = #{id}  </if>    <if test=\"name != null and name !=\'\'\">      and name like \'%\' || #{name} || \'%\'  </if></where></script>', null, '<script>function getQueryString(key) {    var regex = new RegExp(\"[?&]\" + encodeURIComponent(key) + \"\\\\=([^&#]+)\");    var value = (location.search.match(regex) || [\"\", \"\"])[1];    return decodeURIComponent(value);}</script>', 'nowrap:true'), ('-6.000000000000000000000000000000', '表单定制列表', 'true', '正在加载...', null, 'false', 'false', null, null, null, null, 'true', 'true', null, 'order by form_id desc', '1.000000000000000000000000000000', '1.000000000000000000000000000000', null, '<script>select FORM_ID,TITLE,NAME,CLASS_NAME,METHOD,URL,PAGE_TYPE,TEMPLATE_NAME,SHOW_GROUP,SAVE_GROUP from form_info<where> <if test=\"title != null and title !=\'\'\">      and title like \'%\' || #{title} || \'%\'  </if>  <if test=\"name != null and name !=\'\'\">      and name like \'%\' || #{name} || \'%\'  </if></where></script>', null, '<script type=\"text/javascript\">function preview(url, title) {$.messager.prompt(\'提示\', \'以下地址为您要访问的,可以为此地址添加额外参数：\', function(_url) { if (_url) {openUrl(_url, title);}});$(\".messager-input\").val(url);}</script>', 'striped:true,nowrap:true'), ('0.000000000000000000000000000000', '表单SQL列表', 'true', '正在加载...', null, 'true', 'false', null, null, null, null, 'false', 'true', null, 'order by id desc', '1.000000000000000000000000000000', '1.000000000000000000000000000000', null, '<script>select ID,RUN_ID,TYPE,SQL_TEXT,RUN_ORDER,RUN_GROUP,KEY_TEXT from form_sql<where>  <if test=\"id != null and id !=\'\'\">      and run_id = #{id}  </if>  <if test=\"type != null and type !=\'\' and type != 2\">      and type = #{type}  </if>  <if test=\"run_group != null and run_group !=\'\'\">      and run_group = #{run_group}  </if></where></script>', null, '<script>function getQueryString(key) {    var regex = new RegExp(\"[?&]\" + encodeURIComponent(key) + \"\\\\=([^&#]+)\");    var value = (location.search.match(regex) || [\"\", \"\"])[1];    return decodeURIComponent(value);}</script>', 'nowrap:true'), ('-7.000000000000000000000000000000', '表单控件列表', 'true', '正在加载...', null, 'true', 'false', null, null, null, null, 'false', 'true', null, 'order by id desc', '1.000000000000000000000000000000', '1.000000000000000000000000000000', null, '<script>select ID,FORM_ID,TITLE,CLASS_NAME,NAME,VALUE,TYPE,FORMATTER,VALIDATOR_NAME,VALIDATOR_REGEX,VALIDATOR_MESSAGE,JSON,DATA_OPTIONS,DISPLAY_ORDER from form_widget<where>   <if test=\"id != null and id !=\'\'\">      and form_id = #{id}  </if>  <if test=\"type != null and type !=\'\'and TYPE !=0\">      and type = #{type}  </if>  <if test=\"title != null and title !=\'\'\">      and title like \'%\' || #{title} || \'%\'  </if>  <if test=\"name != null and name !=\'\'\">      and name like \'%\' || #{name} || \'%\'  </if></where></script>', null, '<script>function getQueryString(key) {    var regex = new RegExp(\"[?&]\" + encodeURIComponent(key) + \"\\\\=([^&#]+)\");    var value = (location.search.match(regex) || [\"\", \"\"])[1];    return decodeURIComponent(value);}</script>', 'nowrap:true'), ('-10.000000000000000000000000000000', '列表字段列表', 'true', '正在加载...', null, 'true', 'false', null, null, null, null, 'false', 'true', null, 'order by id desc  ', '1.000000000000000000000000000000', '1.000000000000000000000000000000', null, '<script>select ID,TITLE,FIELD,WIDTH,SORTABLE,DISPLAY,AUTH_CODE,FROZEN,DISPLAY_ORDER from grid_field <where><if test=\"id != null and id !=\'\'\"> and grid_id = #{id} </if><if test=\"title != null and title !=\'\'\"> and title like \'%\' || #{title} || \'%\' </if><if test=\"field != null and field !=\'\'\"> and field like \'%\' || #{field}|| \'%\' </if></where></script>', null, '<script>function getQueryString(key) {    var regex = new RegExp(\"[?&]\" + encodeURIComponent(key) + \"\\\\=([^&#]+)\");    var value = (location.search.match(regex) || [\"\", \"\"])[1];    return decodeURIComponent(value);}</script>', 'nowrap:true');
COMMIT;

-- ----------------------------
--  Table structure for `grid_query`
-- ----------------------------
DROP TABLE IF EXISTS `grid_query`;
CREATE TABLE `grid_query` (
  `ID` decimal(65,30) NOT NULL,
  `GRID_ID` decimal(65,30) DEFAULT NULL COMMENT '对应的网格id',
  `TITLE` varchar(20) DEFAULT NULL COMMENT '查询的标题',
  `NAME` varchar(20) DEFAULT NULL COMMENT '查询NAME',
  `CLASS_NAME` varchar(10) DEFAULT NULL COMMENT '查询CLASS',
  `TYPE` varchar(2) DEFAULT NULL COMMENT '控件类型 1.文本框  2.下拉列表框  3.日期输入框',
  `AUTH_CODE` varchar(30) DEFAULT NULL COMMENT '查询权限',
  `DATA_OPTION` text COMMENT '自定义配置',
  `VALUE` varchar(100) DEFAULT NULL COMMENT '默认值',
  `FORMATTER` text COMMENT '格式式化方法名',
  `VALIDATOR_NAME` varchar(100) DEFAULT NULL COMMENT '验证名称',
  `VALIDATOR_REGEX` text COMMENT '验证表达式',
  `VALIDATOR_MESSAGE` varchar(200) DEFAULT NULL COMMENT '验证提示信息',
  `DISPLAY_ORDER` decimal(65,30) DEFAULT NULL COMMENT '字段顺序',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='网格查询字段';

-- ----------------------------
--  Records of `grid_query`
-- ----------------------------
BEGIN;
INSERT INTO `grid_query` VALUES ('-10.000000000000000000000000000000', '-10.000000000000000000000000000000', 'title', 'title', null, '1', null, null, null, null, null, null, null, '1.000000000000000000000000000000'), ('-11.000000000000000000000000000000', '-10.000000000000000000000000000000', 'field', 'field', null, '1', null, null, null, null, null, null, null, '2.000000000000000000000000000000'), ('-13.000000000000000000000000000000', '-12.000000000000000000000000000000', 'title', 'title', null, '1', null, null, null, null, null, null, null, '1.000000000000000000000000000000'), ('-12.000000000000000000000000000000', '-11.000000000000000000000000000000', 'name', 'name', null, '1', null, null, null, null, null, null, null, '1.000000000000000000000000000000'), ('-9.000000000000000000000000000000', '-9.000000000000000000000000000000', 'title', 'title', null, '1', null, 'validType:\'length[0,10]\'', null, null, null, null, null, '1.000000000000000000000000000000'), ('-1.000000000000000000000000000000', '-6.000000000000000000000000000000', 'title', 'title', null, '1', null, null, null, null, null, null, null, '2.000000000000000000000000000000'), ('-2.000000000000000000000000000000', '-6.000000000000000000000000000000', 'name', 'name', null, '1', null, null, null, null, null, null, null, '3.000000000000000000000000000000'), ('-3.000000000000000000000000000000', '-7.000000000000000000000000000000', 'title', 'title', null, '1', null, null, null, null, null, null, null, '1.000000000000000000000000000000'), ('-4.000000000000000000000000000000', '-7.000000000000000000000000000000', 'name', 'name', null, '1', null, null, null, null, null, null, null, '2.000000000000000000000000000000'), ('-6.000000000000000000000000000000', '-8.000000000000000000000000000000', 'type', 'type', null, '3', null, 'editable:false,data:[{   text:\'查询\',   value:1},{   text:\'非查询\',   value:0},{   text:\'所有\',   value:2}]', '2', null, null, null, null, '2.000000000000000000000000000000'), ('-7.000000000000000000000000000000', '-8.000000000000000000000000000000', 'run_group', 'run_group', null, '1', null, null, null, null, null, null, null, '1.000000000000000000000000000000');
COMMIT;

-- ----------------------------
--  Table structure for `log_module_code`
-- ----------------------------
DROP TABLE IF EXISTS `log_module_code`;
CREATE TABLE `log_module_code` (
  `ID` decimal(8,0) NOT NULL COMMENT '自增ID',
  `MODULE_CODE` varchar(50) DEFAULT NULL COMMENT '模块编码',
  `MODULE_NAME` varchar(50) DEFAULT NULL COMMENT '模块名称',
  `MODULE_DESCRIPTION` varchar(500) DEFAULT NULL COMMENT '模块描述',
  `DISPLAY_ORDER` decimal(8,0) DEFAULT NULL COMMENT '显示排序',
  `CLASS_METHON` varchar(500) DEFAULT NULL COMMENT '要日志控制层包类方法',
  `OK_LOG` varchar(500) DEFAULT NULL COMMENT '成功消息',
  `ERR_LOG` varchar(500) DEFAULT NULL COMMENT '失败消息',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='模块编码表';

-- ----------------------------
--  Table structure for `log_sys`
-- ----------------------------
DROP TABLE IF EXISTS `log_sys`;
CREATE TABLE `log_sys` (
  `ID` decimal(8,0) DEFAULT NULL,
  `LEVEL_TYPE` varchar(8) DEFAULT NULL,
  `CLASS_NAME` varchar(100) DEFAULT NULL,
  `MESSAGE` varchar(2000) DEFAULT NULL,
  `THREAD_NAME` varchar(100) DEFAULT NULL,
  `STACK` text,
  `LOG_DATE` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `log_user`
-- ----------------------------
DROP TABLE IF EXISTS `log_user`;
CREATE TABLE `log_user` (
  `ID` decimal(8,0) NOT NULL COMMENT '自增主键',
  `MODULE_CODE` varchar(50) DEFAULT NULL COMMENT '模块编码',
  `USERNAME` varchar(256) DEFAULT NULL COMMENT '操作用户',
  `CONTENT` varchar(500) DEFAULT NULL COMMENT '操作内容',
  `STATUS` varchar(50) DEFAULT NULL COMMENT '操作状态',
  `IP` varchar(50) DEFAULT NULL COMMENT '操作IP',
  `LOG_DATE` datetime DEFAULT NULL COMMENT '日志时间',
  `ORIGIN` varchar(200) DEFAULT NULL COMMENT '操作来源',
  `RUN_TIMEMILLIS` decimal(8,0) DEFAULT NULL COMMENT '执行过程的毫秒数',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户日志表';

-- ----------------------------
--  Table structure for `notify_content`
-- ----------------------------
DROP TABLE IF EXISTS `notify_content`;
CREATE TABLE `notify_content` (
  `NOTIFY_ID` decimal(20,0) NOT NULL COMMENT '通知ID(主键)',
  `USER_ID` decimal(20,0) NOT NULL COMMENT '发起人用户ID（外键）',
  `TITLE` varchar(128) DEFAULT NULL COMMENT '通知标题',
  `CONTENT` varchar(2048) DEFAULT NULL COMMENT '通知内容',
  `SEND_DATE` datetime NOT NULL COMMENT '发起时间',
  `SEND_TYPE` varchar(64) DEFAULT NULL COMMENT '通知类型,为业务类型，调用者提供',
  `ACTION` decimal(2,0) DEFAULT NULL COMMENT '动作,触发动作1：点击，2：超链接',
  `ACTION_VALUE` varchar(128) DEFAULT NULL COMMENT '动作为内容',
  PRIMARY KEY (`NOTIFY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `notify_scope`
-- ----------------------------
DROP TABLE IF EXISTS `notify_scope`;
CREATE TABLE `notify_scope` (
  `NOTIFY_SCOPE_ID` decimal(20,0) NOT NULL COMMENT '通知分发成员ID(主键)',
  `NOTIFY_ID` decimal(20,0) NOT NULL COMMENT '通知ID（外键）',
  `USER_ID` decimal(20,0) NOT NULL COMMENT '接收用户ID（外键）',
  `STATUS` decimal(2,0) NOT NULL COMMENT '通知状态1.UnRead 2.Read 3.Delete',
  `READ_DATE` datetime DEFAULT NULL COMMENT '阅读时间',
  `DELETE_DATE` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`NOTIFY_SCOPE_ID`),
  KEY `FK_Reference_1` (`NOTIFY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
--  Table structure for `os_action_form`
-- ----------------------------
DROP TABLE IF EXISTS `os_action_form`;
CREATE TABLE `os_action_form` (
  `ID` decimal(8,0) NOT NULL,
  `WORKFLOW_NAME` varchar(50) DEFAULT NULL,
  `FORM_ID` decimal(8,0) DEFAULT NULL,
  `ACTION_ID` decimal(8,0) DEFAULT NULL,
  `STEP_ID` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `os_currentstep`
-- ----------------------------
DROP TABLE IF EXISTS `os_currentstep`;
CREATE TABLE `os_currentstep` (
  `ID` decimal(8,0) NOT NULL,
  `ENTRY_ID` decimal(8,0) DEFAULT NULL,
  `STEP_ID` int(11) DEFAULT NULL,
  `ACTION_ID` int(11) DEFAULT NULL,
  `OWNER` varchar(20) DEFAULT NULL,
  `START_DATE` datetime DEFAULT NULL,
  `FINISH_DATE` datetime DEFAULT NULL,
  `DUE_DATE` datetime DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  `CALLER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Reference_2` (`ENTRY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `os_currentstep_prev`
-- ----------------------------
DROP TABLE IF EXISTS `os_currentstep_prev`;
CREATE TABLE `os_currentstep_prev` (
  `ID` decimal(8,0) NOT NULL,
  `PREVIOUS_ID` decimal(8,0) NOT NULL,
  PRIMARY KEY (`ID`,`PREVIOUS_ID`),
  KEY `FK_Reference_5` (`PREVIOUS_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
--  Table structure for `os_historystep`
-- ----------------------------
DROP TABLE IF EXISTS `os_historystep`;
CREATE TABLE `os_historystep` (
  `ID` decimal(8,0) NOT NULL,
  `ENTRY_ID` decimal(8,0) DEFAULT NULL,
  `STEP_ID` int(11) DEFAULT NULL,
  `ACTION_ID` int(11) DEFAULT NULL,
  `OWNER` varchar(20) DEFAULT NULL,
  `START_DATE` datetime DEFAULT NULL,
  `FINISH_DATE` datetime DEFAULT NULL,
  `DUE_DATE` datetime DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  `CALLER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Reference_3` (`ENTRY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `os_historystep_prev`
-- ----------------------------
DROP TABLE IF EXISTS `os_historystep_prev`;
CREATE TABLE `os_historystep_prev` (
  `ID` decimal(8,0) NOT NULL,
  `PREVIOUS_ID` decimal(8,0) NOT NULL,
  PRIMARY KEY (`ID`,`PREVIOUS_ID`),
  KEY `FK_Reference_7` (`PREVIOUS_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
--  Table structure for `os_propertyentry`
-- ----------------------------
DROP TABLE IF EXISTS `os_propertyentry`;
CREATE TABLE `os_propertyentry` (
  `GLOBAL_KEY` varchar(255) NOT NULL,
  `ITEM_KEY` varchar(255) NOT NULL,
  `ITEM_TYPE` decimal(65,30) DEFAULT NULL,
  `STRING_VALUE` varchar(255) DEFAULT NULL,
  `DATE_VALUE` datetime DEFAULT NULL,
  `DATA_VALUE` longblob,
  `FLOAT_VALUE` double DEFAULT NULL,
  `NUMBER_VALUE` decimal(65,30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `os_propertyentry`
-- ----------------------------
BEGIN;
INSERT INTO `os_propertyentry` VALUES ('1', '1', '1.000000000000000000000000000000', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `os_wfentry`
-- ----------------------------
DROP TABLE IF EXISTS `os_wfentry`;
CREATE TABLE `os_wfentry` (
  `ID` decimal(8,0) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `STATE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_demo`
-- ----------------------------
DROP TABLE IF EXISTS `t_demo`;
CREATE TABLE `t_demo` (
  `ID` decimal(65,30) NOT NULL,
  `NAME` varchar(200) DEFAULT NULL,
  `TYPE` decimal(65,30) DEFAULT NULL,
  `DESCRIPTION` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_demo`
-- ----------------------------
BEGIN;
INSERT INTO `t_demo` VALUES ('23.000000000000000000000000000000', '3', '3.000000000000000000000000000000', '3');
COMMIT;

-- ----------------------------
--  Table structure for `tb_auto_number`
-- ----------------------------
DROP TABLE IF EXISTS `tb_auto_number`;
CREATE TABLE `tb_auto_number` (
  `TABLE_NAME` varchar(20) DEFAULT NULL,
  `MAX_NUMBER` decimal(65,30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_auto_number`
-- ----------------------------
BEGIN;
INSERT INTO `tb_auto_number` VALUES ('TSYS_ORG', '100.000000000000000000000000000000'), ('LOG_SYS', '1.000000000000000000000000000000'), ('LOG_USER', '1.000000000000000000000000000000'), ('FORM_INFO', '3.000000000000000000000000000000'), ('FORM_SQL', '13.000000000000000000000000000000'), ('FORM_WIDGET', '2.000000000000000000000000000000'), ('GRID_BUTTON', '2.000000000000000000000000000000'), ('GRID_FIELD', '2.000000000000000000000000000000'), ('GRID_PANEL', '2.000000000000000000000000000000'), ('GRID_QUERY', '2.000000000000000000000000000000'), ('TSYS_DICT', '1.000000000000000000000000000000'), ('TSYS_RESOURCES', '206.000000000000000000000000000000'), ('TSYS_ROLE_AUTHORITY', '3724.000000000000000000000000000000'), ('FILE_INFO', '9.000000000000000000000000000000'), ('TSYS_MENU', '53.000000000000000000000000000000'), ('TSYS_USER', '20.000000000000000000000000000000'), ('TSYS_USER_ROLE', '32.000000000000000000000000000000'), ('TSYS_ROLE', '21.000000000000000000000000000000'), ('TSYS_AUTHORITY', '158.000000000000000000000000000000');
COMMIT;

-- ----------------------------
--  Table structure for `tsys_authority`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_authority`;
CREATE TABLE `tsys_authority` (
  `AUTH_ID` decimal(20,0) NOT NULL COMMENT '权限ID',
  `MENU_ID` decimal(20,0) DEFAULT NULL COMMENT '菜单ID',
  `AUTH_TYPE` decimal(2,0) NOT NULL COMMENT '权限类型  1:菜单  2:自定义URL',
  `AUTH_NAME` text NOT NULL COMMENT '权限名称',
  `AUTH_CODE` text NOT NULL COMMENT '权限编码',
  `IS_ENABLE` decimal(2,0) DEFAULT NULL COMMENT '是否启用',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `NOTE` text COMMENT '备注',
  PRIMARY KEY (`AUTH_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='权限表';

-- ----------------------------
--  Records of `tsys_authority`
-- ----------------------------
BEGIN;
INSERT INTO `tsys_authority` VALUES ('157', '53', '2', '系统日志列表', 'LOG_SYS_LIST', '1', '2015-07-31 00:00:00', null, null), ('158', '52', '2', '用户日志列表', 'LOG_USER_LIST', '1', '2015-07-31 00:00:00', null, null), ('148', '50', '1', '列表', 'GRID_LIST', '1', '2015-07-03 00:00:00', null, null), ('147', '48', '1', '表单列表', 'FORM_LIST', '1', '2015-07-01 00:00:00', null, null), ('146', '44', '2', 'GROUP_DEL', 'GROUP_DEL', '1', '2015-07-15 00:00:00', null, null), ('151', '30', '2', '文件列表', 'UPLOAD_LIST', '1', '2015-07-17 00:00:00', null, null), ('154', '30', '1', '文件删除', 'FILE_DEL', '1', '2015-07-17 00:00:00', null, null), ('141', '44', '2', 'list', 'list', '1', '2015-06-24 00:00:00', null, null), ('143', '44', '1', 'auth_query', 'auth_query', '1', '2015-06-24 00:00:00', null, null), ('145', '44', '2', 'GROUP_EDIT', 'GROUP_EDIT', '1', '2015-07-15 00:00:00', null, null), ('152', '30', '1', '上传文件', 'UPLOAD_FILE', '1', '2015-07-17 00:00:00', null, null), ('125', '26', '1', '用户字典-列表', 'USER_DICT_LIST', '1', '2015-03-13 00:00:00', null, null), ('126', '26', '1', '用户字典-添加', 'USER_DICT_ADD', '1', '2015-03-13 00:00:00', '2015-03-13 00:00:00', null), ('124', '26', '1', '用户字典-设置缓存', 'USER_DICT_SETCACHE', '1', '2015-03-13 00:00:00', '2015-03-13 00:00:00', null), ('129', '26', '1', '用户字典-启停用', 'USER_DICT_ENABLE', '1', '2015-03-13 00:00:00', null, null), ('122', '5', '1', '权限-启停用按钮', 'AUTH_ENABLE', '1', '2015-03-12 00:00:00', null, null), ('115', '28', '1', '发送消息-详情按钮', 'NOTIFY_ADMIN_DETAIL', '1', '2015-03-12 00:00:00', '2015-03-19 00:00:00', null), ('117', '29', '1', '接收消息-列表浏览', 'NOTIFY_USERLIST', '1', '2015-03-12 00:00:00', '2015-03-19 00:00:00', null), ('120', '3', '2', '用户-详情', 'USER_DETAIL', '1', '2015-03-12 00:00:00', null, null), ('121', '4', '1', '角色-启停用按钮', 'ROLE_ENABLE', '1', '2015-03-12 00:00:00', null, null), ('2', '2', '2', '菜单-列表浏览 ', 'MENU_LIST', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('3', '2', '1', '菜单-添加按钮', 'MENU_ADD', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('4', '2', '2', '菜单-删除按钮', 'MENU_DELETE', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('5', '2', '2', '菜单-更新按钮', 'MENU_EDIT', '1', '2014-03-12 00:00:00', '2015-03-12 00:00:00', null), ('6', '3', '2', '用户-列表浏览 ', 'USER_LIST', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('7', '3', '2', '用户-添加按钮', 'USER_ADD', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('8', '3', '2', '用户-删除按钮', 'USER_DELETE', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('9', '3', '2', '用户-编辑按钮', 'USER_EDIT', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('10', '3', '2', '用户-重置密码', 'USER_RESETPWD', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('11', '3', '2', '用户-启禁用按钮', 'USER_ENABLED', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('12', '4', '1', '角色-列表浏览', 'ROLE_LIST', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('13', '4', '1', '角色-添加按钮', 'ROLE_ADD', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('14', '4', '1', '角色-删除按钮', 'ROLE_DELETE', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('15', '4', '1', '角色-编辑按钮', 'ROLE_EDIT', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('16', '4', '1', '角色-分配权限按钮', 'ROLE_GOAUTH', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('123', '7', '1', '系统字典-设置缓存', 'DICT_SETCACHE', '1', '2015-03-12 00:00:00', null, null), ('18', '5', '1', '权限-列表浏览', 'AUTH_LIST', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('19', '5', '1', '权限-添加按钮', 'AUTH_ADD', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('20', '5', '1', '权限-删除按钮', 'AUTH_DELETE', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('21', '5', '1', '权限-编辑按钮', 'AUTH_EDIT', '1', '2014-03-13 00:00:00', '2015-03-13 00:00:00', null), ('23', '6', '2', '组织机构-列表浏览', 'GROUP_MAIN', '1', '2014-03-13 00:00:00', '2015-03-19 00:00:00', null), ('24', '6', '1', '组织机构-添加按钮', 'GROUP_ADD', '1', '2014-03-13 00:00:00', '2015-03-19 00:00:00', null), ('25', '6', '1', '组织机构-删除按钮', 'GROUP_DEL', '1', '2014-03-13 00:00:00', '2015-03-19 00:00:00', null), ('26', '6', '1', '组织机构-编辑按钮', 'GROUP_EDIT', '1', '2014-03-13 00:00:00', '2015-03-19 00:00:00', null), ('27', '7', '1', '系统字典-列表浏览', 'USER_DICT_LIST', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('28', '7', '1', '系统字典-添加按钮', 'USER_DICT_ADD', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('29', '7', '1', '系统字典-编辑按钮', 'DICT_EDIT', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('30', '7', '1', '系统字典-启禁用按钮', 'DICT_ENABLED', '1', '2014-03-13 00:00:00', '2015-03-12 00:00:00', null), ('31', '10', '1', '业务字典-列表浏览', 'USER_DICT_LIST ', '1', '2014-03-13 00:00:00', null, null), ('32', '10', '1', '业务字典-添加按钮', 'USER_DICT_ADD ', '1', '2014-03-13 00:00:00', null, null), ('33', '10', '1', '业务字典-编辑按钮', 'USER_DICT_EDIT ', '1', '2014-03-13 00:00:00', null, null), ('34', '10', '1', '业务字典-启禁用按钮', 'USER_DICT_ENABLED ', '1', '2014-03-13 00:00:00', null, null), ('35', '8', '1', '刷新缓存', 'CACHE_REFRESH', '1', '2014-03-13 00:00:00', null, null), ('36', '9', '1', '操作日志-列表浏览', 'OPERLOGS_LIST', '1', '2014-03-13 00:00:00', null, null), ('113', '28', '1', '发送消息-添加按钮', 'NOTIFY_ADD', '1', '2015-03-12 00:00:00', '2015-03-19 00:00:00', null), ('114', '28', '1', '发送消息-列表浏览', 'NOTIFY_ADMINLIST', '1', '2015-03-12 00:00:00', '2015-03-19 00:00:00', null), ('116', '28', '1', '接收消息-分发成员按钮', 'NOTIFY_SCOPE', '1', '2015-03-12 00:00:00', '2015-03-19 00:00:00', null), ('118', '29', '1', '接收消息-详情按钮', 'NOTIFY_USER_DETAIL', '1', '2015-03-12 00:00:00', '2015-03-19 00:00:00', null), ('119', '29', '1', '接收消息-删除按钮', 'NOTIFY_DELETE', '1', '2015-03-12 00:00:00', '2015-03-19 00:00:00', null), ('127', '26', '1', '用户字典-修改', 'DICT_EDIT', '1', '2015-03-13 00:00:00', '2015-03-13 00:00:00', null), ('128', '26', '1', '用户字典-删除', 'DICT_DELETE', '1', '2015-03-13 00:00:00', null, null), ('130', '7', '1', '系统字典-删除按钮', 'DICT_DEL', '1', '2015-03-19 00:00:00', null, null), ('153', '30', '1', '上传图片', 'UPLOAD_PICTURE', '1', '2015-07-17 00:00:00', null, null), ('142', '44', '1', 'auth_add', 'add', '1', '2015-06-24 00:00:00', null, null), ('144', '44', '2', 'GROUP_ADD', 'GROUP_ADD', '1', '2015-07-15 00:00:00', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `tsys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_dict`;
CREATE TABLE `tsys_dict` (
  `DICT_ID` decimal(65,0) NOT NULL,
  `PARENT_DICTID` decimal(65,0) DEFAULT NULL COMMENT '父ID',
  `DICT_TYPE` varchar(50) DEFAULT NULL COMMENT '分类 0：系统字典 1：用户字典',
  `DICT_CODE` varchar(50) DEFAULT NULL COMMENT '编号',
  `DICT_VALUE` varchar(200) DEFAULT NULL COMMENT '值',
  `ARRAY` decimal(65,0) DEFAULT NULL COMMENT '排序',
  `STATUS` decimal(65,0) DEFAULT NULL COMMENT '状态 1:启用 0:禁用',
  `CREATEDATE` datetime DEFAULT NULL COMMENT '创建时间',
  `OPUSER` decimal(65,0) DEFAULT NULL COMMENT '操作人,最后一次编辑人',
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间',
  `NOTE` text COMMENT '描述',
  `ALIASNAME` varchar(100) DEFAULT NULL COMMENT '别名',
  `IS_CACHE` decimal(65,0) DEFAULT NULL COMMENT '是否缓存',
  `DICT_NAME` varchar(200) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`DICT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='数据字典表';

-- ----------------------------
--  Records of `tsys_dict`
-- ----------------------------
BEGIN;
INSERT INTO `tsys_dict` VALUES ('12', '0', '1', 'DICT_test', 'test', '1', '1', '2015-08-17 23:23:40', null, null, '', null, '0', 'test');
COMMIT;

-- ----------------------------
--  Table structure for `tsys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_menu`;
CREATE TABLE `tsys_menu` (
  `MENU_ID` decimal(20,0) NOT NULL COMMENT '菜单ID',
  `MENU_NAME` text NOT NULL COMMENT '菜单名称',
  `PARENT_ID` decimal(20,0) NOT NULL COMMENT '默认顶级 菜单父类ID：0',
  `MENU_LEVEL` decimal(2,0) NOT NULL COMMENT '菜单级别',
  `MENU_URL` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `MENU_TYPE` decimal(2,0) DEFAULT NULL COMMENT '菜单类型  1:TAB  2:文件夹  3:URL',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `ENABLE` decimal(2,0) NOT NULL COMMENT '是否启用',
  `NOTE` text COMMENT '备注',
  `OPEN_TYPE` decimal(2,0) DEFAULT NULL COMMENT '打开方式  1:内部窗口打开  2:外部新窗口打开',
  `ORDER_NO` decimal(20,0) NOT NULL COMMENT '排序',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台菜单管理';

-- ----------------------------
--  Records of `tsys_menu`
-- ----------------------------
BEGIN;
INSERT INTO `tsys_menu` VALUES ('51', '日志管理', '0', '1', null, '1', '2015-07-31 09:40:36', '2015-07-31 09:42:12', '1', null, '1', '2'), ('52', '用户日志列表', '51', '2', '/admin/log/user/list', '3', '2015-07-31 09:43:07', '2015-07-31 09:43:07', '1', null, '1', '1'), ('44', 'Grid', '43', '2', '/demo/list', '3', '2015-06-24 11:15:58', '2015-07-16 08:54:13', '1', null, '1', '1'), ('49', '列表定制管理', '0', '1', null, '1', '2015-07-03 23:36:16', '2015-07-31 09:41:58', '1', null, '1', '5'), ('50', '列表定制列表', '49', '2', '/admin/grid/view/-9', '3', '2015-07-03 23:36:39', '2016-01-18 23:13:14', '1', '', '1', '1'), ('48', '表单定制列表', '47', '2', '/admin/grid/view/-6', '3', '2015-07-01 17:53:29', '2016-01-18 23:13:05', '1', '', '1', '1'), ('45', '用户日志列表', '43', '2', '/log/user/list', '3', '2015-06-25 18:14:49', '2015-06-25 18:16:15', '1', null, '1', '1'), ('46', '系统日志列表', '43', '2', '/log/sys/list', '3', '2015-06-25 19:36:47', '2015-06-25 19:38:23', '1', null, '1', '1'), ('47', '表单定制管理', '0', '1', null, '1', '2015-07-01 17:52:41', '2015-07-31 09:41:53', '1', null, '1', '4'), ('26', '用户字典管理', '1', '2', '/admin/dict/goUserDict', '3', '2015-03-09 09:44:24', '2015-03-09 09:44:34', '1', null, '1', '8'), ('29', '接收消息', '27', '2', '/admin/notify/userlist', '3', '2015-03-09 09:48:14', '2015-03-19 10:33:24', '1', null, '1', '1'), ('28', '发送消息', '27', '2', '/admin/notify/adminlist', '3', '2015-03-09 09:47:50', '2015-03-19 10:33:13', '1', null, '1', '1'), ('27', '通知管理', '0', '1', null, '1', '2015-03-09 09:47:10', '2015-07-31 09:42:07', '1', null, '1', '3'), ('30', '上传管理', '1', '2', '/admin/upload/list', '3', '2015-03-09 09:49:17', '2015-03-12 14:19:50', '1', null, '1', '9'), ('1', '系统管理', '0', '1', null, '1', '2014-03-12 00:00:00', null, '1', null, '1', '1'), ('2', '菜单维护', '1', '2', '/admin/menu/list', '3', '2014-03-12 00:00:00', '2015-03-09 09:41:26', '1', null, '1', '2'), ('3', '用户管理', '1', '2', '/admin/user/list', '3', '2014-03-12 00:00:00', null, '1', null, '1', '3'), ('4', '角色管理', '1', '2', '/admin/role/list', '3', '2014-03-12 00:00:00', '2015-03-09 09:42:22', '1', null, '1', '4'), ('5', '权限管理', '1', '2', '/admin/auth/list', '3', '2014-03-12 00:00:00', '2015-03-09 09:42:30', '1', null, '1', '5'), ('6', '组织机构管理', '1', '2', '/admin/org/list', '3', '2014-03-12 00:00:00', '2015-03-12 14:20:47', '1', null, '1', '6'), ('7', '系统字典管理', '1', '2', '/admin/dict/goSysDict', '3', '2014-03-12 00:00:00', '2015-03-09 09:43:58', '1', null, '1', '7'), ('43', 'Demo', '0', '1', null, '1', '2015-06-24 11:15:01', '2015-07-31 09:41:11', '1', null, '1', '9'), ('53', '系统日志列表', '51', '2', '/admin/log/sys/list', '3', '2015-07-31 09:43:51', '2015-07-31 09:43:51', '1', null, '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `tsys_org`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_org`;
CREATE TABLE `tsys_org` (
  `GROUP_ID` decimal(20,0) NOT NULL COMMENT '组织机构ID',
  `PARENT_ID` decimal(20,0) DEFAULT NULL COMMENT '父类ID,当为顶级时PARENT_ID为0',
  `GROUP_NAME` text NOT NULL COMMENT '组织机构名称',
  `GROUP_CODE` text COMMENT '组织机构编码',
  `GROUP_DESC` text COMMENT '组织机构描述',
  `IS_DEL` decimal(2,0) NOT NULL COMMENT '是否删除（0：删除，1：正常）',
  `IS_ENABLE` decimal(2,0) NOT NULL COMMENT '是否启用（0：未启用，1：启用）',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `ORDER_DISPLAY` decimal(65,30) DEFAULT NULL COMMENT '排序索引',
  `GROUP_LEVEL` decimal(65,30) DEFAULT NULL COMMENT '组织层级\n',
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='组织机构表';

-- ----------------------------
--  Records of `tsys_org`
-- ----------------------------
BEGIN;
INSERT INTO `tsys_org` VALUES ('1', '0', '根组织', null, '根组织', '1', '1', '2015-07-31 00:00:00', '2015-07-31 00:00:00', '1.000000000000000000000000000000', '1.000000000000000000000000000000'), ('16', '1', '福建中企移动有限公司', null, null, '1', '1', '2015-03-05 00:00:00', null, '1.000000000000000000000000000000', '2.000000000000000000000000000000'), ('52', '16', '研发中心', null, '研发中心', '1', '1', '2015-03-05 00:00:00', '2015-07-31 00:00:00', '2.000000000000000000000000000000', '3.000000000000000000000000000000'), ('18', '16', '外包中心', null, '外包中心', '1', '1', '2015-03-05 00:00:00', '2015-07-31 00:00:00', '1.000000000000000000000000000000', '3.000000000000000000000000000000');
COMMIT;

-- ----------------------------
--  Table structure for `tsys_resources`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_resources`;
CREATE TABLE `tsys_resources` (
  `ID` decimal(20,0) NOT NULL COMMENT '资源ID',
  `AUTH_ID` decimal(20,0) NOT NULL COMMENT '权限ID',
  `URL` text COMMENT '资源URL',
  `NOTE` text COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='权限资源表';

-- ----------------------------
--  Records of `tsys_resources`
-- ----------------------------
BEGIN;
INSERT INTO `tsys_resources` VALUES ('204', '156', '/admin/log/user/list', null), ('205', '157', '/admin/log/sys/list', null), ('206', '158', '/admin/log/user/list', null), ('202', '150', '/admin/upload/list', null), ('203', '151', '/admin/upload/list', null), ('182', '25', '/admin/org/del*', null), ('184', '23', '/admin/org/list*', null), ('181', '26', '/admin/org/edit*', null), ('193', '113', '/admin/notify/add', null), ('188', '116', '/admin/notify/scope', null), ('189', '117', '/admin/notify/userlist', null), ('190', '118', '/admin/notify/detail', null), ('191', '119', '/admin/notify/remove', null), ('192', '115', '/admin/notify/detail', null), ('194', '114', '/admin/notify/adminlist', null), ('168', '21', '/admin/auth/edit*', null), ('170', '125', '/admin/dict/goUserDict', null), ('172', '126', '/admin/dict/add*', null), ('175', '127', '/admin/dict/edit*', null), ('176', '129', '/admin/dict/enable*', null), ('132', '4', '/admin/menu/remove*', '带有参数所以加上通配符*,带有参数所以加上通配符*'), ('153', '17', '/admin/role/enable*', null), ('147', '13', '/admin/role/add*', null), ('156', '18', '/admin/auth/list*', null), ('155', '122', '/admin/auth/enable*', null), ('158', '19', '/admin/auth/add*', null), ('161', '27', '/admin/dict/goSysDict', null), ('164', '29', '/admin/dict/edit*', null), ('129', '3', '/admin/menu/add*', '带有参数所以加上通配符*'), ('117', '8', '/admin/user/removes*', '带有参数所以加上通配符*'), ('195', '130', '/admin/dict/del*', null), ('149', '15', '/admin/role/edit*', null), ('150', '16', '/admin/role/setCache*', null), ('159', '20', '/admin/auth/del*', 'rrrrrrrrrrrrrrrr'), ('174', '128', '/admin/dict/del*', null), ('146', '12', '/admin/role/list*', null), ('107', '110', null, null), ('154', '121', '/admin/role/enable*', null), ('101', '103', 'ddddddddd,6666666', 'dddddddddddddddddd,666666666666'), ('103', '105', null, null), ('104', '107', 'eeeeeeeeeee', 'eeeeeeeeeeeeeeeeeeeeee'), ('109', '109', 'rrrrrrrrrrrrrrr,dddddddddddd', 'rrrrrrrrrrrrrrrrrrrrrr,ddddddddddd'), ('162', '28', '/admin/dict/add*', null), ('165', '30', '/admin/dict/enable*', null), ('123', '6', '/admin/user/list*', '带有参数所以加上通配符*'), ('126', '10', '/admin/user/resetPassword*', '带有参数所以加上通配符*'), ('131', '5', '/admin/menu/edit*,/admin/menu/modify*', '带有参数所以加上通配符*,'), ('139', '22', 'eeeeeeeee,eeeeeeeeee', 'eeeeeeeeeeeeee,eeeeeeeeeee'), ('143', '120', '/admin/user/detail*', '带有参数所以加上通配符*'), ('166', '123', '/admin/dict/setCache*', null), ('148', '14', '/admin/role/del*', null), ('124', '7', '/admin/user/add*', '带有参数所以加上通配符*'), ('125', '9', '/admin/user/edit,/admin/user/modify*', '带有参数所以加上通配符*'), ('127', '11', '/admin/user/setEnable*', '带有参数所以加上通配符*'), ('128', '2', '/admin/menu/list*', '带有参数所以加上通配符*'), ('134', '112', '/admin/notify/adminlist', null), ('169', '124', '/admin/dict/setCache*', null), ('183', '24', '/admin/org/add*', null);
COMMIT;

-- ----------------------------
--  Table structure for `tsys_role`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_role`;
CREATE TABLE `tsys_role` (
  `ROLE_ID` decimal(20,0) NOT NULL COMMENT '角色ID',
  `ROLE_NAME` text NOT NULL COMMENT '角色名称',
  `ROLE_CODE` text NOT NULL COMMENT '角色编码',
  `CREATER_ID` decimal(20,0) DEFAULT NULL COMMENT '创建者ID',
  `IS_SYS` decimal(2,0) DEFAULT NULL COMMENT '是否系统内置',
  `ENABLE` decimal(2,0) NOT NULL COMMENT '是否有效',
  `NOTE` text COMMENT '备注',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色表';

-- ----------------------------
--  Records of `tsys_role`
-- ----------------------------
BEGIN;
INSERT INTO `tsys_role` VALUES ('1', '超级管理员', 'ROLE_ADMIN', null, '0', '1', null, '2014-03-12 00:00:00', '2015-03-13 16:16:05'), ('21', '用户', 'ROLE_21', '1', '0', '1', null, '2015-06-23 17:17:13', null);
COMMIT;

-- ----------------------------
--  Table structure for `tsys_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_role_authority`;
CREATE TABLE `tsys_role_authority` (
  `ID` decimal(20,0) NOT NULL COMMENT '角色权限关系ID',
  `ROLE_ID` decimal(20,0) NOT NULL COMMENT '角色ID',
  `AUTH_ID` decimal(20,0) NOT NULL COMMENT '权限ID',
  `IS_SYS` decimal(2,0) NOT NULL COMMENT '若为系统内置不允许删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED COMMENT='角色权限关系表';

-- ----------------------------
--  Records of `tsys_role_authority`
-- ----------------------------
BEGIN;
INSERT INTO `tsys_role_authority` VALUES ('3663', '21', '141', '0'), ('3664', '21', '148', '0'), ('3665', '21', '150', '0'), ('270', '19', '39', '0'), ('271', '19', '2', '0'), ('272', '19', '3', '0'), ('273', '19', '4', '0'), ('274', '19', '5', '0'), ('101', '2', '39', '0'), ('102', '2', '2', '0'), ('103', '2', '3', '0'), ('104', '2', '4', '0'), ('105', '2', '5', '0'), ('106', '2', '45', '0'), ('1026', '21', '137', '0'), ('1027', '21', '138', '0'), ('3666', '1', '2', '0'), ('3667', '1', '3', '0'), ('3668', '1', '4', '0'), ('3669', '1', '5', '0'), ('3670', '1', '120', '0'), ('3671', '1', '6', '0'), ('3672', '1', '7', '0'), ('3673', '1', '8', '0'), ('3674', '1', '9', '0'), ('3675', '1', '10', '0'), ('3676', '1', '11', '0'), ('3677', '1', '121', '0'), ('3678', '1', '12', '0'), ('3679', '1', '13', '0'), ('3680', '1', '14', '0'), ('3681', '1', '15', '0'), ('3682', '1', '16', '0'), ('3683', '1', '122', '0'), ('3684', '1', '18', '0'), ('3685', '1', '19', '0'), ('3686', '1', '20', '0'), ('3687', '1', '21', '0'), ('3688', '1', '23', '0'), ('3689', '1', '24', '0'), ('3690', '1', '25', '0'), ('3691', '1', '26', '0'), ('3692', '1', '123', '0'), ('3693', '1', '27', '0'), ('3694', '1', '28', '0'), ('3695', '1', '29', '0'), ('3696', '1', '30', '0'), ('3697', '1', '130', '0'), ('3698', '1', '125', '0'), ('3699', '1', '126', '0'), ('3700', '1', '124', '0'), ('3701', '1', '129', '0'), ('3702', '1', '127', '0'), ('3703', '1', '128', '0'), ('3704', '1', '151', '0'), ('3705', '1', '154', '0'), ('3706', '1', '152', '0'), ('3707', '1', '153', '0'), ('3708', '1', '157', '0'), ('3709', '1', '158', '0'), ('3710', '1', '115', '0'), ('3711', '1', '113', '0'), ('3712', '1', '114', '0'), ('3713', '1', '116', '0'), ('3714', '1', '117', '0'), ('3715', '1', '118', '0'), ('3716', '1', '119', '0'), ('3717', '1', '147', '0'), ('3718', '1', '148', '0'), ('3719', '1', '146', '0'), ('3720', '1', '141', '0'), ('3721', '1', '143', '0'), ('3722', '1', '145', '0'), ('3723', '1', '142', '0'), ('3724', '1', '144', '0');
COMMIT;

-- ----------------------------
--  Table structure for `tsys_user`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_user`;
CREATE TABLE `tsys_user` (
  `USER_ID` decimal(20,0) NOT NULL COMMENT '用户主键',
  `USER_TYPE` decimal(2,0) NOT NULL COMMENT '用户类型  1:系统预置 2:非系统预置',
  `USERNAME` text NOT NULL COMMENT '用户名',
  `PASSWORD` text NOT NULL COMMENT '用户密码',
  `REALNAME` text COMMENT '真实姓名',
  `MOBILE` varchar(128) DEFAULT NULL COMMENT '手机号码',
  `SEX` decimal(2,0) NOT NULL COMMENT '性别 1:男  2:女',
  `ADDRESS` varchar(128) DEFAULT NULL COMMENT '地址',
  `IS_ENABLE` decimal(2,0) NOT NULL COMMENT '是否启用',
  `IS_EXPIRE` decimal(2,0) NOT NULL COMMENT '是否过期',
  `IS_PASSWORD_EXPIRE` decimal(2,0) NOT NULL COMMENT '是否密码过期',
  `IS_LOCK` decimal(2,0) NOT NULL COMMENT '是否锁定',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `NOTE` text COMMENT '备注',
  `EMAIL` text NOT NULL COMMENT '邮箱',
  `IS_DELETE` decimal(2,0) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`USER_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
--  Records of `tsys_user`
-- ----------------------------
BEGIN;
INSERT INTO `tsys_user` VALUES ('20', '2', 'tttt', 'E10ADC3949BA59ABBE56E057F20F883E', 'ttttt', null, '1', null, '1', '0', '0', '0', '2015-06-29 09:48:11', '2015-06-29 14:22:27', null, '1111@as.cc', '1'), ('17', '2', 'DAYDAH', 'E10ADC3949BA59ABBE56E057F20F883E', 'DAD', null, '1', null, '1', '0', '0', '0', '2015-06-25 19:40:27', '2015-06-25 19:51:47', null, '11@EQ.DAD', '1'), ('19', '2', 'sdha', 'E10ADC3949BA59ABBE56E057F20F883E', '大', null, '1', null, '1', '0', '0', '0', '2015-06-26 10:41:02', '2015-06-26 10:41:29', null, '111@da.cm', '1'), ('14', '2', 'test', 'E10ADC3949BA59ABBE56E057F20F883E', 'ceshi ', null, '1', null, '1', '0', '0', '0', '2015-06-25 19:12:53', '2015-06-25 19:12:53', null, '111@san.cd', '0'), ('18', '2', '111', 'E10ADC3949BA59ABBE56E057F20F883E', 'ttt', null, '1', null, '1', '0', '0', '0', '2015-06-25 19:48:14', '2015-06-25 19:51:16', null, '111@eqeq.ca', '1'), ('12', '2', 'ddsa', 'E10ADC3949BA59ABBE56E057F20F883E', 'uud', null, '1', null, '1', '0', '0', '0', '2015-06-25 18:23:36', '2015-06-25 19:52:46', 'wa', '11145@qq.c', '1'), ('13', '2', 'jiangzhijua', 'E10ADC3949BA59ABBE56E057F20F883E', 'jnd', null, '1', null, '1', '0', '0', '0', '2015-06-25 19:07:09', '2015-06-25 19:07:09', null, '12@ada.iadsa', '1'), ('15', '2', 'jidiajd', 'E10ADC3949BA59ABBE56E057F20F883E', '倒萨', null, '1', null, '1', '0', '0', '0', '2015-06-25 19:16:21', '2015-06-25 19:52:20', 'd', '111@www.dd', '1'), ('16', '2', 'yyds', 'E10ADC3949BA59ABBE56E057F20F883E', '大eewq', null, '1', null, '1', '0', '0', '0', '2015-06-25 19:17:20', '2015-06-25 19:51:56', null, '112@da.cd', '1'), ('1', '1', 'admin', 'C4CA4238A0B923820DCC509A6F75849B', '超级管理员', '13000000000', '1', '中企移动', '1', '0', '0', '0', '2015-03-12 00:00:00', '2015-03-12 14:16:14', '中企移动框架-超级管理员，必须分配所有权限。', 'admin@cemobile.com', '0'), ('11', '2', 'czp', 'E10ADC3949BA59ABBE56E057F20F883E', 'czp', null, '1', null, '1', '0', '0', '0', '2015-06-05 10:56:19', '2015-06-05 10:56:19', null, 'czp1219@gmail.com', '0'), ('0', '2', 'teacher', '', 'yxm', null, '1', null, '1', '0', '0', '0', null, null, null, '', '1'), ('21', '2', '胖家长', '', 'lcw', null, '0', null, '0', '0', '0', '0', null, null, null, '', '1');
COMMIT;

-- ----------------------------
--  Table structure for `tsys_user_group`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_user_group`;
CREATE TABLE `tsys_user_group` (
  `ID` decimal(20,0) NOT NULL COMMENT '用户与组织机构关系ID',
  `GROUP_ID` decimal(20,0) NOT NULL COMMENT '组织机构ID',
  `USER_ID` decimal(20,0) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED COMMENT='用户与组织机构关系表';

-- ----------------------------
--  Table structure for `tsys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_user_role`;
CREATE TABLE `tsys_user_role` (
  `ID` decimal(20,0) NOT NULL COMMENT '用户角色关系ID',
  `ROLE_ID` decimal(20,0) NOT NULL COMMENT '角色ID',
  `USER_ID` decimal(20,0) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED COMMENT='用户角色关系表';

-- ----------------------------
--  Records of `tsys_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `tsys_user_role` VALUES ('15', '1', '14'), ('11', '1', '1'), ('12', '1', '11');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
