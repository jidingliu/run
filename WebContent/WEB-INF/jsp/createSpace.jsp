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
  
  <div id="content" align="center">
     
     <div id="center">
       
		<table style="margin-top: 50px; border: 1px solid #cccccc;"
							width="500" align="center" cellpadding="0" cellspacing="0">
  			<tr>
   				<td colspan="3">
				<table cellpadding="0" cellspacing="0" width="100%" height="62">
					<tr>
						<td align="center">
							<b>-&gt;创建个性化空间</b></td>
						
					</tr>
				</table></td>
 			</tr>
  			<tr>
				<td></td>
				<td width="100%">
					<table width="100%" border="0" style="margin: 5px 0;"
										cellspacing="0" cellpadding="0" align="center" height="50">
		 			<tr>
											<td width="126" align="center" rowspan="3" valign="top"
												style="padding-top: 0px;">
												<img src="images/icon03.gif" width="16" height="16"
													align="right" />
											</td>
											<td width="10" height="30">
												&nbsp;
											</td>
											<td width="466" align="left" valign="top" class="fontgreen"
												style="padding-top: 2px;">
												<b>系统提醒</b>
											</td>
										</tr>
										<tr>
											<td height="34">
												&nbsp;
											</td>
											<td valign="top" class="fontgray" style="padding-top: 2px;">
												<ol>
													<li>
														<font color="#ff0000">带*号的选项内容必须填写</font>
													</li>
													<li>
														<font color="#ff0000">注意上传的图片尺寸尽量不要太大</font>
													</li>
												</ol>
											</td>
										</tr>
		  			</table>
		  			<form name="sform" onsubmit="return checkspace();" action="createSpace.action" method="post"	enctype="multipart/form-data">
		  			<table width="100%" border="0" style="margin:5px 0;" cellspacing="2" cellpadding="0" align="center">
					<tr>
						<TD width="50%" align="right">
							<FONT color=#ff9933>*</FONT> 请用一句话形容对跑步的主张：						</TD>
						<TD width="50%" align="left">
							<INPUT class=INPUT1 type=text maxLength=14 name=opinion
										
														style="width:200;height:25" />						</TD>
					</tr>
					<TR>
						<TD width="50%" align="right">
							<FONT color=#ff9933>*</FONT> 喜欢在什么时段跑步？						</TD>
						<TD width="50%" align="left">
						
									<input name="runtime" class=radio1 type="radio" value="清晨" />清晨
									<input type="radio" name="runtime" class=radio1 value="午后" />午后
									<input type="radio" name="runtime" class=radio1	value="黄昏" checked="checked"/>黄昏						</TD>
					</TR>
					<TR>
						<TD width="50%" align="right">
							<FONT color=#ff9933>*</FONT> 喜欢独自跑还是结伴跑？						</TD>
						<TD width="50%" align="left">
							<input type="radio" name="runhabit" class=radio1 value="独自" />独自
							<input type="radio" name="runhabit" class=radio1 value="结伴" checked="checked"/>结伴
						</TD>
					</TR>
					<TR>
						<TD width="50%" align="right">
							<FONT color=#ff9933>*</FONT>最喜欢的体育明星：						</TD>
						<TD align="left">
							<INPUT class=INPUT1 type=text maxLength=20 name=runstar	 style="width:200;height:25" />						</TD>
					</TR>
					<TR>
						<TD width="50%" align="right">
							<FONT color=#ff9933>*</FONT> 正在使用的手机：						</TD>
						<TD width="50%" align="left">
							<INPUT class=INPUT1 type=text maxLength=14 name=cellphone 
																style="width:200;height:25" />						</TD>
					</TR>
					<TR>
						<TD width="50%" align="right">
							<FONT color=#ff9933>*</FONT> 经常跑步的地点：						</TD>
						<TD width="50%" align="left">
							<INPUT class="INPUT1" type="text" maxLength="14" name="runplace"
																
																style="width:200;height:25" />						</TD>
					</TR>
					<TR>
						<TD width="50%" align="right">&nbsp;&nbsp;上传个性化形象：</TD>
						<TD align="left">
							<input type="file" id="icon" name="icon" style="width:200;height:25" />						</TD>
					</TR>									
    				<tr>
						<td colSpan="2">
							<div align="center">
								<input type="submit" value="提交" style="cursor: hand"/>
								&nbsp;&nbsp;
								<input type="reset" value="重置" style="cursor: hand"/>
							</div>						</td>
					</tr> 
					</table>
					</form>					</td>
				<td></td>
  			</tr>
  			<tr>
				<td colspan="3" height="30"></td>
  			</tr>
			</table>
	        
        <div id="hots">
          <h2>我的地盘</h2>
          <ul>
          <li>
           <div>
            <img src="images/a.gif" />
            <a href="modify.html">基本信息</a>
            <p>可修改自己的基本信息</p>
           </div>
          </li>
          <li>
           <div>
            <img src="images/b.gif" />
            <a href="../messenger/inbox.html">我的信箱</a>
            <p>写信息、收件箱、发件箱</p>
           </div>
          </li>
          <li>
           <div>
            <img src="images/c.gif" />
            <a href="../messenger/buddyList.html">我的好友</a>
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
