<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- 
<base href="<%=basePath%>" />
 -->
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
			function delMessage(){
				cCount = getCheckedCount("id");
				if (cCount == 0){
					alert("请至少一条信息!");
					return;
				}
				if (confirm("确定删除吗？")==false){
					return false;
				}
				document.forms.inboxForm.action="<%=basePath%>delReceiveMessage.action";
				document.forms.inboxForm.submit();	
			}	
			function detailMessage(){
				cCount = getCheckedCount("id");
				if (cCount == 0){
					alert("请选择一条信息!");
					return;
				}
				if (cCount > 1){
					alert("对不起，一次只能查看一条信息!");
					return;
				}
				document.forms.inboxForm.action="<%=basePath%>view";
				document.forms.inboxForm.submit();		
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
    <li><a href="sendInfo" title="写纸条"><span>写纸条</span></a></li>
    <li><a href="inbox" title="收件箱"><span><b>收件箱</b></span></a></li>
    <li><a href="outbox" title="发件箱"><span>发件箱</span></a></li>
  </ul>
</div>
<br /><br />

  <div id="content" align="center"> 
     <div id="center">
	 <br /><br />
		<form  method="post" name="inboxForm" >
			<table width="600" align="center" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<td width="70%"><h4>收件箱</h4></td>
						<td>
							<span onclick="javascript:detailMessage();">
								<img src="images/icon06.gif" height="14" />&nbsp;查看</span>
							<span onclick="javascript:delMessage();">
								<img src="images/delete.gif" height="14"/>&nbsp;删除</span>
						</td>
					</tr>
				</thead>
			
				<tr>
					
					<td width="100%" colspan="2">
						<table width="100%">
							<thead>
								<tr>
									<th width="10%">
										<b>选择</b>
									</th>
									<th width="20%">
										<b>主题</b>
									</th>
									<th width="20%"> 
										<b>发信人</b>
									</th>
									<th width="30%">
										<b>发送时间</b>
									</th>
									<th width="20%">
										<b>状态</b>
									</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${listRecieveMessageR}" var="list1">
								<tr>
									<td width="10%">
										<input type="checkbox" name="id" value="${list1.id }" />
									</td>
									<td width="20%">
										<a href="view.do?id=${list1.id}">${list1.title}</a>
									</td>
									<td width="20%">${list1.sender}</td>
									<td width="30%">
									<fmt:formatDate value="${list1.senddate}" pattern="yy-MM-dd hh:mm:ss" />
										
									</td>
									<td>
										<img src="images/icon09.gif" />
									</td>
								</tr>
								</c:forEach>
								<c:forEach items="${listRecieveMessageRe}" var="list2">
								<tr>
									<td width="10%">
										<input type="checkbox" name="id" value="${list2.id }" />
									</td>
									<td width="20%">
										<a href="view.do?id=${list2.id}">${list2.title}</a>
									</td>
									<td width="20%">${list2.sender }</td>
									<td width="30%">
									<fmt:formatDate value="${list2.senddate}" pattern="yy-MM-dd hh:mm:ss" />
									</td>
									<td>
										<img src="images/icon10.gif" />
									</td>
								</tr>
								</c:forEach>		
							</tbody>
							
							<tfoot>
							<tr>
								<td align="right" width="30%" colspan="5">
								选择：<a href="#" onclick="javascript:selAllCheckbox('id');">全部</a>-
						  			  <a href="#" onclick="javascript:unselAllCheckbox('id');">不选</a>-
						 			  <a href="#" onclick="javascript:reAllCheckbox('id');">反选</a>
				               </td>
							</tr>
							<tr>
								<td colspan="5">
									<img src="images/icon09.gif" />未读短信
									<img src="images/icon10.gif" />已读短信
								</td>
								
							</tr>
							</tfoot>
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
