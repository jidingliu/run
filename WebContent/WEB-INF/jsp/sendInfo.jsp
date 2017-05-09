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
<script src="js/base.js" type="text/javascript"></script>
<style type="text/css">
<!--
table{border-spacing:1px; border:1px solid #A2C0DA;}
td, th{padding:2px 5px;border-collapse:collapse;text-align:left; font-weight:normal;}
thead tr th{height:35px;background:#FFFFFF;border:1px solid white;}
thead tr th.line1{background:#D3E5FD;}
thead tr th.line4{background:#C6C6C6;}
tbody tr td{height:30px;background:#CBE2FB;border:1px solid white; vertical-align:middle;}
tbody tr td.line4{background:#D5D6D8;}
tbody tr th{height:30px;background: #DFEDFF;border:1px solid white; vertical-align:middle; text-align:right}

tfoot.tr th{height:30px;background: #FFFFFF;border:1px solid white; vertical-align:middle; text-align:center}
-->
</style>
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
    <li><a href="sendInfo" title="写纸条"><span><b>写纸条</b></span></a></li>
    <li><a href="inbox" title="收件箱"><span>收件箱</span></a></li>
    <li><a href="outbox" title="发件箱"><span>发件箱</span></a></li>
  </ul>
  
</div>
  <div id="content" align="center"> 
     <div id="center"><br/><br/>
		<table width="600">
			<thead>
				<tr>
					<th colspan="2"><h4>发送讯息</h4></th>
				</tr>
			</thead>
		
			<tr>
				<td width="100%">
					<form name="sendInfoForm" action="sendMessage.do" method="post" onsubmit="return sendInfo();">
						<table width="100%">
						<tbody>
						<tr>
							<th width="30%" class="line1" scope="col">收信人：</th>
							<td>
								<input type="text" name="receiver" style="width: 250;height: 25" value=""/>
							</td>
						</tr>
						<tr>
							<th>主题：</th>
							<td>
								<input type="text" name="title" style="width: 350;height: 25" />
							</td>
						</tr>
						<tr>
							<th>消息内容：</th>
							<td>
								<textarea name="content" rows="8" cols="55"></textarea>
							</td>
						</tr>
						</tbody>
						<tfoot>
						<tr>
							<th colspan="2">
								<input type="submit" value="发送" />
								<input type="reset" value="重置" />
							</th>
						</tr>
						</tfoot>
						
					  </table>
					</form>
				</td>
				
			</tr>
				
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
