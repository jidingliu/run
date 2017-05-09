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
<link rel="stylesheet" type="text/css" id="css" href="style/style.css" />

<style type="text/css">
<!--
table{border-spacing:1px; border:1px solid #A2C0DA;}
td, th{padding:2px 5px;border-collapse:collapse;text-align:left; font-weight:normal;}
thead tr th{background:#B0D1FC;border:1px solid white;}
thead tr th.line1{background:#D3E5FD;}
thead tr th.line4{background:#C6C6C6;}
tbody tr td{height:35px;background:#CBE2FB;border:1px solid white; vertical-align:middle;}
tbody tr td.line4{background:#D5D6D8;}
tbody tr th{height:35px;background: #DFEDFF;border:1px solid white; vertical-align:middle;}
tfoot tr td{height:35px;background:#F5F5F5;border:1px solid white; vertical-align:middle; text-align:right}
-->
</style>

<script src="js/common.js" type="text/javascript"></script>
<script type="text/javascript" src="js/common.js" ></script>
<!-- 如果msg不为空，代表当前有错误信息，弹出框给用户提示 -->
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
   
  <div id="tabs1">
  <ul>
    <li><a href="matchFriend" title="好友速配"><span><b>好友速配</b></span></a></li>
    <li><a href="buddyList" title="好友名单"><span>好友名单</span></a></li>
    <li><a href="blackList" title="黑名单"><span>黑名单</span></a></li>
  </ul>
</div>
<br /><br />

  <div id="content" align="center"> 
     <div id="center">
	 <br /><br />
		<table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<td colspan="2" height="40">
						<h4>-&gt;好友速配</h4>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td width="100%">
						<form action="matchFriends.do" method="post" name="matchFriendForm">
						<table width="100%" cellspacing="1" cellpadding="3" align="center">
							<tr>
								<td colspan="4">
									<b>找到您跑步世界的另一半，您可以 <a href="findOneFriend.do"><FONT color=#ff0000>马上速配</FONT></a> 一位跑友</b>
								</td>
							</tr>
							<tr>
								<td colspan="4"><b>更可以按要求检索</b></td>
							</tr>
							<tr>
         						 <td align="center">年龄范围：
         						 	<select name="age">
                  						<option value="10-19">10-19岁</option>
                  						<option value="20-29">20-29岁</option>
                  						<option value="30-39">30-39岁</option>
                  						<option value="unlimited" selected="selected">不限</option>
                    				</select>
                    			</td>
           						<td align="center">性别：
                					<select name="gender">
               							<option value="男">男</option>
              							<option value="女">女</option>
               							<option value="unlimited" selected="selected">不限</option>
                					</select>
                				</td>
                				<td align="center">所在省/城市：
                					<select name="provincecity">
                    					<OPTION value=北京>北京</OPTION> <OPTION 
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
                    					<option selected="selected" value="unlimited">不限</option>
                    				</select> 
                    			</td>
                    			<td align="center">
            						<input type="submit" name="Submit2" value="开始检索" />                 
          						</td>
         					</tr>
						</table>
						</form>
					</td>
				</tr>
			</tbody>		
					
			<table width="100%" cellspacing="1" cellpadding="3" align="center">
				<tfoot>
				<c:forEach items="${members}" var="mem">
				<tr height="25">
					<td width="15%" align="center">${mem.nickname}</td>
					<td width="15%" align="center">${mem.gender}</td>
					<td width="15%" align="center">${mem.age}</td>
					<td width="15%" align="center">${mem.provincecity}</td>
					<td width="20%" align="center">
						<a href="addFriends.action?nickname=${mem.nickname}">添加好友</a>
					</td>
					<td width="20%" align="center">
						<a href="zsendInfo?nickname=${mem.nickname}">发送短信</a>
					</td>
				</tr>
				</c:forEach>
				</tfoot>
			</table>
		</table>
	     <br /><br />
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
