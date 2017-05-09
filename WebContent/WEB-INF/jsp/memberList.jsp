<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
thead tr th{height:50px;background:#B0D1FC;border:1px solid white;}
thead tr th.line1{background:#D3E5FD;}
thead tr th.line4{background:#C6C6C6;}
tbody tr td{height:35px;background:#CBE2FB;border:1px solid white; vertical-align:middle;}
tbody tr td.line4{background:#D5D6D8;}
tbody tr th{height:35px;background: #DFEDFF;border:1px solid white; vertical-align:middle;}
tfoot tr td{height:35px;background:#FFFFFF;border:1px solid white; vertical-align:middle;}
-->
</style>

<script src="js/common.js" type="text/javascript"></script>
<script type="text/javascript" src="js/common.js" ></script>
<script type="text/javascript">
			
		function addFriend(){
			document.forms.buddyListForm.action="memberList";
			document.all("buddyListForm").submit();		
		}
		function delBuddy(){
			cCount = getCheckedCount("nickName");
			if (cCount == 0){
				alert("请至少一条信息!");
				return;
			}
			if (confirm("确定删除吗？")==false){
				return false;
			}
			document.forms.buddyListForm.action="<c:url value='deleteBuddy.action' />";
			document.all("buddyListForm").submit();		
		}	
</script>
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
    <li><a href="matchFriend" title="好友速配"><span>好友速配</span></a></li>
    <li><a href="buddyList" title="好友名单"><span>好友名单</span></a></li>
    <li><a href="blackList" title="黑名单"><span>黑名单</span></a></li>
  </ul>
</div>
<br /><br />

  <div id="content" align="center"> 
     <div id="center">
	 <BR /><BR />
		<form  method="post" name="buddyListForm" >
			<table width="600" align="center" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<td><h4>会员列表</h4></td>
					</tr>
				</thead>
				
				<tr>
					<td width="100%">
						<table width="100%">
							<thead>
							<tr>
								<th width="20%" align="center" scope="col">
									<b>姓名</b>
								</th>
								<th width="20%" align="center" scope="col">
									<b>性别</b>
								</th>
								<th width="20%" align="center" scope="col">
									<b>年龄</b>
								</th>
								<th width="20%" align="center" scope="col">
									<b>来自</b>
								</th>
								<th width="10%" align="center">
									<b>操作</b>
								</th>
							</tr>
							</thead>
							
							<tbody>								
							<tr>
								<td width="20%" align="center">
									briup2
								</td>
								<td width="20%" align="center">男</td>
								<td width="20%" align="center" >33</td>
								<td width="20%" align="center">内蒙古</td>
								<td width="10%" align="center">
									<img src="images/button_delete.gif" alt="移动到黑名单" onclick="window.location='moveToBlackList.do?blackName=briup2'" style="cursor:hand"/>
								</td>
							</tr>
														
							<tr>
								<td width="20%" align="center">
									briup4
								</td>
								<td width="20%" align="center">男</td>
								<td width="20%" align="center" >32</td>
								<td width="20%" align="center">其它</td>
								<td width="10%" align="center">
									<img src="images/button_delete.gif" alt="移动到黑名单" onclick="window.location='moveToBlackList.do?blackName=briup4'" style="cursor:hand"/>
								</td>
							</tr>
							<tr>
								<td width="20%" align="center">
									briup5
								</td>
								<td width="20%" align="center">男</td>
								<td width="20%" align="center" >32</td>
								<td width="20%" align="center">其它</td>
								<td width="10%" align="center">
									<img src="images/button_delete.gif" alt="移动到黑名单" onclick="window.location='moveToBlackList.do?blackName=briup5'" style="cursor:hand"/>
								</td>
							</tr>
														
							<tr>
								<td width="20%" align="center">
									briup6
								</td>
								<td width="20%" align="center">男</td>
								<td width="20%" align="center" >23</td>
								<td width="20%" align="center">内蒙古</td>
								<td width="10%" align="center">
									<img src="images/button_delete.gif" alt="移动到黑名单" onclick="window.location='moveToBlackList.do?blackName=briup6'" style="cursor:hand"/>
								</td>
							</tr>
							</tbody>						
														
					  </table>
					</td>
				</tr>
			</table>
		
		</form>
		
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
