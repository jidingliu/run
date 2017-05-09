<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="keywords" content="杰普软件(www.briup.com)" />
<meta name="description" content="杰普软件(www.briup.com)" />
<title>杰普――跑步社区</title>
<link rel="stylesheet" type="text/css" id="css" href="style/main.css" />
<link rel="stylesheet" type="text/css" id="css" href="style/style1.css" />
<script src="js/main.js" type="text/javascript"></script>
<script src="js/base.js" type="text/javascript"></script>							
<style type="text/css">
<!--
table{border-spacing:1px; border:1px solid #A2C0DA;}
td, th{padding:2px 5px;border-collapse:collapse;text-align:left; font-weight:normal; text-align:left}
thead tr th{height:30px;background:#FFFFFF;border:1px solid white;}
thead tr th.line1{background:#FFFFFF;}
thead tr th.line4{background:#C6C6C6;}
tbody tr td{height:35px;background:#CBE2FB;border:1px solid white; vertical-align:middle;}
tbody tr td.line4{background:#D5D6D8;}
tbody tr th{height:35px;background: #DFEDFF;border:1px solid white; vertical-align:middle;}
tfoot tr td{height:35px;background:#FFFFFF;border:1px solid white; vertical-align:middle; text-align:center}
-->
</style>

<c:if test="${msg != null}">
	<script type="text/javascript">
		alert('${msg}');
	</script>
</c:if>
</head>
<body>
<div id="btm">
<div id="main">

  <div id="header">
    <div id="top"></div>
    <div id="logo">
      <h1>跑步社区</h1></div>
	  <div id="logout">
	<a href="logout">注  销</a> | 收  藏
	 </div>
    <div id="mainnav">
      <ul>
      <li><a href="activity">首页</a></li>
      <li><a href="#">音乐跑不停</a></li>
      <li><a href="#">跑步装备库</a></li>
      <li><a href="#">专业跑步指南</a></li>
      <li><a href="#">跑步论坛</a></li>
	  
      </ul>
      <span></span>
    </div>
   </div>
  
  <div id="content" align="center">
     
     <div id="center">
      
		<table width="600">
			<thead>
  			<tr>
   				<th colspan="3">
					<h4>修改会员信息</h4>
				</th>
 			</tr>
			</thead>
			
  			<tr>
				<td width="100%">
					<form action="modify.action" name="mform" method="post" onSubmit="return validateModifyForm();">
					<table width="100%" border="0" style="margin:5px 0;" cellspacing="0" cellpadding="0" align="center" >
					<thead>
		 			<tr>
						<td colSpan=3>
							请填写个人资料：（注意带有<font color=#ff0000>*</font>的项目必须填写）
						</td>
					</tr>
					</thead>
					<tbody>
					<tr>
						<th width="25%" class="line1">
							<div align="right" >
								<font color="#ff0000">*</font>昵称：
							</div>
						</th>
						<td width="30%" >
							<input type="text" maxLength="14" style="width:200px" name="nickname" value="${member.nickname}" disabled />
						</td>
						<th width="45%" >
							<font color="#ff0000">昵称可使用长度为0-16的任何字符</font>
						</th>
					</tr>
					<tr>
						<th class="line1">
							<div align="right">
								<font color="#ff0000" >*</font> 旧密码：
							</div>
						</th>
						<td>
							<input type="password" maxLength="14" style="width:200px" name="oldpasswd"  />
						</td>
						<th>&nbsp;
							
						</th>
					</tr>
					<tr>
						<th class="line1">
							<div align="right">
								<font color="#ff0000" >*</font> 新密码：
							</div>
						</th>
						<td>
							<input type="password" maxLength="14" style="width:200px" name="newpasswd" />
						</td>
						<th>
							<font color="#ff0000">密码可使用长度为6-14的任何字符，并区分英文字母大小写</font>
						</th>
					</tr>
					<tr>
						<th class="line1">
							<div align="right">
								<font color="#ff0000">*</font>密码确认：
							</div>
						</th>
						<td>
							<input type="password" maxLength="14" style="width:200px"	name=newpasswdre />
						</td>
						<th>
							<font color="#ff0000">请再输入一次密码</font>
						</th>
					</tr>
					<tr>
						<th class="line1">
							<div align="right">
								<font color="#ff0000">*</font>电子邮箱：
							</div>
						</th>
						<td>
							<input type="text" maxLength="30" style="width:200px" name="email" value="${member.email}"  />
						</td>
						<th>
							<font color="#ff0000">请输入您常用的其它电子邮箱</font>
						</th>
					</tr>
					<tr>
						<th class="line1">
							<div align="right">
								<font color="#ff0000">*</font> 密码提示问题：
							</div>
						</th>
						<th>
							<input style="width:200px" type="text" name="passwdquestion" value="${member.passwordquestion}"  />
						</th>
						<th>
							<font color="#ff0000">例如：我的哥哥是谁？</font>
						</th>
					</tr>
					<tr>
						<th class="line1">
							<div align="right">
								<font color="#ff0000">*</font> 密码提示答案：
							</div>
						</th>
						<td>
							<input  type="text" style="width:200px" name="passwdanswer"  value="${member.passwordanswer}" />
						</td>
						<th>
							<font color="#ff0000">注意：密码提示问题答案长度不少于6位</font>
						</th>
					</tr>
					<tr>
						<th class="line1">
							<div align="right" >
								<font color=#ff0000>*</font> 性别：
							</div>
						</th>
						<c:if test="${member.gender=='男'}">
						<td>
							<input type="radio" value="男" name="gender" checked="checked"/>男
							<input type="radio" value="女" name="gender" />女
						</td>
						</c:if>
						<c:if test="${member.gender=='女'}">
						<td>
							<input type="radio" value="男" name="gender" />男
							<input type="radio" value="女" name="gender" checked="checked"/>女
						</td>
						</c:if>
						
						<th>&nbsp;	</th>
					</tr>
					<tr>
						<th class="line1">
							<div align="right">
								所在省份/城市：
							</div>
						</th>
						<td >
							<select name="provincecity">
								<OPTION value="" 
									  selected>请选择</OPTION> <OPTION value=北京>北京</OPTION> <OPTION 
									  value=上海>上海</OPTION> <OPTION value=天津>天津</OPTION> <OPTION 
									  value=重庆>重庆</OPTION> <OPTION value=辽宁>辽宁</OPTION> <OPTION 
									  value=广东>广东</OPTION> <OPTION value=浙江>浙江</OPTION> <OPTION 
									  value=江苏>江苏</OPTION> <OPTION value=山东>山东</OPTION> <OPTION 
									  value=四川>四川</OPTION> <OPTION value=黑龙江>黑龙江</OPTION> <OPTION 
									  value=湖南>湖南</OPTION> <OPTION value=湖北>湖北</OPTION> <OPTION 
									  value=福建>福建</OPTION> <OPTION value=陕西>陕西</OPTION> <OPTION 
									  value=河南>河南</OPTION> <OPTION value=安徽>安徽</OPTION> <OPTION 
									  value=河北>河北</OPTION> <OPTION value=吉林>吉林</OPTION> <OPTION 
									  value=江西>江西</OPTION> <OPTION value=广西>广西</OPTION> <OPTION 
									  value=山西>山西</OPTION> <OPTION value=内蒙古>内蒙古</OPTION> <OPTION 
									  value=甘肃>甘肃</OPTION> <OPTION value=贵州>贵州</OPTION> <OPTION 
									  value=新疆>新疆</OPTION> <OPTION value=云南>云南</OPTION> <OPTION 
									  value=宁夏>宁夏</OPTION> <OPTION value=海南>海南</OPTION> <OPTION 
									  value=青海>青海</OPTION> <OPTION value=西藏>西藏</OPTION> <OPTION 
									  value=港澳台>港澳台</OPTION> <OPTION value=海外>海外</OPTION> <OPTION 
									  value=其他>其它</OPTION>
							</select>
							<script type="text/javascript">
								var pc = "${member.provincecity}";
								var opts = document.getElementsByTagName("option");//根据标签名字获取所有的节点属性
								for(var i = 0;i<opts.length;i++){
									//alert(opts[i].value);
									if(opts[i].value==pc){
										opts[i].selected = true;
									}
								}
							</script>
						</td>
						<th>&nbsp;
							
						</th>
					</tr>
					<tr>
						<th class="line1">
							<div align="right">
								联系电话：
							</div>
						</th>
						<td>
							<input type="text" style="width:200px" name="phone" value="${member.phone }" />
						</td>
						<th>
							<font color=#ff0000>请输入区号和真实的电话，以便我们与您联系</font>
						</th>
					</tr>
					<tr>
						<th class="line1">
							<div align="right">
								详细地址：
							</div>
						</th>
						<td>
							<input type="text" style="width:200px" name="address" value="${member.address }" />
						</td>
						<th>&nbsp;</th>
					</tr>
					<tfoot>
    				<tr>
						<td colSpan="3" align="center">
							<input type="submit" value="提交" style="cursor: hand"/>
							&nbsp;&nbsp;
							<input type="reset" value="重置" style="cursor: hand"/>
						</td>
					</tr> 
					</tfoot>
					</table>
					</form>
				</td>
  			</tr>
			</table>
	        <BR /><BR />
        <div id="hots">
          <h2>我的地盘</h2>
          <ul>
          <li>
           <div>
            <img src="images/a.gif" />
            <a href="modify">基本信息</a>
            <p>可修改自己的基本信息</p>
           </div>
          </li>
          <li>
           <div>
            <img src="images/b.gif" />
            <a href="inbox">我的信箱</a>
            <p>写信息、收件箱、发件箱</p>
           </div>
          </li>
          <li>
           <div>
            <img src="images/c.gif" />
            <a href="buddyList">我的好友</a>
            <p>好友管理及黑名单</p>
           </div>
          </li>
          <li>
           <div>
            <img src="images/d.gif" />
            <a href="ishavespace">个性空间</a>
            <p>创建自己的个性空间</p>
           </div>
          </li>
          </ul>
        </div> 
         
     </div>
     
     <div id="right">
       <h2>&nbsp;</h2>
      <ul><li></li>
      </ul>
     </div>
     <div class="clear"></div>
     
  </div>
  
  <div id="footer">
    <div id="copyright">
       <div id="copy">
       <p>CopyRight&copy;2009</p>
       <p>跑步社区(www.irun.com) </p>
        </div>
    </div>
    <div id="bgbottom"></div>
  </div>
  
</div>
</div>
</body>
</html>
